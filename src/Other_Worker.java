import net.thegreshams.firebase4j.error.FirebaseException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.UnsupportedEncodingException;

public class Other_Worker {
    private JPanel WorkerOtherPanel;
    private JButton WorkerReportButton;
    private JButton WorkerProfileButton;
    private JButton WorkerHomeButton;
    private JButton Logout_button;

    public Other_Worker(JFrame frame, Worker worker){
        Color colour3 = new Color(4, 116, 140);
        WorkerOtherPanel.setBackground(colour3);
        //set text button
        WorkerProfileButton.setText("\u2022 Profile");
        WorkerReportButton.setText("\u2022 Report");
        // set worker profile button
        WorkerProfileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        //set worker report button
        WorkerReportButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                frame.setContentPane(new Report(frame,worker).get_Report_panel());
            }
        });
        //set worker home button
        WorkerHomeButton.addActionListener(new ActionListener() {
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
        //set worker profile button
        WorkerProfileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setContentPane(new Profile_worker(frame,worker).get_profile_worker());
                frame.revalidate();
            }
        });

        Logout_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setContentPane((new Login(frame,new Customer(),worker).getLoginPanel()));
                frame.revalidate();
            }
        });
    }
    public JPanel getWorkerOtherPanel() {return WorkerOtherPanel;}
}
