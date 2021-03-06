package backend.hrms.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import backend.hrms.business.abstracts.JobService;
import backend.hrms.core.utilities.results.DataResult;
import backend.hrms.core.utilities.results.Result;
import backend.hrms.entities.concretes.Job;

@RestController
@RequestMapping(value="/api/jobs/")
public class JobsController {
	
	private JobService jobService;

	@Autowired
	public JobsController(JobService jobService) {
		super();
		this.jobService = jobService;
	}
	
	@GetMapping(value="getall")
	public DataResult<List<Job>> getAll() {
		return this.jobService.getAll();
	}

	@PostMapping(value="add")
	public Result add(@RequestBody Job job) {
		return this.jobService.add(job);
	}
}
