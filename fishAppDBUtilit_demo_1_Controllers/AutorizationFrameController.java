package fishAppDBUtilit_demo_1_Controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import fishAppDBUtilit_demo_1_Models.AutorizationFrameModel;
import fishAppUtilitMVC_demo_1_Viewes.AutorizationFrameView;
import fishAppDBUtilit_demo_1_Models.CheckDBFrameModel;
import fishAppDBUtilit_demo_1_Models.RegistrationFrameModel;
import fishAppUtilitMVC_demo_1_Viewes.CheckDBFrameView;
import fishAppUtilitMVC_demo_1_Viewes.RegistrationFrameView;






public class AutorizationFrameController {

	private AutorizationFrameView view;
	private AutorizationFrameModel model;
	private final static String CAPTAIN="капитан";
	private final static String ADMIN="администратор";
	
	

	public AutorizationFrameController(final AutorizationFrameView view, AutorizationFrameModel model) {
	
		this.view=view;
		this.model=model;
		view.addAutorizationListener(new AutorizationListener());
		view.addTransitionRegistrationListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				view.setVisible(false);
				new RegistrationFrameController(new RegistrationFrameView(), new RegistrationFrameModel());
			}
		});
	}
	
	class AutorizationListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(view.getLogin().equals("")||view.getPassword().equals("")){
				JOptionPane.showMessageDialog(view, "Введите Логин или пароль!!", "Предупреждение", JOptionPane.WARNING_MESSAGE);
				return;
			}
			
			try {
				switch (model.autorizationInformation(view.getLogin(),view.getPassword()).get(1).toLowerCase()) {
				case CAPTAIN:
				    view.setVisible(false);
				    new CheckDBFrameController(new CheckDBFrameView(), new CheckDBFrameModel()); 
					break;
				case ADMIN:
				    view.setVisible(false);
				  
					break;	
				default:
					JOptionPane.showMessageDialog(view, "Что-то пошло не так"+'\n'+"Мы уже выехали за разработчиком=))", 
							"Критическая ошибка", JOptionPane.ERROR_MESSAGE);
					break;
				}
			} catch (SQLException e1) {
				
				JOptionPane.showMessageDialog(view, "Логин или пароль введены некорректно."+'\n'+"Пожалуйста,повторите попытку или зарегистрируйтесь.", 
						"Предупреждение", JOptionPane.WARNING_MESSAGE);
				view.clearTextField();
				return;		
			}
		}
	}
}