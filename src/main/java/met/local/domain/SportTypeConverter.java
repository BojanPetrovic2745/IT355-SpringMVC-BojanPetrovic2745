package met.local.domain;

import met.local.service.ReservationService;
import org.springframework.core.convert.converter.Converter;


public class SportTypeConverter  implements Converter<String, SportType>{
    
    private ReservationService reservationService;

    public SportTypeConverter(ReservationService reservationService) {
        this.reservationService = reservationService;
    }
    
    

    @Override
    public SportType convert(String s) {
        
        int sportTypeId = Integer.parseInt(s);
        
        SportType sportType = reservationService.getSportType(sportTypeId);
        
        return sportType;
    }
    
}
