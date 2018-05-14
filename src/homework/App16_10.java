package homework;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.swing.JApplet;
import javax.swing.Timer;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class App16_10 extends JApplet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*
	 * int width = getWidth(); int x = (int)(Math.random()*width);
	 */
	int x = (int) (Math.random() * 200);
	int y = getHeight();

	public void init() {
		/*
		 * System.out.println(getWidth());
		 */ // TODO Auto-generated method stub
		super.init();
		Timer timer = new Timer(50, new MyActionListner());
		timer.start();
		new AudioPlayer(new File("E:\\JAVA Src\\于文文 - 体面 [mqms2].mp3")).start();
	}

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		g.drawString("分手应该体面!", x, y);
	}

	class MyActionListner implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			y -= 5;
			if (y <= 0) {
				x = (int) (Math.random() * 200);
				y = getHeight();
			}
			repaint();
		}

	}

	public class AudioPlayer extends Thread {
		Player player;
		File music;

		// 构造方法
		public AudioPlayer(File file) {
			this.music = file;
		}

		// 重写run方法
		@Override
		public void run() {
			super.run();
			try {
				play();
			} catch (FileNotFoundException | JavaLayerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		// 播放方法
		public void play() throws FileNotFoundException, JavaLayerException {
			BufferedInputStream buffer = new BufferedInputStream(new FileInputStream(music));
			player = new Player(buffer);
			player.play();
		}
	}
}
