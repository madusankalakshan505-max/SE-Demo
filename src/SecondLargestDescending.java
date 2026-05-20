class List2 {

    private int[] list;
    private int position;
    private int maxSize;

    List2(int size) {
        maxSize = size;
        list = new int[maxSize];
        position = -1;
    }

    void insertLast(int value) {
        list[++position] = value;
    }

    int retrieve(int index) {
        return list[index];
    }

    void replace(int index, int value) {
        list[index] = value;
    }

    int listSize() {
        return position + 1;
    }
}

public class SecondLargestDescending {

    public static void main(String[] args) {

        int[] data = {10, 8, 7, 20, 15, 4};

        List2 list2 = new List2(20);

        for (int i = 0; i < data.length; i++) {
            list2.insertLast(data[i]);
        }

        int n = list2.listSize();

        for (int i = 0; i < n - 1; i++) {

            for (int j = 0; j < n - i - 1; j++) {

                if (list2.retrieve(j) < list2.retrieve(j + 1)) {

                    int temp = list2.retrieve(j);
                    list2.replace(j, list2.retrieve(j + 1));
                    list2.replace(j + 1, temp);
                }
            }
        }

        System.out.println("Second largest number = " + list2.retrieve(1));

        System.out.print("Descending order = ");

        for (int i = 0; i < list2.listSize(); i++) {
            System.out.print(list2.retrieve(i) + " ");
        }
    }
}