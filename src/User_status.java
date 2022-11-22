import net.thegreshams.firebase4j.error.FirebaseException;
import net.thegreshams.firebase4j.error.JacksonUtilityException;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;

public class User_status {
    private JButton NewOrderButton;
    private JButton OtherButton;
    private JButton Home_Button;
    private JPanel User_StatusPanel;
    private JComboBox Order;
    private JButton confirm_button;

    public User_status(JFrame frame, Customer customer) throws JacksonUtilityException, FirebaseException, IOException {
        int num = DataBaseFB.getHistoryAmount(customer.getName());
        String[] boxList = new String[num];
        String[] arr;
        for(int i=0; i<num; i++) {
            boxList[i] = String.valueOf(i + 1);
            //create array
            arr = Arrays.copyOf(Objects.requireNonNull(DataBaseFB.getHistory(customer.getName(), i + 1)).toArray(), Objects.requireNonNull(DataBaseFB.getHistory(customer.getName(), i + 1)).size(), String[].class);
            //check status
            if(arr[15].equals("-2") || arr[15].equals("-1")) {
                Order.addItem(i+1);
            }
        }
        NewOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                customer.resetClothes();
                frame.setContentPane((new Order(frame, customer).getOrderPanel()));
                frame.revalidate();
            }
        });

        //goto home page
        Home_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    frame.setContentPane((new Home(frame,customer).getHomePanel()));
                } catch (JacksonUtilityException | FirebaseException | IOException ex) {
                    throw new RuntimeException(ex);
                }
                frame.revalidate();
            }
        });

        OtherButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setContentPane((new Other(frame,customer).getOtherPanel()));
                frame.revalidate();
            }
        });
        confirm_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String o = Order.getSelectedItem().toString();
                if(o.equals(("Select your order:"))){
                    JOptionPane.showMessageDialog(null, "Please select your order!");
                }
                else{
                    try {
                        frame.setContentPane((new History_detail(frame,customer,o).getHistory_detailpanel()));
                    } catch (JacksonUtilityException | FirebaseException | IOException ex) {
                        throw new RuntimeException(ex);
                    }
                    frame.revalidate();
                }
            }
        });
    }
    public JPanel getUser_StatusPanel(){
        return User_StatusPanel;
    }
}
