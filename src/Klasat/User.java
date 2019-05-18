package Klasat;
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
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
public class User extends Application {
	public String emri;
	public String mbiemri;
	
	@Override 
	public void start(Stage primaryStage)
	{
		
		StackPane pane=new StackPane();
pane.getChildren().addAll(new Label("Pershendetje "+emri+" "+mbiemri));

		
		Scene scene=new Scene(pane,200,200);
		primaryStage.setTitle("Hello");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	

}
