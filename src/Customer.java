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
    public int check() throws JacksonUtilityException, FirebaseException, IOException {
        int arr2 = DataBaseFB.getHistoryAmount(this.getName());
        int temp = 0;
        if(arr2==1){
            if(Objects.requireNonNull(DataBaseFB.getHistory(this.getName(), 1)).get(15).equals("-3")){
                temp = 0;
            }
            else{
                temp = 1;
            }
        }
        if(arr2==0){
            temp = 0;
        }
        if(arr2>1){
            temp = 1;
            for(int i = 0; i < arr2; i ++){
                if(Objects.requireNonNull(DataBaseFB.getHistory(this.getName(), i+1)).get(15).equals("-2") || Objects.requireNonNull(DataBaseFB.getHistory(this.getName(), i+1)).get(15).equals("-1")){
                    temp = 1;
                }
            }
        }
        return temp;

    }



    //display how many order using database
    public String displayOrder() throws JacksonUtilityException, FirebaseException, IOException {
        int arr = DataBaseFB.getHistoryAmount(this.getName());
        String temp = "";
        if(arr==1){
            if(Objects.requireNonNull(DataBaseFB.getHistory(this.getName(), 1)).get(15).equals("-3")){
                temp = "You have no order";
            }
            else{
                temp = "You have "+arr+" order";
            }
        }
        if(arr==0){
            temp = "You have no order";
        }
        if(arr>1){
            temp = "You have "+arr+" orders";
            for(int i = 0; i < arr; i ++){
                if(Objects.requireNonNull(DataBaseFB.getHistory(this.getName(), i+1)).get(15).equals("-2") || Objects.requireNonNull(DataBaseFB.getHistory(this.getName(), i+1)).get(15).equals("-1")){
                    temp = "You have "+(arr-1)+" orders";
                }
            }
        }
        return temp;

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
