package backend.hrms.business.abstracts;

import java.util.List;

import backend.hrms.core.utilities.results.DataResult;
import backend.hrms.core.utilities.results.Result;
import backend.hrms.entities.concretes.SystemUser;
import backend.hrms.entities.dtos.SystemUserRegisterDto;

public interface SystemUserService {

	DataResult<List<SystemUser>> getAll();
	
	Result add(SystemUserRegisterDto systemUserRegisterDto);
	
	Result employerActivation(int employerId);
}
