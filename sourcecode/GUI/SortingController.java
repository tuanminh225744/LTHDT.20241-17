import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.Arrays;

public class SortingController {

    @FXML
    private TextField inputArrayField; // TextField để nhập mảng

    @FXML
    private ComboBox<String> algorithmComboBox; // ComboBox để chọn thuật toán

    @FXML
    private TextArea stepsTextArea; // TextArea để hiển thị các bước

    @FXML
    private Button startButton; // Nút Start

    @FXML
    public void initialize() {
        // Thêm các thuật toán vào ComboBox
        algorithmComboBox.getItems().addAll("Bubble Sort", "Quick Sort", "Insertion Sort");

        // Xử lý sự kiện khi nhấn nút Start
        startButton.setOnAction(event -> startSorting());
    }

    private void startSorting() {
        // Xóa các bước cũ
        stepsTextArea.clear();

        // Lấy mảng từ TextField
        String input = inputArrayField.getText();
        if (input == null || input.isEmpty()) {
            stepsTextArea.setText("Please enter an array.");
            return;
        }

        int[] array;
        try {
            array = Arrays.stream(input.split(","))
                          .map(String::trim)
                          .mapToInt(Integer::parseInt)
                          .toArray();
        } catch (NumberFormatException e) {
            stepsTextArea.setText("Invalid input. Please enter numbers separated by commas.");
            return;
        }

        // Xác định thuật toán được chọn
        String algorithm = algorithmComboBox.getValue();
        if (algorithm == null) {
            stepsTextArea.setText("Please select a sorting algorithm.");
            return;
        }

        // Chạy thuật toán và hiển thị từng bước
        switch (algorithm) {
            case "Bubble Sort":
                runBubbleSort(array);
                break;
            case "Quick Sort":
                runQuickSort(array);
                break;
            case "Insertion Sort":
                runInsertionSort(array);
                break;
        }
    }

    // Hiển thị Bubble Sort
    private void runBubbleSort(int[] array) {
        stepsTextArea.appendText("Starting Bubble Sort...\n");
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    // Hoán đổi
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;

                    // Hiển thị bước hiện tại
                    stepsTextArea.appendText(Arrays.toString(array) + "\n");
                }
            }
        }
        stepsTextArea.appendText("Bubble Sort Completed.\n");
    }

    // Hiển thị Insertion Sort
    private void runInsertionSort(int[] array) {
        stepsTextArea.appendText("Starting Insertion Sort...\n");
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
                stepsTextArea.appendText(Arrays.toString(array) + "\n");
            }
            array[j + 1] = key;
            stepsTextArea.appendText(Arrays.toString(array) + "\n");
        }
        stepsTextArea.appendText("Insertion Sort Completed.\n");
    }

    // Hiển thị Quick Sort
    private void runQuickSort(int[] array) {
        stepsTextArea.appendText("Starting Quick Sort...\n");
        quickSort(array, 0, array.length - 1);
        stepsTextArea.appendText("Quick Sort Completed.\n");
    }

    private void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pi = partition(array, low, high);

            // Hiển thị bước phân chia
            stepsTextArea.appendText("Pivot: " + array[pi] + " -> " + Arrays.toString(array) + "\n");

            quickSort(array, low, pi - 1);
            quickSort(array, pi + 1, high);
        }
    }

    private int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (array[j] < pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return i + 1;
    }
}
