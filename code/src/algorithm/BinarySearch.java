package algorithm;
import java.util.Arrays;

public class BinarySearch {
	public static int rank(int key,int[] a){
		//�������������
		int lo = 0;
		int hi = a.length - 1;
		while(lo <= hi) {
			int i = 0;
			i++;
			//�����ҵļ�Ҫô�����ڣ�Ҫô��Ȼ����a[lo..hi]֮��
			int mid = lo + (hi - lo) / 2;
			if(key<a[mid])
				hi = mid - 1;
			else if(key > a[mid])
				lo = mid + 1;
			else 
				return mid;
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] whitelist = {1,9,9,7,0,3,1,3,5,6,1,9};		 
		//������ָ���ķ�Χ��������
		Arrays.sort(whitelist);
		int key = 6;
		if(rank(key,whitelist) < 0)
			System.out.print(key);
		else if(key == whitelist[rank(key,whitelist)])
			System.out.println("�ҵ��ˣ��ڵ�" + rank(key,whitelist) + "λ" );

	}
}
