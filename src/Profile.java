import net.thegreshams.firebase4j.error.FirebaseException;
import net.thegreshams.firebase4j.error.JacksonUtilityException;

import javax.swing.*;
import java.io.IOException;

public class Profile {
    private JPanel panel1;
    private JLabel Profile_icon;
    private JButton Chat_icon;
    private JButton exit_button;
    private JButton Back_button;
    private JLabel Name;
    private JLabel Phone;

    public Profile(JFrame frame, Customer customer) {
        Name.setText("Name: " + customer.getName());
        String phone;
        if(customer.getPhone() != null){
            phone = customer.getPhone();
        }
        else{
            phone = "None";
        }
        Phone.setText("Contact: " + phone);
        exit_button.addActionListener(e -> {
            try {
                frame.setContentPane(new Home(frame,customer).getHomePanel());
            } catch (JacksonUtilityException | FirebaseException | IOException ex) {
                throw new RuntimeException(ex);
            }
            frame.revalidate();
        });
        Back_button.addActionListener(e -> {
            frame.setContentPane(new Other(frame,customer).getOtherPanel());
            frame.revalidate();
        });
        // set chat button
        Chat_icon.addActionListener(e -> {
            JOptionPane.showMessageDialog(null,"Coming soon","Message",JOptionPane.PLAIN_MESSAGE);
            frame.setContentPane(new Profile(frame,customer).get_profilePanel());
            frame.revalidate();
        });
    }


    public JPanel get_profilePanel(){
       return panel1;
    }
}
