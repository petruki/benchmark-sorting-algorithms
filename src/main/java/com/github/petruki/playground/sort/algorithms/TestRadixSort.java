package com.github.petruki.playground.sort.algorithms;

import java.util.Arrays;

import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

/**
 * Code based on https://www.geeksforgeeks.org/radix-sort/
 * 
 * @author Roger Floriano (petruki)
 */
@State(Scope.Benchmark)
public class TestRadixSort {
    
    public static void sort(ExecutionPlan plan) {
    	int[] input = plan.numbers;
    	radixSort(input, input.length);
    }
    
    /**
     * Return maximum value in arr[]
     */
    static int getMax(int arr[], int n) {
    	int max = arr[0];
    	for (int i : arr) {
    		if (i > max)
    			max = i;
    	}
    	return max;
    }
    
    /**
     * A function to do counting sort of arr[] according to
     * the digit represented by exp.
     * 
     * @param arr
     * @param n
     * @param exp
     */
    static void countSort(int arr[], int n, int exp) {
        int output[] = new int[n];
        int i;
        int count[] = new int[10];
        Arrays.fill(count, 0);
        
        for (int j : arr) {
        	count[(j / exp) % 10]++;
        }
 
        // Change count[i] so that count[i] now contains
        // actual position of this digit in output[]
        for (i = 1; i < 10; i++)
            count[i] += count[i - 1];
 
        // Build the output array
        for (i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }
 
        // Copy the output array to arr[], so that arr[] now
        // contains sorted numbers according to curent digit
        for (i = 0; i < n; i++)
            arr[i] = output[i];
    }
    
    static void radixSort(int arr[], int n) {
        int m = getMax(arr, n);
 
        // Do counting sort for every digit. Note that
        // instead of passing digit number, exp is passed.
        // exp is 10^i where i is current digit number
        for (int exp = 1; m / exp > 0; exp *= 10)
            countSort(arr, n, exp);
    }
    
    public static void main(String[] args) {
        ExecutionPlan plan = new ExecutionPlan();
        plan.numbers = new int[] { 170, 45, 75, 90, 802, 24, 2, 66 };
        sort(plan);
        
        System.out.println(Arrays.toString(plan.numbers));
    }
	
}