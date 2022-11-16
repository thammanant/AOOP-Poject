import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Report {
    private JPanel ReportPanel;
    private JButton Exit_button;

    public Report(JFrame frame){
        Exit_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setContentPane(new Home(frame).getHomePanel());
                frame.revalidate();
            }
        });
    }
    public JPanel getReportPanel(){
        return ReportPanel;
    }
}
