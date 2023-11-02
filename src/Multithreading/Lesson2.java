package Multithreading;

public class Lesson2 {
    //Цикл потока
    // 1 состояние потока - new
    // 2 pool потоков - runnable
    //3 выполненяется и может остановиться, вернуться в состояние runnable - running; waiting blocking sleeping
    //4 dead

    //приоритеты потоков
    // метод Thread.yeld дает подсказку Shdeuler запустить другой менее приоритетный поток , переходит из состояния running в runnable

    //join - если нужно чтобы поток гарантированно выполнился myThred.join();
    // yeld sleep вызываются на текущем потоке
    public static void main(String[] args) throws InterruptedException {
        MyThred2 myThred = new MyThred2();
        myThred.start();
        //Thread.sleep(1000);
       // Thread.yield();
        myThred.join();
        System.out.println("thread main");
    }


}
class MyThred2 extends Thread {
    @Override
    public void run() {
        System.out.println("thread 0");
    }
}

