package Multithreading.concurrent.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockEx {
    public static void main(String[] args) {
        FibCalculator calculator = new FibCalculator();

        Thread t1 = new Thread(() -> {
            int result = calculator.calc(5);
            System.out.println(result);
        });

        Thread t2 = new Thread(() -> {
            int result = calculator.calc(2);
            System.out.println(result);
        });

        t1.start();
        t2.start();
    }

}

class FibCalculator {
    private final ReentrantLock lock = new ReentrantLock();
    private int n;
    private int fib;

    public int calc(int n) {

        try {
            lock.lock();
            if (n <= 1) {
                return n;
            }
            return calc(n - 1) + calc(n - 2);
        } finally {
            lock.unlock();
        }

    }

}

