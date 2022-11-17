import AbstactClass.User;
import Resources.ClothesAmount;
import Resources.ClothesType;

public class Customer extends User {
    private String address;
    private ClothesAmount clothes;
    private String status = "Waiting";
    public Customer(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.clothes = new ClothesAmount();
    }

    private ClothesAmount getClothes() {
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
        String a = Integer.toString(this.clothes.printAmount(i));
        return a;
    }
    public String checkClothes(){
        if (this.getClothes().getSize() == 0) {
            return "All cleaned!";
        }
        else {
            return this.printClothes();
        }
    }
    //function add all clothes
    public void addAmountToClothes (int am1, int am2, int am3, int am4, int am5, int am6, int am7, int am8, int am9, int am10, int am11, int am12){
        addClothes(ClothesType.CottonWhite,am1);
        addClothes(ClothesType.CottonColoured,am2);
        addClothes(ClothesType.MixedWhite,am3);
        addClothes(ClothesType.MixedColoured,am4);
        addClothes(ClothesType.DelicatesWhite,am5);
        addClothes(ClothesType.DelicatesColoured,am6);
        addClothes(ClothesType.WoolWhite,am7);
        addClothes(ClothesType.WoolColoured,am8);
        addClothes(ClothesType.BeddingWhite,am9);
        addClothes(ClothesType.BeddingColoured,am10);
        addClothes(ClothesType.Baby_wearWhite,am11);
        addClothes(ClothesType.Baby_wearColoured,am12);
    }
}
