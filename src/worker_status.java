import javax.swing.*;
import java.awt.*;

public class worker_status {
    private JButton OtherButton;
    private JButton Home_Button;
    private JPanel worker_statuspanel;
    private JComboBox comboBox1;
    private JButton confirm_button;

    public worker_status(JFrame frame,Worker worker){
        Color colour18 = new Color(39, 59, 105);
        worker_statuspanel.setBackground(colour18);

    }

    public JPanel getworker_status(){ return worker_statuspanel;}
}
