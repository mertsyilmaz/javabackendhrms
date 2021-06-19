package backend.hrms.core.utilities.EmailConfirm;

public interface EmailConfirmService {

	String sendEmail(String email, String activationCode);
	
	String generateActivationCode();
	
}
