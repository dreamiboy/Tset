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
	//����˵��
	public JPanel top ;
	//����ͽ��ģ��
	public JPanel center;
	public JPanel center_1;
	public JPanel center_2;
	//��ťģ��
	public JPanel bottle;
	
	//����x��y���������
	int x ;
	int y ;
	String[] operators;
	//��¼��Ŀ����
	int count = 1;
	//����˵����
	private JLabel top_1 = new JLabel("�����ı�:");
	private JTextArea top_2 = new JTextArea();
	
	//����ģ��
	private JLabel head ;
	private JLabel num1 ;
	private JLabel operator;
	private JLabel num2;
	private JLabel deng;
	
	public JTextField consle = new JTextField(4);
	
	public int right = 0;
	public int error = 10;
	public double right_lv =0;
	public JLabel test = new JLabel("<html>���Ϲ���10���������⡣<br>����"+right+"�ʻش���ȷ��"+error+"�ʻش����<br>��ȷ��Ϊ��"+right_lv*100+"%</html>");
	
	
	//�ײ���ťģ��
	public JButton next = new JButton("��һ��");
	public JButton end = new JButton("����");
	public JButton start = new JButton("��ʼ");
	
	
	public MianFram() {
		super("");
		this.setBounds(600,400,650,400);
		add();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}
	
	private void add() {
		top = new JPanel();
		//����ͽ��ģ��
		center = new JPanel();
		center_1 = new JPanel();
		center_2 = new JPanel();
		//��ťģ��
		bottle = new JPanel();
		
		x = (int) (Math.random()*99+1);
		y = (int) (Math.random()*99+1);
		operators = new String[]{"+","-","��","��"};
		top_1 = new JLabel("�����ı�:");
		top_2 = new JTextArea();
		
		//����ģ��
		head = new JLabel("[��"+count+"��]  ");
		num1 = new JLabel(x+"");
		operator = new JLabel(operators[0]);
		num2 = new JLabel(y+"");
		deng = new JLabel("=");
		
		Font font = new Font("����", Font.PLAIN, 30);
		/*
		 * ����top���
		 */
		top_1.setFont(font);
		top.setLayout(new BorderLayout());
		String str = "�����Թ��������10��100���ڵļӼ��˳������⡣\n����ȫ����Ŀ����������������ť�����������β���.\n"
				+ "����һ�⡿��ť������������ť��Ϊ���ɵ��״̬�����Ҹ����������ۡ�\n�����ʼ��ť���²��ԡ�";
		top_2.setText(str);
		Font font1 = new Font("����", Font.PLAIN, 15);
		top_2.setFont(font1);
		top.add(top_1,"North");
		top.add(top_2,"Center");
		this.getContentPane().add(top,"North");
		
		//�м��Ԫ��ģ��
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
		
		//�ײ���ťģ��
		
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
	
	
	//��굥���¼�
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("����")) {
			test.setVisible(true);
			next.setEnabled(false);
			end.setEnabled(false);
			count=10;
		}
		if(e.getActionCommand().equals("��ʼ")) {
			test.setVisible(false);
			next.setEnabled(true);
			end.setEnabled(true);
			count=1;
		}
		if (e.getActionCommand().equals("��һ��")) {
			if (consle.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "�㻹û����д�𰸣�����", "����", JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			
			System.out.println("��һ��");
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
			head.setText("[��"+count+"��]  ");
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
