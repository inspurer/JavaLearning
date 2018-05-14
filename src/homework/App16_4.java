package homework;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JApplet;
import javax.swing.Timer;

public class App16_4 extends JApplet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int x = 0, y = 0;
	Color c = new Color(getRandom('c'),getRandom('c'),getRandom('c'));
	int r = 10;

	@Override
	public void init() {
		// TODO Auto-generated method stub
		super.init();
		/*
		 * setBackground(Color.BLUE);//为什么不能设置背景？？？ setSize(300,500);
		 * System.out.println(getWidth());
		 */
		Timer timer = new Timer(50, new MyActionListener());
		//开始没有这句，没有start,调试了好久.orz
		timer.start();
		
		x = getRandom('x');
		y = getRandom('y');
		repaint();
	}

	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(c);
		g.fillOval(x-r, y-r, 2*r,2*r);
		g.drawString("utf-8编码", 10, 10);
	}

	public int getRandom(char order) {
		Random seed = new Random();
		int random = 0;
		if (order == 'x')
			random = seed.nextInt(getWidth());
		else if (order == 'y')
			random = seed.nextInt(getHeight());
		else if (order == 'c')
			random = seed.nextInt(255);
		else
			System.out.println("输入形参错误");
		return random;
	}

	class MyActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			r += 10;
			
			//直径一半左右时重找圆心
			if (r >= getWidth() / 4 ) {
				x = getRandom('x');
				y = getRandom('y');
				r = 10;
				c = new Color(getRandom('c'),getRandom('c'),getRandom('c'));
			}
			repaint();
		}

	}
}
