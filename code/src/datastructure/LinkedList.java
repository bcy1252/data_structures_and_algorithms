package datastructure;

public class LinkedList {
	//定义节点,内部类只为其外部类使用
	//要创建嵌套类的对象，并不需要其外围类的对象,直接用.next；
	static class ListNode{
		int val;
		ListNode next;//指针，指向下一个节点位置
		public ListNode(int val) {
			this.val = val;
		}
	}
	ListNode head;
	ListNode tail;
	int size;	
	//定义链表
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
		//查找
		System.out.println();
		System.out.println(newList.search(1));
		System.out.println(newList.search(0));
		//更新
		newList.update(2, 9);
		newList.display();	
	}
	//增加新元素在末尾
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
	
	//插入节点(位置，新的值)
	public void insert(int position,int number) {
		if(position > size) {
			return;
		}
		ListNode newNode = new ListNode(number);
		//在0处插入节点时，该节点指针指向当前头节点，再替代成为新的头节点,如果就一个节点，那么尾节点也更新下
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
			//找到要插入位置前一个节点
			for(int i = 0;i<position - 1;i++) {
				prev = prev.next;
			}
			ListNode now = prev.next;
			newNode.next = now;
			now = newNode;
			size++;			
		}	
	}
	//打印节点
	public void display() {
		ListNode cur = head;
		while(cur!=null) {
			System.out.print(cur.val + ",");
			cur = cur.next;
		}
	}
	//删除节点，将要删除的节点，前一个节点指向被删除节点的下一个节点
	public void delete(int number) {
		//删除头节点只要让第二个成为头节点即可
		if(head != null && head.val == number) { 
			head = head.next;
			size--;
			//删掉就没了，那也要更新一下
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
					//循环遍历
					prev = cur;
					cur = cur.next;
				}
			}
		}
	}
	//查找,从头节点开始遍历，找到与目标值对应的节点返回其位置即可
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
	//更新，和查找类似，找到对应的节点，改变节点的值即可；
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
