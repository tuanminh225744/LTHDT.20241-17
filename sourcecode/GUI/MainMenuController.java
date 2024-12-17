package GUI;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.application.Platform;

public class MainMenuController {

    @FXML
    private Button bubblesortbutton;

    @FXML
    private Button quicksortbutton;

    @FXML
    private Button help;

    @FXML
    private Button quit;

    // Action for Bubble Sort button
    @FXML
    void handleBubbleSort(ActionEvent event) {
        // Logic to navigate to Bubble Sort screen
        System.out.println("Bubble Sort selected. Navigating to Bubble Sort demonstration...");
        // You can use Scene or Stage to navigate to the BubbleSort UI.
    }

    // Action for Quick Sort button
    @FXML
    void handleQuickSort(ActionEvent event) {
        // Logic to navigate to Quick Sort screen
        System.out.println("Quick Sort selected. Navigating to Quick Sort demonstration...");
    }

    // Action for Help button
    @FXML
    void help(ActionEvent event) {
        // Display help information in an Alert
        Alert helpAlert = new Alert(Alert.AlertType.INFORMATION);
        helpAlert.setTitle("Help");
        helpAlert.setHeaderText("Program Usage Instructions");
        helpAlert.setContentText(
                "Welcome to the Sorting Demonstration Program!\n\n" +
                "1. Select a sorting algorithm (Bubble Sort or Quick Sort).\n" +
                "2. Follow the on-screen demonstration for sorting.\n" +
                "3. Quit to exit the program safely.\n\n" +
                "Enjoy exploring sorting algorithms!"
        );
        helpAlert.showAndWait();
    }

    // Action for Quit button
    @FXML
    void quit(ActionEvent event) {
        // Confirmation dialog before quitting
        Alert quitAlert = new Alert(Alert.AlertType.CONFIRMATION);
        quitAlert.setTitle("Exit Program");
        quitAlert.setHeaderText("Are you sure you want to quit?");
        quitAlert.setContentText("Press OK to confirm or Cancel to stay.");

        // Check user confirmation
        if (quitAlert.showAndWait().orElse(ButtonType.CANCEL) == ButtonType.OK) {
            System.out.println("Exiting program...");
            Platform.exit(); // Properly closes the JavaFX application
        }
    }
}
