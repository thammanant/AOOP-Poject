import AbstactClass.LoginNRegister;
import net.thegreshams.firebase4j.error.FirebaseException;
import net.thegreshams.firebase4j.error.JacksonUtilityException;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

public class Register extends LoginNRegister{
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
    private boolean sta = true;

    public Register(JFrame frame, Customer customer, Worker worker) {
        ButtonGroup Type = new ButtonGroup();
        Type.add(Customer);
        Type.add(Worker);
        //set text field
        emailTextField.setText(this.userTxt);
        emailTextField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if(emailTextField.getText().equals(userTxt)){
                    emailTextField.setText("");
                }
                super.focusGained(e);

                if (passwordTextField.getText().isEmpty()){
                    passwordTextField.setText(passTxt);
                    passwordTextField.setEchoChar((char)0);
                }
                if (confirmPasswordTextField.getText().isEmpty()){
                    confirmPasswordTextField.setText(confirmpassTxt);
                    confirmPasswordTextField.setEchoChar((char)0);
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
                if (confirmPasswordTextField.getText().isEmpty()){
                    confirmPasswordTextField.setText(confirmpassTxt);
                    confirmPasswordTextField.setEchoChar((char)0);
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
                if (passwordTextField.getText().isEmpty()){
                    passwordTextField.setText(passTxt);
                    passwordTextField.setEchoChar((char)0);
                }
            }
        });

        //set register button
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = emailTextField.getText();
                String password = passwordTextField.getText();
                String confirmPassword = confirmPasswordTextField.getText();
                if (email.isEmpty() || email.equals(userTxt)) {
                    Status.setText(emptyUsername);
                    sta = false;
                } else if (password.isEmpty() || password.equals(passTxt)) {
                    Status.setText(emptyPasswd);
                    sta = false;
                } else if (!password.equals(confirmPassword)) {
                    Status.setText(passwdNotMatch);
                    sta = false;
                }else if (Customer.isSelected() || Worker.isSelected()){
                    try {
                        if(DataBaseFB.checkUser(email)) {
                            Status.setText("User already exists");
                            sta = false;
                        }
                    } catch (FirebaseException ex) {
                        throw new RuntimeException(ex);
                    } catch (JacksonUtilityException ex) {
                        throw new RuntimeException(ex);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                    JOptionPane.showMessageDialog(null, "Register successfully!");
                if (Customer.isSelected()) {
                    type = "Customer";
                    Customer customer = new Customer(email);
                    customer.setPassword(password);
                    customer.resetClothes();
                    try {
                        DataBaseFB.updateCustomerData(customer.getName(),customer);
                    } catch (FirebaseException | JacksonUtilityException | IOException ex) {
                        throw new RuntimeException(ex);
                    }
                    try {
                        DataBaseFB.addNewUser(email, password, type);
                    } catch (FirebaseException | IOException | JacksonUtilityException ex) {
                        throw new RuntimeException(ex);
                    }
                } else if (Worker.isSelected()) {
                    type = "Worker";
                    Worker worker = new Worker(email);
                    worker.setPassword(password);
                    try {
                        DataBaseFB.updateWorkerData(worker.getName(),worker);
                    } catch (FirebaseException | JacksonUtilityException | IOException ex) {
                        throw new RuntimeException(ex);
                    }
                    try {
                        DataBaseFB.addNewUser(email, password, type);
                    } catch (FirebaseException | IOException | JacksonUtilityException ex) {
                        throw new RuntimeException(ex);
                    }
                }
                frame.setContentPane(new Login(frame, customer,worker).getLoginPanel());
                frame.revalidate();
                }else {
                    Status.setText("Please select your type");
                }
            }
        });

        Back_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setContentPane(new Login(frame,customer,worker).getLoginPanel());
                frame.revalidate();
            }
        });

    }

    //getter
    public JPanel getRegisterPanel() {
        return RegisterPanel;
    }





//    registerButton.setBounds(x_pos, y_pos, 30, 25);
//    registerButton.setBorder(new RoundedBorder(10)); //10 is the radius
//    registerButton.setForeground(Color.BLUE);

    private static class RoundedBorder implements Border {

        private int radius;


        RoundedBorder(int radius) {
            this.radius = radius;
        }


        public Insets getBorderInsets(Component c) {
            return new Insets(this.radius+1, this.radius+1, this.radius+2, this.radius);
        }


        public boolean isBorderOpaque() {
            return true;
        }


        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            g.drawRoundRect(x, y, width-1, height-1, radius, radius);
        }
    }
}
