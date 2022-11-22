import net.thegreshams.firebase4j.error.FirebaseException;
import net.thegreshams.firebase4j.error.JacksonUtilityException;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;

public class worker_status {
    private JButton OtherButton;
    private JButton Home_Button;
    private JPanel worker_statusPanel;
    private JComboBox comboBox1;
    private JButton confirm_button;
    private JComboBox combobox2;

    public worker_status(JFrame frame,Worker worker) throws JacksonUtilityException, FirebaseException, IOException {
        Color colour18 = new Color(39, 59, 105);
        worker_statusPanel.setBackground(colour18);
        final String[][] arr = new String[1][1];
        comboBox1.requestFocus();
        arr[0] = Arrays.copyOf(DataBaseFB.findAllCustomerUsernames().toArray(), DataBaseFB.findAllCustomerUsernames().size(), String[].class);
        for(int i = 0; i< arr[0].length; i++){
            if(DataBaseFB.getHistoryAmount(arr[0][i])>0 && !(Objects.requireNonNull(DataBaseFB.getHistory(arr[0][i], DataBaseFB.getHistoryAmount(arr[0][i]))).get(15).equals("-3"))){
                comboBox1.addItem(arr[0][i]);
            }
        }
        comboBox1.addItemListener(e -> {
            combobox2.removeAllItems();
            int num;
            try {
                num = DataBaseFB.getHistoryAmount(Objects.requireNonNull(comboBox1.getSelectedItem()).toString());
            } catch (FirebaseException | JacksonUtilityException | IOException ex) {
                throw new RuntimeException(ex);
            }
            String[] boxList = new String[num];
            String[] arr1;
            for(int i=0; i<num; i++) {
                boxList[i] = String.valueOf(i + 1);
                //create array
                try {
                    arr1 = Arrays.copyOf(Objects.requireNonNull(DataBaseFB.getHistory(comboBox1.getSelectedItem().toString(), i + 1)).toArray(), Objects.requireNonNull(DataBaseFB.getHistory(comboBox1.getSelectedItem().toString(), i + 1)).size(), String[].class);
                } catch (FirebaseException | JacksonUtilityException | IOException ex) {
                    throw new RuntimeException(ex);
                }
                //check status
                if(arr1[15].equals("-2") || arr1[15].equals("-1")) {
                    combobox2.addItem(i+1);
                }
            }
        });
//

        Home_Button.addActionListener(e -> {
            try {
                frame.setContentPane((new Home_worker(frame,worker).get_Home_worker_panel()));
            } catch (FirebaseException | JacksonUtilityException | IOException ex) {
                throw new RuntimeException(ex);
            }
            frame.revalidate();
        });
        OtherButton.addActionListener(e -> {
            frame.setContentPane((new Other_Worker(frame,worker).getWorkerOtherPanel()));
            frame.revalidate();
        });
        confirm_button.addActionListener(e -> {
            String n = Objects.requireNonNull(comboBox1.getSelectedItem()).toString();
            String i = Objects.requireNonNull(combobox2.getSelectedItem()).toString();
            if(Objects.equals(comboBox1.getSelectedItem().toString(), "Select customer:")){
                JOptionPane.showMessageDialog(null, "Please select a customer");
            }
            else if(Objects.equals(combobox2.getSelectedItem().toString(), "Select order:")){
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
        });
    }

    public JPanel getWorker_status(){ return worker_statusPanel;}
}
