package app.nanaBank.cards.service;

import app.nanaBank.cards.dto.CardsDTO;

public interface ICardsService {

    void createCard(String mobileNumber);

    CardsDTO fetchCardDetails(String mobileNumber);

    boolean updateCard(CardsDTO cardsDTO);

    boolean deleteCard(String mobileNumber);

}
