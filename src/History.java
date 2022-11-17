import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class History {
    private JButton Exit_button;
    private JPanel HistoryPanel;
    private JButton Back_button;

    public History(JFrame frame, Customer customer)
    {
        Exit_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setContentPane(new Home(frame,customer).getHomePanel());
                frame.revalidate();
            }
        });

        Back_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setContentPane(new Other(frame,customer).getOtherPanel());
                frame.revalidate();
            }
        });
    }

    public JPanel getHistoryPanel(){
        return HistoryPanel;
    }

}
