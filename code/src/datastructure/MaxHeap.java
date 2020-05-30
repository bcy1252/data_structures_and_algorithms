package datastructure;
/*����һ�������������ʵ���
 * ����ѣ���ȫ���������Ҹ��ڵ�Ϊ���/��Сֵ��
 * */

import java.util.*;

public class MaxHeap {
	private int capacity;
	private int size = 0;
	private int[] array;
	
	//����
	public MaxHeap(int capacity) {
		this.capacity = capacity;
		this.array = new int[capacity];
	}
	//�����ڵ�����ֵ
	private int getLeftChildIndex(int parentIndex) {
	    return 2 * parentIndex + 1;
	}
	//����ҽڵ�����ֵ
	private int getRightChildIndex(int parentIndex) {
	    return 2 * parentIndex + 2;
	}
	//��ø��ڵ�����ֵ
	private int getParentIndex(int childIndex) {
	    return (childIndex - 1) / 2;
	}
	//��û��������
	private boolean hasLeftChild(int index) {
	    return getLeftChildIndex(index) < size;
	}
	//��û��������
	private boolean hasRightChild(int index) {
	    return getRightChildIndex(index) < size;
	}
	//��û�и��ڵ�
	private boolean hasParent(int index) {
	    return getParentIndex(index) >= 0;
	}
	//ȡ��ڵ�ֵ
	private int leftChild(int parentIndex) {
	    return array[getLeftChildIndex(parentIndex)];
	}
	//ȡ�ҽڵ�ֵ
	private int rightChild(int parentIndex) {
	    return array[getRightChildIndex(parentIndex)];
	}
	//ȡ���ڵ�ֵ
	private int parent(int childIndex) {
	    return array[getParentIndex(childIndex)];
	}
    private void swap(int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
	
	//����
	public void add(int item) { // Time Complexity: O(logN)
	    if(size == capacity) {
	        array = Arrays.copyOf(array, capacity * 2);
	        capacity = capacity * 2;
	    }
	    array[size] = item;
	    size++;
	    heapifyUp();
	}
	//���ڵ㲻���븸�ڵ�ԱȽ���
	private void heapifyUp() {
	    int index = size - 1;
	    while (hasParent(index) && parent(index) < array[index]) {
	        swap(getParentIndex(index), index);
	        index = getParentIndex(index);
	    }
	}
	//ȡ�����ڵ㣬�������һ���ڵ㸳�����ڵ㣬�ٲ��������Һ��ӶԱȽ�����ֱ���ҵ�����ֵ��
	public void poll() { // ʱ�临�Ӷ�: O(logN)
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
