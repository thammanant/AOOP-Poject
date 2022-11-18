import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home {

    private JButton NewOrderButton;
    private JButton OtherButton;
    private JPanel HomePanel;
    private JButton RefreshButton;
    private JLabel Hi_user;
    private JLabel orderr;
    private JButton Check_your_order;

    public Home(JFrame frame, Customer customer) {
        Color colour5 = new Color(189, 250, 253);
        HomePanel.setBackground(colour5);

        orderr.setText(customer.textorderClothes());

        // set new order button
        NewOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setContentPane((new Order(frame, customer).getOrderPanel()));
                frame.revalidate();
            }
        });

        //set the other button
        RefreshButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setContentPane((new Home(frame,customer).getHomePanel()));
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
