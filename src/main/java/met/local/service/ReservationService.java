package met.local.service;

import java.util.List;

import met.local.domain.Reservation;
import met.local.domain.SportType;

public interface ReservationService {
    
    public List<Reservation> query(String courtName);
    
    void make(Reservation reservation) throws ReservationNotAvailableException;
    
    public List<SportType> getAllSportTypes();
    
    public SportType getSportType(int sportSypeId);
    
}
