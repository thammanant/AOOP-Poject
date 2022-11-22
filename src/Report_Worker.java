import net.thegreshams.firebase4j.error.FirebaseException;
import net.thegreshams.firebase4j.error.JacksonUtilityException;

import javax.swing.*;
import java.io.IOException;

public class Report_Worker {
    private JPanel Report_worker;
    private JTextArea reportTextArea;
    private JButton Send_button;
    private JButton Back_button;
    private JButton exit_button;

    public Report_Worker(JFrame frame, Worker worker){
        exit_button.addActionListener(e -> {
            try {
                frame.setContentPane(new Home_worker(frame,worker).get_Home_worker_panel());
            } catch (FirebaseException | JacksonUtilityException | IOException ex) {
                throw new RuntimeException(ex);
            }
            frame.revalidate();
        });
        Back_button.addActionListener(e -> {
            frame.setContentPane(new Other_Worker(frame,worker).getWorkerOtherPanel());
            frame.revalidate();
        });
        Send_button.addActionListener(e -> {
            if (reportTextArea.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "There is no message to sent");
            }
            else {
                JOptionPane.showMessageDialog(null, "The report has been sent");
                //change panel
                try {
                    frame.setContentPane(new Home_worker(frame, worker).get_Home_worker_panel());
                } catch (FirebaseException | IOException | JacksonUtilityException ex) {
                    throw new RuntimeException(ex);
                }
                frame.revalidate();
            }
        });
    }

    public JPanel get_Report_Worker(){
        return Report_worker;
    }
}
