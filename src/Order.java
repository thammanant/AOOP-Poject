import net.thegreshams.firebase4j.error.FirebaseException;
import net.thegreshams.firebase4j.error.JacksonUtilityException;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Order {
    private JLabel newOrderLabel;
    private JButton cancelButton;
    private JButton processButton;
    private JPanel OrderPanel;
    private JButton add_button1;
    private JButton subtract_button1;
    private JButton add_button2;
    private JButton subtract_button2;
    private JButton add_button3;
    private JButton add_button4;
    private JButton add_button5;
    private JButton add_button6;
    private JButton add_button7;
    private JButton add_button8;
    private JButton add_button9;
    private JButton add_button10;
    private JButton add_button11;
    private JButton add_button12;
    private JButton subtract_button3;
    private JButton subtract_button4;
    private JButton subtract_button5;
    private JButton subtract_button6;
    private JButton subtract_button7;
    private JButton subtract_button8;
    private JButton subtract_button9;
    private JButton subtract_button10;
    private JButton subtract_button11;
    private JButton subtract_button12;
    private JLabel value1;
    private JLabel value2;
    private JLabel value3;
    private JLabel value4;
    private JLabel value5;
    private JLabel value6;
    private JLabel value7;
    private JLabel value8;
    private JLabel value9;
    private JLabel value10;
    private JLabel value11;
    private JLabel value12;
    private JLabel cloth_name1;
    private JLabel cloth_name2;
    private JLabel cloth_name4;
    private JLabel cloth_name5;
    private JLabel cloth_name6;
    private JLabel cloth_name7;
    private JLabel cloth_name8;
    private JLabel cloth_name9;
    private JLabel cloth_name11;
    private JLabel cloth_name3;
    private JButton add_button13;
    private JButton subtract_button13;
    private JLabel value13;
    private JLabel value14;
    private JButton add_button14;
    private JButton subtract_button14;

    //-value is the amount of cloth
    //-add_button and subtract_button follow by number to increase and decrease the amount of that cloth
    /*
    1->Cotton(White)
    2->Cotton(Colour)
    3->Mixed(White)
    4->Mixed(Colour)
    5->Delicates(White)
    6->Delicates(Colour)
    7->Wool(White)
    8->Wool(Colour)
    9->Bedding(White)
    10->Bedding(Colour)
    11->Baby_wear(White)
    12->Baby_wear(Colour)
    */

    private int amount1 = 0;
    private int  amount2 = 0;
    private int  amount3 = 0;
    private int amount4 = 0;
    private int amount5 = 0;
    private int amount6 = 0;
    private int amount7 = 0;
    private int amount8 = 0;
    private int amount9 = 0;
    private int amount10 = 0;
    private int amount11 = 0;
    private int amount12 = 0;
    private int amount13 =0;
    private int amount14 = 0;
    private int total = 0;

    public Order(JFrame frame, Customer customer){
        Color colour18 = new Color(39, 59, 105);
        OrderPanel.setBackground(colour18);

        add_button1.addActionListener(e -> value1.setText(Integer.toString(++amount1)));

        subtract_button1.addActionListener(e -> {
            if(amount1>0)
                value1.setText(Integer.toString(--amount1));
        });

        add_button2.addActionListener(e -> value2.setText(Integer.toString(++amount2)));

        subtract_button2.addActionListener(e -> {
            if(amount2>0)
                value2.setText(Integer.toString(--amount2));
        });

        add_button3.addActionListener(e -> value3.setText(Integer.toString(++amount3)));

        subtract_button3.addActionListener(e -> {
            if(amount3>0)
                value3.setText(Integer.toString(--amount3));
        });

        add_button4.addActionListener(e -> value4.setText(Integer.toString(++amount4)));

        subtract_button4.addActionListener(e -> {
            if(amount4>0)
                value4.setText(Integer.toString(--amount4));
        });

        add_button5.addActionListener(e -> value5.setText(Integer.toString(++amount5)));

        subtract_button5.addActionListener(e -> {
            if(amount5>0)
                value5.setText(Integer.toString(--amount5));
        });

        add_button6.addActionListener(e -> value6.setText(Integer.toString(++amount6)));

        subtract_button6.addActionListener(e -> {
            if(amount6>0)
                value6.setText(Integer.toString(--amount6));
        });

        add_button7.addActionListener(e -> value7.setText(Integer.toString(++amount7)));

        subtract_button7.addActionListener(e -> {
            if(amount7>0)
                value7.setText(Integer.toString(--amount7));
        });

        add_button8.addActionListener(e -> value8.setText(Integer.toString(++amount8)));

        subtract_button8.addActionListener(e -> {
            if(amount8>0)
                value8.setText(Integer.toString(--amount8));
        });

        add_button9.addActionListener(e -> value9.setText(Integer.toString(++amount9)));

        subtract_button9.addActionListener(e -> {
            if(amount9>0)
                value9.setText(Integer.toString(--amount9));
        });

        add_button10.addActionListener(e -> value10.setText(Integer.toString(++amount10)));

        subtract_button10.addActionListener(e -> {
            if(amount10>0)
                value10.setText(Integer.toString(--amount10));
        });

        add_button11.addActionListener(e -> value11.setText(Integer.toString(++amount11)));

        subtract_button11.addActionListener(e -> {
            if(amount11>0)
                value11.setText(Integer.toString(--amount11));
        });

        add_button12.addActionListener(e -> value12.setText(Integer.toString(++amount12)));

        subtract_button12.addActionListener(e -> {
            if(amount12>0)
                value12.setText(Integer.toString(--amount12));
        });
        add_button13.addActionListener(e -> value13.setText(Integer.toString(++amount13)));
        subtract_button13.addActionListener(e -> {
            if(amount13>0){
                value13.setText(Integer.toString(--amount13));
            }
        });
        add_button14.addActionListener(e -> value14.setText(Integer.toString(++amount14)));
        subtract_button14.addActionListener(e -> {
            if(amount14>0){
                value14.setText(Integer.toString(--amount14));
            }
        });
        //Cancel button will back to home page
        cancelButton.addActionListener(e -> {
            try {
                frame.setContentPane((new Home(frame, customer).getHomePanel()));
            } catch (JacksonUtilityException | FirebaseException | IOException ex) {
                throw new RuntimeException(ex);
            }
            frame.revalidate();
        });

        //press process will go total page.
        processButton.addActionListener(e -> {
            total = amount1+ amount2 + amount3 + amount4 + amount5 + amount6 + amount7 + amount8 + amount9 + amount10 + amount11 + amount12 + amount13 + amount14;
            if (total == 0) {
                JOptionPane.showMessageDialog(null,"Please select your order!","Message",JOptionPane.PLAIN_MESSAGE);
            }else{
            customer.addAmountToClothes(amount1,amount2,amount3,amount4,amount5,amount6,amount7,amount8,amount9,amount10,amount11,amount12,amount13,amount14);
            frame.setContentPane((new Total(frame, customer).getTotalPanel()));
            frame.revalidate();
                                                                                                                                                                          }
        });
    }

    public JPanel getOrderPanel(){
        return OrderPanel;
    }
}
