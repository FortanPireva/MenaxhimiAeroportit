package Klasat;
import java.sql.SQLException;

import DB.DatabaseManager;
import javafx.application.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.HPos;
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
public class Register extends Application {
	Stage stage=new Stage();
	TextField emri = new TextField();
	TextField mbiemri = new TextField();
	TextField user_name = new TextField();
    PasswordField password = new PasswordField();
	Label resultHolderLabel = new Label("");
	@Override
	public void start(Stage primaryStage)
	{
GridPane pane = new GridPane();
		
		Label resultLabel = new Label("Forma");
		
		pane.setPadding(new Insets(11, 12 ,13 ,14));
		
		pane.setHgap(10);
		pane.setVgap(15);
		
		pane.add(new Label("Emri"), 0, 0);
		pane.add(emri, 1, 0);
		pane.add(new Label("Mbiemri"), 0, 1);
		pane.add(mbiemri, 1, 1);
		
		pane.add(new Label("User_name:"), 0, 2);
		pane.add(user_name, 1, 2);
		pane.add(new Label("Password:"), 0, 3);
		pane.add(password, 1, 3);

	
		Button RegisterButton = new Button("Regjistrohu");
		
		RegisterButton.setOnAction(e->{
			 DatabaseManager db=new DatabaseManager("javauser", "telegrafi123");
	    	 String query="insert into users(`emri`,`mbiemri`,`user_name`,`password`)  values('"+emri.getText()+"','"+mbiemri.getText()
	    	 +"','"+user_name.getText()+"','"+password.getText()+"')";
	    	 try {
				db.getStatement().execute(query);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		 HBox hbBtn = new HBox(10);
	     hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
	     hbBtn.getChildren().addAll(RegisterButton);
	     pane.add(hbBtn, 1, 4);	

		GridPane.setHalignment(resultLabel, HPos.RIGHT);
		
		pane.addRow(4, resultHolderLabel);
		Font fontForResults = Font.font("Times New Roman", FontWeight.BOLD, 15);
		resultHolderLabel.setFont(fontForResults);

		Scene scene = new Scene(pane);
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("Quadratic Solver");
		
		primaryStage.show();
	}
	public static void main(String[] args)
	{
		Application.launch(args);
	}

}
