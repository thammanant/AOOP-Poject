import net.thegreshams.firebase4j.error.FirebaseException;
import net.thegreshams.firebase4j.error.JacksonUtilityException;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class History_detail_worker {
    private JPanel History_detail_worker;
    private JPanel history_detailpanel;
    private JLabel Num1;
    private JLabel CottonWh;
    private JLabel Num2;
    private JLabel CottonCol;
    private JLabel Amount1;
    private JLabel Amount3;
    private JLabel Num3;
    private JLabel Num4;
    private JLabel Num5;
    private JLabel Num6;
    private JLabel Num7;
    private JLabel Num8;
    private JLabel Num9;
    private JLabel Num10;
    private JLabel Num11;
    private JLabel Num12;
    private JLabel MixedWh;
    private JLabel MixedCol;
    private JLabel DelicatesWh;
    private JLabel DelicatesCol;
    private JLabel WoolWh;
    private JLabel WoolCol;
    private JLabel BabyWh;
    private JLabel BeddingCol;
    private JLabel BabyCol;
    private JLabel Num13;
    private JLabel Num14;
    private JLabel Amount4;
    private JLabel Amount5;
    private JLabel Amount6;
    private JLabel Amount7;
    private JLabel Amount8;
    private JLabel Amount9;
    private JLabel Amount10;
    private JLabel Amount11;
    private JLabel Amount12;
    private JLabel Amount13;
    private JLabel Amount14;
    private JLabel AmountTotal;
    private JLabel Total;
    private JButton okButton;
    private JButton Edit;
    private JLabel sta;
    private JLabel customer_ph;
    private JLabel name;

    public History_detail_worker(JFrame frame, Worker worker,String index_order){
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    frame.setContentPane(new worker_status(frame,worker).getworker_status());
                } catch (JacksonUtilityException | FirebaseException | IOException ex) {
                    throw new RuntimeException(ex);
                }
                frame.setVisible(true);
            }
        });
        Edit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = JOptionPane.showInputDialog(null,"Enter new status(Processing,Delivered)");
                if(sta.getText().compareTo(input)!=0){
                    JOptionPane.showMessageDialog(null,"Status changed");
                    sta.setText(input);
                    frame.setContentPane(new History_detail_worker(frame,worker,index_order).get_history_detail_worker());
                }else{
                    JOptionPane.showMessageDialog(null,"Status has already been registered!");
                }
            }
        });
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    frame.setContentPane(new worker_status(frame,worker).getworker_status());
                } catch (JacksonUtilityException | FirebaseException | IOException ex) {
                    throw new RuntimeException(ex);
                }
                frame.setVisible(true);
            }
        });
    }

    public JPanel get_history_detail_worker(){
        return history_detailpanel;
    }
}
