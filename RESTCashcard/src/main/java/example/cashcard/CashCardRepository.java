package example.cashcard;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

// CrudRepository is interface supplied by Spring Data
// Spring Boot and Spring Data automatically generates CRUD methods needed to interact with database
interface CashCardRepository extends CrudRepository<CashCard, Long>, 
        PagingAndSortingRepository<CashCard, Long> {
    
    // findBy + FieldName + And/Or + FieldName ...
    // FiledName must match entity (CashCard)

            
    CashCard findByIdAndOwner(Long id, String owner);

    Page<CashCard> findByOwner(String owner, PageRequest pageRequest);
}
