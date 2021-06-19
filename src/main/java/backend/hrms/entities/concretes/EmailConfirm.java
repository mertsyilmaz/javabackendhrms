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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="email_confirms")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","user"})
public class EmailConfirm {
	
	@Id
	@Column(name="user_id")
	private int userId;
	
	@Column(name="activation_code")
	private String activationCode;
	
	@Column(name="confirmed")
	private boolean confirmed;
	
	//@Column(name="confirmed_date")
	//private Date confirmedDate;
	
	@OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@MapsId
	@JoinColumn(name="user_id")
	private User user;
}
