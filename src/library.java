class List {
    private int maxSize;
    private int position;
    private int[] ListEntry;
    List(int size) {
        maxSize = size;
        ListEntry = new int[maxSize];
        position = -1;
    }
    boolean IsListEmpty() {
        return position == -1;
    }
    boolean IsListFull() {
        return position == maxSize - 1;
    }
    int ListSize() {
        return position + 1;
    }
    void InsertLast(int x) {
        if (IsListFull()) {
            System.out.println("List is Full");
        } else
            ListEntry[++position] = x;
    }
    void InsertList(int p, int element) {
        if (IsListFull())
            System.out.println("Attempt to insert an entry into a full list");
        else if (p < 0 || p > ListSize())
            System.out.println("attempt to insert a position not in the list");
        else {
            for(int i = ListSize(); i >p; i--)
                ListEntry[i] = ListEntry[i-1];
            ListEntry[p] = element;
            position++; }
    }
    int DeleteList( int  p) {
        int i,element;
        if (IsListEmpty())
            System.out.println("Attempt to delete an entry from an empty list");
        else if (p < 0 || p >= ListSize())
            System.out.println("attempt to delete a position not in the list");
        else {
            element = ListEntry[p];
            for( i = p; i < ListSize()-1; i++)
                ListEntry[i] = ListEntry[i+1];
            position--;
            return element;
        }
        return 0;
    }
    int  RetrieveList(int p ){
        int i,element;
        if (IsListEmpty()){
            System.out.println("Attempt to retrieve an entry from an empty list");
            return 0;}
        else if (p < 0 || p >= ListSize()){
            System.out.println("attempt to retrieve an entry at a position not in the list");
            return 0; }
        else{
            element = ListEntry[p];
            return element;}
    }
    void reverse(){
        int start = 0;
        int end = position;
        while (start < end) {
            int temp = ListEntry[start];
            ListEntry[start] = ListEntry[end];
            ListEntry[end] = temp;
            start++;
            end--;
        }
    }
    void display(){
        for (int i = 0; i < ListSize(); i++) {
            System.out.print(ListEntry[i] + " ");
        }
        System.out.println();
    }
}

public class library  {
    public static void main(String[] args) {
        List lis = new List(10);
        lis.InsertLast(101);
        lis.InsertLast(105);
        lis.InsertLast(110);
        lis.InsertLast(115);
        lis.InsertLast(120);
        lis.InsertLast(125);
    }
}
