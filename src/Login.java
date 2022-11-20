import AbstactClass.LoginNRegister;
import net.thegreshams.firebase4j.error.FirebaseException;
import net.thegreshams.firebase4j.error.JacksonUtilityException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
        emailTextField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (emailTextField.getText().equals(userTxt)) {
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
        if (emailTextField.getText().isEmpty()) {
            emailTextField.setText(userTxt);
        }

        //set Login button
        LoginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = emailTextField.getText();
                String password = PasswordTextField.getText();
                try {
                    CheckValidations(email, password, frame, customer);
                } catch (JacksonUtilityException | FirebaseException | IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        //set Register button
        RegisterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setContentPane(new Register(frame, customer,worker).getRegisterPanel());
                frame.revalidate();
            }
        });
    }

    //check validation
    private void CheckValidations(String email, String password, JFrame frame, Customer customer) throws JacksonUtilityException, FirebaseException, IOException {
        if (email.isEmpty() || email.equals(userTxt)) {
            Status.setText(emptyUsername);
        } else if (password.isEmpty() || password.equals(passTxt)) {
            Status.setText(emptyPasswd);
        } else {
            if (DataBaseFB.checkUserPass(email, password)) {
                //check if user is customer or worker
                if(DataBaseFB.checkType(email).equals("Customer")){
                    //set panel
                    frame.setContentPane(new Home(frame, customer).getHomePanel());
                    frame.revalidate();
                }
                else if (DataBaseFB.checkType(email).equals("Worker")){
                    //set panel
                    Worker worker = new Worker();
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
