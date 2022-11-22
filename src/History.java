import net.thegreshams.firebase4j.error.FirebaseException;
import net.thegreshams.firebase4j.error.JacksonUtilityException;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;

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
        String[] boxList = new String[num];
        String[] arr;
        for(int i=0; i<num; i++) {
            boxList[i] = String.valueOf(i + 1);
            //create array
            arr = Arrays.copyOf(Objects.requireNonNull(DataBaseFB.getHistory(customer.getName(), i + 1)).toArray(), Objects.requireNonNull(DataBaseFB.getHistory(customer.getName(), i + 1)).size(), String[].class);
            //check status
            if(arr[15].equals("-3")) {
                comboBox1.addItem(i+1);
            }
        }

        Exit_button.addActionListener(e -> {
            try {
                frame.setContentPane(new Home(frame,customer).getHomePanel());
            } catch (JacksonUtilityException | FirebaseException | IOException ex) {
                throw new RuntimeException(ex);
            }
            frame.revalidate();
        });

        Back_button.addActionListener(e -> {
            frame.setContentPane(new Other(frame,customer).getOtherPanel());
            frame.revalidate();
        });
        confirm_button.addActionListener(e -> {
            String i = Objects.requireNonNull(comboBox1.getSelectedItem()).toString();
            if(i.equals(("Select your order:"))){
                JOptionPane.showMessageDialog(null, "Please select your order");
            }
            else{
                try {
                    frame.setContentPane(new History_detail(frame,customer,i).getHistory_detailPanel());
                } catch (JacksonUtilityException | FirebaseException | IOException ex) {
                    throw new RuntimeException(ex);
                }
                frame.revalidate();
            }
        });
    }

    public JPanel getHistoryPanel(){
        return HistoryPanel;
    }

}
