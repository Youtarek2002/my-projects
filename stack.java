public class stack {
     Node top;

    public void push(int item) {
        Node newNode = new Node();
        newNode.data=item;
        if (top == null) {
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
    }

    public void pop() {
        if (top == null) {
            System.out.println("Stack is empty");
        } else {
            Node poppedNode = top;
            top = top.next;
            poppedNode.next = null;

        }
    }

    public int peek() {
        if (top == null) {
            System.out.println("No path found!");
            System.exit(0);
            return -1; // or throw an exception
        } else {
            return top.data;
        }
    }
    public void printStack() {
        if (top == null) {
            System.out.println("Stack is empty");
        } else {
            System.out.print("Stack: ");
            Node current = top;
            while (current != null) {
                System.out.print(current.data + " ");
                current = current.next;
            }
            System.out.println();
        }

    }}