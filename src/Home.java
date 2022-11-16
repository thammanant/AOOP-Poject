import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home {

    private JButton HomeButton;
    private JButton NewOrderButton;
    private JButton OtherButton;
    private JPanel HomePanel;

    public Home(JFrame frame) {
        //set Button home
        HomeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setContentPane(new Home(frame).getHomePanel());
                frame.revalidate();
            }
        });

        //set Button new order
        NewOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setContentPane(new Order(frame).getorderpanel());
                frame.revalidate();
            }
        });

        //set Button other
        OtherButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setContentPane(new Others().getOtherPanel());
                frame.revalidate();
            }
        });
    }

    public JPanel getHomePanel(){
        return HomePanel;
    }
}
