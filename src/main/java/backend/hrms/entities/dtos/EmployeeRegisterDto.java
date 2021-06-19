package backend.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeRegisterDto {

	private String email;
	
	private String password;
	
	private String passwordConfirm;
	
	private String identityNumber;
	
	private String firstname;
	
	private String lastname;
	
	private String yearOfBirth;
	
}
