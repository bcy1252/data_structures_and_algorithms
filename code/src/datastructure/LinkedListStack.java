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
			 * �ͽ���Ԫ�ص���һ�ڵ�ָ��ǰ��top������newNode����Ϊtop�ڵ㡣
			 * ע�⣬��ʱ�µ�top�ڵ�Ͳ�����ָ��null����ǰһ���ڵ�*/
			StackNode prevTop = topNode;
			topNode = newNode;
			newNode.next = prevTop;
		}
		System.out.println(val + " �ѽ�ջ.");
	}
	public void pop() {
		if(topNode == null) {
			System.out.println("ջ�ǿյ�");
		}
		int popped = topNode.val;
		//��Ϊָ���Ƿ������ԣ���һ���ڵ������ǰһ���ڵ㣻
		topNode = topNode.next;
		System.out.println(popped + " �ѳ�ջ.");
		
	}
	public int peek() {
		if(topNode == null) {
			System.out.println("ջ�ǿյ�");
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
