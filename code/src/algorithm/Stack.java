package algorithm;

import java.util.Iterator;

import edu.princeton.cs.algs4.StdIn;

public class Stack <Item> implements Iterable<Item>{
	private Node first; //栈顶（最近添加的元素）
	private int N;      //元素数量
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
		//向栈顶添加元素
		Node oldfirst = first;
		first = new Node();
		first.item = item;
		first.next = oldfirst;
		N++;
		
	}
	public Item pop() {
		//从栈顶删除元素
		Item item = first.item;
		first = first.next;
		N--;
		return item;
	}

	public static void main(String[] args) {
		//创建一个栈并根据StdIn中的之时
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
		// TODO 自动生成的方法存根
		return (Iterator<Item>) new Stack();
	}

}
