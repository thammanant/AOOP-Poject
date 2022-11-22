import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        JFrame frame = new JFrame("WashApp");
        frame.setVisible(true);
        frame.setSize(800, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //set frame look and feel
        try {
            UIManager.setLookAndFeel("com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatAtomOneLightContrastIJTheme");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException |
                 UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        }

        Customer customer = new Customer();
        customer.setPhone("None");
        Login login = new Login(frame,customer,new Worker());
        frame.getContentPane().add(login.getLoginPanel());
        frame.revalidate();

    }
}


