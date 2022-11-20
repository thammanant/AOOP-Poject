import net.thegreshams.firebase4j.error.FirebaseException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.UnsupportedEncodingException;
import java.net.DatagramSocket;

public class Home_worker {
    private JPanel Home_worker;
    private JButton OtherButton;
    private JButton Home_Button;
    private JButton Check_your_order_worker;
    private JLabel Hi;


    public Home_worker(JFrame frame, Worker worker) throws FirebaseException, UnsupportedEncodingException, FirebaseException {
        Hi.setText("Hi: " + DataBaseFB.getWorkerName(worker.getName()));
        Home_Button.addActionListener(new ActionListener() {
            @Override
           public void actionPerformed(ActionEvent e) {
                try {
                    frame.setContentPane((new Home_worker(frame,worker).get_Home_worker_panel()));
                } catch (FirebaseException | UnsupportedEncodingException ex) {
                    throw new RuntimeException(ex);
                }
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
