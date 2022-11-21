import javax.swing.*;
import java.awt.*;

public class order_and_status {
    private JButton Basket_button;
    private JPanel Basket_panel;
    private JButton Status;


    public order_and_status(JFrame frame, Customer customer){

    }
    public JPanel getOrder_and_statusPanel(){
        return Basket_panel;
    }
    public JButton get_basket_button() {return Basket_button;}
}
