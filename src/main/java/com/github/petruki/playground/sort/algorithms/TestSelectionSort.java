package com.github.petruki.playground.sort.algorithms;

import java.util.Arrays;

import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

@State(Scope.Benchmark)
public class TestSelectionSort {
    
    public static void sort(ExecutionPlan plan) {
    	int[] input = plan.numbers;
        int size = input.length;
        
        for (int i = 0; i < size - 1; i++) {
            int min_idx = i;
            for (int j = i + 1; j < size; j++)
                if (input[j] < input[min_idx])
                    min_idx = j;
            
            int temp = input[min_idx];
            input[min_idx] = input[i];
            input[i] = temp;
        }
    }
    
    public static void main(String[] args) {
        ExecutionPlan plan = new ExecutionPlan();
        plan.numbers = new int[] { 170, 45, 75, 90, 802, 24, 2, 66 };
        sort(plan);
        
        System.out.println(Arrays.toString(plan.numbers));
    }
	
}