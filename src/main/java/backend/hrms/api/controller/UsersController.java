package backend.hrms.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import backend.hrms.business.abstracts.UserService;
import backend.hrms.core.utilities.results.DataResult;
import backend.hrms.core.utilities.results.Result;
import backend.hrms.entities.concretes.User;

@RestController
@RequestMapping(value="/api/users/")
public class UsersController {

	private UserService userService;

	@Autowired
	public UsersController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@GetMapping(value="getall")
	public DataResult<List<User>> getAll() {
		return this.userService.getAll();
	}
	
	@PostMapping(value="add")
	public Result add(@RequestBody User user) {
		return this.userService.add(user);
	}
	
	@PostMapping(value="useractivation")
	public Result userActivation(@RequestParam int userId, String activationCode) {
		return this.userService.userActivation(userId, activationCode);
	}
}
