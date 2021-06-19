package backend.hrms.core.utilities.EmailConfirm;

import java.util.UUID;

import org.springframework.stereotype.Service;


@Service
public class EmailConfirmManager implements EmailConfirmService {

	private String activationCode;
	
	@Override
	public String sendEmail(String email, String activationCode) {
		// Burada email göndermek için uygun bir servis kullanılacak
		
		return "Activation code {"+ this.activationCode +"} sent to " + email ;
	}

	@Override
	public String generateActivationCode() {
		UUID uniqueKey = UUID.randomUUID();
		this.activationCode = uniqueKey.toString();
		return this.activationCode;
	}

}
