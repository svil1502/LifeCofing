package Multithreading;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class DiningPhilosophers {

/*
Вот один из вариантов решения задачи про обедающих философов с использованием семафора для официанта, иерархии ресурсов и мьютексов:
Основные моменты:

Официант моделируется семафором, ограничивающим одновременный доступ.
Вилки - иерархия ресурсов с блокировкой через ReentrantLock.
Философы по очереди получают разрешение официанта, берут вилки, едят и освобождают вилки.
Такой подход позволяет избежать взаимоблокировки и гарантировать доступ к ресурсам.
 */
    public static void main(String[] args)  {
        Table table = new Table(5);

        for(int i=0; i<5; i++) {
            Philosopher p = new Philosopher(i, table);
            Thread t = new Thread(p);
            t.start();
        }
    }
}

class Table {

    private Semaphore waiter;
    private ReentrantLock[] forks;

    Table(int num) {
        waiter = new Semaphore(num - 1);
        forks = new ReentrantLock[num];
        for(int i=0; i<num; i++)
            forks[i] = new ReentrantLock();
    }

    void takeForks(int left, int right) throws InterruptedException {
        waiter.acquire();
        forks[left].lock();
        forks[right].lock();
    }

    void returnForks(int left, int right) {
        forks[right].unlock();
        forks[left].unlock();
        waiter.release();
    }
}

class Philosopher implements Runnable {

    private int id;
    private Table table;

    Philosopher(int id, Table table) {
        this.id = id;
        this.table = table;
    }

    public void run() {
        try {
            while(true) {
                think();
                table.takeForks(id, (id+1)%5);
                eat();
                table.returnForks(id, (id+1)%5);
            }
        } catch (InterruptedException e) {}
    }

    private void think() throws InterruptedException {
        // thinking
    }

    private void eat() {
        // eating
    }
}