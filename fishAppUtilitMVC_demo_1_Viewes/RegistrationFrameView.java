package fishAppUtilitMVC_demo_1_Viewes;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class RegistrationFrameView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField surnameTextField;
	private JTextField nameTextField;
	private JTextField patronymicTextField;
	private JTextField dataBirthTextField;
	private JTextField addresstextField;
	private JButton registrationButton;
	private JButton homeButton;
	private JLabel label_5;
	private JLabel label_6;
	private JLabel label_7;
	private JLabel label_8;
	private JLabel label_9;

	public RegistrationFrameView() {
		initialize();
	}

	private void initialize() {

		setTitle("Окно регистрации");
		setAutoRequestFocus(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Dell\\workspace\\LogisticUtilit\\fish_2.jpg"));
		getContentPane().setLayout(null);
		surnameTextField = new JTextField();
		surnameTextField.setBounds(35, 47, 225, 20);
		getContentPane().add(surnameTextField);
		surnameTextField.setColumns(10);

		JLabel surnameLabel = new JLabel("\u0412\u0430\u0448\u0430 \u0424\u0430\u043C\u0438\u043B\u0438\u044F");
		surnameLabel.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		surnameLabel.setBounds(35, 22, 145, 14);
		getContentPane().add(surnameLabel);

		JLabel nameLabel = new JLabel("\u0412\u0430\u0448\u0435 \u0418\u043C\u044F");
		nameLabel.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		nameLabel.setBounds(35, 85, 107, 14);
		getContentPane().add(nameLabel);

		nameTextField = new JTextField();
		nameTextField.setColumns(10);
		nameTextField.setBounds(35, 110, 225, 20);
		getContentPane().add(nameTextField);

		JLabel patronymicLabel = new JLabel(
				"\u0412\u0430\u0448\u0430 \u041E\u0442\u0447\u0435\u0441\u0442\u0432\u043E");
		patronymicLabel.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		patronymicLabel.setBounds(35, 141, 107, 14);
		getContentPane().add(patronymicLabel);

		patronymicTextField = new JTextField();
		patronymicTextField.setColumns(10);
		patronymicTextField.setBounds(35, 166, 225, 20);
		getContentPane().add(patronymicTextField);

		JLabel dataBirthLabel = new JLabel(
				"\u0414\u0430\u0442\u0430 \u0420\u043E\u0436\u0434\u0435\u043D\u0438\u044F (\u0424\u043E\u0440\u043C\u0430\u0442 \u0432\u0432\u043E\u0434\u0430: \u0434\u0434/\u043C\u043C/\u0433\u0433\u0433\u0433)");
		dataBirthLabel.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		dataBirthLabel.setBounds(35, 197, 282, 14);
		getContentPane().add(dataBirthLabel);

		dataBirthTextField = new JTextField();
		dataBirthTextField.setColumns(10);
		dataBirthTextField.setBounds(35, 222, 225, 20);
		getContentPane().add(dataBirthTextField);

		JLabel addressLabel = new JLabel(
				"\u0410\u0434\u0440\u0435\u0441 \u041F\u0440\u043E\u0436\u0438\u0432\u0430\u043D\u0438\u044F");
		addressLabel.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		addressLabel.setBounds(35, 253, 145, 14);
		getContentPane().add(addressLabel);

		addresstextField = new JTextField();
		addresstextField.setColumns(10);
		addresstextField.setBounds(35, 278, 225, 20);
		getContentPane().add(addresstextField);

		registrationButton = new JButton(
				"\u0417\u0430\u0440\u0435\u0433\u0438\u0441\u0442\u0440\u0438\u0440\u043E\u0432\u0430\u0442\u044C\u0441\u044F");
		registrationButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
		registrationButton.setBounds(288, 483, 155, 23);
		getContentPane().add(registrationButton);

		homeButton = new JButton(
				"\u0412\u0435\u0440\u043D\u0443\u0442\u044C\u0441\u044F \u0432 \u043E\u043A\u043D\u043E \u0432\u0445\u043E\u0434\u0430");
		homeButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
		homeButton.setBounds(475, 483, 168, 23);
		getContentPane().add(homeButton);

		label_5 = new JLabel("");
		label_5.setForeground(Color.RED);
		label_5.setBounds(270, 50, 404, 14);
		getContentPane().add(label_5);

		label_6 = new JLabel("");
		label_6.setForeground(Color.RED);
		label_6.setBounds(270, 110, 404, 14);
		getContentPane().add(label_6);

		label_7 = new JLabel("");
		label_7.setForeground(Color.RED);
		label_7.setBounds(270, 169, 404, 14);
		getContentPane().add(label_7);

		label_8 = new JLabel("");
		label_8.setForeground(Color.RED);
		label_8.setBounds(270, 222, 404, 14);
		getContentPane().add(label_8);

		label_9 = new JLabel("");
		label_9.setForeground(Color.RED);
		label_9.setBounds(270, 281, 404, 14);
		getContentPane().add(label_9);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setSize(800, 600);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);

	}

	public JTextField getSurname() {

		return surnameTextField;
	}

	public JTextField getNameUser() {

		return nameTextField;
	}

	public JTextField getPatronymic() {

		return patronymicTextField;
	}

	public JTextField getAddress() {

		return addresstextField;
	}

	public JTextField getDataBirth() {

		return dataBirthTextField;
	}

	public JLabel getLabel5() {

		return label_5;
	}

	public JLabel getLabel6() {

		return label_6;
	}

	public JLabel getLabel7() {

		return label_7;
	}

	public JLabel getLabel8() {

		return label_8;
	}

	public JLabel getLabel9() {

		return label_9;
	}

	public void addRegistrationDBListener(ActionListener listenForRegitrationButton) {

		registrationButton.addActionListener(listenForRegitrationButton);
	}

	public void addHomeBackListener(ActionListener listenForHomeBackButton) {

		homeButton.addActionListener(listenForHomeBackButton);
	}

}