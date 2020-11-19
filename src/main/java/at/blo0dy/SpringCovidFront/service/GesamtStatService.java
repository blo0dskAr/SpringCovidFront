package at.blo0dy.SpringCovidFront.service;

import at.blo0dy.SpringCovidFront.model.GesamtStat;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface GesamtStatService {

  Map<Date, Integer> findAllNeueCovidFaelleGesamt();

  List<GesamtStat> findGesamtStatDataByBundesLand(String bundesland);
}
