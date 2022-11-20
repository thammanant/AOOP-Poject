package AbstactClass;

import java.util.Random;

public abstract class User {
    protected String name;
    protected String phone;
    protected String password;
    protected String type;

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
}
