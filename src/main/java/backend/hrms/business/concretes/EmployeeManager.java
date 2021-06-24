package backend.hrms.business.concretes;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import backend.hrms.business.abstracts.EmployeeService;
import backend.hrms.core.utilities.EmailConfirm.EmailConfirmService;
import backend.hrms.core.utilities.mernisConfirm.MernisConfirmService;
import backend.hrms.core.utilities.results.DataResult;
import backend.hrms.core.utilities.results.ErrorResult;
import backend.hrms.core.utilities.results.Result;
import backend.hrms.core.utilities.results.SuccessDataResult;
import backend.hrms.core.utilities.results.SuccessResult;
import backend.hrms.dataAccess.abstracts.EmployeeDao;
import backend.hrms.entities.concretes.EmailConfirm;
import backend.hrms.entities.concretes.Employee;
import backend.hrms.entities.concretes.User;
import backend.hrms.entities.dtos.EmployeeRegisterDto;

@Service
public class EmployeeManager implements EmployeeService{
	
	private EmployeeDao employeeDao;
	private MernisConfirmService mernisConfirmService;
	private EmailConfirmService emailConfirmService;

	@Autowired
	public EmployeeManager(EmployeeDao employeeDao,MernisConfirmService mernisConfirmService,EmailConfirmService emailConfirmService) {
		super();
		this.employeeDao = employeeDao;
		this.mernisConfirmService = mernisConfirmService;
		this.emailConfirmService = emailConfirmService;
	}

	@Override
	public DataResult<List<Employee>> getAll() {
		return new SuccessDataResult<List<Employee>>(
				this.employeeDao.findAll()
				,"Employees listed successfully");
	}

	@Override
	public Result add(EmployeeRegisterDto employeeRegisterDto) {
		
		if(!employeeRegisterDto.getPassword().equals(employeeRegisterDto.getPasswordConfirm())) {
			return new ErrorResult("Not match password!");
		}
		
		if(!this.mernisConfirmService.checkIdentityNumber(employeeRegisterDto.getIdentityNumber(), 
				employeeRegisterDto.getFirstname(), employeeRegisterDto.getLastname(), 
				employeeRegisterDto.getYearOfBirth())) {
			return new ErrorResult("Identity Number is not correct!");
		}
		
		if(!this.employeeDao.findByUserEmail(employeeRegisterDto.getEmail()).isEmpty()) {
			return new ErrorResult("Email already exists");
		}
		
		EmailConfirm emailConfirm = new EmailConfirm();
		String activationCode = this.emailConfirmService.generateActivationCode();
		emailConfirm.setActivationCode(activationCode);
		emailConfirm.setConfirmed(false);
		
		User user = new User();
		user.setEmail(employeeRegisterDto.getEmail());
		user.setPassword(employeeRegisterDto.getPassword());
		
		Employee employee = new Employee();
		employee.setFirstname(employeeRegisterDto.getFirstname());
		employee.setLastname(employeeRegisterDto.getLastname());
		employee.setYearOfBirth(employeeRegisterDto.getYearOfBirth());
		employee.setIdentityNumber(employeeRegisterDto.getIdentityNumber());
		
		user.setEmailConfirm(emailConfirm);
		emailConfirm.setUser(user);
		employee.setUser(user);
		
		this.employeeDao.save(employee);
		
		String result = this.emailConfirmService.sendEmail(employeeRegisterDto.getEmail(), activationCode);
		return new SuccessResult(result);
	}

	@Override
	public DataResult<Employee> getById(int employeeId) {
		
		return new SuccessDataResult<Employee>(this.employeeDao.findById(employeeId).get(),
				"Employee listed successfully");
	}

}
