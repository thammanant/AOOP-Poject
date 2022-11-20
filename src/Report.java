import AbstactClass.User;
import net.thegreshams.firebase4j.error.FirebaseException;
import net.thegreshams.firebase4j.error.JacksonUtilityException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Report {
    private JPanel Report_panel;
    private JTextArea reportTextArea;
    private JButton Send_button;
    private JButton exit_button;
    private JButton Back_button;

    public Report(JFrame frame, Customer customer){
        Color colour18 = new Color(39, 59, 105);
        Report_panel.setBackground(colour18);
        exit_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    frame.setContentPane(new Home(frame,customer).getHomePanel());
                } catch (JacksonUtilityException | FirebaseException | IOException ex) {
                    throw new RuntimeException(ex);
                }
                frame.revalidate();
            }
        });

        Back_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setContentPane(new Other(frame,customer).getOtherPanel());
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
                    JOptionPane.showMessageDialog(null, "The report has been sented");
                    //change panel
                    try {
                        frame.setContentPane(new Home(frame, customer).getHomePanel());
                    } catch (JacksonUtilityException | FirebaseException | IOException ex) {
                        throw new RuntimeException(ex);
                    }
                    frame.revalidate();
                }
            }
        });
    }

    public JPanel get_Report_panel(){
        return Report_panel;
    }
}
