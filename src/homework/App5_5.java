package homework;

public class App5_5 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] arrays =  new int[8];
		for(int i = 0; i < 8; i++){
			arrays[i] = (int) (Math.random()*100);
		}
		arrays = App5_5.bubbleupsort(arrays);
	    for(int i = 0; i < 8; i++)
			System.out.printf("%d<",arrays[i]);
	}
	public static int[] bubbleupsort(int [] a){
		int temp;
		for(int i = 0; i<a.length-1; i++)
		{
			boolean flag = true;
			for(int j = 0; j<a.length-1-i; j++)
			{
				if(a[j] > a[j+1]){
					flag = false;
					temp = a[j+1];
					a[j+1] = a[j];
					a[j] = temp;
				}
			}
			if(flag)
				break;
	}
		/*for(int i = 0; i < 8; i++)
			System.out.println(a[i]);*/
		return a;
	}
}
