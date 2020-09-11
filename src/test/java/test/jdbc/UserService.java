package test.jdbc;

import java.util.List;

/**
 * @author WangPingChun
 */
public interface UserService {
	void save(User user);

	List<User> listUsers();
}
