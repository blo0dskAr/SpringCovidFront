package at.blo0dy.SpringCovidFront.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class KrankenhausStat {

  private Long id;

  @JsonFormat(pattern = "dd.MM.yyyy")
  private Date datum;
  private String bundesland;
  private int testsGesamt;
  private int fzHosp;
  private int fzIcu;
  private int fzHospFree;
  private int fzIcuFree;
  int diffTests;
  int diffFzHosp ;
  int diffFzIcu;
  int hospGesamt;
  int icuGesamt;

  public KrankenhausStat(Date datum, String bundesland, int testsGesamt, int fzHosp, int fzIcu, int fzHospFree,
                         int fzIcuFree, int diffTests, int diffFzHosp, int diffFzIcu, int hospGesamt, int icuGesamt) {
    this.datum = datum;
    this.bundesland = bundesland;
    this.testsGesamt = testsGesamt;
    this.fzHosp = fzHosp;
    this.fzIcu = fzIcu;
    this.fzHospFree = fzHospFree;
    this.fzIcuFree = fzIcuFree;
    this.diffTests = diffTests;
    this.diffFzHosp = diffFzHosp;
    this.diffFzIcu = diffFzIcu;
    this.hospGesamt = hospGesamt;
    this.icuGesamt = icuGesamt;
  }
}
