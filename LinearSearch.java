/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package algorithm_analyzer;

/**
 *
 * @author ASUS Vivobookk
 */
public class LinearSearch {
    
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }
    
    public static double measureTime(int size) {
        int[] arr = generateRandomArray(size);
        int target = arr[(int) (Math.random() * size)]; // Target that exists
        
        long startTime = System.nanoTime();
        linearSearch(arr, target);
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
