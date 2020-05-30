package datastructure;
//���ȶ����������ֲ��������룬ɾ����Сֵ��

public class PriorityQueue {
    static class Node {
        int value;
        //���ȼ�����ֵԽ�����ȼ�Խ��
        int priority;
        Node next;

        public Node(int value, int priority) {
            this.value = value;
            this.priority = priority;
        }
    }

    Node head = null;
    
    //head��ͷ��Զָ����С�����ȼ���ߣ���Щ���������ã���Ԫ��
    public void insert(int value, int priority) {
        if (head == null) {
            head = new Node(value, priority);
            return;
        }
        Node cur = head;
        Node newNode = new Node(value, priority);
        if(head.priority < priority) {
            newNode.next = head;
            this.head = newNode;
        } else {
            while(cur.next != null && cur.next.priority > priority) {
                cur = cur.next;
            }
            newNode.next = cur.next;
            cur.next = newNode;
        }
    }
    public Node peek() {
        return head;
    }

    public Node deleteMin() {
        if (head == null) {
            return null;
        }
        Node temp = head;
        head = head.next;
        return temp;
    }
    public boolean isEmpty() {
        return head == null;
    }
    public static void print(Node node) {
        Node cur = node;
        while(cur != null) {
            System.out.print(cur.value + ", ");
            cur = cur.next;
        }
        System.out.println();
    }


	public static void main(String[] args) {
        PriorityQueue priorityQueue = new PriorityQueue();
        priorityQueue.insert(5, 1);
        priorityQueue.insert(4, 2);
        priorityQueue.insert(3, 3);
        priorityQueue.insert(1, 5);
        priorityQueue.insert(2, 4);
        priorityQueue.deleteMin();
        System.out.println(priorityQueue.peek().value);
        print(priorityQueue.head);

	}

}
