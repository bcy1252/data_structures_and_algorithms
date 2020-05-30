package datastructure;

/*
 *  二叉树（Binary Tree）：每个节点最多含有两个子节点，上面图示中的树就是二叉树。
	完全二叉树（Complete Binary Tree）：假设一个二叉树深度（depth）为d（d > 1），除了
								       第d层外，其它各层的节点数量均已达到最大值，且第d层
								       所有节点从左向右紧密排列，这样的二叉树就是完全二叉树。
								       
	满二叉树（Full Binary Tree）：在满二叉树中，每个不是尾节点的节点都有两个子节点。
	
	排序二叉树（Binary Search Tree）：在此树中，每个节点的数值比左子树上的每个节点都大，
								    比所有右子树上的节点都小。
								    
	平衡二叉树（AVL Tree）：任何节点的两颗子树的高度差不大于1的二叉树。
	B树（B-Tree）：B树和平衡二插树一样，只不过它是一种多叉树（一个节点的子节点数量可以超过二）。
	红黑树（Red—Black Tree）：是一种自平衡二叉寻找树。
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
	//找到和输入key相等的树节点
	public TreeNode get(int key) {
		TreeNode current = root;
		//当current.value相等或者迭代完（说明没找到）时循环停止
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
		//你要插入的位置，初始化root
		TreeNode current = root;
		//要插入位置的父节点，初始值null
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
					return;//二叉查找树不能允许相同的值
				}
			}
	
	}
	
	public boolean delete(int key) {
		TreeNode parent = root;
		TreeNode current = root;
		//判断是父节点的左子树还是右子树
		boolean isLeftChild = false;
		//寻找删除的节点
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
		//一、如果是叶子节点,只用将其叶子节点删掉即可；
		if(current.left == null && current.right == null ){
			if(current == root) {
				root = null;
			}else if(isLeftChild){
				parent.left = null;
			}else {
				parent.right =null;
			}
			//二、如果只有一个子树
			//1.这个节点没有有孩子节点，分成其本身是头节点，左孩子节点，还是右孩子节点3种情况
		}else if (current.right == null) {
			//如果是头节点，那么删掉，左节点成为新的头节点
	        if(current == root) {
	            root = current.left;
	        //如果是左节点，那么删掉后，他的左节点取代了他。父节点的左节点（他自己）更新为自己的左节点）
	        } else if (isLeftChild) {
	            parent.left = current.left;
	        //如果是右孩子节点，那么删掉后，他的右节点取代了他。父节点的右节点（他自己）更新为自己的左节点）
	        } else {
	            parent.right = current.left;
	        }
	        //和上面逻辑相反，当前节点没有左子树
	    } else if (current.left == null) {
	        if(current == root) {
	            root = current.right;
	        } else if (isLeftChild) {
	            parent.left = current.right;
	        } else {
	            parent.right = current.right;
	        }
	     //三、如果有两个子树,那么删除的节点要么是用左子树最大的节点代替，要么是右子树最小的节点代替；
	     //本次采用寻找右子树最小的点
		}else {
			TreeNode successor = getSuccessor(current);
	        if (current == root) {
	            root = successor;
	        } else if (isLeftChild) {
	            parent.left = successor;
	        } else {
	            parent.right = successor;
	        }
	        //在getSuccessor已经更新过右节点，所以这里只更新左节点
	        successor.left = current.left;
	    }
	    return true;
		}

	//获得右子树中最小的节点，successor
	private TreeNode getSuccessor(TreeNode node) {
		TreeNode successor = null;
		TreeNode successorParent = null;
		TreeNode current = node.right;
		while(current != null) {
			successorParent = successor;
			//右节点给successor
			successor = current;
			//然后一直向左节点找，不断更新current；
			current = current.left;
		}
		//successor的右子树称为其父节点的左子树。然后其右子树更新指向node的右子树
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

