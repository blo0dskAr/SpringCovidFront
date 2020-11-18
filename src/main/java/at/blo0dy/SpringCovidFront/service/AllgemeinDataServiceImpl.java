package at.blo0dy.SpringCovidFront.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

@Service
@Slf4j
public class AllgemeinDataServiceImpl implements AllgemeinDataService {

  public static final String BASE_URL = "http://localhost:8080/covid/api/v1" ;

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
    ResponseEntity<Map> response = restTemplate.getForEntity(BASE_URL + "/österreich",Map.class);

    Map<Date, Integer> tmpMap = new TreeMap<Date, Integer>();

    tmpMap = response.getBody();

    return tmpMap;

  }

}
