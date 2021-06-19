package backend.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import backend.hrms.entities.concretes.SystemUser;

public interface SystemUserDao extends JpaRepository<SystemUser,Integer> {

}
