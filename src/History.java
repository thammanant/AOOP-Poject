import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class History {
    private JButton Exit_button;
    private JPanel HistoryPanel;

    public History(JFrame frame)
    {
        Exit_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setContentPane(new Home(frame).getHomePanel());
                frame.revalidate();
            }
        });
    }

    public JPanel getHistoryPanel(){
        return HistoryPanel;
    }

}
