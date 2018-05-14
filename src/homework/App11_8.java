package homework;
class XBank{
	private static int sum = 666;
	public synchronized static void deposit(int money) {
		int temp = sum;
		temp += money;
		try {
			Thread.sleep((int)(1000*Math.random()));
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		sum = temp;
		System.out.println("sum = "+sum);
	}
}
class User extends Thread{
	private  String name;
	public User(String name) {
		this.name = name;
	}
	public void run() {
		for(int i=0; i<3; i++) {
			XBank.deposit(100);
			System.out.println("User: "+this.name+"成功汇款100元");
		}
	}
}
public class App11_8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		User u1 = new User("inspurer");
		User u2 = new User("月小水长");
		u1.start();
		u2.start();
	}

}
