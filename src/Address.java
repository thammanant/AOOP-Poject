import net.thegreshams.firebase4j.error.FirebaseException;
import net.thegreshams.firebase4j.error.JacksonUtilityException;

import javax.swing.*;
import javax.swing.plaf.nimbus.State;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;


public class Address {
    private JLabel AddTitle;
    private JTextField AddressField;
    private JTextField ApartmentField;
    private JTextField CityField;
    private JTextField StateField;
    private JTextField PostalField;
    private JPanel AddressPanel;
    private JButton GoToTotal;
    private JButton GoToConfirm;
    private JTextField PhoneField;
    private JLabel Status;
    private final String PhoneTxt = "Enter phone number";
    private final String AddressTxt = "Enter street address";
    private final String ApartmentTxt = "Enter apartment/suit ";
    private final String CityTxt = "Enter city";
    private final String StateTxt = "Enter state";
    private final String PostalTxt = "Enter postal code";

    private final String emptyphone = "Phone number cannot be empty!";
    private final String emptyaddress = "Street adress cannot be empty!";
    private final String emptyapartment = "Please enter '-' if don't have.";
    private final String emptycity = "City cannot be empty!";
    private final String emptystate = "State cannot be empty!";
    private final String emptypostal = "Postal code cannot be empty!";
    public Address(JFrame frame, Customer customer) {
        Color colour5 = new Color(189, 250, 253);
        AddressPanel.setBackground(colour5);
        GoToTotal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setContentPane(new Total(frame,customer).getTotalPanel());
                frame.revalidate();
            }
        });

        //set text field
        PhoneField.setText(PhoneTxt);
        AddressField.setText(AddressTxt);
        ApartmentField.setText(ApartmentTxt);
        CityField.setText(CityTxt);
        StateField.setText(StateTxt);
        PostalField.setText(PostalTxt);
        //set phone field
        PhoneField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(PhoneField.getText().equals(PhoneTxt)){
                    PhoneField.setText("");
                }
                super.mouseClicked(e);
                if(AddressField.getText().isEmpty()){
                    AddressField.setText(AddressTxt);
                }
                if(ApartmentField.getText().isEmpty()){
                    ApartmentField.setText(ApartmentTxt);
                }
                if(CityField.getText().isEmpty()){
                    CityField.setText(CityTxt);
                }
                if(StateField.getText().isEmpty()){
                    StateField.setText(StateTxt);
                }
                if(PostalField.getText().isEmpty()){
                    PostalField.setText(PostalTxt);
                }

            }
        });
        // set address field
        AddressField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(AddressField.getText().equals(AddressTxt)){
                    AddressField.setText("");
                }
                super.mouseClicked(e);
                if(PhoneField.getText().isEmpty()){
                    PhoneField.setText(PhoneTxt);
                }
                if(ApartmentField.getText().isEmpty()){
                    ApartmentField.setText(ApartmentTxt);
                }
                if(CityField.getText().isEmpty()){
                    CityField.setText(CityTxt);
                }
                if(StateField.getText().isEmpty()){
                    StateField.setText(StateTxt);
                }
                if(PostalField.getText().isEmpty()){
                    PostalField.setText(PostalTxt);
                }
            }
        });
        //set apartment field
        ApartmentField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(ApartmentField.getText().equals(ApartmentTxt)){
                    ApartmentField.setText("");
                }
                super.mouseClicked(e);
                if(PhoneField.getText().isEmpty()){
                    PhoneField.setText(PhoneTxt);
                }
                if(AddressField.getText().isEmpty()){
                    AddressField.setText(AddressTxt);
                }
                if(CityField.getText().isEmpty()){
                    CityField.setText(CityTxt);
                }
                if(StateField.getText().isEmpty()){
                    StateField.setText(StateTxt);
                }
                if(PostalField.getText().isEmpty()){
                    PostalField.setText(PostalTxt);
                }
            }
        });
        //set City feild
        CityField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(CityField.getText().equals(CityTxt)){
                    CityField.setText("");
                }
                super.mouseClicked(e);
                if(PhoneField.getText().isEmpty()){
                    PhoneField.setText(PhoneTxt);
                }
                if(AddressField.getText().isEmpty()){
                    AddressField.setText(AddressTxt);
                }
                if(ApartmentField.getText().isEmpty()){
                    ApartmentField.setText(ApartmentTxt);
                }
                if(StateField.getText().isEmpty()){
                    StateField.setText(StateTxt);
                }
                if(PostalField.getText().isEmpty()){
                    PostalField.setText(PostalTxt);
                }
            }
        });
        //set state field
        StateField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(StateField.getText().equals(StateTxt)){
                    StateField.setText("");
                }
                super.mouseClicked(e);
                if(PhoneField.getText().isEmpty()){
                    PhoneField.setText(PhoneTxt);
                if(AddressField.getText().isEmpty()){
                    AddressField.setText(AddressTxt);
                }
                if(ApartmentField.getText().isEmpty()){
                    ApartmentField.setText(ApartmentTxt);
                }
                }
                if(CityField.getText().isEmpty()){
                    CityField.setText(CityTxt);
                }
                if(PostalField.getText().isEmpty()){
                    PostalField.setText(PostalTxt);
                }
            }
        });
        //set postal field
        PostalField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(PostalField.getText().equals(PostalTxt)){
                    PostalField.setText("");
                }
                super.mouseClicked(e);
                if(PhoneField.getText().isEmpty()){
                    PhoneField.setText(PhoneTxt);
                }
                if(AddressField.getText().isEmpty()){
                    AddressField.setText(AddressTxt);
                }
                if(ApartmentField.getText().isEmpty()){
                    ApartmentField.setText(ApartmentTxt);
                }
                if(CityField.getText().isEmpty()){
                    CityField.setText(CityTxt);
                }
                if(StateField.getText().isEmpty()){
                    StateField.setText(StateTxt);
                }
            }
        });
        //set confirm button
        GoToConfirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String regex = "\\d+";
                Boolean phone_check_int = true;
                Boolean postcode_check_int = true;
                String phone = PhoneField.getText();
                String address = AddressField.getText();
                String apartment = ApartmentField.getText();
                String city = CityField.getText();
                String state = StateField.getText();
                String postal = PostalField.getText();
                if(phone.matches(regex)){
                    phone_check_int = false;
                }
                if(postal.matches(regex)){
                    postcode_check_int = false;
                }
                if(phone.isEmpty() || phone.equals(PhoneTxt)){
                    Status.setText(emptyphone);
                } else if (phone_check_int) {
                    Status.setText("Phone must be number.");
                } else if (postcode_check_int) {
                    Status.setText("Postal code must number.");
                } else if (address.isEmpty() || address.equals(AddressTxt)) {
                    Status.setText(emptyaddress);
                } else if (apartment.isEmpty() || apartment.equals(ApartmentTxt)) {
                    Status.setText(emptyapartment);
                } else if (city.isEmpty() || city.equals(CityTxt)) {
                    Status.setText(emptycity);
                } else if (state.isEmpty() || state.equals(StateTxt)) {
                    Status.setText(emptystate);
                } else if (postal.isEmpty() || postal.equals(PostalTxt)) {
                    Status.setText(emptypostal);
                } else {
                    try {
                        DataBaseFB.setAddress(customer.getName(),address + "," + apartment + "," + city + "," + state + "," + postal);
                    } catch (FirebaseException | JacksonUtilityException | IOException ex) {
                        throw new RuntimeException(ex);
                    }
                    JOptionPane.showMessageDialog(null,"Your order have been sent","Message",JOptionPane.PLAIN_MESSAGE);
                    try {
                        frame.setContentPane(new Home(frame,customer).getHomePanel());
                    } catch (JacksonUtilityException | FirebaseException | IOException ex) {
                        throw new RuntimeException(ex);
                    }
                    frame.revalidate();
                }
            }
        });
    }

    public JPanel getAddressPanel() {
        return AddressPanel;
    }
}
