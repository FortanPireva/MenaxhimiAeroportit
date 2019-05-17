package Klasat;

import java.sql.ResultSet;
import java.sql.SQLException;

import DB.DatabaseManager;
import javafx.application.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
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
	    
	     
	     grid.add(scenetitle,0,0,2,1);
	     grid.add(userName,0,1);
	     grid.add(userTextField, 1, 1);
	     grid.add(pw, 0, 2);
	     grid.add(pwBox, 1, 2);
	     
	     
	     
	     Button btn = new Button("Sign In");
	 
	     Button btn1 = new Button("Register");
	     btn1.setOnAction(e->{
	    	 Stage stage=new Stage();
	    	 Register register=new Register();
	    	 register.start(stage);
	    	 
	     });
	     
	     HBox hbBtn = new HBox(10);
	     hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
	     hbBtn.getChildren().addAll(btn,btn1);
	     grid.add(hbBtn, 1, 4);
	     
	     final Text actiontarget = new Text();
	     grid.add(actiontarget, 1, 6);
	     
	     btn.setOnAction(event -> {
	    	 DatabaseManager db=new DatabaseManager("javauser", "telegrafi123");
	    	 String query="Select user_name,password,emri,mbiemri from users";
	    	 try {
				ResultSet result=db.getStatement().executeQuery(query);
				while(result.next())
		    	{
				
		    		if(result.getString(1).equals(userTextField.getText())&&result.getString(2).equals(pwBox.getText()))
		    		{ 
		    			User user1=new User();
		    			user1.emri=result.getString(3);
		    			user1.mbiemri=result.getString(4);
		    			Stage stage=new Stage();
		    			user1.start(stage);
		    			
		    		}
		    		else
		    		{
		    			
		    		}
		    			
		    	}
		    	 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	
	    	 
	     });
	    
	     primaryStage.setTitle("Projekti");
	     primaryStage.setScene(scene);
	     primaryStage.show();
		
	}
	 public static void main(String[] args) {
	        launch(args);
	    }
}