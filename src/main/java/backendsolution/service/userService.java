package backendsolution.service;

import java.util.List;
import java.util.Set;

import backendsolution.entity.Card;
import backendsolution.entity.User;


public interface userService {
	
	public List<User> GetAllUsers();
	public User SaveUserWithCard(User user);
	public Card associateCardToUser(long cardId, long userId);
	public User findUserById(Long userId);
	public void  deleteUserWithCards( long  userId , long cardId) ;
	public Set<User> getUsersByCard(Long cardId);
	public User saveUser(User user);
	public User updateUser(User user);
	public void deleteUser(long userId);
	


}
