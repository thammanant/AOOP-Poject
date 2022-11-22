import AbstactClass.LoginNRegister;
import net.thegreshams.firebase4j.error.FirebaseException;
import net.thegreshams.firebase4j.error.JacksonUtilityException;

import javax.swing.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.io.IOException;
import java.util.List;

public class Register extends LoginNRegister {
    private JPanel RegisterPanel;
    private JTextField emailTextField;
    private JButton registerButton;
    private JPasswordField passwordTextField;
    private JPasswordField confirmPasswordTextField;
    private JLabel Status;
    private JRadioButton Customer;
    private JRadioButton Worker;
    private JButton Back_button;
    private String type;

    public Register(JFrame frame, Customer customer, Worker worker) {
        ButtonGroup Type = new ButtonGroup();
        Type.add(Customer);
        Type.add(Worker);
        //set text field
        emailTextField.setText(this.userTxt);
        emailTextField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (emailTextField.getText().equals(userTxt)) {
                    emailTextField.setText("");
                }
                super.focusGained(e);

                if (passwordTextField.getText().isEmpty()) {
                    passwordTextField.setText(passTxt);
                    passwordTextField.setEchoChar((char) 0);
                }
                if (confirmPasswordTextField.getText().isEmpty()) {
                    confirmPasswordTextField.setText(confirmpassTxt);
                    confirmPasswordTextField.setEchoChar((char) 0);
                }
            }
        });

        //set password field
        passwordTextField.setText(passTxt);
        passwordTextField.setEchoChar((char) 0);
        passwordTextField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (passwordTextField.getText().equals(passTxt)) {
                    passwordTextField.setText("");
                }
                super.focusGained(e);
                passwordTextField.setEchoChar(passwdChar);

                if (emailTextField.getText().isEmpty()) {
                    emailTextField.setText(userTxt);
                }
                if (confirmPasswordTextField.getText().isEmpty()) {
                    confirmPasswordTextField.setText(confirmpassTxt);
                    confirmPasswordTextField.setEchoChar((char) 0);
                }
            }
        });

        //set confirm password field
        confirmPasswordTextField.setText(confirmpassTxt);
        confirmPasswordTextField.setEchoChar((char) 0);
        confirmPasswordTextField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (confirmPasswordTextField.getText().equals(confirmpassTxt)) {
                    confirmPasswordTextField.setText("");
                }
                confirmPasswordTextField.setEchoChar(passwdChar);
                super.focusGained(e);

                if (emailTextField.getText().isEmpty()) {
                    emailTextField.setText(userTxt);
                }
                if (passwordTextField.getText().isEmpty()) {
                    passwordTextField.setText(passTxt);
                    passwordTextField.setEchoChar((char) 0);
                }
            }
        });

        //set register button
        registerButton.addActionListener(e -> {
            String email = emailTextField.getText();
            String password = passwordTextField.getText();
            String confirmPassword = confirmPasswordTextField.getText();
            List<String> list;
            boolean same = false;
            try {
                list = DataBaseFB.findAllCustomerUsernames();
            } catch (FirebaseException | IOException | JacksonUtilityException ex) {
                throw new RuntimeException(ex);
            }
            for (String s : list) {
                if (email.equals(s)) {
                    same = true;
                    break;
                }
            }
            if (email.isEmpty() || email.equals(userTxt)) {
                Status.setText(emptyUsername);
            } else if (password.isEmpty() || password.equals(passTxt)) {
                Status.setText(emptyPasswd);
            } else if (!password.equals(confirmPassword)) {
                Status.setText(passwdNotMatch);
            } else if (same) {
                Status.setText("Username already exists");
            } else if (Customer.isSelected() || Worker.isSelected()) {
                if (Customer.isSelected()) {
                    type = "Customer";
                    Customer customer1 = new Customer(email);
                    customer1.setPassword(password);
                    customer1.resetClothes();
                    try {
                        DataBaseFB.updateCustomerData(customer1.getName(), customer1);
                        DataBaseFB.addNewUser(email, password, type);
                    } catch (FirebaseException | JacksonUtilityException | IOException ex) {
                        throw new RuntimeException(ex);
                    }
                    JOptionPane.showMessageDialog(null, "Register successfully!");
                } else if (Worker.isSelected()) {
                    type = "Worker";
                    Worker worker1 = new Worker(email);
                    worker1.setPassword(password);
                    try {
                        DataBaseFB.updateWorkerData(worker1.getName(), worker1);
                        DataBaseFB.addNewUser(email, password, type);
                    } catch (FirebaseException | JacksonUtilityException | IOException ex) {
                        throw new RuntimeException(ex);
                    }
                    JOptionPane.showMessageDialog(null, "Register successfully!");
                }
                frame.setContentPane(new Login(frame, customer, worker).getLoginPanel());
                frame.revalidate();
            } else {
                Status.setText("Please select your type");
            }
        });

        Back_button.addActionListener(e -> {
            frame.setContentPane(new Login(frame, customer, worker).getLoginPanel());
            frame.revalidate();
        });

    }

    //getter
    public JPanel getRegisterPanel() {
        return RegisterPanel;
    }

}
