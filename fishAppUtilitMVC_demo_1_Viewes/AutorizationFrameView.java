package fishAppUtilitMVC_demo_1_Viewes;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class AutorizationFrameView extends JFrame {
	
	
	private static final long serialVersionUID = 1L;
	private JLayeredPane layeredPane;
	private JButton autorization;
	private JButton registration;
	private JLabel lblNewLabel;
	private JTextField login;
	private JTextField password;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JButton btnNewButton_2;

	public AutorizationFrameView() {
		
		initialize();
	}
	
	private void initialize() {
		
		setResizable(false);
		setTitle("Окно входа");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Dell\\workspace\\LogisticUtilit\\fish_2.jpg"));
		setBounds(100, 100, 624, 440);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 794, 572);
		getContentPane().add(layeredPane);
		
		registration = new JButton("\u0410\u0432\u0442\u043E\u0440\u0438\u0437\u0430\u0446\u0438\u044F");
		registration.setBounds(508, 148, 111, 23);
		layeredPane.add(registration,new Integer(2));
		
		autorization = new JButton("\u0420\u0435\u0433\u0438\u0441\u0442\u0440\u0430\u0446\u0438\u044F");
		autorization.setBounds(645, 148, 110, 23);
		layeredPane.add(autorization,new Integer(2));
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Dell\\workspace\\LogisticUtilit\\fish_2.jpg"));
		lblNewLabel.setBounds(0, 0, 794, 571);
		layeredPane.add(lblNewLabel);
		
		login = new JTextField();
		login.setBounds(614, 42, 141, 20);
		layeredPane.add(login,new Integer(2));
		login.setColumns(10);
		
		password = new JTextField();
		password.setBounds(616, 100, 139, 20);
		layeredPane.add(password,new Integer(2));
		password.setColumns(10);
		
		lblNewLabel_1 = new JLabel("\u0412\u0432\u0435\u0434\u0438\u0442\u0435 \u043B\u043E\u0433\u0438\u043D");
		lblNewLabel_1.setBackground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Comic Sans MS", Font.ITALIC, 12));
		lblNewLabel_1.setForeground(Color.DARK_GRAY);
		lblNewLabel_1.setBounds(614, 17, 141, 14);
		layeredPane.add(lblNewLabel_1, new Integer(2));
		
		lblNewLabel_2 = new JLabel("\u0412\u0432\u0435\u0434\u0438\u0442\u0435 \u043F\u0430\u0440\u043E\u043B\u044C");
		lblNewLabel_2.setBackground(Color.WHITE);
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2.setFont(new Font("Comic Sans MS", Font.ITALIC, 12));
		lblNewLabel_2.setBounds(614, 73, 141, 14);
		layeredPane.add(lblNewLabel_2, new Integer(2));
		
		btnNewButton_2 = new JButton("\u0412\u044B\u0431\u0440\u0430\u0442\u044C \u0434\u0440\u0443\u0433\u0443\u044E \u0431\u0430\u0437\u0443");
		btnNewButton_2.setBounds(555, 214, 170, 23);
		layeredPane.add(btnNewButton_2,new Integer(2));
		setSize(800, 600);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
   public void addAutorizationListener(ActionListener listenForAutorizationButton){
		
		autorization.addActionListener(listenForAutorizationButton);
	}
   
   public String getLogin(){
	   
	   return login.getText();
   }
   
   public String getPassword(){
	   return password.getText();
   }
   
   public void clearTextField(){
	   login.setText(null);
	   password.setText(null);   
   }
}