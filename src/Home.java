import net.thegreshams.firebase4j.error.FirebaseException;
import net.thegreshams.firebase4j.error.JacksonUtilityException;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Home {

    private JButton NewOrderButton;
    private JButton OtherButton;
    private JPanel HomePanel;
    private JButton RefreshButton;
    private JLabel Hi_user;
    private JLabel orderR;
    private JButton Check_your_order;

    public Home(JFrame frame, Customer customer) throws JacksonUtilityException, FirebaseException, IOException {
        Color colour18 = new Color(39, 59, 105); //main background
        HomePanel.setBackground(colour18);
        Hi_user.setText("Hi " + DataBaseFB.getCustomerName(customer.getName()));
        orderR.setText(customer.displayOrder());

        // set new order button
        NewOrderButton.addActionListener(e -> {
            customer.resetClothes();
            frame.setContentPane((new Order(frame, customer).getOrderPanel()));
            frame.revalidate();
        });

        //set the other button
        RefreshButton.addActionListener(e -> {
            try {
                frame.setContentPane((new Home(frame,customer).getHomePanel()));
            } catch (JacksonUtilityException | FirebaseException | IOException ex) {
                throw new RuntimeException(ex);
            }
            frame.revalidate();
        });

        OtherButton.addActionListener(e -> {
            frame.setContentPane((new Other(frame,customer).getOtherPanel()));
            frame.revalidate();
        });

        Check_your_order.addActionListener(e -> {
            try {
                if(customer.check()==1){
                    frame.setContentPane(new User_status(frame,customer).getUser_StatusPanel());
                    frame.revalidate();
                }if(customer.check()==0){
                    JOptionPane.showMessageDialog(null, "You don't have any order yet!");
                }
            } catch (JacksonUtilityException | FirebaseException | IOException ex) {
                throw new RuntimeException(ex);
            }
        });
    }

    public JPanel getHomePanel(){
        return HomePanel;
    }
}
