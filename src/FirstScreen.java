

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;



public class FirstScreen {
     Scene scene;
     Validation validation;
     TransactionsScreen transactionsScreen;
     Stage stage;
     final TextField cardNumberField = new TextField();
     PasswordField pinField = new PasswordField();
     
     public FirstScreen(Stage stage){
         this.stage=stage;  
     }
     
     
    public void drawScene() {
        
        validation=new Validation();
        Label text= new Label(" Please enter Card Number and PIN and press ENTER : ");
        Label cardNumber= new Label(" Card Number : ");
        Label pin= new Label(" PIN :");
       
        GridPane grid = new GridPane();
        
        Button enter = new Button( "ENTER");
        Button clear = new Button( "CLEAR");
        
        enter.setStyle("-fx-background-color: lightgreen; -fx-text-fill: white;-fx-font: normal bold 20px 'serif';"); 
        clear.setStyle("-fx-background-color: lightpink; -fx-text-fill: white;-fx-font: normal bold 20px 'serif';");
        cardNumber.setStyle("-fx-font: normal bold 20px 'serif' "); 
        pin.setStyle("-fx-font: normal bold 20px 'serif' ");  
        grid.setStyle("-fx-background-color: lavender;");
        
        
        enter.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
               String cardNumber = cardNumberField.getText();
               String pin = pinField.getText();
               boolean valid = validation.validate(cardNumber,pin);
                       if (valid){
                       stage.setScene(transactionsScreen.getScene());
                       }
                       else 
                       {
                        JOptionPane.showMessageDialog(null,"Invalid Card number or PIN!","ERROR",JOptionPane.ERROR_MESSAGE);
                        clearFields(); 
                       }
                           
                           
            }
        });
        clear.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
               clearFields();         
            }
        });
        
        
        
        grid.add(text,0,0);
        grid.add(cardNumber,0,3);
        grid.add(pin,0,4);
        grid.add(cardNumberField,1,3);
        grid.add(pinField,1,4);
        grid.add(enter,0,5);
        grid.add(clear,1,5);
        
        
        grid.setVgap(5); 
        grid.setHgap(0);
        grid.setAlignment(Pos.CENTER);
        

         scene= new Scene(grid,600,200);
    }

    
    public Scene getScene(){
            return this.scene;
        }
    public void setTransactionsScreen(TransactionsScreen transactionsScreen){
        this.transactionsScreen=transactionsScreen;
    }
  
    private void clearFields(){
        cardNumberField .setText(null);
         pinField.setText(null);
      
    }
    }
