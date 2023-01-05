package co.jp.hotel;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document
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
