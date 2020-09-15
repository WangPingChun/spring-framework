package test.transaction;

import org.springframework.jdbc.core.RowMapper;
import test.jdbc.User;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author WangPingChun
 */
public class UserRowMapper implements RowMapper<test.jdbc.User> {
	@Override
	public test.jdbc.User mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new User(rs.getInt("id"), rs.getString("name"), rs.getInt("age"), rs.getString("sex"));
	}
}
