package algorithm;

public class BST<Key extends Comparble<Key>,Value> {
	private Node root;        //二叉查找树的根节点
	
	private class Node{
		private Key key;      //键
		private Value val;    //值
		private Node left, right; //指向左右子树的链接
		private int N;		  //以该节点为根的子树中的结点总数
		
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
		// TODO 自动生成的方法存根

	}

}
