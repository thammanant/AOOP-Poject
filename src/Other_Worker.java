import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Other_Worker {
    private JPanel WorkerOtherPanel;
    private JButton WorkerReportButton;
    private JButton WorkerProfileButton;
    private JButton WorkerHomeButton;
    public Other_Worker(JFrame frame, Worker worker){
        Color colour5 = new Color(189, 250, 253);
        WorkerOtherPanel.setBackground(colour5);
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
                frame.setContentPane(new Home_worker(frame,worker).get_Home_worker_panel());
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
    }
    public JPanel getWorkerOtherPanel() {return WorkerOtherPanel;}
}
