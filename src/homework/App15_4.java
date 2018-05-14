package homework;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class App15_4 extends JFrame {

	/**
	 * 
	 */
	//为了去掉警告自动加的，好像是什么版本兼容、序列化之类的问题
	private static final long serialVersionUID = 1L;
	private static JComboBox<String> shapeChoice = new JComboBox<String>(new String[] { "线", "圆", "椭圆", "矩形" });
	// 绘图面板
	private static PaintPanel ppl = new PaintPanel();
	private static JFrame jfr = new App15_4();
	private static JLabel jl_info_Ofchosen = new JLabel();
	// 判断应该绘什么图形
	private static int index = 0;

	// 保存 ”左上角“ 和 “右下角” 坐标
	private static int[][] location_startAndend = new int[2][2];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		jfr.setTitle("homework:App15_4");
		jfr.setLayout(null);
		jfr.setSize(400, 300);

		// 选择提示标签
		JLabel jl_warn_tochoice = new JLabel("请选择:");
		jl_warn_tochoice.setBounds(10, 10, 50, 20);
		jfr.add(jl_warn_tochoice);

		// 下拉列表框
		shapeChoice.setBounds(80, 10, 60, 20);
		shapeChoice.addItemListener(new MyJComboBoxSelectedChangedListener());
		jfr.add(shapeChoice);

		index = shapeChoice.getSelectedIndex();

		// 选中提示标签
		jl_info_Ofchosen.setText("您已选择: " + shapeChoice.getSelectedItem().toString() + "  " + "现在可以在下方的面板区拖动鼠标画图");
		jl_info_Ofchosen.setBounds(10, 40, 380, 20);
		jfr.add(jl_info_Ofchosen);

		ppl.setBounds(10, 70, 365, 200);
		ppl.setBackground(Color.white);
		jfr.add(ppl);

		jfr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jfr.setVisible(true);
	}

	static class MyJComboBoxSelectedChangedListener implements ItemListener {

		@Override
		public void itemStateChanged(ItemEvent e) {
			// TODO Auto-generated method stub
			jl_info_Ofchosen.setText("您已选择: " + shapeChoice.getSelectedItem().toString() + "  现在可以在下方的面板区拖动鼠标画图");
			index = shapeChoice.getSelectedIndex();
		}

	}

	// 鼠标拖动
	static class MyMouseMotionListener extends MouseMotionAdapter {
		@Override
		public void mouseDragged(MouseEvent e) {
			// TODO Auto-generated method stub
			super.mouseDragged(e);
			// 保存终点信息
			location_startAndend[1][0] = e.getX();
			location_startAndend[1][1] = e.getY();
			ppl.repaint();
		}
	}

	// 鼠标按下
	static class MyMousePressedListener extends MouseAdapter {
		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			super.mousePressed(e);
			// 保存起点信息
			location_startAndend[0][0] = e.getX();
			location_startAndend[0][1] = e.getY();
		}
	}

	static class PaintPanel extends JPanel {
		/**
		 * 
		 */
		//为了去掉警告自动加的，好像是什么版本兼容、序列化之类的问题
		private static final long serialVersionUID = 1L;

		public PaintPanel() {
			// 给面板加监听
			this.addMouseListener(new MyMousePressedListener());
			this.addMouseMotionListener(new MyMouseMotionListener());
		}

		@Override
		protected void paintComponent(Graphics g) {
			// TODO Auto-generated method stub
			super.paintComponent(g);
			int x1 = location_startAndend[0][0],y1 = location_startAndend[0][1],
					x2 = location_startAndend[1][0], y2 = location_startAndend[1][1];
			switch (index) {
			case 0:
				g.drawLine(x1,y1,x2,y2);
				break;
			case 1:
				int r = Math.max(x2-x1,y2-y1);
				g.drawOval(x1,y1,r,r);
				break;
			case 2:
				g.drawOval(x1,y1,x2,y2);
				break;
			case 3:
				g.drawRect(x1,y1,x2-x1,y2-y1);
				break;
			}
		}
	}

}
