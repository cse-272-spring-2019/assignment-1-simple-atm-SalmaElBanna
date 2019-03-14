import java.util.HashMap;

public class Validation {
    HashMap user;
    public Validation(){
    user = new HashMap();
    user.put("5425053","1998");
}
    

    public boolean validate(String cardNumber,String pin){
        //TODO: validate Card number and Pin
        boolean result = false;
        String number=(String) user.get(cardNumber);
        if(number!=null){
            result=number.equals(pin);
        }
        return result ;
    
} 
    
    
}
