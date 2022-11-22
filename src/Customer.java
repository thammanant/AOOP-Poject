import AbstactClass.User;
import Resources.ClothesAmount;
import Resources.ClothesType;
import net.thegreshams.firebase4j.error.FirebaseException;
import net.thegreshams.firebase4j.error.JacksonUtilityException;
import org.apache.log4j.helpers.CountingQuietWriter;

import javax.swing.*;
import javax.xml.crypto.Data;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Vector;

public class Customer extends User {
    private String address;
    private ClothesAmount clothes;
    private String status = "Waiting";
    private ArrayList<ClothesAmount> history = new ArrayList<>();

    private ArrayList<int[]> test = new ArrayList<>();

    public Customer(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.clothes = new ClothesAmount();
    }

    public Customer(String name) {
        this.name = name;
        this.address = "None";
        this.phone = "None";
        this.clothes = new ClothesAmount();
    }
    public Customer() {
        this.clothes = new ClothesAmount();
    }
    public void addHistory(ClothesAmount temp){this.history.add(temp);}
    public ArrayList<ClothesAmount> getHistory(){return this.history;}

    public ClothesAmount getClothes() {
        return this.clothes;
    }
    public String getAddress() {
        return this.address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void addClothes(ClothesType name, int amount) {
        this.clothes.addWord(name, amount);
    }
    public void removeClothes(ClothesType clothes) {
        this.clothes.remove(clothes);
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getStatus() {
        return status;
    }
    public void resetClothes() {
        this.clothes = new ClothesAmount();
    }

    @Override
    public String printAll() {
        String result = "";
        result += "Name: " + this.name + "\n";
        result += "Address: " + this.address + "\n";
        result += "Phone: " + this.phone + "\n";
        result += "Status: " + this.status + "\n";
        return result;
    }

    public String printClothes() {
        return this.clothes.printAll();
    }
    public String printAmount(int i){
        return Integer.toString(this.clothes.printAmount(i));
    }
    //print amount total
    public String printtotal(){
        return Integer.toString(this.clothes.printTotal());
    }

    //check whether there is order or not
    public String check() throws JacksonUtilityException, FirebaseException, IOException {
        //keep status of every order
        String[] arr = new String[DataBaseFB.getHistoryAmount(this.getName())];
        String c= "";
        for(int i=0; i<arr.length; i++){
            arr[i] = DataBaseFB.getHistory(this.getName(), i+1).get(15);
        }
        //check whether there is order or not
        for(int i=0; i<arr.length; i++){
            if(arr[i].equals("-1")|| arr[i].equals("-2")){
                c= "1";
            } else if (arr[i].equals("-3")) {
                c="0";
            }
        }
        return c;
    }
    public String check_history() throws JacksonUtilityException, FirebaseException, IOException {
        //keep status of every order
        String[] arr2 = new String[DataBaseFB.getHistoryAmount(this.getName())];
        String c= "";
        for(int i=0; i<arr2.length; i++){
            arr2[i] = Objects.requireNonNull(DataBaseFB.getHistory(this.getName(), i + 1)).get(15);
        }
        //check whether there is order or not
        for(int i=0; i<arr2.length; i++){
             if (arr2[i].equals("-3")) {
                c="0";
            }
        }
        return c;
    }



    //display how many order using database
    public String displayOrder() throws JacksonUtilityException, FirebaseException, IOException {
        //display current order
        String[] arr = new String[DataBaseFB.getHistoryAmount(this.getName())];
        int count = 0;
        for(int i=0; i<arr.length; i++){
            if(DataBaseFB.getHistory(this.getName(), i+1).get(15).equals("-1")){
                arr[i] = Objects.requireNonNull(DataBaseFB.getHistory(this.getName(), i + 1)).get(15);
                count++;
            }
            else if(DataBaseFB.getHistory(this.getName(), i+1).get(15).equals("-2")){
                arr[i] = Objects.requireNonNull(DataBaseFB.getHistory(this.getName(), i + 1)).get(15);
                count++;
            }
        }
        return "You have " + count + " order(s)";
    }

    //popup that there is no order
    public void Popup_order() {
            JOptionPane.showMessageDialog(null, "You have no order now!");
        }

    //function add all clothes
    public void addAmountToClothes (int am1, int am2, int am3, int am4, int am5, int am6, int am7, int am8, int am9, int am10, int am11, int am12, int am13,int am14){
        int arr[]= {am1,am2,am3,am4,am5,am6,am7,am8,am9,am10,am11,am12,am13,am14};
        ClothesType c[] ={ClothesType.CottonWhite,ClothesType.CottonColoured,ClothesType.MixedWhite,ClothesType.MixedColoured,ClothesType.DelicatesWhite,ClothesType.DelicatesColoured,ClothesType.WoolWhite,ClothesType.WoolColoured,ClothesType.BeddingWhite,ClothesType.BeddingColoured,ClothesType.Baby_wearWhite,ClothesType.Baby_wearColoured,ClothesType.LeatherWhite,ClothesType.LeatherColoured};
        for(int i=0 ; i< arr.length ; i++){
                addClothes(c[i],arr[i]);
        }
    }
}
