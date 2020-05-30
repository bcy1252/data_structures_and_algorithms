package datastructure;

/*
 *  ��������Binary Tree����ÿ���ڵ���ຬ�������ӽڵ㣬����ͼʾ�е������Ƕ�������
	��ȫ��������Complete Binary Tree��������һ����������ȣ�depth��Ϊd��d > 1��������
								       ��d���⣬��������Ľڵ��������Ѵﵽ���ֵ���ҵ�d��
								       ���нڵ�������ҽ������У������Ķ�����������ȫ��������
								       
	����������Full Binary Tree���������������У�ÿ������β�ڵ�Ľڵ㶼�������ӽڵ㡣
	
	�����������Binary Search Tree�����ڴ����У�ÿ���ڵ����ֵ���������ϵ�ÿ���ڵ㶼��
								    �������������ϵĽڵ㶼С��
								    
	ƽ���������AVL Tree�����κνڵ�����������ĸ߶Ȳ����1�Ķ�������
	B����B-Tree����B����ƽ�������һ����ֻ��������һ�ֶ������һ���ڵ���ӽڵ��������Գ���������
	�������Red��Black Tree������һ����ƽ�����Ѱ������
 * */
public class BST {
	static class TreeNode{
		public int value;
		public TreeNode left;
		public TreeNode right;
		public TreeNode(int value) {
			this.value = value;
		}
	}
	private TreeNode root;
	//�ҵ�������key��ȵ����ڵ�
	public TreeNode get(int key) {
		TreeNode current = root;
		//��current.value��Ȼ��ߵ����꣨˵��û�ҵ���ʱѭ��ֹͣ
		while(current != null && current.value != key) {
			if(key < current.value) {
				current = current.left;
			}else if(key > current.value) {
				current = current.right;
			}
		}
		return current == null ? null : current;
	}
	
	public void insert(int key) {
		if(root == null) {
			root = new TreeNode(key);
			return;
		}
		//��Ҫ�����λ�ã���ʼ��root
		TreeNode current = root;
		//Ҫ����λ�õĸ��ڵ㣬��ʼֵnull
		TreeNode parent = null;
		while(true) {
			parent = current;
			if(key < parent.value) {
				current = parent.left;
				if(current == null) {
					parent.left = new TreeNode(key);
					return;
				}
			}else if(key > parent.value) {
				current = parent.right;
				if(current == null) {
					parent.right = new TreeNode(key);
					return;	
					}			
				}else {
					return;//�������������������ͬ��ֵ
				}
			}
	
	}
	
	public boolean delete(int key) {
		TreeNode parent = root;
		TreeNode current = root;
		//�ж��Ǹ��ڵ������������������
		boolean isLeftChild = false;
		//Ѱ��ɾ���Ľڵ�
		while(current != null && current.value != key) {
			parent = current;
			if(current.value > key) {
				isLeftChild = true;
				current = current.left;
			}else {
				isLeftChild = false;
				current = current.right;
			}
		}
		if(current == null) {
			return false;
		}
		//һ�������Ҷ�ӽڵ�,ֻ�ý���Ҷ�ӽڵ�ɾ�����ɣ�
		if(current.left == null && current.right == null ){
			if(current == root) {
				root = null;
			}else if(isLeftChild){
				parent.left = null;
			}else {
				parent.right =null;
			}
			//�������ֻ��һ������
			//1.����ڵ�û���к��ӽڵ㣬�ֳ��䱾����ͷ�ڵ㣬���ӽڵ㣬�����Һ��ӽڵ�3�����
		}else if (current.right == null) {
			//�����ͷ�ڵ㣬��ôɾ������ڵ��Ϊ�µ�ͷ�ڵ�
	        if(current == root) {
	            root = current.left;
	        //�������ڵ㣬��ôɾ����������ڵ�ȡ�����������ڵ����ڵ㣨���Լ�������Ϊ�Լ�����ڵ㣩
	        } else if (isLeftChild) {
	            parent.left = current.left;
	        //������Һ��ӽڵ㣬��ôɾ���������ҽڵ�ȡ�����������ڵ���ҽڵ㣨���Լ�������Ϊ�Լ�����ڵ㣩
	        } else {
	            parent.right = current.left;
	        }
	        //�������߼��෴����ǰ�ڵ�û��������
	    } else if (current.left == null) {
	        if(current == root) {
	            root = current.right;
	        } else if (isLeftChild) {
	            parent.left = current.right;
	        } else {
	            parent.right = current.right;
	        }
	     //�����������������,��ôɾ���Ľڵ�Ҫô�������������Ľڵ���棬Ҫô����������С�Ľڵ���棻
	     //���β���Ѱ����������С�ĵ�
		}else {
			TreeNode successor = getSuccessor(current);
	        if (current == root) {
	            root = successor;
	        } else if (isLeftChild) {
	            parent.left = successor;
	        } else {
	            parent.right = successor;
	        }
	        //��getSuccessor�Ѿ����¹��ҽڵ㣬��������ֻ������ڵ�
	        successor.left = current.left;
	    }
	    return true;
		}

	//�������������С�Ľڵ㣬successor
	private TreeNode getSuccessor(TreeNode node) {
		TreeNode successor = null;
		TreeNode successorParent = null;
		TreeNode current = node.right;
		while(current != null) {
			successorParent = successor;
			//�ҽڵ��successor
			successor = current;
			//Ȼ��һֱ����ڵ��ң����ϸ���current��
			current = current.left;
		}
		//successor����������Ϊ�丸�ڵ����������Ȼ��������������ָ��node��������
		if(successor != node.right) {
			successorParent.left = successor.right;
			successor.right = node.right;
		}
		return successor;
	}

	public static void main(String[] args) {
        BST bst = new BST();
        bst.insert(9);
        bst.insert(5);
        bst.insert(1);
        bst.insert(11);
        bst.insert(3);
        bst.insert(7);
        bst.insert(10);
        TreeTraversal.inOrderTraversal(bst.root);
        System.out.println();
        //bst.delete(7);
        TreeTraversal.inOrderTraversal(bst.root);
        System.out.println();
        bst.delete(11);
        TreeTraversal.preOrderTraversal(bst.root);
        System.out.println();
        bst.delete(5);
        TreeTraversal.postOrderTraversal(bst.root);
        System.out.println();

	}

}

