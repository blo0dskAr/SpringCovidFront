package at.blo0dy.SpringCovidFront.service.krankenhausStat;


import at.blo0dy.SpringCovidFront.model.KrankenhausStat;

import java.util.List;

public interface KrankenhausStatService {

  KrankenhausStat findLatestKrankenhausStatDataByBundesland(List<KrankenhausStat> krankenhausStatList, String bundesland);

  List<KrankenhausStat> findKrankenhausStatDataByBundesLand(String bundesland);

  List<KrankenhausStat> findLatestKrankenhausStatsForBundeslaender();
}
