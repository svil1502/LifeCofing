package Core2;

import java.util.*;

public class PriorityQueueTest {
    public static void main(String[] args) {

        Queue<Integer> q = new LinkedList<>();
        q.add(5);
        q.add(4);
        q.add(3);
        q.add(2);
        q.add(1);
        System.out.println(q);
        while (!q.isEmpty()) {
            q.poll();
        }
        System.out.println(q);
        System.out.println("===================");
        java.util.PriorityQueue<Integer> qp = new java.util.PriorityQueue<>();
       // qp.add(4);
        qp.add(3);
        qp.add(2);
        qp.add(1);
        List<Integer> list = new ArrayList<>();

// перемещаем все элементы в список
        while(!qp.isEmpty()) {
            list.add(qp.poll());
        }

// выводим список
        for(Integer i : list) {
            System.out.println(i);
        }
        System.out.println(q);
        while (!qp.isEmpty()) {
            qp.poll();
        }
        System.out.println(qp);
        while(!qp.isEmpty()) {
            list.add(qp.poll());
        }

// выводим список
        for(Integer i : list) {
            System.out.println(i);
        }

        //
        System.out.println("=====================");
        PriorityQueue<Integer> queue = new PriorityQueue<>(
                (a, b) -> {
                    if (a % 2 != b % 2) {
                        return a % 2 == 0 ? -1 : 1;
                    }

                    return a - b;
                }
        );

// Добавляем числа
        queue.add(5);
        queue.add(2);
        queue.add(7);
        queue.add(4);
        queue.add(3);
        queue.add(8);

// Выводим очередь
        while (!queue.isEmpty()) {
            System.out.println(queue.remove());
        }

    }
}
