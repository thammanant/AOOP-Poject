import AbstactClass.LoginNRegister;

import javax.swing.*;
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
                CheckValidations(email, password, frame);
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
    private void CheckValidations(String email, String password, JFrame frame) {
        if (email.isEmpty() || email.equals(userTxt)) {
            Status.setText(emptyUsername);
        } else if (password.isEmpty() || password.equals(passTxt)) {
            Status.setText(emptyPasswd);
        } else {
            JOptionPane.showMessageDialog(null, "Login Successful!");
            //change panel
            frame.setContentPane(new Home(frame).getHomePanel());
            frame.revalidate();
        }
    }

    //getters
    public JPanel getLoginPanel() {
        return LoginPanel;
    }
}
