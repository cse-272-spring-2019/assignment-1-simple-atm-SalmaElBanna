
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;



public class TransactionsScreen {
    Scene scene;
    FirstScreen firstScreen;
    WithdrawScreen withdrawScreen;
    DepositScreen depositScreen;
    int balance;
    BalanceScreen balanceScreen=new BalanceScreen(balance);
    Stage stage;
   
    ArrayList<String> history= new ArrayList<>();
     int i=1;
     int flag=0;
     
     
     public TransactionsScreen(Stage stage){
         this.stage=stage;  
     }
    
    public void drawScene() {
         
       
        Label text= new Label("Please select a transaction");
        Button withdraw = new Button( "Cash Withdrawal");
        Button deposit = new Button( "Deposit");
        Button balanceInquiry = new Button( "Balance Inquiry");
        Button next = new Button( "Next");
        Button previous = new Button( "Previous");
        final GridPane grid = new GridPane();
       
        
        
       
        
        
        withdraw.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                i=1;
                stage.setScene(withdrawScreen.getScene());
                
            }
        });
        
        deposit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                i=1;
                stage.setScene(depositScreen.getScene());
            }
        });
        
        balanceInquiry.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                i=1;
                  history.add(" Balance Inquiry: $ "+balanceScreen.getBalance());
                 JOptionPane.showMessageDialog(null, "Your Current Balance is: $"+balanceScreen.getBalance(),"BALANCE",JOptionPane.INFORMATION_MESSAGE);
                 System.out.println("Balance:"+balanceScreen.getBalance());
            }
            
        });
       
       
        previous.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                
                 if(history.isEmpty()==true)
                 {
                  JOptionPane.showMessageDialog(null,"Please select a Transaction first","Warning",JOptionPane.WARNING_MESSAGE);
                 }       
                else
                  { 
                       
                     //System.out.println(history.get(history.size()-i));
                      
                     if(history.size()-i>0) 
                     {
                          i++;
                      String str=history.get(history.size()-i);
                      JOptionPane.showMessageDialog(null,str,"Previous Transaction",JOptionPane.INFORMATION_MESSAGE);
                       
                     }  
                     else 
                     {
                         JOptionPane.showMessageDialog(null,"No more previous Transactions to be shown","Warning",JOptionPane.WARNING_MESSAGE);
                     } 
                    
                      
                      
                    
                  }
            }
        });
        next.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(flag==0)
                { 
                    i--;
                    flag=1;
                }
               if(history.isEmpty()==true)
                {
                   JOptionPane.showMessageDialog(null,"Please select a Transaction first","Warning",JOptionPane.WARNING_MESSAGE);
                }       
               else
                { 
                  if(history.size()-i<history.size()-1)
                  {   
                      i--;
                      String str1=history.get(history.size()-i);
                      JOptionPane.showMessageDialog(null,str1,"Next Transaction",JOptionPane.INFORMATION_MESSAGE);
                  }
                     
                  else
                  {
                   
                      JOptionPane.showMessageDialog(null,"No more Transactions to be shown","Warning",JOptionPane.WARNING_MESSAGE);
                  }
                  
                }
            }
        });
        
        
        
        
        grid.add(text,0,0);
        grid.add(withdraw,1,2);
        grid.add(deposit,2,2);
        grid.add(balanceInquiry,3,2);
        grid.add(next,3,3);
        grid.add(previous,1,3);
        grid.setVgap(10); 
        grid.setHgap(2);
        grid.setAlignment(Pos.CENTER);
        grid.setStyle("-fx-background-color: lavender;"); 
        previous.setStyle(" -fx-text-fill: black;-fx-font: normal bold 20px 'serif';");
        next.setStyle(" -fx-text-fill: black;-fx-font: normal bold 20px 'serif';");
        
       scene= new Scene(grid,550,200);
        
    }
    public Scene getScene(){
       return scene; 
    }
    public void setFirstScreen(FirstScreen firstScreen){
        this.firstScreen=firstScreen;
    }
    public void setWithdrawScreen(WithdrawScreen withdrawScreen){
        this.withdrawScreen=withdrawScreen;
    }
    public void setDepositScreen(DepositScreen depositScreen){
        this.depositScreen=depositScreen;
    }
    public void setBalanceScreen(BalanceScreen balanceScreen){
        this.balanceScreen= balanceScreen;
    }
    
    
    
}
