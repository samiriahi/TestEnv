package backendsolution.service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import backendsolution.entity.Card;
import backendsolution.entity.User;
import backendsolution.exception.UserNotFoundExeption;
import backendsolution.repository.CardRepository;
import backendsolution.repository.UserRepository;


@Service
public class UserServiceImpl implements userService{
	
	@Autowired
	private UserRepository userRepository ;
	@Autowired
	private CardRepository cardRepository ;
	
	@Autowired
	private EmailSenderService emailService ;
	@Autowired
	private CardService_Imp cardService ;
	
	
	
	
	
	
	 
	@Override
		    public User findUserById(Long userId) {
		    return  userRepository.findUserById(userId)
		    		.orElseThrow(()->new UserNotFoundExeption ("User by id " + userId +" was not found "));
			}
		
	 @Override
			public List<User> GetAllUsers(){
			return userRepository.findAll() ;
			}
	 
	
	 
	@Override
		public User updateUser(User user) {
		  return userRepository.save(user);
		    }
		
	
	@Override
	
	public User  saveUser(User user) {
		return userRepository.save(user) ;
	}
	
	 
	@Override
	public User SaveUserWithCard (User user  ) {
		User newUser = new User();
		newUser.setFirstName(user.getFirstName());
		newUser.setJobTitle(user.getJobTitle());
		newUser.setEmailId(user.getEmailId());
		newUser.setPhone_Type(user.getPhone_Type());
		
		newUser.getCards()
                .addAll(user
                        .getCards()
                        .stream()
                        .map(v -> {
                            Card vv = cardService.findCardById(v.getCardId());
                            vv.getUsers().add(newUser);
                            return vv;
                        }).collect(Collectors.toList()));
        return userRepository.save(newUser);
        
	}
	
	
	
	
	
	@Override
	public Card associateCardToUser (long cardId , long userId ) { 
		
		    Card card = cardRepository.findById(cardId).get();
	        User user = userRepository.findById(userId);
	        card.users.add(user);	
	       	        	      
            emailService.sendSimpleEmail( user.getEmailId() , 
            		" Dear  " + user.getFirstName()+ "  " + user.getJobTitle() +" : \r"
            		+   "This  KEY  is  required to connect to your device , please confirm your connection by entering this code  : \r\n    "
                    + "    "   + card.getCodeCarte().toUpperCase() +  "               "  + 
                     "            " +  "\r Cordially\r\n  "  +"     "
                 + " NB: This is an automatic email, please do not reply.  " ,
           " Device Connection "  );
            
            
            
            return cardRepository.save(card);
            
	}
	
	
	@Transactional
	public void  deleteUserWithCards( long  userId , long cardId)  {
		User user= userRepository.findById(userId);
		 Card card =  cardRepository.findById(cardId).get() ;
		 user.cards.remove(card) ;
		 card.users.remove(user) ;
		 userRepository.save(user) ;
		 cardRepository.save(card) ;
		  
	}
	
	
	@Override
	@Transactional
	public void  deleteUser( long  userId )  {
		User user= userRepository.findById(userId);
		for (Card card : user.getCards()) { 
			 card.users.remove(user); 	
			}
		 	userRepository.delete(user) ;	
	}

	 @Override
	    public Set<User> getUsersByCard(Long cardId) {
	        Card card = cardRepository.findById(cardId).get();
	        return card.getUsers();
	    }
	
	
	
}
