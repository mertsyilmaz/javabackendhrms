package backend.hrms.entities.concretes;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="system_users")
public class SystemUser{
	
	
	@Id
	@Column(name="user_id")
	private int userId;
	
	@Column(name="system_user_firstname")
	private String firstname;
	
	@Column(name="system_user_lastname")
	private String lastname;
	
	@Column(name="system_user_phone_number")
	private String phoneNumber;
	
	
	@OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@MapsId
	@JoinColumn(name="user_id")
	private User user;
	
}
