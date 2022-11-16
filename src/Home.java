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
        Color colour5 = new Color(189, 250, 253);
        HomePanel.setBackground(colour5);
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
                frame.setContentPane((new Order(frame).getorderpanel()));
                frame.revalidate();
            }
        });
    }

    public JPanel getHomePanel(){
        return HomePanel;
    }
}
