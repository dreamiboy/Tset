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

public class MainFrame extends JFrame implements ActionListener{


	
	private static final long serialVersionUID = 1L;
	//����˵��
	public JPanel top = new JPanel();
	//����ͽ��ģ��
	public JPanel center = new JPanel();
	public JPanel center_1 = new JPanel();
	public JPanel center_2 = new JPanel();
	//��ťģ��
	public JPanel bottle = new JPanel();
	
	//����x��y���������
	private int x = (int) (Math.random()*99+1);
	private int y = (int) (Math.random()*99+1);
	private String[] operators = {"+","-","��","��"};
	private int index = 0;
	//��¼��Ŀ����
	int count = 1;
	//����˵����
	private JLabel top_1 = new JLabel("�����ı�:");
	private JTextArea top_2 = new JTextArea();
	
	//����ģ��
	private JLabel head = new JLabel("[��"+count+"��]  ");
	private JLabel num1 = new JLabel(String.valueOf(x));
	private JLabel operator = new JLabel(operators[0]);
	private JLabel num2 = new JLabel(String.valueOf(y));
	private JLabel deng = new JLabel("=");
	
	public JTextField consle = new JTextField(4);
	
	public int right = 0;
	public int error = 10;
	public double right_lv =0;
	public JLabel test = new JLabel("<html>���Ϲ���10���������⡣<br>����"+right+"�ʻش���ȷ��"+error+"�ʻش����<br>��ȷ��Ϊ��"+right_lv*100+"%</html>");
	
	
	//�ײ���ťģ��
	public JButton next = new JButton("��һ��");
	public JButton end = new JButton("����");
	public JButton start = new JButton("��ʼ");
	
	
	public MainFrame() {
		super("");
		this.setBounds(600,400,650,400);
		add();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}
	
	private void add() {
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
		/*
		center_1.add(head);
		center_1.add(num1);
		center_1.add(operator);
		center_1.add(num2);
		center_1.add(deng);
		center_1.add(consle);
		*/
		center_2.add(test);
		test.setFont(font);
		test.setVisible(false);
		center.add(center_1,"North");
		center.add(center_2, "Center");
		
		this.getContentPane().add(center);
		
		//�ײ���ťģ��
		
		next.setFont(font);
		
		end.setFont(font);
		end.setEnabled(false);
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
		
		next.setEnabled(false);
		end.setEnabled(false);
		
		
	}

	public static void main(String[] args) {
		new MainFrame();
	}
	
	
	//��굥���¼�
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("����")) {
			//test = new JLabel("<html>���Ϲ���10���������⡣<br>����"+right+"�ʻش���ȷ��"+error+"�ʻش����<br>��ȷ��Ϊ��"+right_lv*100+"%</html>");
			right_lv = (double)right/10;
			test.setText("<html>���Ϲ���10���������⡣<br>����"+right+"�ʻش���ȷ��"+error+"�ʻش����<br>��ȷ��Ϊ��"+right_lv*100+"%</html>");
			center_2.removeAll();
			center_2.add(test);
			test.setVisible(true);
			next.setEnabled(false);
			end.setEnabled(false);
			center_1.setVisible(false);
			
			
		}
		if(e.getActionCommand().equals("��ʼ")) {
			test.setVisible(false);
			next.setEnabled(true);
			end.setEnabled(true);
			count=1;
			center_1.removeAll();
			x=(int) (Math.random()*99+1);
			y=(int) (Math.random()*99+1);
			index = (int) (Math.random()*3);
			
			System.out.println("index:"+index);
			head.setText("[��"+count+"��]  ");
			center_1.add(head);
			new String();
			num1.setText(String.valueOf(x));
			center_1.add(num1);
			
			operator.setText(operators[index]);
			center_1.add(operator);
			
			num2.setText(String.valueOf(y));
			center_1.add(num2);
			center_1.add(deng);
			center_1.add(consle);
			center_1.updateUI();
			center_1.setVisible(true);
			consle.setText("");
			right = 0;
			error = 10;
		}
		if (e.getActionCommand().equals("��һ��")) {
			
			if (consle.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "�㻹û����д�𰸣�����", "����", JOptionPane.INFORMATION_MESSAGE);
				return;
			}			
			++count;
			if (count>10) {
				count = 1;
				end.setEnabled(true);
				next.setEnabled(false);
				JOptionPane.showMessageDialog(null, "�Ѿ����ȫ����Ŀ����������", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			
			switch (index) {
			case 0:
				System.out.println("�ӷ�����");
				int z = x+y;
				if (Integer.parseInt(consle.getText())==z) {
					right++;
					error--;
				}
				break;
			case 1:
				System.out.println("��������");
				if (Integer.parseInt(consle.getText())==x-y) {
					right++;
					error--;
				}
				break;
			case 2:
				System.out.println("�˷�����");
				if (Integer.parseInt(consle.getText())==x*y) {
					right++;
					error--;
				}
				break;
			case 3:
				System.out.println("��������");
				if (Double.parseDouble(consle.getText())==(double)x/y) {
					right++;
					error--;
				}
				break;
			
			
		}
			System.out.println("right:"+right);
			System.out.println("error:"+error);
			consle.setText("");
			center_1.removeAll();
			
			x=(int) (Math.random()*99+1);
			y=(int) (Math.random()*99+1);
			index = (int) (Math.random()*3);
			
			System.out.println("index:"+index);
			head.setText("[��"+count+"��]  ");
			center_1.add(head);
			new String();
			num1.setText(String.valueOf(x));
			center_1.add(num1);
			
			operator.setText(operators[index]);
			center_1.add(operator);
			
			num2.setText(String.valueOf(y));
			center_1.add(num2);
			center_1.add(deng);
			center_1.add(consle);
			center_1.updateUI();
			
		}

	}
	}
	

