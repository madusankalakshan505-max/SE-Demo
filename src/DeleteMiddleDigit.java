class CircularQueue {

    private char[] queue;
    private int front;
    private int rear;
    private int count;
    private int maxSize;

    CircularQueue(int size) {
        maxSize = size;
        queue = new char[maxSize];
        front = 0;
        rear = -1;
        count = 0;
    }

    boolean isEmpty() {
        return count == 0;
    }

    void append(char ch) {
        rear = (rear + 1) % maxSize;
        queue[rear] = ch;
        count++;
    }

    char serve() {
        char ch = queue[front];
        front = (front + 1) % maxSize;
        count--;
        return ch;
    }
}

public class DeleteMiddleDigit {

    public static void main(String[] args) {

        int number = 12345;

        String str = Integer.toString(number);

        CircularQueue q = new CircularQueue(20);

        for (int i = 0; i < str.length(); i++) {
            q.append(str.charAt(i));
        }

        int middle = str.length() / 2;

        String result = "";

        for (int i = 0; i < str.length(); i++) {

            char ch = q.serve();

            if (i != middle) {
                result += ch;
            }
        }

        System.out.println("Output: " + result);
    }
}