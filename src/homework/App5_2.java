package homework;

import java.util.Arrays;
import java.util.Scanner;

public class App5_2 {
	public static void main(String [] args){
		Scanner scanner = new Scanner(System.in);
		System.out.println("How many numbers? : ");
		int numbers = scanner.nextInt();
		System.out.println("\n Now input the numbers");
		int  [] arrays = new int [numbers];
		for (int i = 0; i<numbers; i++){
			arrays[i] = scanner.nextInt();
		}
		scanner.close();//不加这句会有警告
		Arrays.sort(arrays);
		System.out.println("The smallest number is :"+arrays[0]);
		System.out.println("The biggest number is :"+arrays[numbers-1]);
		
	}
}
