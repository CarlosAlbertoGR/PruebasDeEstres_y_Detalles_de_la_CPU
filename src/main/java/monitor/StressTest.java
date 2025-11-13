/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package monitor;

/**
 *
 * @author vince
 */

import java.util.concurrent.*;

public class StressTest {
    

    private static final long WORKLOAD = 5_000_000_000L; 

    private void doWork(long i) {
        Math.pow(Math.sqrt(i), 1.01); 
    }

    public long runSerialTest() {
        long start = System.nanoTime();
        for (long i = 0; i < WORKLOAD; i++) {
            doWork(i);
        }
        return System.nanoTime() - start;
    }

    public long runParallelTest() throws InterruptedException {
        int numProcessors = Runtime.getRuntime().availableProcessors();
        ExecutorService executor = Executors.newFixedThreadPool(numProcessors);
        long start = System.nanoTime();
        long iterationsPerTask = WORKLOAD / numProcessors;
        CountDownLatch latch = new CountDownLatch(numProcessors);

        for (int i = 0; i < numProcessors; i++) {
            final int taskIndex = i;
            executor.submit(() -> {
                long startIteration = (long)taskIndex * iterationsPerTask;
                long endIteration = (taskIndex == numProcessors - 1)
                                 ? WORKLOAD
                                 : startIteration + iterationsPerTask;
                                 
                for (long j = startIteration; j < endIteration; j++) {
                    doWork(j);
                }
                latch.countDown(); 
            });
        }
        
        latch.await(); 
        executor.shutdown();
        return System.nanoTime() - start;
    }
}