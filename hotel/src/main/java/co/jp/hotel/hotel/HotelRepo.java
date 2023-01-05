package co.jp.hotel.hotel;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepo extends MongoRepository<Hotel, String> {
}
