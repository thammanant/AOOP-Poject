import net.thegreshams.firebase4j.error.FirebaseException;
import net.thegreshams.firebase4j.error.JacksonUtilityException;

import javax.print.attribute.standard.DateTimeAtProcessing;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;

public class worker_status {
    private JButton OtherButton;
    private JButton Home_Button;
    private JPanel worker_statuspanel;
    private JComboBox comboBox1;
    private JButton confirm_button;

    public worker_status(JFrame frame,Worker worker) throws JacksonUtilityException, FirebaseException, IOException {
        Color colour18 = new Color(39, 59, 105);
        worker_statuspanel.setBackground(colour18);
        String[] arr ;
        arr = Arrays.copyOf(DataBaseFB.findAllCustomerUsernames().toArray(), DataBaseFB.findAllCustomerUsernames().size(), String[].class);
        for(int i =0; i<arr.length; i++){
            if(DataBaseFB.getHistoryAmount(arr[i])>0 && !(Objects.requireNonNull(DataBaseFB.getHistory(arr[i], DataBaseFB.getHistoryAmount(arr[i]))).get(15).equals("-3"))){
                comboBox1.addItem(arr[i]);
            }
        }

        Home_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    frame.setContentPane((new Home_worker(frame,worker).get_Home_worker_panel()));
                } catch (FirebaseException | JacksonUtilityException | IOException ex) {
                    throw new RuntimeException(ex);
                }
                frame.revalidate();
            }
        });
        OtherButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setContentPane((new Other_Worker(frame,worker).getWorkerOtherPanel()));
                frame.revalidate();
            }
        });
        confirm_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public JPanel getworker_status(){ return worker_statuspanel;}
}
