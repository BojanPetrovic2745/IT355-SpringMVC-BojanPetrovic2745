package met.local.domain;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class ReservationValidator implements Validator {

    @Override
    public boolean supports(Class<?> type) {
        return Reservation.class.isAssignableFrom(type);
    }

    @Override
    public void validate(Object o, Errors errors) {

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "courtName",
                "required.courtName", "Court name is required.");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors,
                "player.name", "required.playerName",
                "Player name is required!");
        
        ValidationUtils.rejectIfEmpty(errors, "sportType", 
                "required.sportType", "Sport type is required!");
    }

}
