import net.thegreshams.firebase4j.error.FirebaseException;
import net.thegreshams.firebase4j.error.JacksonUtilityException;

import javax.print.attribute.standard.DateTimeAtProcessing;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class worker_status {
    private JButton OtherButton;
    private JButton Home_Button;
    private JPanel worker_statuspanel;
    private JComboBox comboBox1;
    private JButton confirm_button;
    private JComboBox combobox2;

    public worker_status(JFrame frame,Worker worker) throws JacksonUtilityException, FirebaseException, IOException {
        Color colour18 = new Color(39, 59, 105);
        worker_statuspanel.setBackground(colour18);
        final String[][] arr = new String[1][1];
        arr[0] = Arrays.copyOf(DataBaseFB.findAllCustomerUsernames().toArray(), DataBaseFB.findAllCustomerUsernames().size(), String[].class);
        for(int i = 0; i< arr[0].length; i++){
            if(DataBaseFB.getHistoryAmount(arr[0][i])>0 && !(Objects.requireNonNull(DataBaseFB.getHistory(arr[0][i], DataBaseFB.getHistoryAmount(arr[0][i]))).get(15).equals("-3"))){
                comboBox1.addItem(arr[0][i]);
            }
        }
        comboBox1.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                String c = Objects.requireNonNull(comboBox1.getSelectedItem()).toString();
                int num;
                List<String> history;
                String a;
                try {
                    num = DataBaseFB.getHistoryAmount(c);
                } catch (FirebaseException | JacksonUtilityException | IOException ex) {
                    throw new RuntimeException(ex);
                }
                combobox2.removeAllItems();
                try {
                    history = DataBaseFB.getHistory(c, num);
                    assert history != null;
                } catch (FirebaseException | JacksonUtilityException | IOException ex) {
                    throw new RuntimeException(ex);
                }
                a = history.get(15);
                for(int i = 0; i< num; i++){
                    if(Objects.equals(a, "-1")){
                        combobox2.addItem(i+1);
                    }
                    if(Objects.equals(a, "-2")){
                        combobox2.addItem(i+1);
                    }
                }
            }
        });
//

        Home_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    frame.setContentPane((new Home_worker(frame,worker).get_Home_worker_panel()));
                } catch (FirebaseException | JacksonUtilityException | IOException ex) {
                    throw new RuntimeException(ex);
                }
                frame.revalidate();
            }
        });
        OtherButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setContentPane((new Other_Worker(frame,worker).getWorkerOtherPanel()));
                frame.revalidate();
            }
        });
        confirm_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String n =comboBox1.getSelectedItem().toString();
                String i = combobox2.getSelectedItem().toString();
                if(comboBox1.getSelectedItem().toString() == "Select customer:"){
                    JOptionPane.showMessageDialog(null, "Please select a customer");
                }
                else if(combobox2.getSelectedItem().toString() == "Select order:"){
                    JOptionPane.showMessageDialog(null, "Please select an order");
                }
                else {
                    try {
                        frame.setContentPane(new History_detail_worker(frame, worker,n, i).get_history_detail_worker());
                    } catch (JacksonUtilityException | FirebaseException | IOException ex) {
                        throw new RuntimeException(ex);
                    }
                    frame.revalidate();
                }
            }
        });
    }

    public JPanel getworker_status(){ return worker_statuspanel;}
}
