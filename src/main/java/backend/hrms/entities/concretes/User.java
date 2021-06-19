package backend.hrms.entities.concretes;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="users")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","systemUser","employee","employer"})
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_id")
	private int userId;
	
	@Column(name="user_email")
	private String email;
	
	@Column(name="user_password")
	private String password;
	
	
	@OneToOne(mappedBy = "user")
	@PrimaryKeyJoinColumn
	private SystemUser systemUser;
	
	@OneToOne(mappedBy = "user",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private Employee employee;
	
	@OneToOne(mappedBy = "user",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private Employer employer;
	
	@OneToOne(mappedBy = "user",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private EmailConfirm emailConfirm;
	
}
