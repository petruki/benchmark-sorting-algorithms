package com.github.petruki.playground.sort.algorithms;

import java.util.Arrays;

import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

@State(Scope.Benchmark)
public class TestQuickSort {
    
    public static void sort(ExecutionPlan plan) {
    	int[] input = plan.numbers;
    	quickSort(input, 0, input.length - 1);
    }
    
    public static void quickSort(int[] numbers, int start, int end) {
        int partition = partition(numbers, start, end);
 
        if (partition - 1 > start) {
        	quickSort(numbers, start, partition - 1);
        }
        
        if (partition + 1 < end) {
        	quickSort(numbers, partition + 1, end);
        }
    }
 
    public static int partition(int[] numbers, int start, int end) {
        int pivot = numbers[end];
 
        for (int i = start; i < end; i++) {
            if (numbers[i] < pivot) {
                int temp = numbers[start];
                numbers[start] = numbers[i];
                numbers[i] = temp;
                start++;
            }
        }
 
        int temp = numbers[start];
        numbers[start] = pivot;
        numbers[end] = temp;
 
        return start;
    }
    
    public static void main(String[] args) {
        ExecutionPlan plan = new ExecutionPlan();
        plan.numbers = new int[] { 170, 45, 75, 90, 802, 24, 2, 66 };
        sort(plan);
        
        System.out.println(Arrays.toString(plan.numbers));
    }
	
}