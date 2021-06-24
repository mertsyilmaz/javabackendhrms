package backend.hrms.business.abstracts;

import java.util.List;

import backend.hrms.core.utilities.results.DataResult;
import backend.hrms.core.utilities.results.Result;
import backend.hrms.entities.concretes.Employee;
import backend.hrms.entities.dtos.EmployeeRegisterDto;

public interface EmployeeService {

	DataResult<List<Employee>> getAll();
	
	Result add(EmployeeRegisterDto employeeRegisterDto);
	
	DataResult<Employee> getById(int employeeId);
}
