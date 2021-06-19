package backend.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import backend.hrms.business.abstracts.UserService;
import backend.hrms.core.utilities.results.DataResult;
import backend.hrms.core.utilities.results.ErrorResult;
import backend.hrms.core.utilities.results.Result;
import backend.hrms.core.utilities.results.SuccessDataResult;
import backend.hrms.core.utilities.results.SuccessResult;
import backend.hrms.dataAccess.abstracts.UserDao;
import backend.hrms.entities.concretes.User;

@Service
public class UserManager implements UserService {

	private UserDao userDao;

	@Autowired
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public DataResult<List<User>> getAll() {
		return new SuccessDataResult<List<User>>(this.userDao.findAll(),"Users listed successfully");
	}

	@Override
	public Result add(User user) {
		this.userDao.save(user);
		return new SuccessResult("User added successfully");
	}

	@Override
	public Result userActivation(int userId, String activationCode) {
		User  user = this.userDao.getById(userId);
		
		if(user == null) {
			return new ErrorResult("User not found!");
		}
		
		if(!user.getEmailConfirm().getActivationCode().equals(activationCode)) {
			return new ErrorResult("Wrong activation code!");
		}

		user.getEmailConfirm().setConfirmed(true);
		this.userDao.save(user);
		return new SuccessResult("User activated successfully");
	}
}
