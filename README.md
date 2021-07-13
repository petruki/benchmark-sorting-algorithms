### About

Benchmark testing 6 sorting algorithms.

```
# JMH version: 1.28
# VM version: JDK 1.8.0_144, Java HotSpot(TM) 64-Bit Server VM, 25.144-b01
# VM options: <none>
# Blackhole mode: full + dont-inline hint
# Warmup: 1 iterations, 1 s each
# Measurement: 1 iterations, 1 s each
# Timeout: 10 min per iteration
# Threads: 1 thread, will synchronize iterations
# Benchmark mode: Average time, time/op
# Parameters: (iterations = 100000)
```

Benchmark     | (iterations) | Mode | Score | Units
:-------------|:-------------|:-----|:------|:-------
BenchmarkRunner.testBubbleSort  				| 100000  |avgt       |21357,747	|ms/op
BenchmarkRunner.testInsertionSort  				| 100000  |avgt       |1183,553     |ms/op
BenchmarkRunner.testSelectionSort  				| 100000  |avgt       |7946,768		|ms/op
BenchmarkRunner.testQuickSort  					| 100000  |avgt       |9,330		|ms/op
BenchmarkRunner.testRadixSort  					| 100000  |avgt       |6,559		|ms/op
BenchmarkRunner.testArraysQuickDualPivotSort  	| 100000  |avgt       |8,159		|ms/op
BenchmarkRunner.testArraysParallelSort  		| 100000  |avgt       |1,927		|ms/op

### Running

Do not use the embedded Maven from your IDE

Create the benchmark jar
> mvn clean install

Run
> java -jar target/benchmarks.jar

