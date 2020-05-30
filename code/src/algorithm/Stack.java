package algorithm;

import java.util.Iterator;

import edu.princeton.cs.algs4.StdIn;

public class Stack <Item> implements Iterable<Item>{
	private Node first; //ջ���������ӵ�Ԫ�أ�
	private int N;      //Ԫ������
	private class Node{
		Item item;
		Node next;
	}
	public boolean isEmpty() {
		return first == null;
	}
	public int size() {
		return N;
	}
	public void push(Item item) {
		//��ջ�����Ԫ��
		Node oldfirst = first;
		first = new Node();
		first.item = item;
		first.next = oldfirst;
		N++;
		
	}
	public Item pop() {
		//��ջ��ɾ��Ԫ��
		Item item = first.item;
		first = first.next;
		N--;
		return item;
	}

	public static void main(String[] args) {
		//����һ��ջ������StdIn�е�֮ʱ
		Stack<String> s = new Stack<String>();
		while(!StdIn.isEmpty()) {
			String item = StdIn.readString();
			if(!item.equals("-"))
				s.push(item);
			else if(!s.isEmpty())
				System.out.print(s.pop() + "");
		}
		System.out.print("(" + s.size() + " left on stack");

	}
	@SuppressWarnings("unchecked")
	@Override
	public Iterator<Item> iterator() {
		// TODO �Զ����ɵķ������
		return (Iterator<Item>) new Stack();
	}

}
