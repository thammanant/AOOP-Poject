import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Report {
    private JPanel Report_panel;
    private JTextArea reportTextArea;
    private JButton Send_button;
    private JButton exit_button;
    private JButton Back_button;

    public Report(JFrame frame,Customer customer){
        Color colour5 = new Color(189, 250, 253);
        Report_panel.setBackground(colour5);
        exit_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setContentPane(new Home(frame,customer).getHomePanel());
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

    }

    public JPanel get_Report_panel(){
        return Report_panel;
    }
}
