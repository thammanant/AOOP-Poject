import AbstactClass.User;
import net.thegreshams.firebase4j.error.FirebaseException;
import net.thegreshams.firebase4j.error.JacksonUtilityException;

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
        String cus[] = new String[DataBaseFB.findAllCustomerUsernames().size()];
        for(int i =0 ; i< DataBaseFB.findAllCustomerUsernames().size();i++){
            cus[i] = DataBaseFB.findAllCustomerUsernames().get(i);
        }
        if(DataBaseFB.getHistoryAmount(cus[0])!= 0){
            return "There is order";
        }
        else{
            return "There is no order";
        }
    }

}
