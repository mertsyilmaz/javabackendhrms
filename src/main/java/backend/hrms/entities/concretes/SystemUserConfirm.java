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
@Table(name="system_user_confirms")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","employer"})
public class SystemUserConfirm {

	@Id
	@Column(name="user_id")
	private int userId;
	
	@Column(name="confirmed")
	private boolean confirmed;
	
	@OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@MapsId
	@JoinColumn(name="user_id")
	private Employer employer;
}
