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
        final String[] c = {Objects.requireNonNull(comboBox1.getSelectedItem()).toString()};
//        if(c =="Select customer:"){
//            combobox2.setVisible(false);
//        }
//        else{
//            combobox2.setVisible(true);
//               c= Objects.requireNonNull(comboBox1.getSelectedItem()).toString();
//               int num = DataBaseFB.getHistoryAmount(c);
//                String[] boxList = new String[num];
//                for(int i=0; i<num; i++) {
//                    boxList[i] = String.valueOf(i + 1);
//                    //create array
//                    arr = Arrays.copyOf(Objects.requireNonNull(DataBaseFB.getHistory(c, i + 1)).toArray(), Objects.requireNonNull(DataBaseFB.getHistory(c, i + 1)).size(), String[].class);
//                    //check status
//                    if(arr[15].equals("-2")||arr[15].equals("-1")){
//                        combobox2.addItem(i+1);
//                    }
//                }
//        }
        comboBox1.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                String c = Objects.requireNonNull(comboBox1.getSelectedItem()).toString();
                int num = 0;
                try {
                    num = DataBaseFB.getHistoryAmount(c);
                } catch (FirebaseException | JacksonUtilityException | IOException ex) {
                    throw new RuntimeException(ex);
                }
                String[] boxList = new String[num];
                String [] arr;
                for(int i=0; i<num; i++) {
                    boxList[i] = String.valueOf(i + 1);
                    //create array
                    try {
                        arr = (String[]) Arrays.copyOf(Objects.requireNonNull(DataBaseFB.getHistory(c, i)).toArray(), Objects.requireNonNull(DataBaseFB.getHistory(c, i )).size());
                    } catch (FirebaseException | JacksonUtilityException | IOException ex) {
                        throw new RuntimeException(ex);
                    }
                    //check status
                    if(arr[15].equals("-2")|| arr[15].equals("-1")){
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

            }
        });
    }

    public JPanel getworker_status(){ return worker_statuspanel;}
}
