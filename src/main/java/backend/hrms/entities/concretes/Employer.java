package backend.hrms.entities.concretes;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="employers")
public class Employer {
	
	@Id
	@Column(name="user_id")
	private int userId;
	
	@Column(name="employer_company_name")
	private String companyName;
	
	@Column(name="employer_website_url")
	private String websiteUrl;
	
	@Column(name="employer_phone_number")
	private String phoneNumber;

	@OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@MapsId
	@JoinColumn(name="user_id")
	private User user;
	
	@OneToOne(mappedBy = "employer",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private SystemUserConfirm systemUserConfirm;
	
}
