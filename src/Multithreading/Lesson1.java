package Multithreading;

public class Lesson1 {
    public static void main(String[] args) {
        //<<2 способа создания потока
        MyThred myThred = new MyThred();
        //myThred.start();
        System.out.println(Thread.currentThread().getName());
        MyRunnable myRunnable = new MyRunnable();
        Thread thread2 = new Thread(myRunnable);
        //thread2.start();
        //>>
        new MyThred().start();
        new MyThred().start();
        new MyThred().start();
    }


}

class MyThred extends Thread {
    @Override
    public void run() {
        for(int i = 0; i < 400; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }

}

class MyRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}