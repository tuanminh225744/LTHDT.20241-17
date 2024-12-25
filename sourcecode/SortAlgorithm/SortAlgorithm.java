package SortAlgorithm;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public abstract class SortAlgorithm extends Application {

    protected static final int BLOCK_SIZE = 50;
    protected static final int DELAY = 500; // Độ trễ tính bằng mili giây
    protected int[] array;
    protected VBox sortingArea;



    @Override
    public void start(Stage primaryStage) {
        
    }

    protected void renderArray() {
        sortingArea.getChildren().clear();
        addBlocks(array);
    }

    protected void addBlocks(int[] arr) {
        HBox blockRow = new HBox(5);
        blockRow.setAlignment(Pos.CENTER);
        for (int value : arr) {
            Rectangle block = new Rectangle(BLOCK_SIZE, BLOCK_SIZE, Color.CYAN);
            Text text = new Text(String.valueOf(value));
            StackPane stack = new StackPane(block, text);
            blockRow.getChildren().add(stack);
        }
        sortingArea.getChildren().add(blockRow);
    }

    protected abstract void startSorting();

    protected void updateBlocks(int i, int j) {
        javafx.application.Platform.runLater(() -> {
            HBox blockRow = (HBox) sortingArea.getChildren().get(0);
            StackPane blockI = (StackPane) blockRow.getChildren().get(i);
            StackPane blockJ = (StackPane) blockRow.getChildren().get(j);
            Text textI = (Text) blockI.getChildren().get(1);
            Text textJ = (Text) blockJ.getChildren().get(1);
            textI.setText(String.valueOf(array[i]));
            textJ.setText(String.valueOf(array[j]));
        });
    }

    protected void highlightBlocks(int i, int j, Color color) {
        javafx.application.Platform.runLater(() -> {
            HBox blockRow = (HBox) sortingArea.getChildren().get(0);
            StackPane blockI = (StackPane) blockRow.getChildren().get(i);
            StackPane blockJ = (StackPane) blockRow.getChildren().get(j);
            Rectangle rectI = (Rectangle) blockI.getChildren().get(0);
            Rectangle rectJ = (Rectangle) blockJ.getChildren().get(0);
            rectI.setFill(color);
            rectJ.setFill(color);
        });
    }

    protected void highlightSorted() {
        javafx.application.Platform.runLater(() -> {
            HBox blockRow = (HBox) sortingArea.getChildren().get(0);
            for (int i = 0; i < blockRow.getChildren().size(); i++) {
                StackPane block = (StackPane) blockRow.getChildren().get(i);
                Rectangle rect = (Rectangle) block.getChildren().get(0);
                rect.setFill(Color.GREEN);
            }
        });
    }

    protected void swap(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}