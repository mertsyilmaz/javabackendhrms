package backend.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import backend.hrms.entities.concretes.Employee;

public interface EmployeeDao extends JpaRepository<Employee,Integer>{
	
	List<Employee> findByUserEmail(String email);
	
	//List<Employee> findByUserEmailConfirmConfirmedEquals(boolean confirmed);
}
