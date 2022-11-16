import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Report {
    private JPanel Report_panel;
    private JTextArea reportTextArea;
    private JButton Send_button;
    private JButton exit_button;
    private JButton Back_button;

    public Report(JFrame frame){
        exit_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setContentPane(new Home(frame).getHomePanel());
                frame.revalidate();
            }
        });

        Back_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setContentPane(new Other(frame).getOtherPanel());
                frame.revalidate();
            }
        });

    }

    public JPanel get_Report_panel(){
        return Report_panel;
    }
}
