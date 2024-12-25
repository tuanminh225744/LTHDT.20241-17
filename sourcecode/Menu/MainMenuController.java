package Menu;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import Input.SortInputGUI;
import javafx.application.Platform;

public class MainMenuController {

    
    @FXML
    private Button help;

    @FXML
    private Button quit;

    @FXML
    private Button input;
    

    // Action for Help button
    @FXML
    void help(ActionEvent event) {
        // Display help information in an Alert
        Alert helpAlert = new Alert(Alert.AlertType.INFORMATION);
        helpAlert.setTitle("Help");
        helpAlert.setHeaderText("Program Usage Instructions");
        helpAlert.setContentText(
                "Welcome to the Sorting Demonstration Program!\n\n" +
                "1. Enter array or generate random array\n"+
                "2. Select a sorting algorithm (Bubble Sort, Insertion Sort or Quick Sort).\n" +
                "3. Follow the on-screen demonstration for sorting.\n" +
                "4. Quit to exit the program safely.\n\n" +
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
    
    @FXML
    void input(ActionEvent event) {
    	try {
            // Đóng cửa sổ hiện tại
            ((Button) event.getSource()).getScene().getWindow().hide();

            // Tạo một cửa sổ mới và hiển thị màn hình SortInputGUI
            SortInputGUI sortInputGUI = new SortInputGUI();
            Stage stage = new Stage();
            sortInputGUI.start(stage);
        } catch (Exception e) {
            e.printStackTrace(); // In lỗi nếu có vấn đề
        }
    }
    
    
}
