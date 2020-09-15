package test.transaction;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.Types;

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

		// 事务测试，加上这句代码及测试数据不会保存到数据库中
		throw new RuntimeException("aa");
	}
}
