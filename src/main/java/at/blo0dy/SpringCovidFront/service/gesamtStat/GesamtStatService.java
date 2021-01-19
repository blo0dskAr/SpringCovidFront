package at.blo0dy.SpringCovidFront.service.gesamtStat;

import at.blo0dy.SpringCovidFront.model.GesamtStat;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;

public interface GesamtStatService {

  Map<Date, Integer> findAllNeueCovidFaelleGesamt();

  List<GesamtStat> findGesamtStatDataByBundesland(String bundesland, LocalDate startDate, LocalDate endDate);

  GesamtStat findLatestGesamtStatDataByBundesland(List<GesamtStat> gesamtStatList, String bundesland);

  List<GesamtStat> findlatestGesamtStatsForBundeslaender();

  Date findLatestGesamtStatDate();
}
