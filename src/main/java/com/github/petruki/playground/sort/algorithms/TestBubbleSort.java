package com.github.petruki.playground.sort.algorithms;

import java.util.Arrays;

import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

@State(Scope.Benchmark)
public class TestBubbleSort {
	
    public static void sort(ExecutionPlan plan) {
    	int[] input = plan.numbers;
        
    	int inputLength = input.length;
        int temp;
        boolean is_sorted;

        for (int i = 0; i < inputLength; i++) {
            is_sorted = true;

            for (int j = 1; j < (inputLength - i); j++) {
                if (input[j - 1] > input[j]) {
                    temp = input[j - 1];
                    input[j - 1] = input[j];
                    input[j] = temp;
                    is_sorted = false;
                }
            }
            
            if (is_sorted) break;
        }
    }
    
    public static void main(String[] args) {
        ExecutionPlan plan = new ExecutionPlan();
        plan.numbers = new int[] { 170, 45, 75, 90, 802, 24, 2, 66 };
        sort(plan);
        
        System.out.println(Arrays.toString(plan.numbers));
    }
	
}