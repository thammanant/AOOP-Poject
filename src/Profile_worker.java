import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Profile_worker {
    private JPanel Profile_worker;
    private JLabel Profile_icon;
    private JButton Back_button;
    private JButton exit_button;
    private JButton Chat_icon;
    private JButton Edit;
    private JLabel NamePanel;
    private JLabel ContactPanel;


    public Profile_worker(JFrame frame, Worker worker){
        Color colour5 = new Color(189, 250, 253);
        Profile_worker.setBackground(colour5);

        NamePanel.setText("Name: " + worker.getName());
        ContactPanel.setText("Contact: "+ worker.getPhone());
        exit_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setContentPane(new Home_worker(frame,worker).get_Home_worker_panel());
                frame.revalidate();
            }
        });
        Back_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setContentPane(new Other_Worker(frame,worker).getWorkerOtherPanel());
                frame.revalidate();
            }
        });
        // set chat button
        Chat_icon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"Coming soon","Message",JOptionPane.PLAIN_MESSAGE);
                frame.setContentPane(new Profile_worker(frame,worker).get_profile_worker());
                frame.revalidate();
            }
        });
    }

    public JPanel get_profile_worker(){
        return Profile_worker;
    }
}
