import AbstactClass.User;
import net.thegreshams.firebase4j.error.FirebaseException;
import net.thegreshams.firebase4j.error.JacksonUtilityException;

import java.awt.*;
import java.io.IOException;

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
        String cus[] = new String[DataBaseFB.findAllCustomerUsernames().size()];            //create customers
        String res = "";
        for(int i =0 ; i< DataBaseFB.findAllCustomerUsernames().size();i++){                //transfer all customers to array
            cus[i] = DataBaseFB.findAllCustomerUsernames().get(i);
        }
        for(int i=0; i< cus.length;i++){
            int s =DataBaseFB.getHistoryAmount(cus[i]);
            for(int j=0; j < s;j++) {
                if (DataBaseFB.getHistory(cus[i], j + 1).get(15).equals("-3")) {
                    res = "You don't have order now";
                    return res;
                }
                else {
                    res = "You have order now";
                    return res;
                }
            }
        }
        return res;
    }

}