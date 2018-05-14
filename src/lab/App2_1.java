package lab;
public class App2_1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean flag = true;
		int count = 0;
/*		System.out.println(((int)(Math.sqrt(3)))); print 1 
*/		System.out.println("下面是200以内的素数:");
		for (int i = 1; i<= 200; i++){
			for(int j = 2; j<=Math.sqrt(i); j++){
				/**
				 * int j = 1; No Output!
				 */
				if(i%j == 0) {
					flag = false;
					break;
				}
			}
			if(flag) {
				System.out.printf("%-3d ",i);//控制输出格式，三位左对齐
				count++;
				if(count%8 == 0)  
					System.out.println();//一行输出六个
			}
			flag = true;
		}
	}
}
