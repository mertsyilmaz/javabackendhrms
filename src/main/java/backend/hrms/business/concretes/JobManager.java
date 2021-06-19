package backend.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import backend.hrms.business.abstracts.JobService;
import backend.hrms.core.utilities.results.DataResult;
import backend.hrms.core.utilities.results.ErrorResult;
import backend.hrms.core.utilities.results.Result;
import backend.hrms.core.utilities.results.SuccessDataResult;
import backend.hrms.core.utilities.results.SuccessResult;
import backend.hrms.dataAccess.abstracts.JobDao;
import backend.hrms.entities.concretes.Job;

@Service
public class JobManager implements JobService {

	private JobDao jobDao;
	
	@Autowired
	public JobManager(JobDao jobDao) {
		super();
		this.jobDao = jobDao;
	}

	@Override
	public DataResult<List<Job>> getAll() {
		return new SuccessDataResult<List<Job>>(this.jobDao.findAll(),"Jobs listed successfully");
	}

	@Override
	public Result add(Job job) {
		
		if(!this.jobDao.findByName(job.getName()).isEmpty()){
			return new ErrorResult("Jon name is already exists!");
		}
		
		this.jobDao.save(job);
		return new SuccessResult("Jobs added successfully");
	}

}
