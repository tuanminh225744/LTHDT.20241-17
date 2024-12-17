package GUI;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    private static Stage primaryStage; // Lưu trữ Stage chính

    @Override
    public void start(Stage primaryStage) throws Exception {
        App.primaryStage = primaryStage; // Gán Stage cho biến tĩnh
        changeScene("GUi.fxml"); // Hiển thị Scene chính
        primaryStage.setTitle("Main Menu");
        primaryStage.show();
    }

    public static void changeScene(String fxmlFile) throws Exception {
        // Thay đổi Scene với tệp FXML mới
        Parent root = FXMLLoader.load(App.class.getResource(fxmlFile));
        primaryStage.setScene(new Scene(root, 600, 400));
    }

    public static void main(String[] args) {
        launch(args); // Khởi động ứng dụng
    }
}
