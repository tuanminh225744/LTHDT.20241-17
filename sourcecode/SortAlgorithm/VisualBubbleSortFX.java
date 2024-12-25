package SortAlgorithm;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class VisualBubbleSortFX extends SortAlgorithm {

    
//    public VisualBubbleSortFX() {
//    }

    public VisualBubbleSortFX(int[] array) {
        this.array = array;
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Visual Bubble Sort - JavaFX");

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
                bubbleSort();
                highlightSorted();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    private void bubbleSort() throws InterruptedException {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                int finalJ = j;
                javafx.application.Platform.runLater(() -> highlightBlocks(finalJ, finalJ + 1, Color.YELLOW));
                Thread.sleep(DELAY);

                if (array[j] > array[j + 1]) {
                    swap(j, j + 1);
                    updateBlocks(j, j + 1);
                }

                javafx.application.Platform.runLater(() -> highlightBlocks(finalJ, finalJ + 1, Color.CYAN));
            }
        }
    }

    

    
    

//    public static void main(String[] args) {
//        launch(args);
//    }
}
