package at.blo0dy.SpringCovidFront.service;

import java.util.Date;
import java.util.Map;

public interface AllgemeinDataService {

  Map<Date, Integer> findAllNeueCovidFaelleGesamt();
}
