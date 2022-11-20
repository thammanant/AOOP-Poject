import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home_worker {
    private JPanel Home_worker;
    private JButton OtherButton;
    private JButton Home_Button;
    private JButton Check_your_order_worker;
    private JLabel Hi;


    public Home_worker(JFrame frame, Worker worker){
        Color colour5 = new Color(39, 59, 105);
        Home_worker.setBackground(colour5);
        Hi.setText("Hi: " + worker.getName());
        Home_Button.addActionListener(new ActionListener() {
            @Override
           public void actionPerformed(ActionEvent e) {
                frame.setContentPane((new Home_worker(frame,worker).get_Home_worker_panel()));
                frame.revalidate();
            }
        });

        OtherButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setContentPane((new Other_Worker(frame,worker).getWorkerOtherPanel()));
                frame.revalidate();
            }
        });

    }

    public JPanel get_Home_worker_panel(){
        return Home_worker;
    }
}
