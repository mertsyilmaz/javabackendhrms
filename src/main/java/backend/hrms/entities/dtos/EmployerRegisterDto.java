package backend.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployerRegisterDto {

	private String email;
	
	private String password;
	
	private String passwordConfirm;
	
	private String companyName;
	
	private String phoneNumber;
	
	private String websiteUrl;
	
}
