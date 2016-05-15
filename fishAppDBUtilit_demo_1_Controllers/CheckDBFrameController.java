package fishAppDBUtilit_demo_1_Controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import fishAppDBUtilit_demo_1_Models.AutorizationFrameModel;
import fishAppDBUtilit_demo_1_Models.CheckDBFrameModel;
import fishAppSql.SqlConnectSingleton;
import fishAppUtilitMVC_demo_1_Viewes.AutorizationFrameView;
import fishAppUtilitMVC_demo_1_Viewes.CheckDBFrameView;

public class CheckDBFrameController {

	private CheckDBFrameView view;
	private CheckDBFrameModel model;
	private final static Connection connection = SqlConnectSingleton.getInstance().getConnection();

	public CheckDBFrameController(CheckDBFrameView view, CheckDBFrameModel model) {
		this.view = view;
		this.model = model;
		addListDBForm();
		view.addConnectDBListener(new ConnectListener());
	}

	private void addListDBForm() {
		
		for (String item : model.getListDB()) {	
			view.getCombobox().addItem(item);
		}
	}

	class ConnectListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			try {
				connection.setCatalog((String) view.getCombobox().getSelectedItem());
				new AutorizationFrameController(new AutorizationFrameView(), new AutorizationFrameModel());
				view.setVisible(false);
			} catch (SQLException e1) {

				System.out.println("Не завелось!!!");
			}
			
		}

	}

}