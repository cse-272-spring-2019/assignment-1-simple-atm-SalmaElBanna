
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




public class WithdrawScreen {
    int withdraw=0;
    Scene scene;
    TransactionsScreen transactionsScreen;
    Stage stage;
    int balance;
    BalanceScreen  balanceScreen = new BalanceScreen(balance);
    Stage primaryStage;
                
   
    TextField tf1= new TextField();
    TextField tf= new TextField();
    
     
    
     public WithdrawScreen(Stage stage){
         this.stage=stage;  
     }
     
     
     public void drawScene() {
      
        Label amount= new Label(" Select an amount and press ENTER: ");
        Label or = new Label("Or enter another amount and press OK");
        Button ok = new Button( "OK");
        Button zero = new Button( "$50");
        Button one = new Button( "$100");
        Button two = new Button( "$150");
        Button three = new Button( "$200");
        Button four = new Button( "$250");
        Button five = new Button( "$300");
        Button six = new Button( "$350");
        Button seven = new Button( "$400");
        Button enter = new Button( "ENTER");
       
        
        final Label label= new Label();
        final Label label2= new Label();
        
        
        
        
        final GridPane grid = new GridPane();
        grid.add(amount,0,0);
        grid.add(zero,0,2);
        grid.add(one,0,3);
        grid.add(two,0,4);
        grid.add(three,0,5);
        grid.add(four,1,2);
        grid.add(five,1,3);
        grid.add(six,1,4);
        grid.add(seven,1,5);
        grid.add(tf,0,7);
        grid.add(enter,0,8);
        grid.add(or,2,6);
        grid.add(tf1,2,7);
        grid.add(ok,2,8);
        
        
        grid.add(label,0,11);
        grid.add(label2,0,12);
        grid.setVgap(5); 
        grid.setHgap(0);
        grid.setAlignment(Pos.CENTER);
        grid.setStyle("-fx-background-color: lightblue;");
        enter.setStyle("-fx-background-color: lightgreen;-fx-text-fill: black;-fx-font: normal bold 20px 'serif';-fx-text-fill: black;-fx-border-color: black;");
        ok.setStyle("-fx-background-color: blue;-fx-text-fill: black;;-fx-font: normal bold 20px 'serif';-fx-text-fill: black;-fx-border-color: black;");
       
        
         zero.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                TextField tf= new TextField("50");
                withdraw=Integer.parseInt(tf.getText());
                grid.add(tf,0,7);
  
            }   
          
            });
        one.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                TextField tf= new TextField("100");
                 withdraw=Integer.parseInt(tf.getText());
                grid.add(tf,0,7);
  
            }});
        two.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                TextField tf= new TextField("150");
                 withdraw=Integer.parseInt(tf.getText());
                grid.add(tf,0,7);
            }});
        three.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
               TextField tf= new TextField("200");
                withdraw=Integer.parseInt(tf.getText());
                grid.add(tf,0,7);
            }});
        four.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                TextField tf= new TextField("250");
                 withdraw=Integer.parseInt(tf.getText());
                grid.add(tf,0,7);
            }});
        five.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                TextField tf= new TextField("300");
                withdraw=Integer.parseInt(tf.getText());
                grid.add(tf,0,7);
            }});
        six.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                TextField tf= new TextField("350");
                withdraw=Integer.parseInt(tf.getText());
                grid.add(tf,0,7);
            }});
        seven.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                TextField tf= new TextField("400");
                withdraw=Integer.parseInt(tf.getText());
                grid.add(tf,0,7);
            }});
        
        
        
        ok.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                
                if (tf1.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Enter Amount first!","Warning",JOptionPane.WARNING_MESSAGE);
                }
                //Validation that Textfield contain no Character only numbers
                 else if( tf1.getText().matches("^[a-zA-Z]*$")){
                     JOptionPane.showMessageDialog(null,"Invalid!\n"+"This field can't contain any characters.","ERROR",JOptionPane.ERROR_MESSAGE);
                     clearFields();
                 }
                 //Validation that Textfield contain  only positive numbers
                else if(Integer.parseInt(tf1.getText())<0)
                 {
                   JOptionPane.showMessageDialog(null,"Invalid!","ERROR",JOptionPane.ERROR_MESSAGE);
                     clearFields();
                 }
                else{
                withdraw=Integer.parseInt(tf1.getText());
                
                if((balanceScreen.getBalance())>=withdraw)
                { 
                 balanceScreen.setBalance(balanceScreen.getBalance()-withdraw);
                label.setText("Your transaction is complete");
                transactionsScreen.history.add("Withdraw amount : $ "+withdraw);
                System.out.println("Balance:"+balanceScreen.getBalance());
                 
                 
                }
                else 
                {   balanceScreen.setBalance(balanceScreen.getBalance());
                    JOptionPane.showMessageDialog(null,"Invalid Amount","Error",JOptionPane.ERROR_MESSAGE);
                    clearFields();
               
                }
                
                label2.setText("Would you like to preform  another Transaction?");
                final Button yes = new Button( "Yes");
                final Button no = new Button( "No");
                
                
                grid.add(yes,2,12);
                grid.add(no,2,13);
                label.setVisible(true);
                label2.setVisible(true);  
                yes.setVisible(true);
                no.setVisible(true);
                
            yes.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //clear Labels&Buttons after Button click
                  label.setVisible(false);
                  label2.setVisible(false);
                  yes.setVisible(false);
                  no.setVisible(false);
                stage.setScene(transactionsScreen.getScene());
                clearFields();
            }});
            no.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.exit(0);
               
            }});
                } 
            }  
            });
              
        
        enter.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
               
               
                if((balanceScreen.getBalance())>=withdraw)
                { 
                 balanceScreen.setBalance(balanceScreen.getBalance()-withdraw);
                label.setText("Your transaction is complete");
                transactionsScreen.history.add("Withdraw amount : $ "+withdraw);
                System.out.println("Balance:"+balanceScreen.getBalance());
                 
                 
                }
                else 
                {   balanceScreen.setBalance(balanceScreen.getBalance());
                    JOptionPane.showMessageDialog(null,"Invalid Amount","Error",JOptionPane.ERROR_MESSAGE);
                    clearFields();
               
                }            
                              
                label2.setText("Would you like to preform  another Transaction?  ");
                final Button yes = new Button( "Yes");
                final Button no = new Button( "No");
                grid.add(yes,2,12);
                grid.add(no,2,13);
                label.setVisible(true);
                label2.setVisible(true);  
                yes.setVisible(true);
                no.setVisible(true);
                
            yes.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                clearFields();
                //clear Labels after Button click
                  label.setVisible(false);
                  label2.setVisible(false);
                  yes.setVisible(false);
                  no.setVisible(false);
                stage.setScene(transactionsScreen.getScene());
                
            }});
            no.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.exit(0);
               
            }});
                
            }  
            });
         
        scene= new Scene(grid,800,400);
        
     } 
       public Scene getScene(){
            return this.scene;
       }

    public int getWithdraw() {
        return withdraw;
    }
       
       
       public void setTransactionsScreen(TransactionsScreen transactionsScreen){
        this.transactionsScreen=transactionsScreen;
    }

    private void clearFields(){
        tf.setText(null);
        tf1.setText(null);
      
    }
  
}
