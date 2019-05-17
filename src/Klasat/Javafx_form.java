package projekti;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Javafx_form extends Application {

	 public static void main(String[] args) {
	        launch(args);
	    }
	 
	@Override
    public void start(Stage primaryStage) {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25,25,25,25));
        
        
        
        
        Text scenetitle = new Text("  PRISHTINA  AIRPORT ");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.BOLD, 20));
        scenetitle.setStyle("-fx-text-fill: blue; -fx-font-size: 16px;");
        Label userName = new Label("User Name:");
        TextField userTextField = new TextField();
        Label pw = new Label("Password: ");
        PasswordField pwBox = new PasswordField();
       
        

        grid.add(userName,0,1);
        grid.add(userTextField, 1, 1);
        grid.add(pw, 0, 2);
        grid.add(pwBox, 1, 2);
        
       
        
        Button btn = new Button("Sign In");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 1, 4);
        
        final Text actiontarget = new Text();
        grid.add(actiontarget, 1, 6);
        
        
        GridPane imgpane = new GridPane();
        Image image1 = new Image("projekti/airair.png");
        ImageView selectimg = new ImageView(image1);
        imgpane.setAlignment(Pos.CENTER);
        imgpane.getChildren().add(selectimg);
        imgpane.add(scenetitle,1,0,2,1);
        
        VBox main = new VBox(10);
        main.getChildren().addAll(imgpane,grid);
        
        Scene scene = new Scene(main, 500, 600);
        scene.getStylesheets().add(Javafx_form.class.getResource("login.css").toExternalForm());
        primaryStage.setTitle("Projekti");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
