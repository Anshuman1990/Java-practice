import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Solution {

   static long maximumSum(long[] a, long m) {
		ArrayList<Long> sum = new ArrayList<Long>();
        int size = a.length;
        int fixed_size = a.length;
        int start=0;
        int end=0;
        while(size>0){
        	int temp = fixed_size-size;
        	end = temp;
        	for(int i=0;i<size;i++){
        		long add = 0;
        		if(start == end){
        			add = a[i];
        			sum.add(add%m);
        		}
        		else{
        			for(int j=start;j<=end;j++){
        				add+=a[j];
        			}
        			sum.add(add%m);
        			start+=1;
        			end+=1;
        		}
//        		System.out.println("sum value= "+add);
        	}
        	start = 0;
        	end = 0;
        	size--;
//        	System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        }
        Collections.sort(sum);
//        System.out.println(sum);
		return sum.get(sum.size()-1);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            int n = in.nextInt();
            long m = in.nextLong();
            long[] a = new long[n];
            for(int a_i = 0; a_i < n; a_i++){
                a[a_i] = in.nextLong();
            }
            long result = maximumSum(a, m);
            System.out.println(result);
        }
        in.close();
    }
}
