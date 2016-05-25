package fishAppDBUtilit_demo_1_Controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import FishAppUtilit.RegularExp;
import fishAppDBUtilit_demo_1_Models.AutorizationFrameModel;
import fishAppDBUtilit_demo_1_Models.RegistrationFrameModel;
import fishAppUtilitMVC_demo_1_Viewes.AutorizationFrameView;
import fishAppUtilitMVC_demo_1_Viewes.RegistrationFrameView;

public class RegistrationFrameController {

	private RegistrationFrameView view;
	private RegistrationFrameModel model;
	private final String clientInfoError = "���� ������ ������� ����. ����������� �� ����:2-20 ��������";
	private LinkedHashMap<JTextField, JLabel> map = new LinkedHashMap<JTextField, JLabel>();
	private RegularExp regExp = new RegularExp();

	public RegistrationFrameController(final RegistrationFrameView view, RegistrationFrameModel model) {

		this.view = view;
		this.model = model;
		view.addRegistrationDBListener(new RegistrationListener());
		
		view.addHomeBackListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				view.setVisible(false);
				new AutorizationFrameController(new AutorizationFrameView(), new AutorizationFrameModel());
			}
		});
	}

	class RegistrationListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			clearAllJlabel();
			map.put(view.getSurname(), view.getLabel5());
			map.put(view.getNameUser(), view.getLabel6());
			map.put(view.getPatronymic(), view.getLabel7());
			map.put(view.getDataBirth(), view.getLabel8());
			map.put(view.getAddress(), view.getLabel9());

			for (Entry<JTextField, JLabel> entry : map.entrySet()) {
				if (model.isEmptyDataUser(entry.getKey().getText())) {
					notification((JLabel) entry.getValue());
					return;
				}
			}

			if (!regExp.validateDataClient(view.getSurname().getText())) {
				System.out.println(regExp.validateDataClient(view.getSurname().getText()));
				view.getLabel5().setText(clientInfoError);
				return;
			}
			if (!regExp.validateDataClient(view.getNameUser().getText())) {
				view.getLabel6().setText(clientInfoError);
				return;
			}

			if (!regExp.validateDataClient(view.getPatronymic().getText())) {
				view.getLabel7().setText(clientInfoError);
				return;
			}
			if (!regExp.validateDataOfBirth(view.getDataBirth().getText())) {
				view.getLabel8().setText("���� ������� �����������");
				return;
			}

			if (!model.checkAge(view.getDataBirth().getText())) {
				view.getLabel8().setText("�� �� ��������� ����,������� ������� ����� 60 ��� ����� 20 ���");
				return;
			}

			if (!regExp.validateAddress(view.getAddress().getText())) {
				view.getLabel8().setText("������������ ���� ������!!");
			}
			try {
				model.registationUser(view.getSurname().getText(), view.getNameUser().getText(),
						view.getPatronymic().getText(), view.getDataBirth().getText(), view.getAddress().getText());
			} catch (SQLException e1) {

				JOptionPane.showMessageDialog(view, "���������� � ������������ ��� ������� ��������",
						"������ ��� �����������", JOptionPane.ERROR_MESSAGE);
				return;
			}

			JOptionPane.showMessageDialog(view, "�������� �� ������ '��������� � ���� �����' ��� �����������",
					"�������� �����������", JOptionPane.INFORMATION_MESSAGE);

		}

	}

	private void clearAllJlabel() {

		for (JLabel value : map.values()) {
			if (!value.getText().equals("")) {
				value.setText("");
			}
		}
		map.clear();
	}

	private void notification(JLabel label) {

		label.setText("���� ����������� ��� ����������!!");
	}
}