package lab;

public class App2_3 {

	/**
	 * @param args 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cylinder cd = new Cylinder(33.0,55.0);
		System.out.printf("体积为:%.2f",cd.getVolume());
		/**
		 * printf语句是在JDK1.5后引入的，学校机房里的JDK虽然我新装了1.9，
		 * 但机房里华清远见文件夹下的Eclispe for Android使用的是1.5以下的JDK
		 * 所以在学校电脑上报错，在我的电脑上ok
		 */

	}
	static class Cylinder{
		private double Hight ;
		private double Radius ;
		public double getVolume(){
			return Math.PI*Radius*Radius*Hight;
		}
		public Cylinder(){
			System.out.println("被调用者曰：我开始被调用了");
		}
		public Cylinder(double h, double r){
			this();
			System.out.println("调用者道：我调用完毕");
			Hight = h;
			Radius = r;
		}
	}
}
