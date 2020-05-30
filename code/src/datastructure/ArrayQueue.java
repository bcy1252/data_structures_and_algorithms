package datastructure;

public class ArrayQueue {
	int front,back,currentSize;
	int capacity;
	int arrayQueue[];
	public ArrayQueue(int capacity) {
		this.capacity = capacity;
		front = back = currentSize = 0;
		arrayQueue = new int[capacity];
	}
	
	public boolean isEmpty() {
		return currentSize == 0;
	}
	
	//�����Ƿ�����
	public boolean isFull() {
		return currentSize == capacity;
	}
	//����
	public void enqueue(int val) {
		if(isFull()) return;
		arrayQueue[back] = val;
		back = (back + 1) % capacity;
		currentSize++;
		System.out.println(val + "�����");
	}
	public int dequeue() {
		if(isEmpty()) {
			System.out.println("�����ǿյ�");
		}
		int val = arrayQueue[front];
		front  = (front + 1) % capacity;
		currentSize--;
		return val;
	}
	public int peek() {
		if(isEmpty()) {
			System.out.println("�����ǿյ�");
		}
		return arrayQueue[front];
	}

	public static void main(String[] args) {
		ArrayQueue queue1 = new ArrayQueue(3);
		queue1.enqueue(1);
		queue1.enqueue(9);
		queue1.enqueue(9);
		System.out.println(queue1.dequeue());
		System.out.println(queue1.dequeue());
	
		for(int a = 0;a < 3;a++) {
			System.out.print(queue1.arrayQueue[a]);
		}		

	}

}
