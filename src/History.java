import net.thegreshams.firebase4j.error.FirebaseException;
import net.thegreshams.firebase4j.error.JacksonUtilityException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.util.Arrays;

public class History {
    private JButton Exit_button;
    private JPanel HistoryPanel;
    private JButton Back_button;
    private JPanel panel2;
    private JComboBox comboBox1;
    private JButton confirm_button;

    public History(JFrame frame, Customer customer) throws JacksonUtilityException, FirebaseException, IOException {
        Color colour18 = new Color(39, 59, 105);
        HistoryPanel.setBackground(colour18);
        int num = DataBaseFB.getHistoryAmount(customer.getName());
        String boxList[] = new String[num];
        for(int i=0; i<num; i++) {
            boxList[i] = String.valueOf(i + 1);
            int order_num = i+1;
            int size =DataBaseFB.getHistory(customer.getName(),order_num).size();
            //create arra
            String arr[] = new String[size];
            for(int j=0 ; j<size ; j++){
                arr[j] = DataBaseFB.getHistory(customer.getName(),order_num).get(j);
            }
            //check status
            if(arr[15] == "-3"){
                comboBox1.addItem(order_num);
            }
            else{
                JOptionPane.showMessageDialog(null, "No order to show");
            }
        }

//        System.out.println("\n");
//        System.out.println(Arrays.toString(boxList));

        Exit_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    frame.setContentPane(new Home(frame,customer).getHomePanel());
                } catch (JacksonUtilityException | FirebaseException | IOException ex) {
                    throw new RuntimeException(ex);
                }
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
        confirm_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String i = comboBox1.getSelectedItem().toString();
                if(i.equals(("Select your order:"))){
                    JOptionPane.showMessageDialog(null, "Select your order:");
                }
                else{
                    try {
                        frame.setContentPane(new History_detail(frame,customer,i).getHistory_detailpanel());
                    } catch (JacksonUtilityException | FirebaseException | IOException ex) {
                        throw new RuntimeException(ex);
                    }
                    frame.revalidate();
                }
            }
        });
    }

    public JPanel getHistoryPanel(){
        return HistoryPanel;
    }

}
