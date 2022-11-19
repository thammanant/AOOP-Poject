import net.thegreshams.firebase4j.error.FirebaseException;
import net.thegreshams.firebase4j.error.JacksonUtilityException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class History {
    private JButton Exit_button;
    private JPanel HistoryPanel;
    private JButton Back_button;

    public History(JFrame frame, Customer customer)
    {
        Color colour5 = new Color(189, 250, 253);
        HistoryPanel.setBackground(colour5);
        Exit_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    frame.setContentPane(new Home(frame,customer).getHomePanel());
                } catch (JacksonUtilityException | FirebaseException | IOException ex) {
                    throw new RuntimeException(ex);
                }
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
