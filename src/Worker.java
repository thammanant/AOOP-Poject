import AbstactClass.User;

public class Worker extends User {

    private String email;
    private String password;

    public Worker(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }
    public Worker(String email) {
        this.email = email;
    }
    public Worker() {
    }

    @Override
    public String printAll() {
        String result = "";
        result += "Name: " + this.name + "";
        result += "Phone: " + this.phone + "";
        return result;
    }
}
