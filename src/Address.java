import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Address {
    private JLabel AddTitle;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JPanel AddressPanel;
    private JButton GoToTotal;
    private JButton GoToConfirm;

    public Address(JFrame frame) {
        GoToTotal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setContentPane(new Total(frame).getTotalPanel());
                frame.revalidate();
            }
        });

        GoToConfirm.addActionListener(e -> {
//            frame.setContentPane(new Confirm(frame).getPanel());
//            frame.revalidate();
        });

    }

    public JPanel getAddressPanel() {
        return AddressPanel;
    }
}
