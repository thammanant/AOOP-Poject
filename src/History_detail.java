import net.thegreshams.firebase4j.error.FirebaseException;
import net.thegreshams.firebase4j.error.JacksonUtilityException;

import javax.swing.*;
import java.io.IOException;
import java.util.Objects;

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
    private JPanel history_detailPanel;
    private JLabel Amount3;
    private JLabel sta;

    public History_detail(JFrame frame, Customer customer , String index_order) throws JacksonUtilityException, FirebaseException, IOException {
        int order = Integer.parseInt(index_order);
        int temp = Objects.requireNonNull(DataBaseFB.getHistory(customer.getName(), order)).size();
        String[] temp2 = new String[temp];
        for(int j=0 ; j<temp ; j++){
            temp2[j] = Objects.requireNonNull(DataBaseFB.getHistory(customer.getName(), order)).get(j);
        }
        JLabel[] c = {Amount1,Amount2,Amount3,Amount4,Amount5,Amount6,Amount7,Amount8,Amount9,Amount10,Amount11,Amount12,Amount13,Amount14,AmountTotal,sta};
        if(temp2[15].equals("-2")){
            sta.setText("Processing");
        }
        else if(temp2[15].equals("-1")){
            sta.setText("Waiting");
        }
        else{
            sta.setText("Delivered");
        }
        for(int i=0 ; i<=14 ; i++){
            c[i].setText(temp2[i]);
        }


        okButton.addActionListener(e -> {
            try {
                frame.setContentPane(new Home(frame,customer).getHomePanel());
            } catch (JacksonUtilityException | FirebaseException | IOException ex) {
                throw new RuntimeException(ex);
            }
            frame.revalidate();
        });
    }
    public JPanel getHistory_detailPanel(){
        return history_detailPanel;
    }
}

