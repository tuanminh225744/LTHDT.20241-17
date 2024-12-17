package SortAlgorithm;
import java.util.ArrayList;
import java.util.List;

public class BubbleSort extends SortAlgorithm {
    private List<int[]> steps;

    public BubbleSort(int[] array) {
        super("BubbleSort", array);
        this.steps = new ArrayList<>();
    }

    @Override
    public void sort() {
        int n = array.length;
        steps.clear();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
                steps.add(array.clone());
            }
        }
    }

    @Override
    public void visualize() {
        System.out.println("Visualization of BubbleSort:");
        for (int[] step : steps) {
            printArray(step);
        }
    }
}
