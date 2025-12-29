package example.cashcard;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


// Component of type RestController capable of handling HTTP requests
@RestController
// Indicates which address requests must have access to this controller
@RequestMapping("/cashcards")
public class CashCardController {
    private final CashCardRepository cashCardRepository;

    private CashCardController(CashCardRepository cashCardRepository) {
        this.cashCardRepository = cashCardRepository;
    }

    @GetMapping("/{requestedId}")
    private ResponseEntity<CashCard> findById(@PathVariable Long requestedId) {
        // @PathVariable makes Spring Web aware of requestedId supplied in HTTP request
        Optional<CashCard> cashCardOptional = cashCardRepository.findById(requestedId);
        
        return (cashCardOptional.isPresent()) 
                ? ResponseEntity.ok(cashCardOptional.get())
                : ResponseEntity.notFound().build();
    }

    
}
