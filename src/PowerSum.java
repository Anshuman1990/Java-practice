import java.util.ArrayList;
import java.util.Scanner;

public class PowerSum {
static int result=0;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int X = in.nextInt();
        int N = in.nextInt();
        int result = powerSum(X, N,1);
        System.out.println(result);
        in.close();
	}
	
	static int powerSum(int X, int N,int j) {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		
		for(int i=j;i<X;i++) {
			int pow = (int) Math.pow(i, N);
			if(pow>X)
				break;
			else {
				
			}
		}
		return result;
    }
}
