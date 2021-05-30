import javax.swing.*;
import java.awt.Font;
//import java.awt.borderLayot;



public class GuessGame extends JFrame {
	private JTextField textField;
	public GuessGame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("\u0423\u0433\u0430\u0434\u0430\u0439 \u0447\u0438\u0441\u043B\u043E");
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Dmitry's Hi Lo Guessing Game");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(106, 10, 234, 15);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u0412\u0435\u0434\u0438\u0442\u0435 \u0447\u0438\u0441\u043B\u043E \u043E\u0442 1 \u0434\u043E 100:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(8, 35, 220, 35);
		getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(236, 36, 81, 35);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(275, 47, 42, 13);
		getContentPane().add(lblNewLabel_2);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
