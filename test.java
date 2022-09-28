package demo01;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import demo01.登录.Arith;

import javax.swing.JButton;

public class test {
	
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
					test window = new test();
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
	public test() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("请输入生成的算式数量：");
		lblNewLabel.setBounds(22, 66, 150, 34);
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(182, 72, 66, 23);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("提交");
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
		btnNewButton.setBounds(273, 72, 93, 23);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("提示：确认提交后将生成相应数量的算式");
		lblNewLabel_1.setBounds(22, 110, 302, 25);
		frame.getContentPane().add(lblNewLabel_1);
	}
}
