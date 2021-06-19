package backend.hrms.business.abstracts;

import java.util.List;

import backend.hrms.core.utilities.results.DataResult;
import backend.hrms.core.utilities.results.Result;
import backend.hrms.entities.concretes.Employer;
import backend.hrms.entities.dtos.EmployerRegisterDto;

public interface EmployerService {

	DataResult<List<Employer>> getAll();
	
	Result add(EmployerRegisterDto employerRegisterDto);
}
