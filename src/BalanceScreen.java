
import javafx.stage.Stage;

public class BalanceScreen {
    Stage primaryStage;
    static int balance;
    TransactionsScreen transactionsScreen;
    
    
    
    
    

    public BalanceScreen(int balance) {
        this.balance = 1000;
    }
     
    
     public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        
        return balance;
    }
    
       public void setTransactionsScreen(TransactionsScreen transactionsScreen){
        this.transactionsScreen=transactionsScreen;
    }
        
}
