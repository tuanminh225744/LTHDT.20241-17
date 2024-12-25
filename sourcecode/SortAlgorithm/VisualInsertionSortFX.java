package SortAlgorithm;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class VisualInsertionSortFX extends SortAlgorithm {


    public VisualInsertionSortFX(int[] array) {
    	this.array = array;
    }
    
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Visual Insertion Sort - JavaFX");

        // Khu vực sắp xếp
        sortingArea = new VBox(10);
        sortingArea.setAlignment(Pos.TOP_CENTER);

        renderArray();
        startSorting();

        Scene scene = new Scene(sortingArea, 970, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @Override
    protected void startSorting() {
        new Thread(() -> {
            try {
                insertionSort();
                highlightSorted();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    private void insertionSort() throws InterruptedException {
        int n = array.length;
        for (int i = 1; i < n; i++) {
            int key = array[i];
            int j = i - 1;

            // Highlight phần tử đang được kiểm tra (key)
            highlightBlocks(i, i, Color.YELLOW);
            Thread.sleep(DELAY);

            // Duyệt và di chuyển các phần tử lớn hơn key
            while (j >= 0 && array[j] > key) {
                highlightBlocks(j, j + 1, Color.RED); // Highlight các phần tử đang so sánh
                Thread.sleep(DELAY);

                swap(j + 1, j);                      // Hoán đổi giá trị
                updateBlocks(j + 1, j);              // Cập nhật giao diện
                highlightBlocks(j + 1, j, Color.CYAN); // Reset màu các khối đã hoán đổi
                Thread.sleep(DELAY);

                j--;
            }

            // Chèn key vào vị trí đúng
            array[j + 1] = key;
            updateBlocks(j + 1, j + 1);              // Cập nhật giá trị của khối chèn
            Thread.sleep(DELAY);
        }
    }
}