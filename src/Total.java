import Resources.ClothesAmount;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Total {
    private JPanel TotalPanel;
    private JLabel Num1;
    private JLabel CottonWh;
    private JLabel Num2;
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
    private JLabel Total;
    private JLabel CottonCol;
    private JLabel MixedWh;
    private JLabel MixedCol;
    private JLabel DelicatesWh;
    private JLabel DelicatesCol;
    private JLabel WoolWh;
    private JLabel WoolCol;
    private JLabel BeddingWh;
    private JLabel BeddingCol;
    private JLabel BabyWh;
    private JLabel BabyCol;
    private JLabel Amount1;
    private JLabel AmountTotal;
    private JLabel Amount2;
    private JLabel Amount3;
    private JLabel Amount4;
    private JLabel Amount5;
    private JLabel Amount6;
    private JLabel Amount7;
    private JLabel Amount8;
    private JLabel Amount9;
    private JLabel Amount10;
    private JLabel Amount11;
    private JLabel Amount12;
    private JButton editButton;
    private JButton confirmButton;
    private JPanel ButtonPanel;
    private JLabel Num13;
    private JLabel Num14;
    private JLabel Amount13;
    private JLabel Amount14;


    public Total(JFrame frame, Customer customer){
        Color colour5 = new Color(189, 250, 253);
        TotalPanel.setBackground(colour5);
        ButtonPanel.setBackground(colour5);
        //add amount from order
        Amount1.setText(customer.printAmount(0));
        Amount2.setText(customer.printAmount(1));
        Amount3.setText(customer.printAmount(2));
        Amount4.setText(customer.printAmount(3));
        Amount5.setText(customer.printAmount(4));
        Amount6.setText(customer.printAmount(5));
        Amount7.setText(customer.printAmount(6));
        Amount8.setText(customer.printAmount(7));
        Amount9.setText(customer.printAmount(8));
        Amount10.setText(customer.printAmount(9));
        Amount11.setText(customer.printAmount(10));
        Amount12.setText(customer.printAmount(11));
        Amount13.setText(customer.printAmount(12));
        Amount14.setText(customer.printAmount(13));
        AmountTotal.setText(customer.printtotal());
        // set edit button
        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                customer.resetClothes();
                frame.setContentPane(new Order(frame, customer).getOrderPanel());
                frame.revalidate();
            }
        });
        // set confirm button
        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setContentPane(new Address(frame,customer).getAddressPanel());
                frame.revalidate();
            }
        });

    }

    public JPanel getTotalPanel() {return TotalPanel;}
}
