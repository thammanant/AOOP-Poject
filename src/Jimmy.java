import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Jimmy {
    private JPanel panel1;
    private JLabel Profile_icon;
    private JButton Chat_icon;
    private JButton exit_button;

    public Jimmy(JFrame frame) {
        exit_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setContentPane(new Register(frame).getRegisterPanel());
                frame.revalidate();
            }
        });
    }


    public JPanel getjimmypanel(){
       return panel1;
    }
}
