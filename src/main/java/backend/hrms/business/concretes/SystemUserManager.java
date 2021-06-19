package backend.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import backend.hrms.business.abstracts.SystemUserService;
import backend.hrms.core.utilities.results.DataResult;
import backend.hrms.core.utilities.results.ErrorResult;
import backend.hrms.core.utilities.results.Result;
import backend.hrms.core.utilities.results.SuccessDataResult;
import backend.hrms.core.utilities.results.SuccessResult;
import backend.hrms.dataAccess.abstracts.EmployerDao;
import backend.hrms.dataAccess.abstracts.SystemUserDao;
import backend.hrms.entities.concretes.Employer;
import backend.hrms.entities.concretes.SystemUser;
import backend.hrms.entities.concretes.User;
import backend.hrms.entities.dtos.SystemUserRegisterDto;

@Service
public class SystemUserManager implements SystemUserService {

	private SystemUserDao systemUserDao;
	private EmployerDao employerDao;

	@Autowired
	public SystemUserManager(SystemUserDao systemUserDao,EmployerDao employerDao) {
		super();
		this.systemUserDao = systemUserDao;
		this.employerDao = employerDao;
	}

	@Override
	public DataResult<List<SystemUser>> getAll() {
		
		return new SuccessDataResult<List<SystemUser>>(this.systemUserDao.findAll(),"System Users listed successfully");
	}

	@Override
	public Result add(SystemUserRegisterDto systemUserregisterDto) {
		
		if(!systemUserregisterDto.getPassword().equals(systemUserregisterDto.getPasswordConfirm())) {
			return new ErrorResult("Not match password!");
		}
			
		
		User user = new User();
		user.setEmail(systemUserregisterDto.getEmail());
		user.setPassword(systemUserregisterDto.getPassword());
		
		SystemUser systemUser = new SystemUser();
		systemUser.setFirstname(systemUserregisterDto.getFirstname());
		systemUser.setLastname(systemUserregisterDto.getLastname());
		systemUser.setPhoneNumber(systemUserregisterDto.getPhoneNumber());
		systemUser.setUser(user);
		
		
		this.systemUserDao.save(systemUser);
		return new SuccessResult("System User added successfully");
	}

	@Override
	public Result employerActivation(int employerId) {
		
		Employer employer = this.employerDao.getById(employerId);
		
		if(employer == null) {
			return new ErrorResult("Employer not found!");
		}
		
		employer.getSystemUserConfirm().setConfirmed(true);
		this.employerDao.save(employer);
		return new SuccessResult("Employer activated successfully");
	}

}
