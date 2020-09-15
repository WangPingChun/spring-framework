package test.transaction;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author WangPingChun
 */
@Transactional(propagation = Propagation.REQUIRED)
public interface UserService {
	void save(User user);
}
