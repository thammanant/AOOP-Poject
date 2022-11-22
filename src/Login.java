import AbstactClass.LoginNRegister;
import net.thegreshams.firebase4j.error.FirebaseException;
import net.thegreshams.firebase4j.error.JacksonUtilityException;

import javax.swing.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.io.IOException;
import java.util.Objects;

public class Login extends LoginNRegister {
    private JPanel LoginPanel;
    private JTextField emailTextField;
    private JPasswordField PasswordTextField;
    private JButton RegisterButton;
    private JButton LoginButton;
    private JLabel image;
    private JLabel Status;


    public Login(JFrame frame, Customer customer,Worker worker) {

//        LoginButton.setBorder(new RoundBo);
        //change panel theme
        LoginPanel.setBackground(colour18);

        //set text field
        emailTextField.setText(userTxt);
        emailTextField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (emailTextField.getText().equals(userTxt)) {
                    emailTextField.setText("");
                }

                super.focusGained(e);

                if (PasswordTextField.getText().isEmpty()) {
                    PasswordTextField.setText(passTxt);
                    PasswordTextField.setEchoChar((char) 0);
                }
            }
        });
        //set password field
        PasswordTextField.setText(passTxt);
        PasswordTextField.setEchoChar((char) 0);
        PasswordTextField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (PasswordTextField.getText().equals(passTxt)) {
                    PasswordTextField.setText("");
                }

                super.focusGained(e);
                PasswordTextField.setEchoChar(passwdChar);

                if (emailTextField.getText().isEmpty()) {
                    emailTextField.setText(userTxt);
                }
            }
        });
        if (emailTextField.getText().isEmpty()) {
            emailTextField.setText(userTxt);
        }

        //set Login button
        LoginButton.addActionListener(e -> {
            String email = emailTextField.getText();
            String password = PasswordTextField.getText();
            try {
                CheckValidations(email, password, frame);
            } catch (JacksonUtilityException | FirebaseException | IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        //set Register button
        RegisterButton.addActionListener(e -> {
            frame.setContentPane(new Register(frame, customer,worker).getRegisterPanel());
            frame.revalidate();
        });
    }

    //check validation
    private void CheckValidations(String email, String password, JFrame frame) throws JacksonUtilityException, FirebaseException, IOException {
        if (email.isEmpty() || email.equals(userTxt)) {
            Status.setText(emptyUsername);
        } else if (password.isEmpty() || password.equals(passTxt)) {
            Status.setText(emptyPasswd);
        } else {
            if (DataBaseFB.checkUserPass(email, password)) {
                //check if user is customer or worker
                if(Objects.equals(DataBaseFB.checkType(email), "Customer")){
                    //set panel
                    Customer customer1 = new Customer(DataBaseFB.getCustomerName(email), DataBaseFB.getCustomerAddress(email), DataBaseFB.getCustomerPhone(email));
                    customer1.setPassword(password);
                    frame.setContentPane(new Home(frame, customer1).getHomePanel());
                    frame.revalidate();
                }
                else if (Objects.equals(DataBaseFB.checkType(email), "Worker")){
                    //set panel
                    Worker worker = new Worker(DataBaseFB.getWorkerName(email));
                    frame.setContentPane(new Home_worker(frame,worker).get_Home_worker_panel());
                    frame.revalidate();
                }
                else {
                Status.setText(invalidUser);
                }
            }
            else {
                JOptionPane.showMessageDialog(null, invalidUser);
            }
        }


    }


    public JPanel getLoginPanel() {
        return LoginPanel;
    }
}

