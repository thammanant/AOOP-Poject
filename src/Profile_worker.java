import com.sun.source.tree.WhileLoopTree;
import net.thegreshams.firebase4j.error.FirebaseException;
import org.apache.http.client.params.ClientPNames;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.UnsupportedEncodingException;

public class Profile_worker {
    private JPanel Profile_worker;
    private JLabel Profile_icon;
    private JButton Back_button;
    private JButton exit_button;
    private JButton Chat_icon;
    private JButton Edit;
    private JLabel NamePanel;
    private JLabel ContactPanel;


    public Profile_worker(JFrame frame, Worker worker) throws FirebaseException, UnsupportedEncodingException {
        NamePanel.setText("Name: " + DataBaseFB.getWorkerName(worker.getName()));
        String workerPhone = "";
        if(worker.getPhone() != null){
            workerPhone = worker.getPhone();
        }
        else {

            worker.setPhone("None");
        }
        ContactPanel.setText("Contact: " + workerPhone);

        exit_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    frame.setContentPane(new Home_worker(frame,worker).get_Home_worker_panel());
                } catch (FirebaseException | UnsupportedEncodingException ex) {
                    throw new RuntimeException(ex);
                }
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
                try {
                    frame.setContentPane(new Profile_worker(frame,worker).get_profile_worker());
                } catch (FirebaseException | UnsupportedEncodingException ex) {
                    throw new RuntimeException(ex);
                }
                frame.revalidate();
            }
        });
        Edit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String phone = worker.getPhone();
                String input = JOptionPane.showInputDialog(null,"Please enter your phone");
                if(phone.compareTo(input)!=0){
                    JOptionPane.showMessageDialog(null,"Done!");
                    worker.setPhone(input);
                    try {
                        frame.setContentPane(new Profile_worker(frame,worker).get_profile_worker());
                    } catch (FirebaseException | UnsupportedEncodingException ex) {
                        throw new RuntimeException(ex);
                    }
                    frame.revalidate();
                }
                else {
                    JOptionPane.showMessageDialog(null,"Phone number has already been registered!");
                }
            }
        });
    }

    public JPanel get_profile_worker(){
        return Profile_worker;
    }
}
