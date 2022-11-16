import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class History {
    private JButton Exit_button;
    private JPanel HistoryPanel;
    private JButton Back_button;

    public History(JFrame frame)
    {
        Exit_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setContentPane(new Home(frame).getHomePanel());
                frame.revalidate();
            }
        });

        Back_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setContentPane(new Other(frame).getOtherPanel());
                frame.revalidate();
            }
        });
    }

    public JPanel getHistoryPanel(){
        return HistoryPanel;
    }

}
