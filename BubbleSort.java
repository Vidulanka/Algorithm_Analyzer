package algorithm_analyzer;


public class BubbleSort {
    
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
    
    public static double measureTime(int size) {
        int[] arr = generateRandomArray(size);
        
        long startTime = System.nanoTime();
        bubbleSort(arr);
        long endTime = System.nanoTime();
        
        return (endTime - startTime) / 1_000_000.0;
    }
    
    private static int[] generateRandomArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = (int) (Math.random() * 1000);
        }
        return arr;
    }
}
