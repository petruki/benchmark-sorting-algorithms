package com.github.petruki.playground.sort;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import com.github.petruki.playground.sort.algorithms.ExecutionPlan;
import com.github.petruki.playground.sort.algorithms.TestBubbleSort;
import com.github.petruki.playground.sort.algorithms.TestInsertionSort;
import com.github.petruki.playground.sort.algorithms.TestQuickSort;
import com.github.petruki.playground.sort.algorithms.TestRadixSort;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Fork(value = 1)
@Measurement(iterations = 1, time = 1)
@Warmup(iterations = 1, time = 1)
public class BenchmarkRunner {
	
	@Benchmark
    public void testBubbleSort(ExecutionPlan plan) {
		TestBubbleSort.sort(plan);
    }
	
	@Benchmark
    public void testInsertionSort(ExecutionPlan plan) {
		TestInsertionSort.sort(plan);
    }
	
	@Benchmark
    public void testQuickSort(ExecutionPlan plan) {
		TestQuickSort.sort(plan);
    }
	
	@Benchmark
    public void testRadixSort(ExecutionPlan plan) {
		TestRadixSort.sort(plan);
    }
	
	@Benchmark
	public void testArraysQuickDualPivotSort(ExecutionPlan plan) {
		Arrays.sort(plan.numbers);
	}
	
	@Benchmark
	public void testArraysParallelSort(ExecutionPlan plan) {
		Arrays.parallelSort(plan.numbers);
	}
	
    public static void main(String[] args) throws Exception {
    	Options opt = new OptionsBuilder()
                .include(BenchmarkRunner.class.getSimpleName())
                .build();
    	
    	new Runner(opt).run();
    }

}
