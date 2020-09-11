package test.jdbc;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.Types;
import java.util.List;

/**
 * @author WangPingChun
 */
public class UserServiceImpl implements UserService {
	private JdbcTemplate jdbcTemplate;

	public void setDatasource(DataSource datasource) {
		this.jdbcTemplate = new JdbcTemplate(datasource);
	}

	@Override
	public void save(User user) {
		jdbcTemplate.update("insert into user(name,age,sex)values (?,?,?)",
				new Object[]{user.getName(), user.getAge(), user.getSex()},
				new int[]{Types.VARCHAR, Types.INTEGER, Types.VARCHAR});
	}

	@Override
	public List<User> listUsers() {
		return jdbcTemplate.query("select * from user", new UserRowMapper());
	}
}
