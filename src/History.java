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
    private JPanel panel2;
    private JComboBox comboBox1;
    private JButton button1;

    public History(JFrame frame, Customer customer) throws JacksonUtilityException, FirebaseException, IOException {
        Color colour18 = new Color(39, 59, 105);
        HistoryPanel.setBackground(colour18);
        int a = DataBaseFB.getHistoryAmount(customer.getName());

        HistoryText.setText(customer.printAll());
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
