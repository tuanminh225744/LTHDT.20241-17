package SortAlgorithm;
import java.util.ArrayList;
import java.util.List;

public class QuickSort extends SortAlgorithm {
    private List<int[]> steps;

    public QuickSort(int[] array) {
        super("QuickSort", array);
        this.steps = new ArrayList<>();
    }

    @Override
    public void sort() {
        steps.clear();
        quickSort(0, array.length - 1);
    }

    private void quickSort(int low, int high) {
        if (low < high) {
            int pivotIndex = partition(low, high);
            steps.add(array.clone());
            quickSort(low, pivotIndex - 1);
            quickSort(pivotIndex + 1, high);
        }
    }

    private int partition(int low, int high) {
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

    @Override
    public void visualize() {
        System.out.println("Visualization of QuickSort:");
        for (int[] step : steps) {
            printArray(step);
        }
    }
}
