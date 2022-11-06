package backendsolution.service;

import java.util.List;
import java.util.Set;

import backendsolution.entity.Card;

public interface cardService {
	
	public void saveCard(Card card) ;
	public void DeleteCard(Long cardId) ;
	public List<Card> GetAllCards() ;
	public Set<Card> getCardByUser(Long idUser) ;
	public Card findCardById(Long cardId) ;
	
}
