package test.bean;

import java.util.Date;

/**
 * @author WangPingChun
 */
public class UserManager {
	private Date dateValue;

	public Date getDateValue() {
		return dateValue;
	}

	public void setDateValue(Date dateValue) {
		this.dateValue = dateValue;
	}

	@Override
	public String toString() {
		return "UserManager{" +
				"dateValue=" + dateValue +
				'}';
	}
}
