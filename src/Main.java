import Resources.*;

import javax.swing.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) {

//        //database
//        User[] allUserPass = new User[100];
//
//        // First pages
//        String name = "John";
//        String address = "123 Main St";
//        String phone = "555-555-5555";
//        Customer customer = new Customer(name, address, phone);
//        customer.setEmail("fffff");
//        customer.setPassword("1234");
//        System.out.println(customer.getEmail());
//        System.out.println(customer.getPassword());
//        System.out.println();
//
//        String name2 = "Jane";
//        String address2 = "456 Main St";
//        String phone2 = "999-999-9999";
//        Customer customer2 = new Customer(name2, address2, phone2);
//        customer2.setEmail("00000");
//        customer2.setPassword("5678");
//        System.out.println(customer2.getEmail());
//        System.out.println(customer2.getPassword());
//        System.out.println();
//
//        String name3 = "Alex";
//        String phone3 = "777-777-7777";
//        Worker worker = new Worker(name3, phone3);
//        worker.setEmail("aaaaa");
//        worker.setPassword("9012");
//
//        System.out.println(customer.getEmail());
//        System.out.println(customer.getPassword());
//        System.out.println();
//
//        allUserPass[0] = customer;
//        allUserPass[1 ] = customer2;
//        allUserPass[2] = worker;
//
//        for (int i = 0; i < 3; i++) {
//            System.out.println(allUserPass[i].getEmail());
//            System.out.println(allUserPass[i].getPassword());
//            System.out.println();
//        }
//
//
//        // Second pages
//        //customer 1
//        customer.addClothes(ClothesType.CottonWhite, 2);
//        customer.addClothes(ClothesType.CottonColoured, 1);
//        customer.addClothes(ClothesType.WoolWhite, 2);
//        customer.addClothes(ClothesType.WoolColoured, 1);
//        customer.addClothes(ClothesType.MixedWhite, 2);
//        customer.addClothes(ClothesType.MixedColoured, 1);
//        customer.addClothes(ClothesType.LeatherWhite, 2);
//        customer.addClothes(ClothesType.LeatherColoured, 1);
//        customer.addClothes(ClothesType.Baby_wearWhite, 2);
//        customer.addClothes(ClothesType.Baby_wearColoured, 1);
//        customer.addClothes(ClothesType.DelicatesWhite, 2);
//        customer.addClothes(ClothesType.DelicatesColoured, 1);
//        customer.addClothes(ClothesType.BeddingWhite, 2);
//        customer.addClothes(ClothesType.BeddingColoured, 1);
//
//        customer.removeClothes(ClothesType.CottonWhite);
//        customer.removeClothes(ClothesType.WoolWhite);
//        customer.removeClothes(ClothesType.MixedWhite);
//        customer.removeClothes(ClothesType.LeatherWhite);
//        customer.removeClothes(ClothesType.Baby_wearWhite);
//        customer.removeClothes(ClothesType.DelicatesWhite);
//        customer.removeClothes(ClothesType.BeddingWhite);
//
//        customer.removeClothes(ClothesType.CottonColoured);
//
//        System.out.println(customer.checkClothes());
//
//        //customer 2
//        customer2.addClothes(ClothesType.CottonWhite, 1);
//        customer2.addClothes(ClothesType.CottonColoured, 2);
//        customer2.addClothes(ClothesType.WoolWhite, 1);
//        customer2.addClothes(ClothesType.WoolColoured, 2);
//        customer2.addClothes(ClothesType.MixedWhite, 1);
//        customer2.addClothes(ClothesType.MixedColoured, 2);
//        customer2.addClothes(ClothesType.LeatherWhite, 1);
//        customer2.addClothes(ClothesType.LeatherColoured, 2);
//        customer2.addClothes(ClothesType.Baby_wearWhite, 1);
//        customer2.addClothes(ClothesType.Baby_wearColoured, 2);
//        customer2.addClothes(ClothesType.DelicatesWhite, 1);
//        customer2.addClothes(ClothesType.DelicatesColoured, 2);
//        customer2.addClothes(ClothesType.BeddingWhite, 1);
//        customer2.addClothes(ClothesType.BeddingColoured, 2);
//
//        customer2.removeClothes(ClothesType.CottonColoured);
//        customer2.removeClothes(ClothesType.WoolColoured);
//        customer2.removeClothes(ClothesType.MixedColoured);
//        customer2.removeClothes(ClothesType.LeatherColoured);
//        customer2.removeClothes(ClothesType.Baby_wearColoured);
//        customer2.removeClothes(ClothesType.DelicatesColoured);
//        customer2.removeClothes(ClothesType.BeddingColoured);
//
//        customer2.removeClothes(ClothesType.CottonWhite);
//
//        System.out.println(customer2.checkClothes());
//
//        // Third pages
//        customer.setAddress("123 Main St, Apt 1");
//        System.out.println(customer.printAll());
//
//        customer2.setAddress("456 Main St, Apt 2");
//        System.out.println(customer2.printAll());

        JFrame frame = new JFrame("WashApp");
        frame.setVisible(true);
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //set frame look and feel
        try {
            UIManager.setLookAndFeel("com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatAtomOneLightContrastIJTheme");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        }

        Login login = new Login(frame, new Customer(),new Worker());
        frame.getContentPane().add(login.getLoginPanel());

    }
}