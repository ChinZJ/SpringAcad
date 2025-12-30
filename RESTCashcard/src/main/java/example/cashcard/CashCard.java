package example.cashcard;

import org.springframework.data.annotation.Id;

// @Id is used to configure its ID
record CashCard(@Id Long id, Double amount, String owner) {
}