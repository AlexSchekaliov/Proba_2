package FishAppUtilit;

import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExp {

	Pattern p;
	Matcher m;

	public boolean validatePassword(String text) {
		p = Pattern.compile("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?!.*\\s).*$");
		m = p.matcher(text);
		return m.matches();
	}

	public boolean validateLogin(String text) {
		p = Pattern.compile("^[a-zA-Z][a-zA-Z0-9-_\\.]{1,20}$");
		m = p.matcher(text);
		return m.matches();
	}

	public boolean validateAddress(String text) {
		p = Pattern.compile("^[à-ÿ¸À-ß¨0-9., ]+$");
		m = p.matcher(text);
		return m.matches();
	}

	public boolean validateDataOfBirth(String dataofBirth) {
		p = Pattern.compile("(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((19|20)\\d\\d)");
		m = p.matcher(dataofBirth);
		if (!m.matches()) {
			return false;
		}
		if (Integer.parseInt(dataofBirth.split("/")[2]) > Calendar.getInstance().get(Calendar.YEAR)) {
			return false;
		}
		return true;
	}

	public boolean validateDataClient(String text) {
		Pattern p = Pattern.compile("^[à-ÿ¸À-ß¨]{5,20}+$");
		Matcher m = p.matcher(text);
		return m.matches();
	}
}