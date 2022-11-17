import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Other {
    private JPanel OtherPanel;
    private JButton HomeButton;
    private JButton button1;
    private JButton button3;
    private JButton button2;
    private JPanel MenuPanel;

    public Other(JFrame frame, Customer customer){
        Color colour5 = new Color(189, 250, 253);
        MenuPanel.setBackground(colour5);

        button1.setText("\u2022 History");
        button2.setText("\u2022 Profile");
        button3.setText("\u2022 Report");

        HomeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setContentPane((new Home(frame,customer).getHomePanel()));
                frame.revalidate();
            }
        });
        //goto history of the done order
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setContentPane((new History(frame,customer).getHistoryPanel()));
                frame.revalidate();
            }
        });

        //goto the customer's profile
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setContentPane((new Order_detail(frame, customer).getjimmypanel()));
                frame.revalidate();
            }
        });

        //goto report
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setContentPane((new Report(frame,customer).get_Report_panel()));
                frame.revalidate();
            }
        });
    }


    public JPanel getOtherPanel(){
        return OtherPanel;
    }

}

