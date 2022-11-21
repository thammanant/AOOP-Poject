import Resources.ClothesAmount;
import net.thegreshams.firebase4j.error.FirebaseException;
import net.thegreshams.firebase4j.error.JacksonUtilityException;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class History_detail {
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
    private JPanel history_detailpanel;
    private JLabel Amount3;

    public History_detail(JFrame frame, Customer customer , String index_order) throws JacksonUtilityException, FirebaseException, IOException {
        int i = Integer.parseInt(index_order);

        String temp = DataBaseFB.getHistory(customer.getName(), i);
        // remove [] and split by ,
        assert temp != null;
        temp = temp.substring(1, temp.length() - 1);
        String[] temp2 = temp.split(",");
        // remove space
        List<String> arrayOfHistory = new ArrayList<>();
        for (String s : temp2) {
            arrayOfHistory.add(s.trim());
        }






//        ArrayList temp = DataBaseFB.getHistory(customer.getName(),i-1);
//        String[] temp2 = new String[]{};
//        for (int j = 0; j< temp.size(); j++) {
//            temp2[j] = String.valueOf(temp[j]);
//        }
//        Amount1.setText(temp2[0]);
//        Amount2.setText(temp2[1]);
//        Amount3.setText(temp2[2]);
//        Amount4.setText(temp2[3]);
//        Amount5.setText(temp2[4]);
//        Amount6.setText(temp2[5]);
//        Amount7.setText(temp2[6]);
//        Amount8.setText(temp2[7]);
//        Amount9.setText(temp2[8]);
//        Amount10.setText(temp2[9]);
//        Amount11.setText(temp2[10]);
//        Amount12.setText(temp2[11]);
//        Amount13.setText(temp2[12]);
//        Amount14.setText(temp2[13]);
//        AmountTotal.setText(temp2[14]);
        okButton.addActionListener(new ActionListener() {
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
    }
    public JPanel getHistory_detailpanel(){
        return history_detailpanel;
    }
}

