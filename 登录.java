package demo01;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.*;
import java.util.Random;
public class 登录 {
	
	
	class Arith {
		String arith = "";
		int result = 0;
		
		public Arith() {
			
		}
		
		public Arith(String arith) {
			this.arith = arith;
		}
		
		public void createArith(int Nos) {
			
			int pom = 0;
			for(int i = 0; i <= Nos; i++) {
				Random r = new Random();
				int num = r.nextInt(100) + 1;
				this.arith += num;
				if(i <=Nos - 1) {
					int aom = r.nextInt(2);
					if(aom == 0) {
						this.arith += "+";
						pom = 0;
					}else if(aom == 1) {
						this.arith += "-";
						pom = 1;
					}
				}
				if(i == 0) {
					this.result += num;
				}
				if(i >= 1) {
					if(pom == 0) {
						this.result += num;
					}else if(pom == 1) {
						this.result -= num; 
					}
				}
			}
			this.arith += "=";
			
			FileWriter fw1 = null;
			FileWriter fw2 = null;
			try {

				File file1 = new File("Exercise.txt");
				File file2 = new File("Answer.txt");

				fw1 = new FileWriter(file1,true);
				fw2 = new FileWriter(file2,true);
		
				fw1.write(this.arith + "   ");
				fw2.write(this.result + "   ");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					if (fw1 != null)
						fw1.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				try {
					if (fw2 != null)
						fw2.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		}
		public void showArith() {
			System.out.println(this.arith);
		}
	}
	

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					登录 window = new 登录();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public 登录() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setFont(new Font("微软雅黑", Font.BOLD, 16));
		frame.setTitle("测试界面");
		frame.getContentPane().setFont(new Font("宋体", Font.PLAIN, 12));
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("请输入生成算式的数量：");
		lblNewLabel.setBounds(10, 48, 151, 40);
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(165, 58, 110, 22);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("确定");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int i = 0; i < Integer.valueOf(textField.getText()) ; i++) {
					Arith ari = new Arith();
					Random r = new Random();
					int Nos = r.nextInt(2) + 1;
					ari.createArith(Nos);
					ari.showArith();
					System.out.println();
				}
			}
		});
		btnNewButton.setBounds(279, 57, 96, 22);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("注意：点击确定后生成相应数量的算式");
		lblNewLabel_1.setBounds(10, 82, 211, 30);
		frame.getContentPane().add(lblNewLabel_1);
		frame.setBounds(100, 100, 533, 339);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
