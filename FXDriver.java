


import java.io.IOException;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class FXDriver extends Application {
	   
	/**
	 * The main method for the GUI example program JavaFX version
	 * @paramargs not used
	 * @throws IOException
	 */
	public static void main(String[] args) {
		launch(args);   
	}
		   
	@Override
	public void start(Stage stage) throws IOException {
		//task 1
		FXMainPane root = new FXMainPane();
		//  instantiate the FXMainPane, name it root
		//  set the scene to hold root
		Scene scene = new Scene(root);
	    stage.setScene(scene);
		//set stage title
		stage.setTitle("Hello World GUI");
		//display the stage
		stage.show();

	}
}
