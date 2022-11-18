
import java.util.Random;

public abstract class User {
    protected String name;
    protected String phone;
    protected String username;
    protected String password;

    protected String ID;

    private void setID(){
        //random int
        Random rand = new Random();
        int rand_int = rand.nextInt(1000000);
        this.ID = Integer.toString(rand_int);
    }

    public String getName() {
        return name;
    }
    public String getPhone() {
        return phone;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setUsername(String username){
        this.username = username;
    }
    public String getUsername(){
        return this.username;
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

    public String getID() {
        this.setID();
        return ID;
    }

    public abstract String printAll();

}
