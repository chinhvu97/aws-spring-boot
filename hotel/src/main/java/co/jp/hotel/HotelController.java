package co.jp.hotel;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotel")
@RequiredArgsConstructor
@Slf4j
public class HotelController {
  private final HotelRepo hotelRepo;

  @PostMapping("")
  public Hotel save(@RequestBody Hotel hotel) {
    log.info("saving new entity: " + hotel.toString());

    return hotelRepo.save(hotel);
  }

  @GetMapping("")
  public List<Hotel> getAll() {
    log.info("Getting all hotels available...");
    return hotelRepo.findAll();
  }
}
