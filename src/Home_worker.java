import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home_worker {
    private JPanel Home_worker;
    private JButton OtherButton;
    private JButton Home_Button;
    private JButton Check_your_order_worker;


    public Home_worker(JFrame frame){
//        Home_Button.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                frame.setContentPane((new Home(frame).getHomePanel()));
//                frame.revalidate();
//            }
//        });
//
//        OtherButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                frame.setContentPane((new Other(frame).getOtherPanel()));
//                frame.revalidate();
//            }
//        });

    }

    public JPanel get_Home_worker_panel(){
        return Home_worker;
    }
}
