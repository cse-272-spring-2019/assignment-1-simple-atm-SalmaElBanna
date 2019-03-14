import javafx.application.Application;
import javafx.stage.Stage;



public class ATM_Machine extends Application {
    
    public static void main(String[] args) {
        launch(args);
      
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("           Simple  ATM   ");
        
        FirstScreen firstScreen=new FirstScreen(primaryStage);
        TransactionsScreen transactionsScreen=new TransactionsScreen(primaryStage);
        WithdrawScreen withdrawScreen=new WithdrawScreen(primaryStage);
        DepositScreen depositScreen=new DepositScreen(primaryStage);
        
        
        
        
        firstScreen.setTransactionsScreen(transactionsScreen);
        transactionsScreen.setWithdrawScreen(withdrawScreen);
        transactionsScreen.setDepositScreen(depositScreen);
        withdrawScreen.setTransactionsScreen(transactionsScreen);
        depositScreen.setTransactionsScreen(transactionsScreen);
      
        
        
        firstScreen.drawScene();
        transactionsScreen.drawScene();
        withdrawScreen.drawScene();
        depositScreen.drawScene();
        
        
        primaryStage.setScene(firstScreen.getScene());
        
        primaryStage.show();
    
}
    
}
