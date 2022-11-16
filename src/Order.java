import javax.swing.*;

public class Order {
    private JLabel newOrderLabel;
    private JButton cancelButton;
    private JButton processButton;
    private JPanel OrderPanel;
    private JButton button1;
    private JButton button2;

    public Order(JFrame frame) {

        //set button cancel
        cancelButton.addActionListener(e -> {
            frame.setContentPane(new Home(frame).getHomePanel());
            frame.revalidate();
        });

    }

    public JPanel getorderpanel(){
        return OrderPanel;
    }
}
