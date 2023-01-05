package co.jp.hotel.hotel;

import co.jp.hotel.util.ContainerMetaDataService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hotel")
@RequiredArgsConstructor
@Slf4j
public class HotelController {
  private final HotelRepo hotelRepo;
  private final ContainerMetaDataService containerMetaDataService;

  @PostMapping("")
  public Hotel save(@RequestBody Hotel hotel) {
    log.info("saving new entity: " + hotel.toString());

    return hotelRepo.save(hotel);
  }

  @GetMapping("")
  public ResponseEntity<?> getAll() {
    log.info("Getting all hotels available...");
    String metadataInfo = containerMetaDataService.retrieveContainerMetadataInfo();
    log.info("{}={}", "metadataInfo", metadataInfo);
    return new ResponseEntity<>(hotelRepo.findAll(), HttpStatus.OK);
  }
}
