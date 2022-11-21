import net.thegreshams.firebase4j.error.FirebaseException;
import net.thegreshams.firebase4j.error.JacksonUtilityException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class User_status {
    private JButton NewOrderButton;
    private JButton OtherButton;
    private JButton Home_Button;
    private JPanel User_StatusPanel;
    private JComboBox comboBox1;
    private JButton confirm_button;

    public User_status(JFrame frame, Customer customer){
        NewOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setContentPane((new Order(frame, customer).getOrderPanel()));
                frame.revalidate();
            }
        });

        //goto home page
        Home_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    frame.setContentPane((new Home(frame,customer).getHomePanel()));
                } catch (JacksonUtilityException | FirebaseException | IOException ex) {
                    throw new RuntimeException(ex);
                }
                frame.revalidate();
            }
        });

        OtherButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setContentPane((new Other(frame,customer).getOtherPanel()));
                frame.revalidate();
            }
        });
    }
    public JPanel getUser_StatusPanel(){
        return User_StatusPanel;
    }
}
