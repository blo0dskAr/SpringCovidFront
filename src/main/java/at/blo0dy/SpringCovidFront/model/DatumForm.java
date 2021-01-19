package at.blo0dy.SpringCovidFront.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Past;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DatumForm {

  @Past(message = "Datum in der Vergangenheit angeben")
  
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private LocalDate startDate;

  @PastOrPresent(message = "Datum in der Vergangenheit angeben")
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private LocalDate endDate;

  private Bundesland bundesland;
}
