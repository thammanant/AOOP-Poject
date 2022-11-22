import com.sun.source.tree.WhileLoopTree;
import net.thegreshams.firebase4j.error.FirebaseException;
import net.thegreshams.firebase4j.error.JacksonUtilityException;
import org.apache.http.client.params.ClientPNames;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Objects;

public class Profile_worker {
    private JPanel Profile_worker;
    private JLabel Profile_icon;
    private JButton Back_button;
    private JButton exit_button;
    private JButton Chat_icon;
    private JButton Edit;
    private JLabel NamePanel;
    private JLabel ContactPanel;


    public Profile_worker(JFrame frame, Worker worker) throws FirebaseException, IOException, JacksonUtilityException {
        NamePanel.setText("Name: " + DataBaseFB.getWorkerName(worker.getName()));
        String workerPhone = "None";
        if(DataBaseFB.getWorkerPhone(worker.getName()) != null){
            workerPhone = DataBaseFB.getWorkerPhone(worker.getName());
        }
        ContactPanel.setText("Contact: " + workerPhone);

        exit_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    frame.setContentPane(new Home_worker(frame,worker).get_Home_worker_panel());
                } catch (FirebaseException | JacksonUtilityException | IOException ex) {
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
                } catch (FirebaseException | IOException | JacksonUtilityException ex) {
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

                // check phone number is valid and update worker data in firebase
                if(input != null && input.length() == 10 && input.matches("[0-9]+")){
                    worker.setPhone(input);
                    ContactPanel.setText("Contact: " + worker.getPhone());
                    try {
                        DataBaseFB.updateWorkerData(worker.getName(),worker);
                    } catch (FirebaseException | JacksonUtilityException | IOException ex) {
                        throw new RuntimeException(ex);
                    }
                    JOptionPane.showMessageDialog(null,"Phone number updated","Message",JOptionPane.PLAIN_MESSAGE);
                }
                else if(Objects.equals(input, phone)){
                    JOptionPane.showMessageDialog(null,"Phone number is same","Message",JOptionPane.PLAIN_MESSAGE);
                }
                else{
                    JOptionPane.showMessageDialog(null,"Invalid phone number","Message",JOptionPane.PLAIN_MESSAGE);
                }
            }
        });
    }

    public JPanel get_profile_worker(){
        return Profile_worker;
    }
}
