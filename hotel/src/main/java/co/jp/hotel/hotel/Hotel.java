package co.jp.hotel.hotel;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Hotel {
  @Id
  private String id;

  private String name;

  private Integer star;

  private String address;

}
