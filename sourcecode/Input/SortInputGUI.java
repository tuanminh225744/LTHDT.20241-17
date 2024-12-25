package Input;
import java.io.IOException;

import SortAlgorithm.VisualBubbleSortFX;
import SortAlgorithm.VisualInsertionSortFX;
import SortAlgorithm.VisualQuickSortFX;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SortInputGUI extends Application {

    private int[] array; // Lưu trữ mảng hiện tại
    private TextArea arrayDisplay; // Hiển thị mảng
    private ChoiceBox<String> sortChoice; // Lựa chọn thuật toán
	
    

    @Override
    public void start(Stage primaryStage) {
    	
        primaryStage.setTitle("Sorting Algorithms Demonstration");

        // Label hướng dẫn
        Label instructionLabel = new Label("Choose how to input the array:");

        // Nút tạo mảng ngẫu nhiên
        Button generateArrayButton = new Button("Generate Random Array");
        generateArrayButton.setOnAction(e -> generateRandomArray());

        // Nút nhập mảng thủ công
        Button inputArrayButton = new Button("Input Array Manually");
        inputArrayButton.setOnAction(e -> inputArrayManually());

        // Khu vực hiển thị mảng
        arrayDisplay = new TextArea();
        arrayDisplay.setEditable(false);
        arrayDisplay.setPromptText("Array will be displayed here...");
        arrayDisplay.setPrefHeight(100);

        // Lựa chọn thuật toán sắp xếp
        sortChoice = new ChoiceBox<>();
        sortChoice.getItems().addAll("Bubble Sort", "Quick Sort", "Insertion Sort");
        sortChoice.setValue("Bubble Sort"); // Mặc định chọn Bubble Sort

        // Nút chạy thuật toán
        Button runAlgorithmButton = new Button("Run Algorithm");
        runAlgorithmButton.setOnAction(e -> {
        if (array == null || array.length == 0) {
            showError("No array to sort. Please generate or input an array first.");
            return;
        }

        
        if ("Bubble Sort".equals(sortChoice.getValue())) {
            VisualBubbleSortFX visualBubbleSortFX = new VisualBubbleSortFX(array);
            Stage stage = new Stage();
            try {
                visualBubbleSortFX.start(stage);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        
        if ("Insertion Sort".equals(sortChoice.getValue())) {
            VisualInsertionSortFX visualInsertionSortFX = new VisualInsertionSortFX(array);
            Stage stage = new Stage();
            try {
                visualInsertionSortFX.start(stage);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        
        if ("Quick Sort".equals(sortChoice.getValue())) {
            VisualQuickSortFX visualQuickSortFX = new VisualQuickSortFX(array);
            Stage stage = new Stage();
            try {
                visualQuickSortFX.start(stage);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    });

        // Nút quay lại
        Button backButton = new Button("Back");
        backButton.setOnAction(e -> {
            // Đóng cửa sổ hiện tại
            primaryStage.close();

            // Mở lại màn hình menu
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/Menu/GUi.fxml"));
                Parent root = loader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.setTitle("Main Menu");
                stage.show();
            } catch (IOException ex) {
                ex.printStackTrace(); // In lỗi nếu xảy ra
            }
        }); // Trở về main

        // Bố cục nút và hiển thị
        VBox layout = new VBox(10, instructionLabel, generateArrayButton, inputArrayButton,
                new Label("Select Sorting Algorithm:"), sortChoice, runAlgorithmButton,
                arrayDisplay, backButton);
        layout.setPadding(new Insets(15));
        layout.setStyle("-fx-font-family: Arial; -fx-font-size: 14;");

        // Tạo Scene và hiển thị
        Scene scene = new Scene(layout, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Hàm tạo mảng ngẫu nhiên
    private void generateRandomArray() {
        TextInputDialog sizeDialog = new TextInputDialog();
        sizeDialog.setTitle("Random Array Generator");
        sizeDialog.setHeaderText("Enter the size of the array:");
        sizeDialog.setContentText("Size:");

        sizeDialog.showAndWait().ifPresent(size -> {
            try {
                int arraySize = Integer.parseInt(size);
                if (arraySize <= 0) {
                    throw new NumberFormatException();
                }
                
                array = new int[arraySize];
                for (int i = 0; i < arraySize; i++) {
                    array[i] = (int) (Math.random() * 100) + 1; // Giá trị từ 1 đến 100
                }
                displayArray(array);
            } catch (NumberFormatException e) {
                showError("Invalid size. Please enter a positive integer.");
            }
        });
    }

    // Hàm nhập mảng thủ công
    private void inputArrayManually() {
        TextInputDialog inputDialog = new TextInputDialog();
        inputDialog.setTitle("Manual Array Input");
        inputDialog.setHeaderText("Enter the array elements separated by commas:");
        inputDialog.setContentText("Array:");

        inputDialog.showAndWait().ifPresent(input -> {
            try {
                String[] elements = input.split(" ");
                array = new int[elements.length];
                for (int i = 0; i < elements.length; i++) {
                    array[i] = Integer.parseInt(elements[i].trim());
                }
                displayArray(array);
            } catch (NumberFormatException e) {
                showError("Invalid input. Please enter integers separated by commas.");
            }
        });
    }
    
    


    

    // Hiển thị mảng
    private void displayArray(int[] array) {
        StringBuilder sb = new StringBuilder("Array: ");
        for (int value : array) {
            sb.append(value).append(" ");
        }
        arrayDisplay.setText(sb.toString());
    }

    // Hiển thị lỗi
    private void showError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    
}

