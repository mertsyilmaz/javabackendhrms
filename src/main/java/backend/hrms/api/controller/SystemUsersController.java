package backend.hrms.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import backend.hrms.business.abstracts.SystemUserService;
import backend.hrms.core.utilities.results.DataResult;
import backend.hrms.core.utilities.results.Result;
import backend.hrms.entities.concretes.SystemUser;
import backend.hrms.entities.dtos.SystemUserRegisterDto;

@RestController
@RequestMapping(value="/api/systemusers/")
public class SystemUsersController {

	private SystemUserService systemUserService;

	@Autowired
	public SystemUsersController(SystemUserService systemUserService) {
		super();
		this.systemUserService = systemUserService;
	}
	
	@GetMapping(value="getall")
	public DataResult<List<SystemUser>> getAll() {
		return this.systemUserService.getAll();
	}
	
	@PostMapping(value="add")
	public Result add(@RequestBody SystemUserRegisterDto systemUserRegisterDto) {
		return this.systemUserService.add(systemUserRegisterDto);
	}
	
	@PostMapping(value="employeractivation")
	public Result employerActivation(@RequestParam int employerId) {
		return this.systemUserService.employerActivation(employerId);
	}
}
