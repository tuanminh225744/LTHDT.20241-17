package SortAlgorithm;
import java.util.ArrayList;
import java.util.List;

public class InsertionSort extends SortAlgorithm {
    private List<int[]> steps;

    public InsertionSort(int[] array) {
        super("InsertionSort", array);
        this.steps = new ArrayList<>();
    }

    @Override
    public void sort() {
        steps.clear();
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
            steps.add(array.clone());
        }
    }

    @Override
    public void visualize() {
        System.out.println("Visualization of InsertionSort:");
        for (int[] step : steps) {
            printArray(step);
        }
    }
}
