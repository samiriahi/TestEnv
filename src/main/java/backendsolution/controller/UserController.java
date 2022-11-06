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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import backendsolution.entity.Card;
import backendsolution.entity.User;
import backendsolution.repository.CardRepository;
import backendsolution.repository.UserRepository;
import backendsolution.service.cardService;
import backendsolution.service.userService;


@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private userService userService ;
	@Autowired
	private cardService cardservice ;
	
	 @Autowired
	 CardRepository cardRepository;
	 
	 @Autowired
	 UserRepository userRepository;
	 
	 
	 

	
	
	@GetMapping("/all")
	public List<User> GetAllUsers(){
	return userService.GetAllUsers() ;
	} 
	
	@GetMapping("/{userId}")
	public ResponseEntity<User> GetUserByid (@PathVariable("userId") long userId){
		User user = userService.findUserById(userId) ;
		return new ResponseEntity<User>(user , HttpStatus.OK) ;
	}
	
	
	
	 @PutMapping()
	    public ResponseEntity<User> updateEmployee(@RequestBody User user) {
	        User updateUser= userService.updateUser(user);
	        return new ResponseEntity<>(updateUser, HttpStatus.OK);
	 }
	  
	        

    
	   @PostMapping()
	   public ResponseEntity<User> saveUser(@RequestBody User user) {
    	User newUser = userService.saveUser(user);
    	return new ResponseEntity<>(newUser, HttpStatus.CREATED);
	   }
	
	
    	
		
	   @PostMapping("/userWithCard") 
	 	public ResponseEntity<?> addUser(@RequestBody User user ) {
		return new ResponseEntity<>(userService.SaveUserWithCard(user) ,HttpStatus.CREATED) ;
  	}
	
	
	
	   @PutMapping("/linkCard/{cardId}/{userId}")
	   public  Card addCardToUser(@RequestBody @PathVariable("cardId") long cardId , 
			   								   @PathVariable("userId") long userId ) { 	        
	   return userService.associateCardToUser(cardId, userId) ;
	 	}
	 
	 
	 	@DeleteMapping("/card/{userId}/{cardId}")
		public ResponseEntity<?> deleteUser(@PathVariable("userId") long userId , 
											@PathVariable("cardId") long cardId) {
	 		userService.deleteUserWithCards(userId, cardId) ;
		 return new ResponseEntity<>(HttpStatus.OK) ;
		}
	 	
	 	
	 	@DeleteMapping("/{userId}")
		public ResponseEntity<?> deleteUser(@PathVariable("userId") long userId ) {
	 		userService.deleteUser(userId) ;
		 return new ResponseEntity<>(HttpStatus.OK) ;
	 	}
	 
	 	
	 	@GetMapping("/byCard/{cardId}")
	    public Set<User> UsersByCard(@PathVariable("cardId") Long cardId){
	        return userService.getUsersByCard(cardId)  ;
	 }
	

		@GetMapping("/cards/{idUser}")
	    public Set<Card> getCardByUser(@PathVariable("idUser") Long idUser){
	        return cardservice.getCardByUser(idUser);
		}

}
