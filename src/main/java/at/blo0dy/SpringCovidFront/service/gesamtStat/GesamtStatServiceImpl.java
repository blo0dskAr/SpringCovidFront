package at.blo0dy.SpringCovidFront.service.gesamtStat;

import at.blo0dy.SpringCovidFront.model.GesamtStat;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.util.*;

@Service
@Slf4j
public class GesamtStatServiceImpl implements GesamtStatService {

  public static final String BASE_URL = "http://localhost:8080/covid/api/gesamt/v1" ;

  @Autowired
  RestTemplate restTemplate;


//  @Override
//  public List<Konto> findAll(Konto konto) {
//    log.debug("Kontosuche wird durchgeführt.");
//    ResponseEntity<Konto[]> response = restTemplate.postForEntity(BASE_URL, konto, Konto[].class);
//    List<Konto> konten = Arrays.asList(response.getBody());
//    return konten;
//   }


  public Map<Date, Integer> findAllNeueCovidFaelleGesamt() {
    ResponseEntity<Map> response = restTemplate.getForEntity(BASE_URL + "/neueFaelle/österreich",Map.class);

    Map<Date, Integer> tmpMap = new TreeMap<Date, Integer>();

    tmpMap = response.getBody();

    return tmpMap;

  }

  @Override
  public List<GesamtStat> findGesamtStatDataByBundesland(String bundesland) {

    ResponseEntity<GesamtStat[]> response = restTemplate.getForEntity(BASE_URL + "/getData/" + bundesland, GesamtStat[].class);

    List<GesamtStat> gesamtStatList = Arrays.asList(response.getBody());

    return gesamtStatList;
  }

  @Override
  public GesamtStat findLatestGesamtStatDataByBundesland(List<GesamtStat> gesamtStatList, String bundesland) {
    for ( int i = gesamtStatList.size() - 1;  i >= 0; i-- ) {
      if (gesamtStatList.get(i).getBundesland().equals(bundesland)) {
        return gesamtStatList.get(i);
      }
    }
    return null;
  }

  @Override
  public List<GesamtStat> findlatestGesamtStatsForBundeslaender() {

    ResponseEntity<GesamtStat[]> response = restTemplate.getForEntity(BASE_URL + "/getLatestDataBundeslaender", GesamtStat[].class);

    List<GesamtStat> gesamtStatList = Arrays.asList(response.getBody());

    return gesamtStatList;
  }

  @Override
  public Date findLatestGesamtStatDate() {

    return restTemplate.getForObject(BASE_URL + "/getLatestDate", Date.class) ;
  }


}
