package backend.hrms.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import backend.hrms.business.abstracts.EmployerService;
import backend.hrms.core.utilities.results.DataResult;
import backend.hrms.core.utilities.results.Result;
import backend.hrms.entities.concretes.Employer;
import backend.hrms.entities.dtos.EmployerRegisterDto;

@RestController
@RequestMapping(value="/api/employers/")
public class EmployersController {

	private EmployerService employerService;
	
	@Autowired
	public EmployersController(EmployerService employerService) {
		super();
		this.employerService = employerService;
	}

	@GetMapping(value="getall")
	public DataResult<List<Employer>> getAll() {
		return this.employerService.getAll();
	}
	
	@PostMapping(value="add")
	public Result add(@RequestBody EmployerRegisterDto employerRegisterDto) {
		return this.employerService.add(employerRegisterDto);
	}
}
