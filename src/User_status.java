import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class User_status {
    private JButton NewOrderButton;
    private JButton OtherButton;
    private JButton Home_Button;
    private JPanel User_StatusPanel;

    public User_status(JFrame frame, Customer customer){
        Color colour5 = new Color(189, 250, 253);
        User_StatusPanel.setBackground(colour5);
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
                frame.setContentPane((new Home(frame,customer).getHomePanel()));
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
