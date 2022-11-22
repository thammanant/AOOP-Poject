import AbstactClass.User;
import net.thegreshams.firebase4j.error.FirebaseException;
import net.thegreshams.firebase4j.error.JacksonUtilityException;

import java.awt.*;
import java.io.IOException;
import java.util.Objects;

public class Worker extends User {

    public Worker(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }
    public Worker(String name){
        this.name = name;
    }
    public Worker() {}

    @Override
    public String printAll() {
        String result = "";
        result += "Name: " + this.name + "";
        result += "Phone: " + this.phone + "";
        return result;
    }
    //check order of customer
    public String checkOrder() throws JacksonUtilityException, FirebaseException, IOException {
        String cus[] = new String[DataBaseFB.findAllCustomerUsernames().size()];        //find all customer
        String res = "You don't have order";//result
        for(int i =0 ; i< DataBaseFB.findAllCustomerUsernames().size();i++){        //transfer all customer to array cus
            cus[i] = DataBaseFB.findAllCustomerUsernames().get(i);
        }
        for(int j=0; j< cus.length;j++){
            if(Objects.requireNonNull(DataBaseFB.getHistory(cus[j], j + 1)).get(15).equals("-2")){
                res = "You have order now";
            }
            if(Objects.requireNonNull(DataBaseFB.getHistory(cus[j], j + 1)).get(15).equals("-1")){
                res = "You have order now";
            }
        }
        return res;
    }

}
