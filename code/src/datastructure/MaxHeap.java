package datastructure;
/*堆是一个有着特殊性质的树
 * 二叉堆：完全二叉树，且根节点为最大/最小值。
 * */

import java.util.*;

public class MaxHeap {
	private int capacity;
	private int size = 0;
	private int[] array;
	
	//容量
	public MaxHeap(int capacity) {
		this.capacity = capacity;
		this.array = new int[capacity];
	}
	//获得左节点索引值
	private int getLeftChildIndex(int parentIndex) {
	    return 2 * parentIndex + 1;
	}
	//获得右节点索引值
	private int getRightChildIndex(int parentIndex) {
	    return 2 * parentIndex + 2;
	}
	//获得父节点索引值
	private int getParentIndex(int childIndex) {
	    return (childIndex - 1) / 2;
	}
	//有没有左子树
	private boolean hasLeftChild(int index) {
	    return getLeftChildIndex(index) < size;
	}
	//有没有右子树
	private boolean hasRightChild(int index) {
	    return getRightChildIndex(index) < size;
	}
	//有没有根节点
	private boolean hasParent(int index) {
	    return getParentIndex(index) >= 0;
	}
	//取左节点值
	private int leftChild(int parentIndex) {
	    return array[getLeftChildIndex(parentIndex)];
	}
	//取右节点值
	private int rightChild(int parentIndex) {
	    return array[getRightChildIndex(parentIndex)];
	}
	//取父节点值
	private int parent(int childIndex) {
	    return array[getParentIndex(childIndex)];
	}
    private void swap(int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
	
	//插入
	public void add(int item) { // Time Complexity: O(logN)
	    if(size == capacity) {
	        array = Arrays.copyOf(array, capacity * 2);
	        capacity = capacity * 2;
	    }
	    array[size] = item;
	    size++;
	    heapifyUp();
	}
	//最后节点不断与父节点对比交换
	private void heapifyUp() {
	    int index = size - 1;
	    while (hasParent(index) && parent(index) < array[index]) {
	        swap(getParentIndex(index), index);
	        index = getParentIndex(index);
	    }
	}
	//取出根节点，并将最后一个节点赋给根节点，再不断与左右孩子对比交换，直到找到最大的值。
	public void poll() { // 时间复杂度: O(logN)
		   if (size == 0) {
		       throw new NoSuchElementException();
		   }
		   int element = array[0];
		   array[0] = array[size - 1];
		   size--;
		   heapifyDown();
		}

	private void heapifyDown() {
	    int index = 0;
	    while (hasLeftChild(index)) {
	        int largerChildIndex = getLeftChildIndex(index);
	        if (hasRightChild(index) && rightChild(index) > leftChild(index)) {
	            largerChildIndex = getRightChildIndex(index);
	        }
	        if (array[index] < array[largerChildIndex]) {
	            swap(index, largerChildIndex);
	        } else {
	            break;
	        }
	        index = largerChildIndex;
	    }
	}
	public int peek() {
	    if (size == 0) {
	        throw new NoSuchElementException();
	    }
	    return array[0];
	}
    private void printHeap() {
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + ", ");
        }
        System.out.println();
    }
    public boolean isEmpty() {
        return size == 0;
    }
    

	public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap(10);
        maxHeap.add(1);
        maxHeap.add(11);
        maxHeap.add(7);
        maxHeap.add(5);
        maxHeap.add(3);
        maxHeap.add(8);
        maxHeap.add(10);
        maxHeap.add(12);
        maxHeap.printHeap();
        while(!maxHeap.isEmpty()) {
            System.out.println(maxHeap.peek());
            maxHeap.poll();
        }

	}

}
