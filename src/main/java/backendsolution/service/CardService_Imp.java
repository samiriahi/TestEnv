package backendsolution.service;

import java.util.List;
import java.util.Set;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import backendsolution.entity.Card;
import backendsolution.entity.User;
import backendsolution.exception.UserNotFoundExeption;
import backendsolution.repository.CardRepository;
import backendsolution.repository.UserRepository;


@Service
public class CardService_Imp  implements cardService {
	
	@Autowired
	private CardRepository cardRepository ;
	@Autowired
	private UserRepository userRepository ;
	
	
	
	
	
	@Override
	public void saveCard(Card card) {
		card.setCodeCarte(UUID.randomUUID().toString());
		cardRepository.save(card) ;
	}
	
	
	
	
	@Transactional
	 public void DeleteCard (Long cardId) {
		
		Card card= cardRepository.findById(cardId).get();
		
		for (User user : card.getUsers()) 
			{ 
			 card.users.remove(user); 	
			}
		cardRepository.delete(card);	
		 
	 } 
	
	
	@Override
	public List<Card> GetAllCards(){
		return cardRepository.findAll() ;
	}
	
	
	@Override
    public Card findCardById(Long cardId) {
        return cardRepository.findById(cardId)
        		.orElseThrow(()->new UserNotFoundExeption ("Card by id " + cardId +" was not found "));
    }
    
    @Override
    public Set<Card> getCardByUser(Long idUser) {
        User user = userRepository.findById(idUser).get();
        return user.getCards();
    }

}
