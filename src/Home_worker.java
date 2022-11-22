import net.thegreshams.firebase4j.error.FirebaseException;
import net.thegreshams.firebase4j.error.JacksonUtilityException;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Home_worker {
    private JPanel Home_worker;
    private JButton OtherButton;
    private JButton Home_Button;
    private JButton Check_your_order_worker;
    private JLabel Hi;
    private JLabel worker_status;


    public Home_worker(JFrame frame, Worker worker) throws IOException, FirebaseException, JacksonUtilityException {
        Color colour18 = new Color(39, 59, 105);
        Home_worker.setBackground(colour18);
        System.out.println(worker.getName());
        Hi.setText("Hi: " + DataBaseFB.getWorkerName(worker.getName()));
        worker_status.setText(worker.checkOrder());
        Home_Button.addActionListener(e -> {
            try {
                frame.setContentPane((new Home_worker(frame,worker).get_Home_worker_panel()));
            } catch (FirebaseException | JacksonUtilityException | IOException ex) {
                throw new RuntimeException(ex);
            }
            frame.revalidate();
        });


        OtherButton.addActionListener(e -> {
            frame.setContentPane((new Other_Worker(frame,worker).getWorkerOtherPanel()));
            frame.revalidate();
        });
        Check_your_order_worker.addActionListener(e -> {
            if(worker_status.getText().equals("You don't have order")){
                JOptionPane.showMessageDialog(null, "You have no order");
            }
            else{
                try {
                    frame.setContentPane(new worker_status(frame,worker).getWorker_status());
                } catch (JacksonUtilityException | FirebaseException | IOException ex) {
                    throw new RuntimeException(ex);
                }
                frame.revalidate();
            }
        });
    }

    public JPanel get_Home_worker_panel(){
        return Home_worker;
    }
}
