class queue {
    Node head;
    int queuesize;

    public void enqueue(int item) {

        if (queuesize == 0) {
            Node n = new Node();
            n.data = item;
            head = n;

        } else {
            Node n = head;
            Node temp = new Node();
            temp.data =  item;
            while (n.next != null) {
                n = n.next;
            }
            n.next = temp;


        }
        queuesize++;
    }

    public Object dequeue() {
        if (queuesize == 0) {
            System.out.print("No path found!");
            System.exit(0);

        } else {
            Node n = head;
            head = n.next;
            queuesize--;
        }

        return 0;

    }
    public int peek()
    {
        return head.data;
    }


    public boolean isEmpty() {

        return queuesize == 0;

    }

    public int size() {
        return queuesize;
    }

    public void printqueue() {

        System.out.print("[");
        int[] arr = new int[queuesize];
        Node n = head;
        for (int i = queuesize - 1; i >= 0; i--) {
            arr[i] = n.data;
            n = n.next;
        }
        for (int i = 0; i < queuesize; i++) {
            System.out.print(arr[i]);
            if (i != queuesize - 1)
                System.out.print(", ");
        }

        System.out.print("]");
        System.out.println();
    }
}