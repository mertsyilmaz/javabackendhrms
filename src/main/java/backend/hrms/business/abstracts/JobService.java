package backend.hrms.business.abstracts;

import java.util.List;

import backend.hrms.entities.concretes.Job;

public interface JobService {

	List<Job> getAll();
}
