import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;



public class DepositScreen {
    
    
    
    int deposit=0;
    Scene scene;
    TransactionsScreen transactionsScreen;
    Stage stage;
    int balance;
    BalanceScreen balanceScreen = new BalanceScreen(balance);
     static TextField amountField = new TextField();
   

    public DepositScreen(int deposit) {
        this.deposit = deposit;
    }
    
    
  
     
     public DepositScreen(Stage stage){
         this.stage=stage;  
     }
    public void drawScene() {
       
        Label amount= new Label(" Enter amount to deposit : ");
        Button enter = new Button( "ENTER");
     
        final GridPane grid = new GridPane();
        grid.add(amount,0,0);
        grid.add(enter,1,4);
        grid.add(amountField,1,0);
        grid.setVgap(5); 
        grid.setHgap(0);
        grid.setAlignment(Pos.CENTER);
        grid.setStyle("-fx-background-color: lightblue;");
        
        Button zero = new Button( "0");
        Button one = new Button( "1");
        Button two = new Button( "2");
        Button three = new Button( "3");
        Button four = new Button( "4");
        Button five = new Button( "5");
        Button six = new Button( "6");
        Button seven = new Button( "7");
        Button eight = new Button( "8");
        Button nine = new Button( "9");
        
        grid.add(zero,0,1);
        grid.add(one,1,1);
        grid.add(two,2,1);
        grid.add(three,0,2);
        grid.add(four,1,2);
        grid.add(five,2,2);
        grid.add(six,0,3);
        grid.add(seven,1,3);
        grid.add(eight,2,3);
        grid.add(nine,0,4);
        zero.setStyle("-fx-text-fill: black;-fx-font: normal bold 20px 'serif';");
        one.setStyle("-fx-text-fill: black;-fx-font: normal bold 20px 'serif';");
        two.setStyle("-fx-text-fill: black;-fx-font: normal bold 20px 'serif';");
        three.setStyle("-fx-text-fill: black;-fx-font: normal bold 20px 'serif';");
        four.setStyle("-fx-text-fill: black;-fx-font: normal bold 20px 'serif';");
        five.setStyle("-fx-text-fill: black;-fx-font: normal bold 20px 'serif';");
        six.setStyle("-fx-text-fill: black;-fx-font: normal bold 20px 'serif';");
        seven.setStyle("-fx-text-fill: black;-fx-font: normal bold 20px 'serif';");
        eight.setStyle("-fx-text-fill: black;-fx-font: normal bold 20px 'serif';");
        nine.setStyle("-fx-text-fill: black;-fx-font: normal bold 20px 'serif';");
        enter.setStyle("-fx-background-color:orchid;-fx-text-fill: black;-fx-font: normal bold 20px 'serif';");
        
        
        zero.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                 amountField.appendText(""+"0");
                deposit=Integer.parseInt(amountField.getText());
                
  
            }   
          
            });
        one.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                 amountField.appendText(""+"1");
                deposit=Integer.parseInt(amountField.getText());
                
  
            }});
        two.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                amountField.appendText(""+"2");
                 deposit=Integer.parseInt(amountField.getText());
               
            }});
        three.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
               amountField.appendText(""+"3");
                deposit=Integer.parseInt(amountField.getText());
                
            }});
        four.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                amountField.appendText(""+"4");
                deposit=Integer.parseInt(amountField.getText());
                
            }});
        five.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                 amountField.appendText(""+"5");
                deposit=Integer.parseInt(amountField.getText());
                
            }});
        six.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                amountField.appendText(""+"6");
                deposit=Integer.parseInt(amountField.getText());
                
            }});
        seven.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                amountField.appendText(""+"7");
                deposit=Integer.parseInt(amountField.getText());
               
            }});
        eight.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                amountField.appendText(""+"8");
                deposit=Integer.parseInt(amountField.getText());
                
            }});
        nine.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                amountField.appendText(""+"9");
                deposit=Integer.parseInt(amountField.getText());
               
            }});
        enter.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
            
                
                 if (amountField.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Enter amount first!","Warning",JOptionPane.WARNING_MESSAGE);
                } 
                 //Validation that Textfield contain no Character only numbers
                 else if( amountField.getText().matches("^[a-zA-Z]*$")){
                     JOptionPane.showMessageDialog(null,"Invalid!\n"+"This field can't contain any characters.","ERROR",JOptionPane.ERROR_MESSAGE);
                     clearFields();
                 }
                 //Validation that Textfield contain  only positive numbers
                else if(Integer.parseInt(amountField.getText())<0)
                 {
                   JOptionPane.showMessageDialog(null,"Invalid!","ERROR",JOptionPane.ERROR_MESSAGE);
                     clearFields();
                 }
                 
                 else{
               
               deposit=Integer.parseInt(amountField.getText());
                  
                 balanceScreen.setBalance(balanceScreen.getBalance()+deposit);
                 transactionsScreen.history.add("Deposit amount : $ "+deposit);
                  System.out.println("Balance:"+balanceScreen.getBalance());
              
                  int N=JOptionPane.showConfirmDialog(null,"Your Deposit is complete\n"+"Do you want to make another Transaction?","Question",JOptionPane.YES_NO_OPTION);
                  if(N==0){
                    stage.setScene(transactionsScreen.getScene());
                     clearFields(); 
                  }
                  else{
                       System.exit(0);
                  }
                 }  
            }  
            });
       
        scene= new Scene(grid,700,300);
        
     } 
       public Scene getScene(){
            return this.scene;
       }

    public int getDeposit() {
        return deposit;
    }
       
       
       public void setTransactionsScreen(TransactionsScreen transactionsScreen){
        this.transactionsScreen=transactionsScreen;
    }

     private void clearFields(){
        amountField.setText(null);
        
      
    }
  
}
