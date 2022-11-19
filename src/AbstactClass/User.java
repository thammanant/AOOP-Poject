package AbstactClass;

import java.util.Random;

public abstract class User {
    protected String name;
    protected String phone;
    protected String password;
    protected String type;
    protected String ID;

    public String getName() {
        return name;
    }
    public String getPhone() {
        return phone;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPassword(String password)
    {
        this.password = password;
    }
    public String getPassword()
    {
        return this.password;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public abstract String printAll();

    public String getID() {
        Random rand = new Random();
        int n = rand.nextInt(1000000);
        this.ID = String.valueOf(n);
        return this.ID;
    }
}
