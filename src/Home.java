import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home {

    private JButton HomeButton;
    private JButton NewOrderButton;
    private JButton ChatButton;
    private JPanel HomePanel;
    private JButton History_Button;
    private JButton Report_Button;

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
        History_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setContentPane((new History(frame).getHistoryPanel()));
                frame.revalidate();
            }
        });
    }

    public JPanel getHomePanel(){
        return HomePanel;
    }
}
