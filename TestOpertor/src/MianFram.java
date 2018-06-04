import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MianFram extends JFrame implements ActionListener{


	
	private static final long serialVersionUID = 1L;
	//测试说明
	public JPanel top ;
	//运算和结果模块
	public JPanel center;
	public JPanel center_1;
	public JPanel center_2;
	//按钮模块
	public JPanel bottle;
	
	//设置x和y和运算符号
	int x ;
	int y ;
	String[] operators;
	//记录题目数量
	int count = 1;
	//测试说明：
	private JLabel top_1 = new JLabel("测试文本:");
	private JTextArea top_2 = new JTextArea();
	
	//运算模块
	private JLabel head ;
	private JLabel num1 ;
	private JLabel operator;
	private JLabel num2;
	private JLabel deng;
	
	public JTextField consle = new JTextField(4);
	
	public int right = 0;
	public int error = 10;
	public double right_lv =0;
	public JLabel test = new JLabel("<html>以上共有10道计算问题。<br>其中"+right+"问回答正确，"+error+"问回答错误。<br>正确率为："+right_lv*100+"%</html>");
	
	
	//底部按钮模块
	public JButton next = new JButton("下一题");
	public JButton end = new JButton("结束");
	public JButton start = new JButton("开始");
	
	
	public MianFram() {
		super("");
		this.setBounds(600,400,650,400);
		add();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}
	
	private void add() {
		top = new JPanel();
		//运算和结果模块
		center = new JPanel();
		center_1 = new JPanel();
		center_2 = new JPanel();
		//按钮模块
		bottle = new JPanel();
		
		x = (int) (Math.random()*99+1);
		y = (int) (Math.random()*99+1);
		operators = new String[]{"+","-","×","÷"};
		top_1 = new JLabel("测试文本:");
		top_2 = new JTextArea();
		
		//运算模块
		head = new JLabel("[第"+count+"问]  ");
		num1 = new JLabel(x+"");
		operator = new JLabel(operators[0]);
		num2 = new JLabel(y+"");
		deng = new JLabel("=");
		
		Font font = new Font("宋体", Font.PLAIN, 30);
		/*
		 * 顶层top面板
		 */
		top_1.setFont(font);
		top.setLayout(new BorderLayout());
		String str = "本测试共随机产生10道100以内的加减乘除运算题。\n答完全部题目，或点击【结束】按钮，将结束本次测试.\n"
				+ "【下一题】按钮，【结束】按钮变为不可点击状态，并且给出测试评价。\n点击开始按钮重新测试。";
		top_2.setText(str);
		Font font1 = new Font("宋体", Font.PLAIN, 15);
		top_2.setFont(font1);
		top.add(top_1,"North");
		top.add(top_2,"Center");
		this.getContentPane().add(top,"North");
		
		//中间的元算模块
		center.setLayout(new BorderLayout());
		center_1.setLayout(new FlowLayout());
		center_2.setLayout(new BorderLayout());
		//JPanel operate = new JPanel();
		head.setFont(font);
		num1.setFont(font);
		operator.setFont(font);
		num2.setFont(font);
		deng.setFont(font);
		consle.setFont(font);
		center_1.add(head);
		center_1.add(num1);
		center_1.add(operator);
		center_1.add(num2);
		center_1.add(deng);
		center_1.add(consle);
		
		center_2.add(test);
		test.setFont(font);
		test.setVisible(false);
		center.add(center_1,"North");
		center.add(center_2, "Center");
		
		this.getContentPane().add(center);
		
		//底部按钮模块
		
		next.setFont(font);
		
		end.setFont(font);
		start.setFont(font);
		bottle.setLayout(new GridLayout(1, 5));
		
		bottle.add(next);
		bottle.add(new JLabel(" "));
		bottle.add(end);
		bottle.add(new JLabel(" "));
		bottle.add(start);
		
		next.addActionListener(this);
		start.addActionListener(this);
		end.addActionListener(this);
		this.getContentPane().add(bottle, "South");
		
		
		
		
	}

	public static void main(String[] args) {
		new MianFram();
	}
	
	
	//鼠标单击事件
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("结束")) {
			test.setVisible(true);
			next.setEnabled(false);
			end.setEnabled(false);
			count=10;
		}
		if(e.getActionCommand().equals("开始")) {
			test.setVisible(false);
			next.setEnabled(true);
			end.setEnabled(true);
			count=1;
		}
		if (e.getActionCommand().equals("下一题")) {
			if (consle.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "你还没有填写答案！！！", "警告", JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			
			System.out.println("下一题");
			x=(int) (Math.random()*99+1);
			y=(int) (Math.random()*99+1);
			int index = (int) (Math.random()*3);
			System.out.println(x);
			System.out.println(y);
			System.out.println(index);
			if (count==1) {
				if (Integer.parseInt(consle.getText())==87+32) {
					right++;
					error--;
					System.out.println(right);
				}
			}
			else {
				
//				num1.setText(x+"");
//				num1.updateUI();
//				num2.setText(y+"");
//				num2.updateUI();
//				operator.setText(operators[index]);
//				operator.updateUI();
				num1 = new JLabel(x+"");
				num2 = new JLabel(y+"");
				operator = new JLabel(operators[index]);
				switch (index) {
				case 0:
					if (Integer.parseInt(consle.getText())==x+y) {
						right++;
						error--;
					}
					break;
				case 1:
					if (Integer.parseInt(consle.getText())==x-y) {
						right++;
						error--;
					}
					break;
				case 2:
					if (Integer.parseInt(consle.getText())==x*y) {
						right++;
						error--;
					}
					break;
				case 3:
					if (Double.parseDouble(consle.getText())==(double)x/y) {
						right++;
						error--;
					}
					break;
				
				
			}
			count++;
			head.setText("[第"+count+"问]  ");
			center_1.removeAll();
			center_1.updateUI();
			/*
			center_1.add(head);
			center_1.add(num1);
			center_1.add(operator);
			center_1.add(num2);
			center_1.add(deng);
			center_1.add(consle);
			center_1.updateUI();
			System.out.println(count);
			*/
		}

	}
}
	
}
