package backend.hrms.core.utilities.mernisConfirm;

public interface MernisConfirmService {

	boolean checkIdentityNumber(String identityNumber, String firtname, String lastname,String yearOfBirth);
}
