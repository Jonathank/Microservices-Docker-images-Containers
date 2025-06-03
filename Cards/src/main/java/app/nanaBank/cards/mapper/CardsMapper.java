package app.nanaBank.cards.mapper;

import app.nanaBank.cards.dto.CardsDTO;
import app.nanaBank.cards.models.Cards;

public class CardsMapper {

    public static CardsDTO mapToCardsDTO(Cards card,CardsDTO cardsDTO) {
	if (card == null) {
	    return null;
	}
	if (cardsDTO == null) {
	    cardsDTO = new CardsDTO();
	}
	
	cardsDTO.setMobileNumber(card.getMobileNumber());
	cardsDTO.setCardNumber(card.getCardNumber());
	cardsDTO.setCardType(card.getCardType());
	cardsDTO.setTotalLimit(card.getTotalLimit());
	cardsDTO.setAmountUsed(card.getAmountUsed());
	cardsDTO.setAvailableAmount(card.getAvailableAmount());
	
	return cardsDTO;
    }
    
    public static Cards mapToCards(CardsDTO cardsDTO, Cards card) {
	if (cardsDTO == null) {
	    return null;
	}
	if (card == null) {
	    card = new Cards();
	}
	card.setMobileNumber(cardsDTO.getMobileNumber());
	card.setCardNumber(cardsDTO.getCardNumber());
	card.setCardType(cardsDTO.getCardType());
	card.setTotalLimit(cardsDTO.getTotalLimit());
	card.setAmountUsed(cardsDTO.getAmountUsed());
	card.setAvailableAmount(cardsDTO.getAvailableAmount());
	return card;
	
    }
}
