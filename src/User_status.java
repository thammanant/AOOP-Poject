import net.thegreshams.firebase4j.error.FirebaseException;
import net.thegreshams.firebase4j.error.JacksonUtilityException;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

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
        for(int j =0 ; j<num ; j++){
            boxList[j] = String.valueOf(j+1);
        }
        if(boxList[15] == "-2" || boxList[15] == "-1") {
            for (int i = 0; i < num; i++) {
                Order.addItem(boxList[i]);
            }
        }
        NewOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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
                String i = Order.getSelectedItem().toString();
                if(i.equals(("Select your order:"))){
                    JOptionPane.showMessageDialog(null, "Select your order:");
                }
                else{
                    try {
                        frame.setContentPane((new History_detail(frame,customer,i).getHistory_detailpanel()));
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
