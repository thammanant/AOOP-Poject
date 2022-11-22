import net.thegreshams.firebase4j.error.FirebaseException;
import net.thegreshams.firebase4j.error.JacksonUtilityException;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;

public class History_detail_worker {
    private JPanel History_detail_worker;
    private JPanel history_detailpanel;
    private JLabel Num1;
    private JLabel CottonWh;
    private JLabel Num2;
    private JLabel CottonCol;
    private JLabel Amount1;
    private JLabel Amount2;
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
    private JLabel name_customer;
    private JLabel Amount3;
    private JLabel Address;

    public History_detail_worker(JFrame frame, Worker worker,String name,String index_order) throws JacksonUtilityException, FirebaseException, IOException {
        int order_number = Integer.parseInt(index_order);
        int size = Objects.requireNonNull(DataBaseFB.getHistory(name, order_number)).size();
        String[] temp = new String[size];
        for (int i=0; i<size; i++){
            temp[i] = Objects.requireNonNull(DataBaseFB.getHistory(name, order_number)).get(i);
        }
        JLabel [] amount = {Amount1,Amount2,Amount3,Amount4,Amount5,Amount6,Amount7,Amount8,Amount9,Amount10,Amount11,Amount12,Amount13,Amount14,AmountTotal,sta};
        if(Objects.equals(temp[15],"-1")){
            sta.setText("Waiting");
        }
        if(Objects.equals(temp[15], "-2")){
            sta.setText("Processing");
        }
        if(Objects.equals(temp[15], "-3")){
            sta.setText("Delivered");
        }
        for(int j=0;j< 15;j++){
            amount[j].setText(temp[j]);
        }
        String phone = DataBaseFB.getCustomerPhone(name);
        customer_ph.setText(phone);
        Address.setText(DataBaseFB.getCustomerAddress(name));
        String n = DataBaseFB.getCustomerName(name);
        name_customer.setText(n);
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
                if(input.equalsIgnoreCase("processing") || input.equalsIgnoreCase("delivered")){
                    JOptionPane.showMessageDialog(null,"Status changed");
                    sta.setText(input);
                    if(input.equalsIgnoreCase("processing")){
                        try {
                            DataBaseFB.setHistoryStatus(name,order_number,-2);
                        } catch (FirebaseException | JacksonUtilityException | IOException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                    else {
                        try {
                            DataBaseFB.setHistoryStatus(name,order_number,-3);
                        } catch (FirebaseException | JacksonUtilityException | IOException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                    try {
                        frame.setContentPane(new History_detail_worker(frame,worker,name,index_order).get_history_detail_worker());
                    } catch (JacksonUtilityException | FirebaseException | IOException ex) {
                        throw new RuntimeException(ex);
                    }
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
