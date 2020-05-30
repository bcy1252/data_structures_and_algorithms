package datastructure;

public class LinkedListQueue {
	QueueNode front;
	QueueNode back;
	
	static class QueueNode{
		int value;
		QueueNode next;
		public QueueNode(int value) {
			this.value = value;
		}
	}
	public void enqueue(int value) {
		QueueNode newNode = new QueueNode(value);
		if(this.back == null) {
			this.front = this.back = newNode;
			return;
		}
		this.back.next = newNode;
		this.back = newNode;
	}
	public int dequeue() {
		if(this.front == null) {
			System.out.println("队列是空的");
		}
		QueueNode frontNode = this.front;
		this.front = this.front.next;
		//如果只有一个节点，那么出去后依然是空的
		if(this.front == null) {
			this.back = null;
		}
		return frontNode.value;
	}

	public static void main(String[] args) {
        LinkedListQueue queue = new LinkedListQueue();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
		

	}

}
