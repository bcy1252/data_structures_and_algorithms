package datastructure;
import java.util.ArrayList;
/* ɢ�б��Գ���ƽ��ʱ��ִ�в��롢ɾ���Ͳ��ң���֧������
 * ����ɢ�б����й̶���С�����飬Ϊ�˾���ѡ�����Ĺ�ϣ������
 * ɢ�б���<key,value>��ɣ�ͨ����ϣ����H(key)�������ϣֵ��һ��Ϊ�����±꣩
 * ���д洢�����ң���ϣ������ͨ��keyΪ��������ȡ�����ַ�����ASCII��ֵ��ӣ�
 * ��һ��Ԫ�ر�����ʱ��һ���Ѿ�����Ԫ��ɢ�е���ͬ��ֵ���������ϣ��ͻ��
 * �����ͻ��ʽ���������ӷ�����ͻ�������б���
 * ���Ŷ�ַ��������̽��ɢ�б�����f��i��������Ϲ�ϣ�����ҵ��յĵ�λ��
 * 			����̽�ⷨ������̽�ⷨ��װ�����ӣ��ٹ�ϣ����
 * */
public class HashMap {
	private ArrayList<HashNode<String,Integer>> idealArray;
	//���鳤��
	private int idealCap;
	//�ڵ�����
	private int size;
	//Integer��int�İ�װ�࣬Ϊ��������ã�int����java��һ�ֻ����������ͣ� 
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
	//��ϣ�����������õ����õ�key�������ϣֵ���ٽ���ϣֵȡģ��
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
		//����װ�����ӣ������ϣ��ͻ��
		if((1.0 * size)/idealCap >= 0.7) {
			ArrayList<HashNode<String,Integer>> temp = idealArray;
			idealArray = new ArrayList<>();
			idealCap = 2 * idealCap;
			size = 0;
			for(int i = 0;i < idealCap;i++) {
				idealArray.add(null);
			}
			//�����н���Ƶ��µ����飨ԭ��������
			for(HashNode<String,Integer>headNode:temp) {
				while(headNode != null) {
					add(headNode.key,headNode.value);
					headNode = headNode.next;
				}
			}
		}

	}
	//�ҵ�key��Ӧ��value��
	public Integer get(String key) {
		int idealIndex = getIdealIndex(key);
		HashNode<String,Integer> head = idealArray.get(idealIndex);
		//�ҵ�ͷ�ڵ�󣬵�����ͷ�ڵ������
		while(head != null) {
			if(head.key.equals(key)) {
				return head.value;
			}
			head = head.next;
		}
		return null;
	}
	//ɾ��key���ڵ�item
	public Integer remove(String key) {
		int idealIndex = getIdealIndex(key);
		HashNode<String,Integer> head = idealArray.get(idealIndex);
		HashNode<String,Integer>prev = null;
		while(head != null) {
			if(head.key.equals(key))break;
			prev = head;
			head = head.next;
		}
		//�Ҳ�����û�д˽ڵ�
		if(head == null) {
			return null;
		}
		//�ҵ���ɾ����prev��=null��head����ͷ�ڵ�
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
