import Picture.LoginNRegister;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Register extends LoginNRegister {
    private JPanel RegisterPanel;
    private JTextField emailTextField;
    private JButton registerButton;
    private JPasswordField passwordTextField;
    private JPasswordField confirmPasswordTextField;

    public Register(JFrame frame) {
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
        passwordTextField.setText(passTxt);
        passwordTextField.setEchoChar((char) 0);
        passwordTextField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                passwordTextField.setText("");
                passwordTextField.setEchoChar(passwdChar);
            }
        });

        //set confirm password field
        confirmPasswordTextField.setText(confirmpassTxt);
        confirmPasswordTextField.setEchoChar((char) 0);
        confirmPasswordTextField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                confirmPasswordTextField.setText("");
                confirmPasswordTextField.setEchoChar(passwdChar);
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
                    JOptionPane.showMessageDialog(null, emptyUsername);
                } else if (password.isEmpty() || password.equals(passTxt)) {
                    JOptionPane.showMessageDialog(null, emptyPasswd);
                } else if (!password.equals(confirmPassword)) {
                    JOptionPane.showMessageDialog(null, passwdNotMatch);
                } else {
                    JOptionPane.showMessageDialog(null, "Register successfully!");
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
