package Multithreading;

public class WaitNotifyExample {
    public static void main(String[] args) {
        Market market = new Market();
        Producer producer = new Producer(market);
        Consumer consumer = new Consumer(market);
        Thread thread1 = new Thread(producer);
        Thread thread2 = new Thread(consumer);
        thread1.start();
        thread2.start();

    }
}

class Market {
    private int breadCount = 0;

    //метод для Покупателя
    public synchronized void getBread() {
        while (breadCount < 1) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();

            }
        }
        breadCount--;
        System.out.println("Потребитель купил 1 хлеб");
        System.out.println("Количества хлеба в магазине " + breadCount);
        //нужно известить Производителя, что количество уменьшилось на 1, можно добавлять хлеб
        notify();

    }

    //Метод для Производителя
    public synchronized void putBread() {
        while (breadCount >= 5) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        breadCount++;
        System.out.println("Производитель добавил 1 хлеб");
        System.out.println("Количества хлеба в магазине " + breadCount);
        //Нужно известить Покупателя, что хлеб добавился
        notify();

    }
}
    //Создание потоков Производителя и Покупателя
     class Producer implements Runnable {
        Market market;

        Producer(Market market) {
            this.market = market;
        }

        public void run() {
            for (int i = 0; i < 10; i++) {
                market.putBread();
            }
        }
    }

    class Consumer implements Runnable {
        Market market;

        Consumer(Market market) {
            this.market = market;
        }

        public void run() {
            for (int i = 0;  i < 10; i++) {
                market.getBread();
            }
        }
    }

