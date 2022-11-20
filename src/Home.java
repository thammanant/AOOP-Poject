import net.thegreshams.firebase4j.error.FirebaseException;
import net.thegreshams.firebase4j.error.JacksonUtilityException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Home {

    private JButton NewOrderButton;
    private JButton OtherButton;
    private JPanel HomePanel;
    private JButton RefreshButton;
    private JLabel Hi_user;
    private JLabel orderr;
    private JButton Check_your_order;

    public Home(JFrame frame, Customer customer) throws JacksonUtilityException, FirebaseException, IOException {
        Color colour18 = new Color(39, 59, 105); //main background
        HomePanel.setBackground(colour18);
        Hi_user.setText("Hi " + customer.getName());
        orderr.setText(customer.displayOrder());

        // set new order button
        NewOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                customer.resetClothes();
                frame.setContentPane((new Order(frame, customer).getOrderPanel()));
                frame.revalidate();
            }
        });

        //set the other button
        RefreshButton.addActionListener(new ActionListener() {
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

        Check_your_order.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(customer.check()){
                    frame.setContentPane((new User_status(frame,customer).getUser_StatusPanel()));
                    frame.revalidate();}
                else
                    customer.Popup_order();
            }
        });
    }

    public JPanel getHomePanel(){
        return HomePanel;
    }
}
