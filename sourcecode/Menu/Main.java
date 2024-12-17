package Menu;
import java.util.Random;
import java.util.Scanner;
import SortAlgorithm.*;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose mode:");
        System.out.println("1. Auto mode (generate random array)");
        System.out.println("2. Manual mode (user inputs the array)");
        System.out.print("Your choice: ");
        int modeChoice = scanner.nextInt();

        int[] array = null;

        if (modeChoice == 1) {
            // Auto mode: Máy tự tạo dãy số ngẫu nhiên
            System.out.print("Enter the size of the array: ");
            int size = scanner.nextInt();

            array = generateRandomArray(size);
            System.out.println("Generated random array:");
            for (int num : array) {
                System.out.print(num + " ");
            }
            System.out.println();
        } else if (modeChoice == 2) {
            // Manual mode: Người dùng tự nhập mảng
            System.out.print("Enter the size of the array: ");
            int size = scanner.nextInt();
            array = new int[size];

            System.out.println("Enter the elements of the array:");
            for (int i = 0; i < size; i++) {
                System.out.print("Element " + (i + 1) + ": ");
                array[i] = scanner.nextInt();
            }
        } else {
            System.out.println("Invalid choice! Exiting...");
            System.exit(0);
        }

        // Hiển thị menu để chọn thuật toán
        System.out.println("\nChoose a sorting algorithm:");
        System.out.println("1. Bubble Sort");
        System.out.println("2. Quick Sort");
        System.out.println("3. Insertion Sort");
        System.out.print("Your choice: ");
        int choice = scanner.nextInt();

        // Thực thi thuật toán dựa trên lựa chọn
        SortAlgorithm sortAlgorithm = null;

        switch (choice) {
            case 1:
                sortAlgorithm = new BubbleSort(array.clone());
                break;
            case 2:
                sortAlgorithm = new QuickSort(array.clone());
                break;
            case 3:
                sortAlgorithm = new InsertionSort(array.clone());
                break;
            default:
                System.out.println("Invalid choice!");
                System.exit(0);
        }

        // Thực hiện sắp xếp và hiển thị kết quả
        System.out.println("\nOriginal Array:");
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println("\n");

        // Sắp xếp và hiển thị từng bước
        sortAlgorithm.sort();
        sortAlgorithm.visualize();

        // Hiển thị mảng đã sắp xếp
        System.out.println("\nSorted Array:");
        for (int num : sortAlgorithm.array) {
            System.out.print(num + " ");
        }
        System.out.println();

        scanner.close();
    }

    // Hàm sinh mảng ngẫu nhiên
    private static int[] generateRandomArray(int size) {
        Random random = new Random();
        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(100); // Giá trị từ 0 đến 99
        }
        return array;
    }
}

