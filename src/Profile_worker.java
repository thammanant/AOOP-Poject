import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Profile_worker {
    private JPanel Profile_worker;
    private JLabel Profile_icon;
    private JButton Back_button;
    private JButton exit_button;
    private JButton Chat_icon;

    public Profile_worker(JFrame frame){
        exit_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setContentPane(new Home(frame).getHomePanel());
                frame.revalidate();
            }
        });
        Back_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setContentPane(new Other(frame).getOtherPanel());
                frame.revalidate();
            }
        });

    }

    public JPanel get_profile_worker(){
        return Profile_worker;
    }
}
