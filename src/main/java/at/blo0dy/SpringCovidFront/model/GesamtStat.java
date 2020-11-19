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
  private int anzahlFaelleGesamt;
  private int anzahlFaelle7Tage;
  private BigDecimal inzidenz7Tage;
  private int anzahlNeueTote;
  private int anzahltotegesamt;
  private int anzahlGeheilt;
  private int anzahlGeheiltSum;

  public static final Path FILEPATH = Paths.get("H:/covidApp/CovidFaelle_Timeline.csv");
  public static final Path FILENAME = FILEPATH.getFileName();
  public static final String FETCHURL= "https://covid19-dashboard.ages.at/data/" + FILENAME;

  public GesamtStat(Date datum, String bundesland, int anzahlEinwohner, int anzahlNeueFaelle, int anzahlFaelleGesamt, int anzahlFaelle7Tage,
                    BigDecimal inzidenz7Tage, int anzahlNeueTote, int anzahltotegesamt, int anzahlGeheilt, int anzahlGeheiltSum) {
    this.datum = datum;
    this.bundesland = bundesland;
    this.anzahlEinwohner = anzahlEinwohner;
    this.anzahlNeueFaelle = anzahlNeueFaelle;
    this.anzahlFaelleGesamt = anzahlFaelleGesamt;
    this.anzahlFaelle7Tage = anzahlFaelle7Tage;
    this.inzidenz7Tage = inzidenz7Tage;
    this.anzahlNeueTote = anzahlNeueTote;
    this.anzahltotegesamt = anzahltotegesamt;
    this.anzahlGeheilt = anzahlGeheilt;
    this.anzahlGeheiltSum = anzahlGeheiltSum;
  }
}