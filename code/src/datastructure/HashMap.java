package datastructure;
import java.util.ArrayList;
/* 散列表以常数平均时间执行插入、删除和查找，不支持排序；
 * 理想散列表：具有固定大小的数组，为此尽量选择合理的哈希函数；
 * 散列表由<key,value>组成，通过哈希函数H(key)计算出哈希值（一般为数组下标）
 * 进行存储，查找；哈希函数：通常key为整数可以取摸，字符则将其ASCII码值相加；
 * 当一个元素被插入时与一个已经插入元素散列到相同的值，则产生哈希冲突；
 * 解决冲突方式：分离链接法（冲突区域后跟列表）；
 * 开放定址法：增加探测散列表（函数f（i）），配合哈希函数找到空的单位；
 * 			线性探测法，二次探测法，装填因子，再哈希法；
 * */
public class HashMap {
	private ArrayList<HashNode<String,Integer>> idealArray;
	//数组长度
	private int idealCap;
	//节点数量
	private int size;
	//Integer是int的包装类，为对象的引用，int则是java的一种基本数据类型； 
	static class HashNode<String,Integer>{
		String key;
		Integer value;
		HashNode<String,Integer> next;
		public HashNode(String key, Integer value) {
			this.key = key;
			this.value = value;
		}
	}

	public HashMap() {
		idealArray = new ArrayList<>();
		idealCap = 10;
		size = 0;
		for(int i = 0;i < idealCap;i++) {
			idealArray.add(null);
		}
	}
	//哈希函数：本次用的是拿到key计算出哈希值，再将哈希值取模；
	private int getIdealIndex(String key) {
		int hashCode = key.hashCode();
		int index = hashCode % idealCap;
		return index;
	}
	public void add(String key,Integer value) {
		int idealIndex = getIdealIndex(key);
		HashNode<String,Integer> head = idealArray.get(idealIndex);
		while(head != null) {
			if(head.key.equals(key)) {
				head.value = value;
				return;
			}
			head = head.next;
		}
		size++;
		head = idealArray.get(idealIndex);
		HashNode<String,Integer>newNode = new HashNode<String,Integer>(key,value);
		newNode.next = head;
		idealArray.set(idealIndex, newNode);
		//设置装填因子，避免哈希冲突；
		if((1.0 * size)/idealCap >= 0.7) {
			ArrayList<HashNode<String,Integer>> temp = idealArray;
			idealArray = new ArrayList<>();
			idealCap = 2 * idealCap;
			size = 0;
			for(int i = 0;i < idealCap;i++) {
				idealArray.add(null);
			}
			//将现有结点移到新的数组（原来两倍）
			for(HashNode<String,Integer>headNode:temp) {
				while(headNode != null) {
					add(headNode.key,headNode.value);
					headNode = headNode.next;
				}
			}
		}

	}
	//找到key对应的value；
	public Integer get(String key) {
		int idealIndex = getIdealIndex(key);
		HashNode<String,Integer> head = idealArray.get(idealIndex);
		//找到头节点后，迭代该头节点的链表
		while(head != null) {
			if(head.key.equals(key)) {
				return head.value;
			}
			head = head.next;
		}
		return null;
	}
	//删除key所在的item
	public Integer remove(String key) {
		int idealIndex = getIdealIndex(key);
		HashNode<String,Integer> head = idealArray.get(idealIndex);
		HashNode<String,Integer>prev = null;
		while(head != null) {
			if(head.key.equals(key))break;
			prev = head;
			head = head.next;
		}
		//找不到，没有此节点
		if(head == null) {
			return null;
		}
		//找到了删除，prev！=null，head不是头节点
		if(prev != null) {
			prev.next = head.next;
		}else {
			idealArray.set(idealIndex, head.next);
		}
		size--;
		return head.value;
	}
	public int size() {
		return size;
	}
	public boolean isEmpty() {
		return size == 0;
	}


	public static void main(String[] args) {
        HashMap map = new HashMap();
        map.add("ad", 1);
        map.add("b", 2);
        map.add("c", 3);
        map.add("bc", 4);
        System.out.println(map.get("ad"));
        System.out.println(map.get("b"));
        System.out.println(map.get("c"));
        map.remove("bc");
        System.out.println(map.get("bc"));
	}

}
