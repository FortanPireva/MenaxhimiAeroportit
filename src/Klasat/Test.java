package Klasat;

import java.awt.RenderingHints.Key;
import java.sql.ResultSet;
import java.sql.SQLException;

import DB.DatabaseManager;
import javafx.application.*;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
public class Test extends Application {
	

	@Override
	public void start(Stage primaryStage)
	{
		GridPane grid = new GridPane();
	     grid.setAlignment(Pos.CENTER);
	     grid.setHgap(10);
	     grid.setVgap(10);
	     grid.setPadding(new Insets(25,25,25,25));
	     
	     
	     Scene scene = new Scene(grid, 500, 600);
	     
	     Text scenetitle = new Text("PRISHTINA  AIRPORT ");
	     scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
	     Label userName = new Label("User Name:");
	     TextField userTextField = new TextField();
	     Label pw = new Label("Password: ");
	     PasswordField pwBox = new PasswordField();
	     Label errorMessage=new Label();
	     errorMessage.setText("");
	     
	     
	     grid.add(scenetitle,0,0,2,1);
	     
	     grid.add(userName,0,2);
	     grid.add(userTextField, 1, 2);
	     
	     grid.add(pw, 0, 3);
	     grid.add(pwBox, 1, 3);
	     
	     Button btn = new Button("Sign In");
	 
	     Button btn1 = new Button("Register");
	     btn1.setOnAction(e->{
	    	 Stage stage=new Stage();
	    	 Register register=new Register();
	    	 register.start(stage);
	    	 
	     });
	     HBox ErrorPane=new HBox(10);
	     ErrorPane.setAlignment(Pos.TOP_CENTER);
	     ErrorPane.getChildren().add(errorMessage);
	     
	     HBox hbBtn = new HBox(10);
	     hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
	     hbBtn.getChildren().addAll(btn,btn1);
	     grid.add(hbBtn, 1, 6);
	     grid.add(ErrorPane, 1, 1);
	     
	     final Text actiontarget = new Text();
	     grid.add(actiontarget, 1, 7);
	     
	     btn.setOnAction(event -> {
	    	LoginEventi(userTextField, pwBox, errorMessage);
	     });
	     pwBox.setOnKeyPressed(e->{
	    	
	    	 if(e.getCode()==KeyCode.ENTER)
	    	 {
	    		 LoginEventi(userTextField, pwBox, errorMessage);
	    	 }
	    	 
	     });
	    	      
		   
				
		  
	    
	     primaryStage.setTitle("Projekti");
	     primaryStage.setScene(scene);
	     primaryStage.show();
		
	}
	 public static void main(String[] args) {
	        launch(args);
	    }
	
	 private void LoginEventi(TextField userTextField,TextField pwBox,Label errorMessage) {
		 DatabaseManager db=new DatabaseManager("javauser", "telegrafi123");
    	 String query="Select user_name,password,emri,mbiemri from users where user_name='"+userTextField.getText()
    	 +"' and password='"+pwBox.getText()+"';";
    	 try {
			ResultSet result=db.getStatement().executeQuery(query);
	    if(result.next()==true) {
	    	result.first();
			
			 	    User user1=new User();
	    			user1.emri=result.getString(3);
	    			user1.mbiemri=result.getString(4);
	    			Stage stage=new Stage();
	    			user1.start(stage);
	    			System.out.println("sdfla");
	 }
	    else {
			   
	    	errorMessage.setText("Username or password is incorrect");
    	    errorMessage.setStyle("-fx-text-fill:red;-fx-font-size:12px;");
    	    userTextField.setOnMouseClicked(e->{
    	    	userTextField.clear();
    	    	pwBox.clear();
    	    	errorMessage.setText("");
    	    });
    	 
    	       
    	       
    	}
    	      
	   
			
	    	 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
	 }
	 
	 
}