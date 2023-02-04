package exercise;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Random;

public class Queue {
    private static final List<String> NAMES = List.of(
            "Иван Иванов",
            "Петр Петров",
            "Николай Николаев",
            "Алексей Иванов",
            "Мария Сидорова",
            "Глеб Михайлов",
            "Михаил Петров",
            "Иван Петров",
            "Петр Иванов",
            "Дмитрий Дмитриев"
    );
    private static final Random RANDOM = new Random();
    private static final int MAX_SIZE = 5;
    public static void main(String[] args) {
        java.util.Queue<String> queue1 = new ArrayDeque<>();
        java.util.Queue<String> queue2 = new ArrayDeque<>();
        randomFilling(queue1);
        randomFilling(queue2);
        System.out.println("Первая очередь: " + queue1);
        System.out.println("Вторая очередь: " + queue2);
        System.out.println();

        add("Владимир Петров", queue1, queue2);
        System.out.println("Первая очередь: " + queue1);
        System.out.println("Вторая очередь: " + queue2);
        System.out.println();

        remove(queue1, queue2);
        System.out.println("Первая очередь: " + queue1);
        System.out.println("Вторая очередь: " + queue2);
        System.out.println();
    }

    private static void add(String name,
                            java.util.Queue<String> queue1,
                            java.util.Queue<String> queue2) {
        if (queue1.size() == MAX_SIZE && queue2.size() == MAX_SIZE) {
            System.out.println("Нужно позвать Галю!");
            return;
        }
        if (queue1.size() < queue2.size()) {
            queue1.offer(name);
        } else {
            queue2.offer(name);
        }
    }

    private static void remove(java.util.Queue<String> queue1,
                               java.util.Queue<String> queue2) {
        if (RANDOM.nextBoolean()) {
            queue1.poll();
        } else {
            queue2.poll();
        }
    }

    private static void randomFilling(java.util.Queue<String> queue) {
        int size = RANDOM.nextInt(MAX_SIZE + 1);
        for (int i = 0; i < size; i++) {
            queue.offer(NAMES.get(RANDOM.nextInt(NAMES.size())));
        }
    }
}
