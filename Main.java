/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package algorithm_analyzer;

/**
 *
 * @author ASUS Vivobookk
 */
public class main {
    
    // QuickSort implementation (Member 4)
    public static class QuickSort {
        
        public static void quickSort(int[] arr, int low, int high) {
            if (low < high) {
                int pi = partition(arr, low, high);
                quickSort(arr, low, pi - 1);
                quickSort(arr, pi + 1, high);
            }
        }
        
        private static int partition(int[] arr, int low, int high) {
            int pivot = arr[high];
            int i = (low - 1);
            
            for (int j = low; j < high; j++) {
                if (arr[j] <= pivot) {
                    i++;
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
            
            int temp = arr[i + 1];
            arr[i + 1] = arr[high];
            arr[high] = temp;
            
            return i + 1;
        }
        
        public static double measureTime(int size) {
            int[] arr = generateRandomArray(size);
            long startTime = System.nanoTime();
            quickSort(arr, 0, arr.length - 1);
            long endTime = System.nanoTime();
            return (endTime - startTime) / 1_000_000.0;
        }
    }
    
    public static int[] generateRandomArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = (int) (Math.random() * 1000);
        }
        return arr;
    }
    
    public static void main(String[] args) {
        System.out.println("ALGORITHM PERFORMANCE ANALYSIS");
        System.out.println("==============================\n");
        
        // Member 1: Linear Search
        System.out.println("MEMBER 1: LINEAR SEARCH");
        displayLinearSearchResults();
        
        // Member 2: Binary Search
        System.out.println("\nMEMBER 2: BINARY SEARCH");
        displayBinarySearchResults();
        
        // Member 3: Bubble Sort
        System.out.println("\nMEMBER 3: BUBBLE SORT");
        displayBubbleSortResults();
        
        // Member 4: Quick Sort
        System.out.println("\nMEMBER 4: QUICK SORT");
        displayQuickSortResults();
        
        // Comparative Analysis
        System.out.println("\nCOMPARATIVE ANALYSIS");
        displayComparativeAnalysis();
    }
    
    public static void displayLinearSearchResults() {
        System.out.println("+------------+----------+");
        System.out.println("| Input Size | Time (ms)|");
        System.out.println("+------------+----------+");
        
        int[] sizes = {100, 500, 1000};
        for (int size : sizes) {
            double time = LinearSearch.measureTime(size);
            System.out.printf("| %-10d | %8.4f |\n", size, time);
        }
        System.out.println("+------------+----------+");
    }
    
    public static void displayBinarySearchResults() {
        System.out.println("+------------+----------+");
        System.out.println("| Input Size | Time (ms)|");
        System.out.println("+------------+----------+");
        
        int[] sizes = {100, 500, 1000};
        for (int size : sizes) {
            double time = BinarySearch.measureTime(size);
            System.out.printf("| %-10d | %8.4f |\n", size, time);
        }
        System.out.println("+------------+----------+");
    }
    
    public static void displayBubbleSortResults() {
        System.out.println("+------------+----------+");
        System.out.println("| Input Size | Time (ms)|");
        System.out.println("+------------+----------+");
        
        int[] sizes = {100, 500, 1000};
        for (int size : sizes) {
            double time = BubbleSort.measureTime(size);
            System.out.printf("| %-10d | %8.4f |\n", size, time);
        }
        System.out.println("+------------+----------+");
    }
    
    public static void displayQuickSortResults() {
        System.out.println("+------------+----------+");
        System.out.println("| Input Size | Time (ms)|");
        System.out.println("+------------+----------+");
        
        int[] sizes = {100, 500, 1000};
        for (int size : sizes) {
            double time = QuickSort.measureTime(size);
            System.out.printf("| %-10d | %8.4f |\n", size, time);
        }
        System.out.println("+------------+----------+");
    }
    
    public static void displayComparativeAnalysis() {
        System.out.println("+------------+---------------+---------------+---------------+---------------+");
        System.out.println("| Input Size | Linear Search | Binary Search | Bubble Sort  | Quick Sort   |");
        System.out.println("+------------+---------------+---------------+---------------+---------------+");
        
        int[] sizes = {100, 500, 1000};
        for (int size : sizes) {
            double linearTime = LinearSearch.measureTime(size);
            double binaryTime = BinarySearch.measureTime(size);
            double bubbleTime = BubbleSort.measureTime(size);
            double quickTime = QuickSort.measureTime(size);
            
            System.out.printf("| %-10d | %13.4f | %13.4f | %13.4f | %13.4f |\n", 
                            size, linearTime, binaryTime, bubbleTime, quickTime);
        }
        System.out.println("+------------+---------------+---------------+---------------+---------------+");
    }
}
