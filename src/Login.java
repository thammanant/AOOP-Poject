import Picture.LoginNRegister;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Login extends LoginNRegister {
    private JPanel LoginPanel;
    private JTextField emailTextField;
    private JPasswordField PasswordTextField;
    private JButton RegisterButton;
    private JButton LoginButton;
    private JLabel image;


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
                CheckValidations(email, password);
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
    private void CheckValidations(String email, String password) {
        if (email.isEmpty() || email.equals(userTxt)) {
            JOptionPane.showMessageDialog(null, emptyUsername);
        } else if (password.isEmpty() || password.equals(passTxt)) {
            JOptionPane.showMessageDialog(null, emptyPasswd);
        } else {
            JOptionPane.showMessageDialog(null, "Login Successful!");
        }
    }

    //getters
    public JPanel getLoginPanel() {
        return LoginPanel;
    }
}
