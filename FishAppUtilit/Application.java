package FishAppUtilit;
import javax.swing.SwingUtilities;

import fishAppDBUtilit_demo_1_Controllers.CheckDBFrameController;
import fishAppDBUtilit_demo_1_Models.CheckDBFrameModel;
import fishAppUtilitMVC_demo_1_Viewes.CheckDBFrameView;

public class Application {

	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				
				runApp();
			}
		});
		
		

	}

	public static void runApp() {
	
		
		new CheckDBFrameController(new CheckDBFrameView(), new CheckDBFrameModel());
		
	}

}
