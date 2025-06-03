package app.nanaBank.cards.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import app.nanaBank.cards.models.Cards;

public interface CardsRepository extends JpaRepository<Cards, Long>{

    Optional<Cards> findByMobileNumber(String mobileNumber);

    Optional<Cards> findByCardNumber(String cardNumber);

}
