class Queue2 {

    private int[] queue;
    private int front;
    private int rear;
    private int count;
    private int maxSize;

    Queue2(int size) {
        maxSize = size;
        queue = new int[maxSize];
        front = 0;
        rear = -1;
        count = 0;
    }

    boolean isEmpty() {
        return count == 0;
    }

    boolean isFull() {
        return count == maxSize;
    }

    void append(int value) {
        if (!isFull()) {
            rear = (rear + 1) % maxSize;
            queue[rear] = value;
            count++;
        }
    }

    int serve() {
        if (isEmpty()) {
            return -1;
        }

        int value = queue[front];
        front = (front + 1) % maxSize;
        count--;
        return value;
    }

    int size() {
        return count;
    }
}

public class InterleaveQueue {

    public static void main(String[] args) {

        Queue2 q = new Queue2(20);

        q.append(10);
        q.append(20);
        q.append(30);
        q.append(40);
        q.append(50);
        q.append(60);
        q.append(70);
        q.append(80);
        q.append(90);
        q.append(100);

        int half = q.size() / 2;

        Queue2 firstHalf = new Queue2(20);

        for (int i = 0; i < half; i++) {
            firstHalf.append(q.serve());
        }

        Queue2 result = new Queue2(20);

        while (!firstHalf.isEmpty()) {
            result.append(firstHalf.serve());
            result.append(q.serve());
        }


        while (!result.isEmpty()) {
            int x = result.serve();
            System.out.print(x);

            if (!result.isEmpty()) {
                System.out.print(", ");
            }
        }
    }
}
