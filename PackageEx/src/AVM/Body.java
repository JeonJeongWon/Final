package AVM;
import java.awt.Font;
import java.util.Enumeration;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;
import javax.swing.JTextField;

//������
public class Body {
	static JButton btn1,btn2;
	static JLabel imgLbl1,imgLbl2,imgLbl3;
	static JTextField field;
	static Food food[] = new Food[3];
	static int currentMoeny,TotalPrice=0; // <<< �� ���� ���� �Է��ϴ� ���簪(���� ��)? .���� �� ����
	static final int MaxSize=100; //������ �ִ� ���
	static String ReturnMoney;
	public static void main(String[] args) {
		// ���� ���� ������ >> �˰��� ����
		food[0]= new Food("�ʱ���",0,2500);
		food[1]= new Food("��ī�ݶ�",0,1500);
		food[2]=new Food("Ʈ����ī��",0,1450);
		//

		
	    String foodSize[]= {"0","0","0"}; //�������̽� ���� ǥ�ÿ�
	    String FoodSum[]= {"0"}; //�������̽� ������ ǥ�ÿ�
	    // ��� �۲� ����
		Enumeration<Object> keys = UIManager.getDefaults().keys();
		while (keys.hasMoreElements()) {
			Object key = keys.nextElement();
			Object value = UIManager.get(key);
			if (value instanceof FontUIResource)
				UIManager.put(key, new FontUIResource("����", Font.PLAIN, 14));
		}
		
		// [start] ������ ����
		JFrame frm = new JFrame();
		frm.setTitle("AVM");
		frm.setSize(500, 500);
		frm.setLocationRelativeTo(null);
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm.getContentPane().setLayout(null);
		// [end] ������ ����
		
		
		// [start] ����������ư
		JButton btn1 = new JButton("��"); 
		JButton btn2 = new JButton("��"); 
		JButton btn3 = new JButton("��"); 
		JButton btn4 = new JButton("��"); 
		JButton btn5 = new JButton("��"); 
		JButton btn6 = new JButton("��"); 
		JButton btnSt= new JButton("����");
		
		btn1.setBounds(120, 195, 45, 45);
		btn2.setBounds(120, 145, 45, 45);
		btn3.setBounds(270, 195, 45, 45);
		btn4.setBounds(270, 145, 45, 45);
		btn5.setBounds(420, 195, 45, 45);
		btn6.setBounds(420, 145, 45, 45);
		btnSt.setBounds(330, 295, 65, 35);
		
		frm.getContentPane().add(btn1);
		frm.getContentPane().add(btn2);
		frm.getContentPane().add(btn3);
		frm.getContentPane().add(btn4);
		frm.getContentPane().add(btn5);
		frm.getContentPane().add(btn6);
		frm.getContentPane().add(btnSt);
		// �������� ���̵��� ����
		// [end] ����������ư
		
		JLabel lblReturnText = new JLabel();
		lblReturnText.setBounds(170,400, 80, 40);
		lblReturnText.setText("�Ž�������");
		frm.getContentPane().add(lblReturnText);
		
		ReturnMoney =Integer.toString(Algorithm.change);
		JLabel lblReturnMoney=new JLabel();
		lblReturnMoney.setBounds(260, 395, 50, 50);
		lblReturnMoney.setText(ReturnMoney);
		frm.getContentPane().add(lblReturnMoney);
		
		// [start] �ڹ� �ؽ�Ʈ��Ʈ >> ���� �ݾ� �� ���� ���� ���� �ڵ�
		field= new JTextField(10);
		field.setText("0");
		field.setHorizontalAlignment(JTextField.CENTER);
		field.setBounds(200, 300, 100, 25);
		frm.getContentPane().add(field);
		JLabel lbl4=new JLabel();
		lbl4.setBounds(120, 293, 80, 40);
		lbl4.setText("���� �ݾ�");
		frm.getContentPane().add(lbl4);
		btnSt.addActionListener(event->{
			if(Integer.parseInt(field.getText())<0) {
				field.setEditable(false); //���� �Է� �Ұ� �����޼����� �ٲܿ���
			}
			else {
				currentMoeny = Integer.parseInt(field.getText());//�Է�������ݾ� currentMoney�� ����
			}
			if(Algorithm.change>=0) {
				int rprice=currentMoeny-TotalPrice;
				ReturnMoney =Integer.toString(rprice);
				lblReturnMoney.setText(ReturnMoney);
			}
		});
		// [end] �ڹ� �ؽ�Ʈ�ʵ� >> ���� �ݾ� �Է¹޾� �Ž����� �޴�.
		
		// [start] ������ �հ� ǥ���ϴ� ��
		JLabel lblSumText = new JLabel();
		lblSumText.setBounds(170,360, 80, 40);
		lblSumText.setText("�հ��");
		frm.getContentPane().add(lblSumText);
		
		FoodSum[0]=Integer.toString(TotalPrice);
		JLabel lblSumNum=new JLabel();
		lblSumNum.setBounds(240, 355, 50, 50);
		lblSumNum.setText(FoodSum[0]);
		frm.getContentPane().add(lblSumNum);
		
		JButton btnPurchase= new JButton("����");
		btnPurchase.setBounds(290, 363, 65, 35);
		frm.getContentPane().add(btnPurchase);
		
		
		btnPurchase.addActionListener(event->{
			Algorithm.Greedy(TotalPrice,currentMoeny);
		});
		// [end] ������ �հ� ǥ���ϴ� ��
		

		//Int�� >> String�� (�������̽� ǥ������)
		foodSize[0] = Integer.toString(food[0].size);
		foodSize[1] = Integer.toString(food[1].size);
		foodSize[2] = Integer.toString(food[2].size);
		//
		
		//[����] ����
		JLabel lbl = new JLabel();
		lbl.setBounds(70, 180, 200, 20);
		lbl.setText(foodSize[0]);
		frm.getContentPane().add(lbl);
		
		JLabel lbl2 = new JLabel();
		lbl2.setBounds(220, 180, 200, 20);
		lbl2.setText(foodSize[1]);
		frm.getContentPane().add(lbl2);
		
		JLabel lbl3 = new JLabel();
		lbl3.setBounds(370, 180, 200, 20);
		lbl3.setText(foodSize[2]);
		frm.getContentPane().add(lbl3);
		//[��] ����
		
		//[����] ����ǥ��
		JLabel lblPrice = new JLabel();
		lblPrice.setBounds(40, 10, 200, 20);
		lblPrice.setText("<"+food[0].price+"��"+">");
		frm.getContentPane().add(lblPrice);
		
		JLabel lblPrice2 = new JLabel();
		lblPrice2.setBounds(200, 10, 200, 20);
		lblPrice2.setText("<"+food[1].price+"��"+">");
		frm.getContentPane().add(lblPrice2);
		
		JLabel lblPrice3 = new JLabel();
		lblPrice3.setBounds(350, 10, 200, 20);
		lblPrice3.setText("<"+food[2].price+"��"+">");
		frm.getContentPane().add(lblPrice3);
		//[��] ����ǥ��
		
		// [����] ��ǰ�̹���
		//�ʱ���
		imgLbl1 = new JLabel();
		ImageIcon NGIMg = new ImageIcon(Body.class.getResource("/AVM/img/�ʱ���.jpg"));
		imgLbl1.setIcon(NGIMg);
		imgLbl1.setBounds(15, 35,125,100);
		imgLbl1.setHorizontalAlignment(JLabel.CENTER);
        frm.getContentPane().add(imgLbl1);
        //����ʱ���
        ImageIcon HumanNG = new ImageIcon(Body.class.getResource("/AVM/img/�ʱ�����2.gif"));
        
        //�ݶ�
        imgLbl2 = new JLabel();
		ImageIcon Coke = new ImageIcon(Body.class.getResource("/AVM/img/��īī��.jpg"));
		imgLbl2.setIcon(Coke);
		imgLbl2.setBounds(180, 35,100,100);
		imgLbl2.setHorizontalAlignment(JLabel.CENTER);
        frm.getContentPane().add(imgLbl2);
        //�ݶ��
        ImageIcon Bear = new ImageIcon(Body.class.getResource("/AVM/img/�ݶ��.gif"));
        
        //Ʈ����ī��
        imgLbl3 = new JLabel();
		ImageIcon Trop = new ImageIcon(Body.class.getResource("/AVM/img/Ʈ����ī��2.jpg"));
		imgLbl3.setIcon(Trop);
		imgLbl3.setBounds(330, 35,100,100);
		imgLbl3.setHorizontalAlignment(JLabel.CENTER);
		frm.getContentPane().add(imgLbl3);
        //����
		ImageIcon JOO2 = new ImageIcon(Body.class.getResource("/AVM/img/���̿���2.gif"));
		
		// [��] ��ǰ�̹���
		
		// [����] ����������ư
		btn1.addActionListener(event->{
			if(food[0].size>0) {  //0 �����δ� �������� �����
			food[0].size--;
			TotalPrice-=food[0].price;
			if(food[0].size==10) Body.imgLbl1.setIcon(HumanNG);
			else Body.imgLbl1.setIcon(NGIMg);
			foodSize[0]= Integer.toString(food[0].size);
			lbl.setText(foodSize[0]);//���������Լ�
			
			FoodSum[0]=Integer.toString(TotalPrice);
			lblSumNum.setText(FoodSum[0]);
			}
		});
		btn2.addActionListener(event->{
			if(food[0].size<MaxSize) {
			food[0].size++;
			TotalPrice+=food[0].price;
			if(food[0].size==10) Body.imgLbl1.setIcon(HumanNG);
			else Body.imgLbl1.setIcon(NGIMg);
			foodSize[0]= Integer.toString(food[0].size);
			lbl.setText(foodSize[0]);
			
			FoodSum[0]=Integer.toString(TotalPrice);
			lblSumNum.setText(FoodSum[0]);
			}
		});

		
		btn3.addActionListener(event->{
			if(food[1].size>0) {  //0 �����δ� �������� �����
			food[1].size--;
			TotalPrice-=food[1].price;
			if(food[1].size==10) Body.imgLbl2.setIcon(Bear);
			else Body.imgLbl2.setIcon(Coke);
			foodSize[1]= Integer.toString(food[1].size);
			lbl2.setText(foodSize[1]);//���������Լ�
			
			FoodSum[0]=Integer.toString(TotalPrice);
			lblSumNum.setText(FoodSum[0]);
			}
		});
		btn4.addActionListener(event->{
			if(food[1].size<MaxSize) {
			food[1].size++;
			TotalPrice+=food[1].price;
			if(food[1].size==10) Body.imgLbl2.setIcon(Bear);
			else Body.imgLbl2.setIcon(Coke);
			foodSize[1]=Integer.toString(food[1].size);
			lbl2.setText(foodSize[1]);
			
			FoodSum[0]=Integer.toString(TotalPrice);
			lblSumNum.setText(FoodSum[0]);
			}
		});
		
		
		btn5.addActionListener(event->{
			if(food[2].size>0) {  //0 �����δ� �������� �����
			food[2].size--;
			TotalPrice-=food[2].price;
			if(food[2].size==10) Body.imgLbl3.setIcon(JOO2);
			else Body.imgLbl3.setIcon(Trop);
			foodSize[2]= Integer.toString(food[2].size);
			lbl3.setText(foodSize[2]);//���������Լ�
			
			FoodSum[0]=Integer.toString(TotalPrice);
			lblSumNum.setText(FoodSum[0]);
			}
		});
		btn6.addActionListener(event->{
			if(food[2].size<MaxSize) {
			food[2].size++;
			TotalPrice+=food[2].price;
			if(food[2].size==10) Body.imgLbl3.setIcon(JOO2);
			else Body.imgLbl3.setIcon(Trop);
			foodSize[2]= Integer.toString(food[2].size);
			lbl3.setText(foodSize[2]);
			
			FoodSum[0]=Integer.toString(TotalPrice);
			lblSumNum.setText(FoodSum[0]);
			}
		});
		
		//[����] ����������ư
        
		frm.setVisible(true);
		// [end]
		}
}
