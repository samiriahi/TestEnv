package backendsolution.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import backendsolution.entity.User;

@Repository
public interface UserRepository  extends JpaRepository<User, Long>{
	
	 Optional<User> findUserById (long userId) ;
	 public User findById (long id) ;
	 

}
