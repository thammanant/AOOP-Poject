import net.thegreshams.firebase4j.error.FirebaseException;
import net.thegreshams.firebase4j.error.JacksonUtilityException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class Report_Worker {
    private JPanel Report_worker;
    private JTextArea reportTextArea;
    private JButton Send_button;
    private JButton Back_button;
    private JButton exit_button;

    public Report_Worker(JFrame frame, Worker worker){
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
        Send_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (reportTextArea.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null, "There is no message to sent");
                }
                else {
                    JOptionPane.showMessageDialog(null, "The report has been sent");
                    //change panel
                    try {
                        frame.setContentPane(new Home_worker(frame, worker).get_Home_worker_panel());
                    } catch (FirebaseException | IOException ex) {
                        throw new RuntimeException(ex);
                    }
                    frame.revalidate();
                }
            }
        });
    }

    public JPanel get_Report_Worker(){
        return Report_worker;
    }
}
