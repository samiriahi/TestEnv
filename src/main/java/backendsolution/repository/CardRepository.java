package backendsolution.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import backendsolution.entity.Card;

@Repository
public interface CardRepository extends JpaRepository<Card, Long>{
	
	
}
