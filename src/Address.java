import net.thegreshams.firebase4j.error.FirebaseException;
import net.thegreshams.firebase4j.error.JacksonUtilityException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
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
    private final String emptyPhone = "Phone number cannot be empty!";
    private final String emptyAddress = "Street address cannot be empty!";
    private final String emptyApartment = "Please enter '-' if don't have.";
    private final String emptyCity = "City cannot be empty!";
    private final String emptyState = "State cannot be empty!";
    private final String emptyPostal = "Postal code cannot be empty!";
    public Address(JFrame frame, Customer customer) {
        Color colour18 = new Color(39, 59, 105);
        AddressPanel.setBackground(colour18);
        GoToTotal.addActionListener(e -> {
            frame.setContentPane(new Total(frame,customer).getTotalPanel());
            frame.revalidate();
        });

        //set text field
        PhoneField.setText(PhoneTxt);
        AddressField.setText(AddressTxt);
        ApartmentField.setText(ApartmentTxt);
        CityField.setText(CityTxt);
        StateField.setText(StateTxt);
        PostalField.setText(PostalTxt);
        //set phone field
        PhoneField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if(PhoneField.getText().equals(PhoneTxt)){
                    PhoneField.setText("");
                }
                super.focusGained(e);
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
        AddressField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if(AddressField.getText().equals(AddressTxt)){
                    AddressField.setText("");
                }
                super.focusGained(e);
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
        ApartmentField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if(ApartmentField.getText().equals(ApartmentTxt)){
                    ApartmentField.setText("");
                }
                super.focusGained(e);
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
        //set City field
        CityField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if(CityField.getText().equals(CityTxt)){
                    CityField.setText("");
                }
                super.focusGained(e);
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
        StateField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if(StateField.getText().equals(StateTxt)){
                    StateField.setText("");
                }
                super.focusGained(e);
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
        PostalField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if(PostalField.getText().equals(PostalTxt)){
                    PostalField.setText("");
                }
                super.focusGained(e);
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
        GoToConfirm.addActionListener(e -> {
            String regex = "\\d+";
            boolean phone_check_int = true;
            boolean postcode_check_int = true;
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
                Status.setText(emptyPhone);
            } else if (phone_check_int) {
                Status.setText("Phone must be number.");
            } else if(phone.length()!=10){
                    Status.setText("Phone must be 10 digits.");
            } else if (postcode_check_int) {
                Status.setText("Postal code must number.");
            } else if (address.isEmpty() || address.equals(AddressTxt)) {
                Status.setText(emptyAddress);
            } else if (apartment.isEmpty() || apartment.equals(ApartmentTxt)) {
                Status.setText(emptyApartment);
            } else if (city.isEmpty() || city.equals(CityTxt)) {
                Status.setText(emptyCity);
            } else if (state.isEmpty() || state.equals(StateTxt)) {
                Status.setText(emptyState);
            } else if (postal.isEmpty() || postal.equals(PostalTxt)) {
                Status.setText(emptyPostal);
            } else {
                try {
                    customer.setPhone(phone);
                    String temp = address + "," + apartment + "," + city + "," + state + "," + postal;
                    customer.setAddress(temp);

                    DataBaseFB.addHistory(customer.getName(),customer.getClothes(),customer);
                    DataBaseFB.updateCustomerData(customer.getName(),customer);
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
        });
    }

    public JPanel getAddressPanel() {
        return AddressPanel;
    }
}
