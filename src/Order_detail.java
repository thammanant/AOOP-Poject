import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Order_detail {
    private JPanel panel1;
    private JLabel Profile_icon;
    private JButton Chat_icon;
    private JButton exit_button;

    public Order_detail(JFrame frame) {
        exit_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setContentPane(new Home(frame).getHomePanel());
                frame.revalidate();
            }
        });
    }


    public JPanel getjimmypanel(){
       return panel1;
    }
}
