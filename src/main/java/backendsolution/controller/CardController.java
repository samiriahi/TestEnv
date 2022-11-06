package backendsolution.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import backendsolution.entity.Card;
import backendsolution.service.CardService_Imp;

@RestController
@RequestMapping("/cards")
public class CardController {
	
	@Autowired
	private CardService_Imp cardService ;
	
	@PostMapping()
	@ResponseBody
	public void addCard(@RequestBody Card card) {
		cardService.saveCard(card);
		
	}

	@DeleteMapping("/{cardId}")
	@ResponseBody
	public void removeCard(@PathVariable("cardId") long cardId) {
	cardService.DeleteCard(cardId) ;
	
	}

	
	@GetMapping()
	public List<Card> GetAllCards(){
	return cardService.GetAllCards() ;
	} 
	
	@GetMapping("/{cardId}")
	public ResponseEntity<Card> GetUserByid (@PathVariable("cardId") long cardId){
		Card card = cardService.findCardById(cardId);
		return new ResponseEntity<>(card , HttpStatus.OK) ;
	}
	
	
	
	@GetMapping("/byUser/{idUser}")
    public Set<Card> getCardByUser(@PathVariable("idUser") Long idUser){
        return cardService.getCardByUser(idUser);
	}

}
