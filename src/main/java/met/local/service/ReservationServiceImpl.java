package met.local.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import met.local.domain.Player;
import met.local.domain.Reservation;
import met.local.domain.SportType;
import org.springframework.stereotype.Service;

@Service
public class ReservationServiceImpl implements ReservationService {

    public static final SportType TENNIS = new SportType(1, "Tennis");
    public static final SportType SOCCER = new SportType(2, "Soccer");
    private final List<Reservation> reservations = new ArrayList<>();

    public ReservationServiceImpl() {
        reservations.add(new Reservation("Tennis #1", new GregorianCalendar(2018,
                9, 14).getTime(), 16,
                new Player("Roger", "N/A"), TENNIS));
        reservations.add(new Reservation("Tennis #2", new GregorianCalendar(2018,
                10, 14).getTime(), 20,
                new Player("Novak", "N/A"), TENNIS));
    }

    @Override
    public List<Reservation> query(String courtName) {
        return this.reservations.stream().filter(reservation
                -> Objects.equals(reservation.getCourtName(), courtName))
                .collect(Collectors.toList());
    }

    @Override
    public void make(Reservation reservation) throws
            ReservationNotAvailableException {
        long cnt = reservations.stream()
                .filter(made -> Objects.equals(made.getCourtName(),
                reservation.getCourtName()))
                .filter(made -> Objects.equals(made.getDate(),
                reservation.getDate()))
                .filter(made -> made.getHour() == reservation.getHour())
                .count();
        if (cnt > 0) {
            throw new ReservationNotAvailableException(reservation
                    .getCourtName(), reservation.getDate(), reservation
                    .getHour());
        } else {
            reservations.add(reservation);
        }

        reservations.add(reservation);
    }

    @Override
    public List<SportType> getAllSportTypes() {
        return Arrays.asList(new SportType[]{TENNIS, SOCCER});
    }

    @Override
    public SportType getSportType(int sportSypeId) {
        switch (sportSypeId) {
            case 1:
                return TENNIS;

            case 2:
                return SOCCER;

            default:
                return null;

        }
    }
}
