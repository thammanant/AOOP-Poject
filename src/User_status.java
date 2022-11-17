import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class User_status {
    private JButton NewOrderButton;
    private JButton OtherButton;
    private JButton Home_Button;
    private JPanel User_StatusPanel;

    public User_status(JFrame frame){
        NewOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setContentPane((new Order(frame).getOrderPanel()));
                frame.revalidate();
            }
        });

        //goto home page
        Home_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setContentPane((new Home(frame).getHomePanel()));
                frame.revalidate();
            }
        });

        OtherButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setContentPane((new Other(frame).getOtherPanel()));
                frame.revalidate();
            }
        });
    }
    public JPanel getUser_StatusPanel(){
        return User_StatusPanel;
    }
}
