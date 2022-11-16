import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home {

    private JButton HomeButton;
    private JButton NewOrderButton;
    private JButton OtherButton;
    private JPanel HomePanel;
    private JButton button1;
    private JButton button2;

    public Home(JFrame frame) {
        //set Button home
        HomeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setContentPane(new Home(frame).getHomePanel());
                frame.revalidate();
            }
        });
        // set new order button
        NewOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setContentPane((new Order(frame).getOrderPanel()));
                frame.revalidate();
            }
        });

        //set the other button
        OtherButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setContentPane((new Others(frame).getOtherPanel()));
                frame.revalidate();
            }
        });
    }

    public JPanel getHomePanel(){
        return HomePanel;
    }
}
