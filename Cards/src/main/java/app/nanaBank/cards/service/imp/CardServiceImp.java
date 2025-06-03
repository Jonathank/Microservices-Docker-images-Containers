package app.nanaBank.cards.service.imp;

import java.util.Optional;
import java.util.Random;

import org.springframework.stereotype.Service;

import app.nanaBank.cards.dto.CardsDTO;
import app.nanaBank.cards.exceptions.CardAlreadyExistsException;
import app.nanaBank.cards.exceptions.ResourceNotFoundException;
import app.nanaBank.cards.mapper.CardsMapper;
import app.nanaBank.cards.models.Cards;
import app.nanaBank.cards.repository.CardsRepository;
import app.nanaBank.cards.service.ICardsService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CardServiceImp implements ICardsService{

    private final CardsRepository cardsRepository;
    @Override
    public void createCard(String mobileNumber) {
	Optional<Cards>optionalCard = cardsRepository.findByMobileNumber(mobileNumber);
	if (optionalCard.isPresent()) {
	    throw new CardAlreadyExistsException("Card already exists for this mobile number: " + mobileNumber);
	}
	cardsRepository.save(createNewCard(mobileNumber));
    }
    
    private Cards createNewCard(String mobileNumber) {
	Cards newCard = new Cards();
	newCard.setMobileNumber(mobileNumber);
	Long randomNumber = 100000000000L + new Random().nextLong(900000000000L); 
	newCard.setCardNumber(randomNumber.toString());
	newCard.setCardType("Standard");
	newCard.setTotalLimit(50000); 
	newCard.setAmountUsed(0);
	newCard.setAvailableAmount(50000); 
	return newCard;
    }

    @Override
    public CardsDTO fetchCardDetails(String mobileNumber) {
	Cards card = cardsRepository.findByMobileNumber(mobileNumber)
		.orElseThrow(() -> new ResourceNotFoundException("Card","mobile number" , mobileNumber));
	return CardsMapper.mapToCardsDTO(card,new CardsDTO());
    }
    
    @Override
    public boolean updateCard(CardsDTO cardsDTO) {
	Cards existingCard = cardsRepository.findByCardNumber(cardsDTO.getCardNumber())
		.orElseThrow(() -> new ResourceNotFoundException("Card", "mobile number", cardsDTO.getMobileNumber()));
	CardsMapper.mapToCards(cardsDTO, existingCard);
	cardsRepository.save(existingCard);
	return true;
    }

    @Override
    public boolean deleteCard(String mobileNumber) {
	    Cards card = cardsRepository.findByMobileNumber(mobileNumber)
		    .orElseThrow(() -> new ResourceNotFoundException("Card", "mobile number", mobileNumber));
	        cardsRepository.deleteById(card.getCardId());
	return true;
    }

}
