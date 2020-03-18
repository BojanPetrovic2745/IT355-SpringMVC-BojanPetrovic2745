package met.local.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import met.local.domain.Player;
import met.local.domain.Reservation;
import met.local.domain.ReservationValidator;
import met.local.domain.SportType;
import met.local.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@RequestMapping("/reservationForm")
@SessionAttributes("reservation")
public class ReservationFormController {

    private final ReservationService reservationService;
    private final ReservationValidator reservationValidator;

    @Autowired
    public ReservationFormController(ReservationService reservationService,
            ReservationValidator reservationValidator) {

        this.reservationService = reservationService;
        this.reservationValidator = reservationValidator;

    }

    @ModelAttribute("sportTypes")
    public List<SportType> populateSportTypes() {
        return reservationService.getAllSportTypes();
    }

    @RequestMapping(method = RequestMethod.GET)
    public String setupForm(
            @RequestParam(required = false, value = "username") String username,
            Model model) {

        Reservation reservation = new Reservation();
        reservation.setPlayer(new Player(username, null));
        model.addAttribute("reservation", reservation);
        return "reservationForm";

    }

    @RequestMapping(method = RequestMethod.POST)
    public String submitForm(
            @ModelAttribute("reservation") @Validated Reservation reservation,
            BindingResult result, SessionStatus status) {
        if (result.hasErrors()) {
            return "reservationForm";
        } else {
            reservationService.make(reservation);
            return "reservationSuccess";
        }
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.setValidator(reservationValidator);

        binder.registerCustomEditor(Date.class,
                new CustomDateEditor(new SimpleDateFormat("dd.MM.yyyy"),
                        true, 11));
    }
}
