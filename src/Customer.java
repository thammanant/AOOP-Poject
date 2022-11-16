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

    public String checkClothes(){
        if (this.getClothes().getSize() == 0) {
            return "All cleaned!";
        }
        else {
            return this.printClothes();
        }
    }
}
