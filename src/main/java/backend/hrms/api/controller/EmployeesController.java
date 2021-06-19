package backend.hrms.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import backend.hrms.business.abstracts.EmployeeService;
import backend.hrms.core.utilities.results.DataResult;
import backend.hrms.core.utilities.results.Result;
import backend.hrms.entities.concretes.Employee;
import backend.hrms.entities.dtos.EmployeeRegisterDto;

@RestController
@RequestMapping(value="/api/employees/")
public class EmployeesController {
	
	private EmployeeService employeeService;

	@Autowired
	public EmployeesController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	
	@GetMapping(value="getall")
	public DataResult<List<Employee>> getAll() {
		return this.employeeService.getAll();
	}

	@PostMapping(value="add")
	public Result add(@RequestBody EmployeeRegisterDto employeeRegisterDto) {
		return this.employeeService.add(employeeRegisterDto);
	}
}
