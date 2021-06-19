package backend.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import backend.hrms.entities.concretes.User;

public interface UserDao extends JpaRepository<User,Integer>{

	User findByEmailAndEmailConfirmActivationCode(String email, String activationCode);
}
