package com.github.petruki.playground.sort.algorithms;

import java.util.Arrays;

import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

@State(Scope.Benchmark)
public class TestInsertionSort {
    
    public static void sort(ExecutionPlan plan) {
    	int[] input = plan.numbers;
    	
        int n = input.length;  
        for (int j = 1; j < n; j++) {  
            int key = input[j];  
            int i = j - 1;  
            while ((i > -1) && (input [i] > key)) {  
            	input[i + 1] = input[i];  
                i--;  
            }  
            input[i + 1] = key;  
        } 
    }
    
    public static void main(String[] args) {
        ExecutionPlan plan = new ExecutionPlan();
        plan.numbers = new int[] { 170, 45, 75, 90, 802, 24, 2, 66 };
        sort(plan);
        
        System.out.println(Arrays.toString(plan.numbers));
    }
	
}