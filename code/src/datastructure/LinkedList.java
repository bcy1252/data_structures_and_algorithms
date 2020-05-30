package datastructure;

public class LinkedList {
	//����ڵ�,�ڲ���ֻΪ���ⲿ��ʹ��
	//Ҫ����Ƕ����Ķ��󣬲�����Ҫ����Χ��Ķ���,ֱ����.next��
	static class ListNode{
		int val;
		ListNode next;//ָ�룬ָ����һ���ڵ�λ��
		public ListNode(int val) {
			this.val = val;
		}
	}
	ListNode head;
	ListNode tail;
	int size;	
	//��������
	public LinkedList(){
		head = null;
		tail = null;
		size = 0;
	}
	public static void main(String[] args) {
		LinkedList newList = new LinkedList();
		newList.insert(0, 1);
		newList.append(9);
		newList.insert(2, 2);
		newList.append(7);
		newList.display();
		//����
		System.out.println();
		System.out.println(newList.search(1));
		System.out.println(newList.search(0));
		//����
		newList.update(2, 9);
		newList.display();	
	}
	//������Ԫ����ĩβ
	public void append(int number) {
		ListNode newNode = new ListNode(number);
		if(tail == null) {
			tail = newNode;
		}else {
			tail.next = newNode;
			tail = newNode;
		}
		size++;
	}
	
	//����ڵ�(λ�ã��µ�ֵ)
	public void insert(int position,int number) {
		if(position > size) {
			return;
		}
		ListNode newNode = new ListNode(number);
		//��0������ڵ�ʱ���ýڵ�ָ��ָ��ǰͷ�ڵ㣬�������Ϊ�µ�ͷ�ڵ�,�����һ���ڵ㣬��ôβ�ڵ�Ҳ������
		if(position == 0) {
			newNode.next = head;
			head = newNode;
			if(tail == null) {
				tail = newNode;
			}
			size++;
		}else if(position == size)	{
			this.append(number);
		}else {
			ListNode prev = head;
			//�ҵ�Ҫ����λ��ǰһ���ڵ�
			for(int i = 0;i<position - 1;i++) {
				prev = prev.next;
			}
			ListNode now = prev.next;
			newNode.next = now;
			now = newNode;
			size++;			
		}	
	}
	//��ӡ�ڵ�
	public void display() {
		ListNode cur = head;
		while(cur!=null) {
			System.out.print(cur.val + ",");
			cur = cur.next;
		}
	}
	//ɾ���ڵ㣬��Ҫɾ���Ľڵ㣬ǰһ���ڵ�ָ��ɾ���ڵ����һ���ڵ�
	public void delete(int number) {
		//ɾ��ͷ�ڵ�ֻҪ�õڶ�����Ϊͷ�ڵ㼴��
		if(head != null && head.val == number) { 
			head = head.next;
			size--;
			//ɾ����û�ˣ���ҲҪ����һ��
			if(size == 0) {
				tail = head;
			}else {
				ListNode prev = head;
				ListNode cur = head;
				while(prev!=null && cur != null) {
					if(cur.val == number) {
						if(cur == tail) {
							tail = prev;
						}
						prev.next = cur.next;
						size--;
						return;
					}
					//ѭ������
					prev = cur;
					cur = cur.next;
				}
			}
		}
	}
	//����,��ͷ�ڵ㿪ʼ�������ҵ���Ŀ��ֵ��Ӧ�Ľڵ㷵����λ�ü���
	public int search(int number) {
		ListNode cur = head;
		for(int index = 0;cur != null;index++) {
			if(cur.val == number) {
				return index;
			}
			cur = cur.next;
		}
		return -1;
	}
	//���£��Ͳ������ƣ��ҵ���Ӧ�Ľڵ㣬�ı�ڵ��ֵ���ɣ�
	public int update(int oldValue, int newValue) {
		ListNode cur = head;
		for(int index = 0;cur !=null;index++) {
			if(cur.val == oldValue) {
				cur.val = newValue;
				return index;
			}
			cur = cur.next;
		}
		return -1;
	}		

}
