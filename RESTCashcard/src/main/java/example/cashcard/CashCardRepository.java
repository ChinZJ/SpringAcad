package example.cashcard;

import org.springframework.data.repository.CrudRepository;

// CrudRepository is interface supplied by Spring Data
// Spring Boot and Spring Data automatically generates CRUD methods needed to interact with database
interface CashCardRepository extends CrudRepository<CashCard, Long> {
    
}
