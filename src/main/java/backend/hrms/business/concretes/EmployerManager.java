package backend.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import backend.hrms.business.abstracts.EmployerService;
import backend.hrms.core.utilities.EmailConfirm.EmailConfirmService;
import backend.hrms.core.utilities.results.DataResult;
import backend.hrms.core.utilities.results.ErrorResult;
import backend.hrms.core.utilities.results.Result;
import backend.hrms.core.utilities.results.SuccessDataResult;
import backend.hrms.core.utilities.results.SuccessResult;
import backend.hrms.dataAccess.abstracts.EmployerDao;
import backend.hrms.entities.concretes.EmailConfirm;
import backend.hrms.entities.concretes.Employer;
import backend.hrms.entities.concretes.SystemUserConfirm;
import backend.hrms.entities.concretes.User;
import backend.hrms.entities.dtos.EmployerRegisterDto;

@Service
public class EmployerManager implements EmployerService{
	
	private EmployerDao employeeDao;
	private EmailConfirmService emailConfirmService;

	@Autowired
	public EmployerManager(EmployerDao employeeDao,EmailConfirmService emailConfirmService) {
		super();
		this.employeeDao = employeeDao;
		this.emailConfirmService = emailConfirmService;
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.employeeDao.findAll(), "Employers listed successfully");
	}

	@Override
	public Result add(EmployerRegisterDto employerRegisterDto) {
		
		if(!employerRegisterDto.getPassword().equals(employerRegisterDto.getPasswordConfirm())) {
			return new ErrorResult("Not match password!");
		}
		
		// www.google.com
		String websiteDomain = employerRegisterDto.getWebsiteUrl().split("\\.",2)[1];
		
		// abc@google.com
		String emailDomain = employerRegisterDto.getEmail().split("\\@",2)[1];
		
		if(!websiteDomain.equals(emailDomain)) {
			return new ErrorResult("Not match domain!");
		}
		
		if(!this.employeeDao.findByUserEmail(employerRegisterDto.getEmail()).isEmpty()) {
			return new ErrorResult("Email already exists");
		}
		
		EmailConfirm emailConfirm = new EmailConfirm();
		String activationCode = this.emailConfirmService.generateActivationCode();
		emailConfirm.setActivationCode(activationCode);
		emailConfirm.setConfirmed(false);
		
		SystemUserConfirm systemUserConfirm = new SystemUserConfirm();
		systemUserConfirm.setConfirmed(false);
		
		User user = new User();
		user.setEmail(employerRegisterDto.getEmail());
		user.setPassword(employerRegisterDto.getPassword());
		
		Employer employer = new Employer();
		employer.setCompanyName(employerRegisterDto.getCompanyName());
		employer.setPhoneNumber(employerRegisterDto.getPhoneNumber());
		employer.setWebsiteUrl(employerRegisterDto.getWebsiteUrl());
		
		systemUserConfirm.setEmployer(employer);
		employer.setSystemUserConfirm(systemUserConfirm);
		user.setEmailConfirm(emailConfirm);
		emailConfirm.setUser(user);
		employer.setUser(user);
		
		this.employeeDao.save(employer);
		String result = this.emailConfirmService.sendEmail(employerRegisterDto.getEmail(), activationCode);
		return new SuccessResult(result);
	}
}
