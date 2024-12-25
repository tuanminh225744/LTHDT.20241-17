package SortAlgorithm;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class VisualQuickSortFX extends SortAlgorithm {

    

    public VisualQuickSortFX(int[] array) {
        this.array = array;
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Visual Quick Sort - JavaFX");

        // Khu vực sắp xếp
        sortingArea = new VBox(10);
        sortingArea.setAlignment(Pos.TOP_CENTER);

        renderArray();
        startSorting();

        Scene scene = new Scene(sortingArea, 970, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    

    protected void startSorting() {
        new Thread(() -> {
            try {
                quickSort(0, array.length - 1);
                highlightSorted();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    private void quickSort(int low, int high) throws InterruptedException {
        if (low < high) {
            int pivotIndex = partition(low, high);

            quickSort(low, pivotIndex - 1);
            quickSort(pivotIndex + 1, high);
        }
    }

    private int partition(int low, int high) throws InterruptedException {
        int pivot = array[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            int finalJ = j;
            

            javafx.application.Platform.runLater(() -> highlightBlocks(finalJ, high, Color.YELLOW));
            Thread.sleep(DELAY);

            if (array[j] < pivot) {
                i++;
                swap(i, j);
                updateBlocks(i, j);
            }

            javafx.application.Platform.runLater(() -> highlightBlocks(finalJ, high, Color.CYAN));
        }

        swap(i + 1, high);
        updateBlocks(i + 1, high);
        return i + 1;
    }

}
