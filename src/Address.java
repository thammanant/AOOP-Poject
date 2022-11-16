import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Address {
    private JLabel AddTitle;
    private JTextField AddressField;
    private JTextField ApartmentField;
    private JTextField CityField;
    private JTextField StateField;
    private JTextField ZipField;
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
    private final String ZipTxt = "Enter zipcode";

    private final String emptyphone = "Phone number cannot be empty!";
    private final String emptyaddress = "Street adress cannot be empty!";
    private final String emptyapartment = "Please enter '-' if don't have.";
    private final String emptycity = "City cannot be empty!";
    private final String emptystate = "State cannot be empty!";
    private final String emptyzip = "Zipcode cannot be empty!";
    public Address(JFrame frame) {
        GoToTotal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setContentPane(new Total(frame).getTotalPanel());
                frame.revalidate();
            }
        });

        //set text field
        PhoneField.setText(PhoneTxt);
        PhoneField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(PhoneField.getText().equals(PhoneTxt)){
                    PhoneField.setText("");
                }
                if(AddressField.getText().equals(AddressTxt)){
                    AddressField.setText("");
                }
                if(ApartmentField.getText().equals(ApartmentTxt)){
                    ApartmentField.setText("");
                }
                if(CityField.getText().equals(CityTxt)){
                    CityField.setText("");
                }
                if(StateField.getText().equals(StateTxt)){
                    StateField.setText("");
                }
                if(ZipField.getText().equals(ZipTxt)){
                    ZipField.setText("");
                }
                super.mouseClicked(e);
            }
        });
        //set confirm button
        GoToConfirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String phone = PhoneField.getText();
                String address = AddressField.getText();
                String apartment = ApartmentField.getText();
                String city = CityField.getText();
                String state = StateField.getText();
                String zipcode = ZipField.getText();
                if(phone.isEmpty() || phone.equals(PhoneTxt)){
                    Status.setText(emptyphone);
                } else if (address.isEmpty() || address.equals(AddressTxt)) {
                    Status.setText(emptyaddress);
                } else if (apartment.isEmpty() || apartment.equals(ApartmentTxt)) {
                    Status.setText(emptyapartment);
                } else if (city.isEmpty() || city.equals(CityTxt)) {
                    Status.setText(emptycity);
                } else if (state.isEmpty() || state.equals(StateTxt)) {
                    Status.setText(emptystate);
                } else if (zipcode.isEmpty() || zipcode.equals(ZipTxt)) {
                    Status.setText(emptyzip);
                } else {
                    JOptionPane.showMessageDialog(null,"Your order have been sent","Message",JOptionPane.PLAIN_MESSAGE);
                    frame.setContentPane(new Home(frame).getHomePanel());
                    frame.revalidate();
                }
            }
        });
    }

    public JPanel getAddressPanel() {
        return AddressPanel;
    }
}
