import Picture.LoginNRegister;
import net.thegreshams.firebase4j.error.FirebaseException;
import net.thegreshams.firebase4j.error.JacksonUtilityException;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class Login extends LoginNRegister {
    private JPanel LoginPanel;
    private JTextField emailTextField;
    private JPasswordField PasswordTextField;
    private JButton RegisterButton;
    private JButton LoginButton;
    private JLabel image;
    private JLabel Status;


    public Login(JFrame frame) {
        //change panel theme
        LoginPanel.setBackground(colour5);

        //set text field
        emailTextField.setText(userTxt);
        emailTextField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(emailTextField.getText().equals(userTxt)){
                    emailTextField.setText("");
                }

                super.mouseClicked(e);

                if (PasswordTextField.getText().isEmpty()) {
                    PasswordTextField.setText(passTxt);
                    PasswordTextField.setEchoChar((char) 0);
                }
            }
        });
        //set password field
        PasswordTextField.setText(passTxt);
        PasswordTextField.setEchoChar((char) 0);
        PasswordTextField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (PasswordTextField.getText().equals(passTxt)) {
                    PasswordTextField.setText("");
                }

                super.mouseClicked(e);
                PasswordTextField.setEchoChar(passwdChar);

                if (emailTextField.getText().isEmpty()) {
                    emailTextField.setText(userTxt);
                }
            }
        });
        if (emailTextField.getText().isEmpty()){
            emailTextField.setText(userTxt);
        }

        //set Login button
        LoginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = emailTextField.getText();
                String password = PasswordTextField.getText();
                try {
                    CheckValidations(email, password, frame);
                } catch (JacksonUtilityException | FirebaseException | IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        //set Register button
        RegisterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setContentPane(new Register(frame).getRegisterPanel());
                frame.revalidate();
            }
        });
    }

    //check validation
    private void CheckValidations(String email, String password, JFrame frame) throws JacksonUtilityException, FirebaseException, IOException {
        if (email.isEmpty() || email.equals(userTxt)) {
            Status.setText(emptyUsername);
        } else if (password.isEmpty() || password.equals(passTxt)) {
            Status.setText(emptyPasswd);
        } else {
            //check if user exists
            if (DataBaseFB.checkUser(email, password)) {
                //if user exists, go to main menu
                JOptionPane.showMessageDialog(null, "Login Successful!");
                //change panel
                frame.setContentPane(new Home(frame).getHomePanel());
                frame.revalidate();;
            } else {
                Status.setText("User does not exist!");
            }
        }
    }

    //getters
    public JPanel getLoginPanel() {
        return LoginPanel;
    }
}
