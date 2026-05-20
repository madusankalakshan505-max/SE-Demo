class Queue {
    private int[] queue;
    private int front;
    private int rear;
    private int count;
    private int maxSize;

    Queue(int size) {
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

public class RemoveDuplicatesQueue {

    static boolean contains(Queue q, int value) {

        Queue temp = new Queue(100);
        boolean found = false;

        while (!q.isEmpty()) {
            int x = q.serve();

            if (x == value) {
                found = true;
            }

            temp.append(x);
        }

        while (!temp.isEmpty()) {
            q.append(temp.serve());
        }


        return found;
    }

    public static void main(String[] args) {

        int[] data = {10, 20, 10, 10, 30, 40, 50, 40, 50, 50, 10, 20, 20};

        Queue q = new Queue(100);
        Queue result = new Queue(100);

        for (int i = 0; i < data.length; i++) {
            q.append(data[i]);
        }

        while (!q.isEmpty()) {
            int value = q.serve();

            if (!contains(result, value)) {
                result.append(value);
            }
        }


        System.out.print("Output: [");

        while (!result.isEmpty()) {
        int x = result.serve();
        System.out.print(x);

        if (!result.isEmpty()) {
            System.out.print(", ");
        }
    }

        System.out.println("]");
}
}