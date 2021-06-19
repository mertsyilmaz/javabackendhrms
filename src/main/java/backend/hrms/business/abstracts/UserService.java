package backend.hrms.business.abstracts;

import java.util.List;

import backend.hrms.core.utilities.results.DataResult;
import backend.hrms.core.utilities.results.Result;
import backend.hrms.entities.concretes.User;

public interface UserService {

	DataResult<List<User>> getAll();
	
	Result add(User user);
	
	Result userActivation(int userId,String activationCode);
}
