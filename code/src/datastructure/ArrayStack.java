package datastructure;

/*只有栈顶元素可以访问
 * Array（[]）：最高效；但是其容量固定且无法动态改变；只能存基础数据类型
   ArrayList：  容量可动态增长；但牺牲效率；存对象不可以存基础数据类型，有多种方法调用
              size(),add(),remove()*/

public class ArrayStack {
	static final int CAPACITY = 1997;
	//topOfStack是顶端的值，其实他是一个操作，考察表顶端元素并返回他的值
	int topOfStack;
	int arrayStack[];
	
	public ArrayStack() {
		topOfStack = -1;
		arrayStack = new int[CAPACITY];
	}
	//将数据压进栈；
	public boolean push(int val) {
		if(topOfStack >= (CAPACITY-1)) {
			System.out.println("栈溢出（overflow）");
			return false;
		}
		arrayStack[++topOfStack] = val;
		return true;				
	}
	//弹出栈顶元素（取出），显示新的栈顶元素
	public int pop() {
		if(topOfStack < 0) {
			System.out.println("栈下溢（Underflow） ");
			return 0;
		}
		//指针减一位，直接override
		arrayStack[topOfStack] = 0;
		int newTop = arrayStack[topOfStack--];
		return newTop;
	}
	//查看当前栈顶元素
	public int peek() {
		if(topOfStack < 0) {
			System.out.println("栈是空的（下溢）");
		}
		return arrayStack[topOfStack];
	}
	public boolean isEmpty() {
		return topOfStack < 0;
	}
	

	public static void main(String[] args) {
		ArrayStack test1 = new ArrayStack();
		test1.push(1);
		test1.push(9);
		test1.push(9);		
		System.out.println(test1.push(7));
		for(int a = 0;a < 4;a++) {
			System.out.print(test1.arrayStack[a]);
		}
		/*打印所有堆栈
		 * for(int a : test1.arrayStack) {
			System.out.println(a);
		}*/
		test1.push(0);
		test1.pop();
		System.out.println();
		System.out.println(test1.pop());
		for(int a = 0;a < 4;a++) {
			System.out.print(test1.arrayStack[a]);
		}
		test1.push(6);
		System.out.println();
		for(int a = 0;a < 4;a++) {
			System.out.print(test1.arrayStack[a]);
		}
		

	}

}
