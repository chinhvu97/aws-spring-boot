package co.jp.hotel;

import co.jp.hotel.hotel.Hotel;
import co.jp.hotel.hotel.HotelRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
@Slf4j
public class StartupConstructData implements ApplicationListener<ContextRefreshedEvent> {
  @Autowired
  private HotelRepo hotelRepo;

  @Override
  public void onApplicationEvent(ContextRefreshedEvent event) {
    if (hotelRepo.findAll().isEmpty()) {
      log.info("Starting init data...");
      List<Hotel> hotelList = new ArrayList<>();
      hotelList.add(new Hotel(UUID.randomUUID().toString(), "Lotte Hotel Hanoi", 5, "Hanoi"));
      hotelList.add(new Hotel(UUID.randomUUID().toString(), "Sofitel Lengend Metropole", 5, "Hanoi"));
      hotelList.add(new Hotel(UUID.randomUUID().toString(), "Grand Plaza Hanoi", 5, "Hanoi"));
      hotelList.add(new Hotel(UUID.randomUUID().toString(), "Anatole Hanoi", 5, "Hanoi"));
      hotelRepo.saveAll(hotelList);
    }
  }
}
