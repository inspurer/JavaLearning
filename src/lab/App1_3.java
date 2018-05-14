package lab;

import java.util.Scanner;

public class App1_3 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double r,h;
		@SuppressWarnings("resource")
		Scanner reader = new Scanner(System.in);
		System.out.println("请输入圆柱体的底半径:");
		r = reader.nextDouble();
		System.out.println("请输入圆柱体的高:");
		h = reader.nextDouble();
		System.out.printf("该圆柱体的体积为:%.2f",
				new App1_3().new Cylinder(r, h).getVolume());
	}
	/**
	 * 为什么要先new CylinderTest()呢
	 * 查看帮助文档Cylinder.txt
	 * @author lenovo
	 *
	 */
class Cylinder{
	private double r = 1;
	private double h = 1;
	public Cylinder(double r, double h) {
		this.r = r;
		this.h = h;
	}
	public double getR() {
		return r;
	}
	public void setR(double r) {
		if(r>0)
		this.r = r;
		else
			System.out.println("r输入有误");
	}
	public double getH() {
		return h;
	}
	public void setH(double h) {
		if(h>0)
		this.h = h;
		else
			System.out.println("h输入有误");
	}
	public double getVolume() {
		return Math.PI*r*r*h;
	}
	
}
}
