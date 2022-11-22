import net.thegreshams.firebase4j.error.FirebaseException;
import net.thegreshams.firebase4j.error.JacksonUtilityException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;

public class Other {
    private JPanel OtherPanel;
    private JButton HomeButton;
    private JButton History_Button;
    private JButton Order_Button;
    private JButton Profile_Button;
    private JPanel MenuPanel;
    private JButton Logout_button;

    public Other(JFrame frame, Customer customer){
        Color colour18 = new Color(39, 59, 105);
        MenuPanel.setBackground(colour18);

        History_Button.setText("\u2022 History");
        Profile_Button.setText("\u2022 Profile");
        Order_Button.setText("\u2022 Report");

        HomeButton.addActionListener(new ActionListener() {
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
        //goto history of the done order
        History_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if(customer.check_history()=="0"){
                        frame.setContentPane(new History(frame,customer).getHistoryPanel());
                        frame.revalidate();
                    } else{
                        JOptionPane.showMessageDialog(null, "You don't have any order yet");
                    }
                } catch (JacksonUtilityException | FirebaseException | IOException ex) {
                    throw new RuntimeException(ex);
                }


            }
        });

        //goto the customer's profile
        Profile_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setContentPane((new Profile(frame, customer).get_profilepanel()));
                frame.revalidate();
            }
        });

        //goto report
        Order_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setContentPane((new Report(frame,customer).get_Report_panel()));
                frame.revalidate();
            }
        });

        Logout_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setContentPane((new Login(frame,customer, new Worker()).getLoginPanel()));
                frame.revalidate();
            }
        });
    }


    public JPanel getOtherPanel(){
        return OtherPanel;
    }

}

