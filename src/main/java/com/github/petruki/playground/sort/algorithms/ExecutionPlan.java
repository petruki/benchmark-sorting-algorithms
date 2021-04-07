package com.github.petruki.playground.sort.algorithms;

import java.util.Random;

import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;

@State(Scope.Benchmark)
public class ExecutionPlan {
	
	@Param({ "100000" })
	public int size;
	
	public int[] numbers;
	
    @Setup(Level.Invocation)
    public void setUp() {
		this.numbers = new int[size];

		Random random = new Random();
		for (int i = 0; i < size; i++)
			numbers[i] = random.nextInt(size);
    }
}