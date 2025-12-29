package example.cashcard;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


// Component of type RestController capable of handling HTTP requests
@RestController
// Indicates which address requests must have access to this controller
@RequestMapping("/cashcards")
public class CashCardController {

    @GetMapping("/{requestedId}")
    private ResponseEntity<CashCard> findById() {
        // Hardcoded
        CashCard cashCard = new CashCard(99L, 123.45);
        return ResponseEntity.ok(cashCard);
    }
}
