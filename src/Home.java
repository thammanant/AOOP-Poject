import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home {

    private JButton HomeButton;
    private JButton NewOrderButton;
    private JButton OtherButton;
    private JPanel HomePanel;
    private JButton Home_Button;

    public Home(JFrame frame) {

        // set new order button
        NewOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setContentPane((new Order(frame).getOrderPanel()));
                frame.revalidate();
            }
        });

        //set the other button
        Home_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setContentPane((new Home(frame).getHomePanel()));
                frame.revalidate();
            }
        });

        OtherButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setContentPane((new Other(frame).getOtherPanel()));
                frame.revalidate();
            }
        });
    }

    public JPanel getHomePanel(){
        return HomePanel;
    }
}
