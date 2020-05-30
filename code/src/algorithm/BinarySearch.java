package algorithm;
import java.util.Arrays;

public class BinarySearch {
	public static int rank(int key,int[] a){
		//数组必须是有序
		int lo = 0;
		int hi = a.length - 1;
		while(lo <= hi) {
			int i = 0;
			i++;
			//被查找的键要么不存在，要么必然存在a[lo..hi]之中
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
		//将数组指定的范围升序排列
		Arrays.sort(whitelist);
		int key = 6;
		if(rank(key,whitelist) < 0)
			System.out.print(key);
		else if(key == whitelist[rank(key,whitelist)])
			System.out.println("找到了，在第" + rank(key,whitelist) + "位" );

	}
}
