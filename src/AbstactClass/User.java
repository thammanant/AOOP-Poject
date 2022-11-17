package AbstactClass;

public abstract class User {
    protected String name;
    protected String phone;
    protected String email;
    protected String password;

    public String getName() {
        return name;
    }
    public String getPhone() {
        return phone;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String getEmail(){
        return this.email;
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