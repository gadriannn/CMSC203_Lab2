


import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;



/**
 * This panel is the basic panel, inside which other panels are placed.  
 * Before beginning to implement, design the structure of your GUI in order to 
 * understand what panels go inside which ones, and what buttons or other components
 * go in which panels.  
 * @author ralexander
 *
 */
//make the main panel's layout be a VBox
public class FXMainPane extends VBox {

	//student Task #2:
	 // Declare the buttons, label, textfield, and HBoxes
    private Button helloButton;
    private Button howdyButton;
    private Button chineseButton;
    private Button clearButton;
    private Button exitButton;

    private Label feedbackLabel;
    private TextField feedbackTextField;

    private HBox buttonBox;
    private HBox feedbackBox;

    // Declare an instance of DataManager
    private DataManager dataManager;

    /**
     * The MainPanel constructor sets up the entire GUI. Remember to wait to add a component to its
     * containing component until the container has been created. This is the only constraint on
     * the order in which the following statements appear.
     */
    FXMainPane() {
        // Instantiate the buttons with the arguments “Hello”, “Howdy”, “Chinese“, Clear”, and “Exit”.
        helloButton = new Button("Hello");
        howdyButton = new Button("Howdy");
        chineseButton = new Button("Chinese");
        clearButton = new Button("Clear");
        exitButton = new Button("Exit");

        // Instantiate the label with the argument “Feedback:”.
        feedbackLabel = new Label("Feedback:");

        // Instantiate the textfield.
        feedbackTextField = new TextField();

        // Instantiate the HBoxes.
        buttonBox = new HBox(10, helloButton, howdyButton, chineseButton, clearButton, exitButton);
        feedbackBox = new HBox(10, feedbackLabel, feedbackTextField);

        // Instantiate the DataManager instance.
        dataManager = new DataManager();

        // Add the label and textfield to one of the HBoxes.
        feedbackBox.setPadding(new Insets(10, 10, 10, 10));

        // Add the buttons to the other HBox.
        buttonBox.setPadding(new Insets(10, 10, 10, 10));

        // Add the HBoxes to this FXMainPanel (a VBox).
        this.getChildren().addAll(feedbackBox, buttonBox);

        // Set the buttons to respond to mouse-clicks.
        helloButton.setOnAction(new ButtonHandler());
        howdyButton.setOnAction(new ButtonHandler());
        chineseButton.setOnAction(new ButtonHandler());
        clearButton.setOnAction(new ButtonHandler());
        exitButton.setOnAction(new ButtonHandler());
    }

    // Create a private inner class to handle button clicks.
    private class ButtonHandler implements javafx.event.EventHandler<javafx.event.ActionEvent> {
        @Override
        public void handle(javafx.event.ActionEvent e) {
            // Determine which button was clicked and update the feedback textfield accordingly.
            if (e.getSource() == helloButton) {
                feedbackTextField.setText(dataManager.getHello());
            } else if (e.getSource() == howdyButton) {
                feedbackTextField.setText(dataManager.getHowdy());
            } else if (e.getSource() == chineseButton) {
                feedbackTextField.setText(dataManager.getChinese());
            } else if (e.getSource() == clearButton) {
                feedbackTextField.setText("");
            } else if (e.getSource() == exitButton) {
                System.exit(0);
            }
        }
    }

}