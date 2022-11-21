import net.thegreshams.firebase4j.error.FirebaseException;
import net.thegreshams.firebase4j.error.JacksonUtilityException;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class worker_status {
    private JButton OtherButton;
    private JButton Home_Button;
    private JPanel worker_statuspanel;
    private JComboBox comboBox1;
    private JButton confirm_button;

    public worker_status(JFrame frame,Worker worker) throws JacksonUtilityException, FirebaseException, IOException {
        Color colour18 = new Color(39, 59, 105);
        worker_statuspanel.setBackground(colour18);
        int num = DataBaseFB.getHistoryAmount(worker.getName());
        String boxList[] = new String[num];
        for(int i=0 ; i<num ; i++){
            boxList[i] = String.valueOf(i+1);
        }
        if(boxList[15] == "-2" || boxList[15] == "-1") {
            for (int i = 0; i < num; i++) {
                comboBox1.addItem(boxList[i]);
            }
        }

    }

    public JPanel getworker_status(){ return worker_statuspanel;}
}
