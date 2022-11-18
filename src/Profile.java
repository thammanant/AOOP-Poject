import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Profile {
    private JPanel panel1;
    private JLabel Profile_icon;
    private JButton Chat_icon;
    private JButton exit_button;
    private JButton Back_button;

    public Profile(JFrame frame, Customer customer) {
        exit_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setContentPane(new Home(frame,customer).getHomePanel());
                frame.revalidate();
            }
        });
        Back_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setContentPane(new Other(frame,customer).getOtherPanel());
                frame.revalidate();
            }
        });
    }


    public JPanel get_profilepanel(){
       return panel1;
    }
}
