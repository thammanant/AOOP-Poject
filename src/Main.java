import Resources.*;
import net.thegreshams.firebase4j.error.FirebaseException;
import net.thegreshams.firebase4j.error.JacksonUtilityException;

import javax.swing.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) throws JacksonUtilityException, FirebaseException, IOException {

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


