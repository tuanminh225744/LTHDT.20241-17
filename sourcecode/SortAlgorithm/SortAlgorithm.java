package SortAlgorithm;


public abstract class SortAlgorithm {
    protected String name;
    public int[] array;

    public SortAlgorithm(String name, int[] array) {
        this.name = name;
        this.array = array;
    }

    public abstract void sort();
    public abstract void visualize();

    public void inputArray(int[] array) {
        this.array = array;
    }

    public void generateArray(int size) {
        array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = (int) (Math.random() * 100);
        }
    }

    protected void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
    
    public int[] getArray() {
        return array;
    }
}
