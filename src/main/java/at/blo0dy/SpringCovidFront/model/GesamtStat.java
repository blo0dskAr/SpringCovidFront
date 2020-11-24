package at.blo0dy.SpringCovidFront.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GesamtStat {

  private Long id;

  @JsonFormat(pattern = "dd.MM.yyyy")
  private Date datum;
  private String bundesland;
  private int anzahlEinwohner;
  private int anzahlNeueFaelle;
  private int diffNeueFaelle;
  private int anzahlFaelleGesamt;
  private int anzahlFaelle7Tage;
  private int diffFaelle7Tage;
  private BigDecimal inzidenz7Tage;
  private BigDecimal diffInzidenz7Tage;
  private int anzahlNeueTote;
  private int diffNeueTote;
  private int anzahlToteGesamt;
  private int anzahlGeheilt;
  private int diffGeheilt;
  private int anzahlGeheiltGesamt;
  int anzahlAktive;


  public static final Path FILEPATH = Paths.get("H:/covidApp/CovidFaelle_Timeline.csv");
  public static final Path FILENAME = FILEPATH.getFileName();
  public static final String FETCHURL= "https://covid19-dashboard.ages.at/data/" + FILENAME;

  public GesamtStat(Date datum, String bundesland, int anzahlEinwohner, int anzahlNeueFaelle, int diffNeueFaelle, int anzahlFaelleGesamt,
                    int anzahlFaelle7Tage, int diffFaelle7Tage, BigDecimal inzidenz7Tage, BigDecimal diffInzidenz7Tage, int anzahlNeueTote,
                    int diffNeueTote, int anzahlToteGesamt, int anzahlGeheilt, int diffGeheilt, int anzahlGeheiltGesamt, int anzahlAktive ) {
    this.datum = datum;
    this.bundesland = bundesland;
    this.anzahlEinwohner = anzahlEinwohner;
    this.anzahlNeueFaelle = anzahlNeueFaelle;
    this.diffNeueFaelle = diffNeueFaelle;
    this.anzahlFaelleGesamt = anzahlFaelleGesamt;
    this.anzahlFaelle7Tage = anzahlFaelle7Tage;
    this.diffFaelle7Tage = diffFaelle7Tage;
    this.inzidenz7Tage = inzidenz7Tage;
    this.diffInzidenz7Tage = diffInzidenz7Tage;
    this.anzahlNeueTote = anzahlNeueTote;
    this.diffNeueTote = diffNeueTote;
    this.anzahlToteGesamt = anzahlToteGesamt;
    this.anzahlGeheilt = anzahlGeheilt;
    this.diffGeheilt = diffGeheilt;
    this.anzahlGeheiltGesamt = anzahlGeheiltGesamt;
    this.anzahlAktive = anzahlAktive;
  }
}
