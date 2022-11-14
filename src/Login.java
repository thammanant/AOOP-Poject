import Picture.LoginNRegister;

import javax.swing.*;
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
        emailTextField.setText(this.userTxt);
        emailTextField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                emailTextField.setText("");
            }
        });
        //set password field
        PasswordTextField.setText(this.passTxt);
        PasswordTextField.setEchoChar((char) 0);
        PasswordTextField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                PasswordTextField.setText("");
                PasswordTextField.setEchoChar(passwdChar);
            }
        });

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
