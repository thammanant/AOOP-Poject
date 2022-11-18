
import Picture.LoginNRegister;
import net.thegreshams.firebase4j.error.FirebaseException;
import net.thegreshams.firebase4j.error.JacksonUtilityException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class Register extends LoginNRegister {
    private JPanel RegisterPanel;
    private JTextField emailTextField;
    private JButton registerButton;
    private JPasswordField passwordTextField;
    private JPasswordField confirmPasswordTextField;
    private JLabel Status;

    public Register(JFrame frame) {
        //set text field
        emailTextField.setText(this.userTxt);
        emailTextField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (emailTextField.getText().equals(userTxt)) {
                    emailTextField.setText("");
                }
                super.mouseClicked(e);

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
        passwordTextField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (passwordTextField.getText().equals(passTxt)) {
                    passwordTextField.setText("");
                }
                super.mouseClicked(e);
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
        confirmPasswordTextField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (confirmPasswordTextField.getText().equals(confirmpassTxt)) {
                    confirmPasswordTextField.setText("");
                }
                confirmPasswordTextField.setEchoChar(passwdChar);
                super.mouseClicked(e);

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
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = emailTextField.getText();
                String password = passwordTextField.getText();
                String confirmPassword = confirmPasswordTextField.getText();
                if (username.isEmpty() || username.equals(userTxt)) {
                    Status.setText(emptyUsername);
                } else if (password.isEmpty() || password.equals(passTxt)) {
                    Status.setText(emptyPasswd);
                } else if (!password.equals(confirmPassword)) {
                    Status.setText(passwdNotMatch);
                } else {
                    try {
                        DataBaseFB.put(username, password);
                    } catch (JacksonUtilityException | FirebaseException | IOException ex) {
                        throw new RuntimeException(ex);
                    }
                    Status.setText("Register Success");
                    frame.setContentPane(new Login(frame).getLoginPanel());
                    frame.revalidate();
                }
            }

        });
    }

    //getter
    public JPanel getRegisterPanel() {
        return RegisterPanel;
    }
}
