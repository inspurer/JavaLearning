package lab;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class App4_3 {
    //帧数
	static int count = 24;
	//面板默认图片
	static JLabel label = new JLabel(new ImageIcon("0.jpg"));
	static JButton bPlay = new JButton("播放");
	static JButton bStop = new JButton("停止");
	static ImageIcon[] img = new ImageIcon[count];
	static int num = 0;
	static MyListener ml = new MyListener();
	static Timer timer = new Timer(2000, ml);

	public static void main(String [] args)
  {
    JFrame jf = new JFrame("动画");
    jf.setLayout(null);
    jf.setSize(1300,760);
    
    //播放动画面板
	JPanel p1=new JPanel();
	p1.setBounds(0, 0,1300,760);
	p1.add(label);
	jf.add(p1);
	
	//控制播放按钮面板
    JPanel p2=new JPanel();
    p2.setBounds(500,40,200,40);
    bPlay.setBounds(350,220, 40,30);
    bPlay.addActionListener(ml);
    bStop.addActionListener(ml);
    bStop.setBounds(550,220,40,30);
    p2.add(bPlay);
    p2.add(bStop);
    jf.add(p2);
  
    for(int i=0;i<count;i++)
    {
      img[i]=new ImageIcon(num+".jpg");
      num++;
    }
    
    //
    jf.setVisible(true);
    jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    new AudioPlayer(new File("E:\\JAVA Src\\于文文 - 体面 [mqms2].mp3")).start();
  }

	static class MyListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == bPlay)
				timer.start();
			else if (e.getSource() == bStop)
				timer.stop();
			else if (e.getSource() == timer) {
				if(num == count) {
					num = 0;
					try {
						Thread.sleep(3000);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				label.setIcon(img[num]);
				num++;
			}
		}
	}

	public static class AudioPlayer extends Thread {
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
