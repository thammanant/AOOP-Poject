import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Others {
    private JPanel OtherPanel;
    private JButton ChatButton;
    private JButton HistoryButton;
    private JButton HomeButton;
    private JButton reportButton;
    private JPanel Menu_Panel;

    public Others(JFrame frame){
        Color colour5 = new Color(189, 250, 253);
        Menu_Panel.setBackground(colour5);
        HomeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setContentPane((new Home(frame).getHomePanel()));
                frame.revalidate();
            }
        });
    }

    public JPanel getOtherPanel(){
        return OtherPanel;
    }
}
