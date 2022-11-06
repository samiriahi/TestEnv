package backendsolution.entity;



import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data
@Entity
@Table(name = "Users")
public class User implements Serializable{
	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id ;
	
	@Column(name="First_Name")
	private String firstName ;
	
	@Column(name="Job_title")
	private String jobTitle ;
	
	@Column(name="Email")
	private String emailId ;
	
	 @Enumerated(EnumType.STRING)
	 private phone_Type phone_Type;
	 
	
	 private String image ;
	 
	 
	 
	 @ManyToMany(fetch = FetchType.LAZY , mappedBy  = "users")
	  	public Set<Card> cards =  new HashSet<>();
	 
	 
	 
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public String getJobTitle() {
		return jobTitle;
	}


	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}




	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public phone_Type getPhone_Type() {
		return phone_Type;
	}

	public void setPhone_Type(phone_Type phone_Type) {
		this.phone_Type = phone_Type;
	}

	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}

	public Set<Card> getCards() {
		return cards;
	}

	public void setCards(Set<Card> cards) {
		this.cards = cards;
	}

	
	
	public User(String firstName, String jobTitle, String emailId, backendsolution.entity.phone_Type phone_Type,
			String image) {
		super();
		this.firstName = firstName;
		this.jobTitle = jobTitle;
		this.emailId = emailId;
		this.phone_Type = phone_Type;
		this.image = image;
	}


	public User() {
		
	
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", jobTitle=" + jobTitle + ", emailId=" + emailId
				+ ", phone_Type=" + phone_Type + ", image=" + image + ", cards=" + cards + "]";
	}
	 
	 
	 
	 
	 
}
