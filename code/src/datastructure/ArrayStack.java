package datastructure;

/*ֻ��ջ��Ԫ�ؿ��Է���
 * Array��[]�������Ч�������������̶����޷���̬�ı䣻ֻ�ܴ������������
   ArrayList��  �����ɶ�̬������������Ч�ʣ�����󲻿��Դ�����������ͣ��ж��ַ�������
              size(),add(),remove()*/

public class ArrayStack {
	static final int CAPACITY = 1997;
	//topOfStack�Ƕ��˵�ֵ����ʵ����һ���������������Ԫ�ز���������ֵ
	int topOfStack;
	int arrayStack[];
	
	public ArrayStack() {
		topOfStack = -1;
		arrayStack = new int[CAPACITY];
	}
	//������ѹ��ջ��
	public boolean push(int val) {
		if(topOfStack >= (CAPACITY-1)) {
			System.out.println("ջ�����overflow��");
			return false;
		}
		arrayStack[++topOfStack] = val;
		return true;				
	}
	//����ջ��Ԫ�أ�ȡ��������ʾ�µ�ջ��Ԫ��
	public int pop() {
		if(topOfStack < 0) {
			System.out.println("ջ���磨Underflow�� ");
			return 0;
		}
		//ָ���һλ��ֱ��override
		arrayStack[topOfStack] = 0;
		int newTop = arrayStack[topOfStack--];
		return newTop;
	}
	//�鿴��ǰջ��Ԫ��
	public int peek() {
		if(topOfStack < 0) {
			System.out.println("ջ�ǿյģ����磩");
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
		/*��ӡ���ж�ջ
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
