import javax.swing.*;
import java.awt.*;

public class Report_Worker {
    private JPanel Report_worker;
    private JTextArea reportTextArea;
    private JButton Send_button;
    private JButton Back_button;
    private JButton exit_button;

    public Report_Worker(JFrame frame, Worker worker){
        Color colour5 = new Color(189, 250, 253);
        Report_worker.setBackground(colour5);


    }

    public JPanel get_Report_Worker(){
        return Report_worker;
    }
}
