package backend.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import backend.hrms.entities.concretes.Job;

public interface JobDao  extends JpaRepository<Job,Integer>{

}
