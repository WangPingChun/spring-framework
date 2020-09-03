package test.bean;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author WangPingChun
 */
public class DatePropertyEditor extends PropertyEditorSupport {
	private String format = "yyyy-MM-dd";

	public void setFormat(String format) {
		this.format = format;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		System.out.println("text: " + text);
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		try {
			final Date date = sdf.parse(text);
			this.setValue(date);
		}
		catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
