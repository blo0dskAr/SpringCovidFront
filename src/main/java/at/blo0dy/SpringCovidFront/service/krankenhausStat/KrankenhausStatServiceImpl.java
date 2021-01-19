package at.blo0dy.SpringCovidFront.service.krankenhausStat;

import at.blo0dy.SpringCovidFront.model.GesamtStat;
import at.blo0dy.SpringCovidFront.model.KrankenhausStat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

@Service
public class KrankenhausStatServiceImpl implements KrankenhausStatService {

  @Autowired
  RestTemplate restTemplate;

  public static final String BASE_URL = "http://localhost:8080/covid/api/krankenhaus/v1" ;

  @Override
  public List<KrankenhausStat> findKrankenhausStatDataByBundesLand(String bundesland, LocalDate startDate, LocalDate endDate) {

    // das Datum da umwandeln wirkt noch schiach, LocaldateConfig zieht beim erstellen nicht?
    String moddedStartDate = startDate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    String moddedEndDate = endDate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));

    ResponseEntity<KrankenhausStat[]> response = restTemplate.getForEntity(BASE_URL + "/getData/" + bundesland + "?startDate=" + moddedStartDate + "&endDate=" + moddedEndDate, KrankenhausStat[].class);

    List<KrankenhausStat> krankenhausStatList = Arrays.asList(response.getBody());

    return krankenhausStatList;
  }

  @Override
  public List<KrankenhausStat> findLatestKrankenhausStatsForBundeslaender() {
    ResponseEntity<KrankenhausStat[]> response = restTemplate.getForEntity(BASE_URL + "/getLatestDataBundeslaender", KrankenhausStat[].class);

    List<KrankenhausStat> krankenhausStatList = Arrays.asList(response.getBody());

    return krankenhausStatList;
  }

  @Override
  public KrankenhausStat findLatestKrankenhausStatDataByBundesland(List<KrankenhausStat> krankenhausStatList, String bundesland) {
    for ( int i = krankenhausStatList.size() - 1;  i >= 0; i-- ) {
      if (krankenhausStatList.get(i).getBundesland().equals(bundesland)) {
        return krankenhausStatList.get(i);
      }
    }
    return null;
  }



}
