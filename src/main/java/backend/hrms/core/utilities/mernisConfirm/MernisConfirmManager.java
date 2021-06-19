package backend.hrms.core.utilities.mernisConfirm;

import org.springframework.stereotype.Service;

@Service
public class MernisConfirmManager implements MernisConfirmService{

	@Override
	public boolean checkIdentityNumber(String identityNumber, String firtname, String lastname, String yearOfBirth) {
		// Burada tc doğrulamak için uygun bir servis kullanılacak
		if(identityNumber.length() == 11) {
			return true;
		}
		else {
			return false;
		}
	}

}
