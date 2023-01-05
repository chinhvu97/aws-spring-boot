package co.jp.hotel;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

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
      hotelList.add(new Hotel("Lotte Hotel Hanoi", 5, "Hanoi"));
      hotelList.add(new Hotel("Sofitel Lengend Metropole", 5, "Hanoi"));
      hotelList.add(new Hotel("Grand Plaza Hanoi", 5, "Hanoi"));
      hotelList.add(new Hotel("Anatole Hanoi", 5, "Hanoi"));
      hotelRepo.saveAll(hotelList);
    }
  }
}
