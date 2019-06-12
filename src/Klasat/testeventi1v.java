package javaFx;
import javafx.application.Application; 
import javafx.geometry.Pos; 
import javafx.scene.Scene; 
import javafx.scene.control.Button; 
import javafx.scene.layout.HBox; 
import javafx.stage.Stage; 
import javafx.event.ActionEvent; 
import javafx.event.EventHandler ;
public class ushtrimefx extends Application { 
	@Override // Override the start method in the Application class 
	public void start(Stage primaryStage) { 
		  
		HBox pane = new HBox(); 
		// Place nodes in the pane 
		pane.setAlignment(Pos.CENTER);
		Button btOK=new Button("ok");
		Button btCancle=new Button("cancle");
		
		okhandlerclass handler1=new okhandlerclass();
		btOK.setOnAction(handler1);
		
		canclehandlerclass handler2=new canclehandlerclass();
		btCancle.setOnAction(handler2);
		
		pane.getChildren().addAll(btOK,btCancle);
		
// Create a scene and place it in the stage 
		Scene scene = new Scene(pane); 
		primaryStage.setTitle("handle event"); // Set the stage title 
		primaryStage.setScene(scene); // Place the scene in the stage 
     	primaryStage.show(); // Display the stage 27  
	} 

}
		 
class okhandlerclass implements EventHandler<ActionEvent> { 
	@Override
	public void handle(ActionEvent e) { 
		 System.out.println("ok button eshte shtyp");
}   
}

class canclehandlerclass implements EventHandler<ActionEvent> { 
	@Override
	public void handle(ActionEvent e) { 
		 System.out.println("cancle button eshte shtyp");
}   
}
		 