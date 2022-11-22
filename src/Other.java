import net.thegreshams.firebase4j.error.FirebaseException;
import net.thegreshams.firebase4j.error.JacksonUtilityException;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
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

        HomeButton.addActionListener(e -> {
            try {
                frame.setContentPane((new Home(frame,customer).getHomePanel()));
            } catch (JacksonUtilityException | FirebaseException | IOException ex) {
                throw new RuntimeException(ex);
            }
            frame.revalidate();
        });
        //goto history of the done order
        History_Button.addActionListener(e -> {
            int next = 0;
            int size;
            try {
                size = DataBaseFB.getHistoryAmount(customer.getName());
            } catch (FirebaseException | JacksonUtilityException | IOException ex) {
                throw new RuntimeException(ex);
            }
            String[] arr = new String[size];
            for (int i = 0; i < size; i++) {
                try {
                    arr[i] = Objects.requireNonNull(DataBaseFB.getHistory(customer.getName(), i + 1)).get(15);
                } catch (FirebaseException | JacksonUtilityException | IOException ex) {
                    throw new RuntimeException(ex);
                }
                if (arr[i].equals("-3")) {
                    next++;
                }
            }
            if (next > 0) {
                try {
                    frame.setContentPane(new History(frame, customer).getHistoryPanel());
                } catch (JacksonUtilityException | FirebaseException | IOException ex) {
                    throw new RuntimeException(ex);
                }
                frame.revalidate();
            } else if (next == 0) {
                JOptionPane.showMessageDialog(null, "You don't have any order yet");
            }
        });

        //goto the customer's profile
        Profile_Button.addActionListener(e -> {
            frame.setContentPane((new Profile(frame, customer).get_profilePanel()));
            frame.revalidate();
        });

        //goto report
        Order_Button.addActionListener(e -> {
            frame.setContentPane((new Report(frame,customer).get_Report_panel()));
            frame.revalidate();
        });

        Logout_button.addActionListener(e -> {
            frame.setContentPane((new Login(frame,customer, new Worker()).getLoginPanel()));
            frame.revalidate();
        });
    }


    public JPanel getOtherPanel(){
        return OtherPanel;
    }

}

