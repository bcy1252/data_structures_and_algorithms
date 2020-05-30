package datastructure;

public class LinkedListStack {
	static class StackNode{
		int val;
		StackNode next;
		public StackNode(int val){
			this.val = val;
		}
	}
	int val;
	StackNode topNode;
	public LinkedListStack() {
		topNode = null;
	}
	public void push(int val) {
		StackNode newNode = new StackNode(val);
		if(topNode == null) {
			topNode = newNode;
		}else {
			/*
			 * 就将新元素的下一节点指向当前的top，并将newNode更新为top节点。
			 * 注意，此时新的top节点就不再是指向null而是前一个节点*/
			StackNode prevTop = topNode;
			topNode = newNode;
			newNode.next = prevTop;
		}
		System.out.println(val + " 已进栈.");
	}
	public void pop() {
		if(topNode == null) {
			System.out.println("栈是空的");
		}
		int popped = topNode.val;
		//因为指针是反的所以，下一个节点就是他前一个节点；
		topNode = topNode.next;
		System.out.println(popped + " 已出栈.");
		
	}
	public int peek() {
		if(topNode == null) {
			System.out.println("栈是空的");
		}
		return topNode.val;		
	}
	public boolean isEmpty() {
		return topNode == null;
	}
	public void  display(int val) {
		StackNode curTop = new StackNode(val);
		while (curTop != null) {
			System.out.println(curTop.val);
			curTop = curTop.next;
		}
		
	}
	public static void main(String[] args) {
		LinkedListStack test2 = new LinkedListStack();
		test2.push(1);
		test2.push(9);
		test2.push(9);
		test2.push(7);
		test2.pop();
		test2.pop();
		test2.push(0);
		test2.push(3);
		test2.pop();
		test2.pop();
		test2.pop();
		
	}

}
