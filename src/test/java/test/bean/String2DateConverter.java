package test.bean;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

/**
 * @author WangPingChun
 */
public class String2DateConverter implements Converter<String, Date> {
	@Override
	public Date convert(String source) {
		try {
			return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(source);
		}
		catch (ParseException e) {
			return null;
		}
	}
}
