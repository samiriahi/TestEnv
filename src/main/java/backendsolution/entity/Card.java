package backendsolution.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name = "cartes")
public class Card implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Long cardId ;
	
	@Column(name = "Num_Serie" )
	private String numSerie ;
	

	@Column(name = "code_carte" , nullable = false , updatable = false )
	private String codeCarte ;
	
	
	

	
	@ManyToMany( cascade = CascadeType.ALL )
	@JoinTable(name = "users_card",
     joinColumns = @JoinColumn(name = "card_id"),
     inverseJoinColumns = @JoinColumn(name = "user_id")
       )
    @JsonIgnore
	public Set<User> users = new HashSet<>() ;
	
	
	
	
	
	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public Card() {
		
	}

	
	

	public Card(String numSerie, int nbUser) {
		super();
		this.numSerie = numSerie;
		
	}

	

	public String getNumSerie() {
		return numSerie;
	}

	public void setNumSerie(String numSerie) {
		this.numSerie = numSerie;
	}

	public Long getCardId() {
		return cardId;
	}

	public void setCardId(Long cardId) {
		this.cardId = cardId;
	}

	public String getCodeCarte() {
		return codeCarte;
	}

	public void setCodeCarte(String codeCarte) {
		this.codeCarte = codeCarte;
	}

	@Override
	public String toString() {
		return "Card [cardId=" + cardId + ", numSerie=" + numSerie + ", codeCarte=" + codeCarte + ", users=" + users
				+ "]";
	}

	
	 
	
	
	
	
	

}
