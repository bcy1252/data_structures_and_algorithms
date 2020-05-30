package algorithm;

public class BST<Key extends Comparble<Key>,Value> {
	private Node root;        //����������ĸ��ڵ�
	
	private class Node{
		private Key key;      //��
		private Value val;    //ֵ
		private Node left, right; //ָ����������������
		private int N;		  //�Ըýڵ�Ϊ���������еĽ������
		
		public Node(Key key, Value val; int N) {
			this.key = key;
			this.val = val;
			this.N = N;
		}
	}
	
	public int size() {
		return size(root);
	}
	private int size(Node x) {
		if(x == null)
			return 0;
		else
			return x.N;
	}

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������

	}

}
