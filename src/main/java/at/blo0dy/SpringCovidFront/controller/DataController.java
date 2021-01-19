package at.blo0dy.SpringCovidFront.controller;


import at.blo0dy.SpringCovidFront.config.LocalDateConfig;
import at.blo0dy.SpringCovidFront.model.Bundesland;
import at.blo0dy.SpringCovidFront.model.GesamtStat;
import at.blo0dy.SpringCovidFront.model.KrankenhausStat;
import at.blo0dy.SpringCovidFront.service.bundesland.BundeslandService;
import at.blo0dy.SpringCovidFront.service.gesamtStat.GesamtStatService;
import at.blo0dy.SpringCovidFront.service.krankenhausStat.KrankenhausStatService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@Controller
@Slf4j
@RequestMapping()
public class DataController {

  GesamtStatService gesamtStatService;
  KrankenhausStatService krankenhausStatService;
  BundeslandService bundeslandService;

  @Autowired
  public DataController(GesamtStatService gesamtStatService, KrankenhausStatService krankenhausStatService, BundeslandService bundeslandService) {
    this.gesamtStatService = gesamtStatService;
    this.krankenhausStatService = krankenhausStatService;
    this.bundeslandService = bundeslandService;
  }

  @GetMapping({"", "/", "/index", "/index/"})
  public String showCovidIndexPage(Model model) {

    LocalDate dataStartDate = LocalDate.of(2020,02,20);
    LocalDate dataEndDate = LocalDate.now();


    Bundesland bundesland = new Bundesland("Österreich") ;
    List<Bundesland> bundeslandListe = bundeslandService.loadBundeslaender();

    List<GesamtStat> gesamtStatList = gesamtStatService.findGesamtStatDataByBundesland(bundesland.getName().toLowerCase(), dataStartDate, dataEndDate);
    GesamtStat latestGesamtStat = gesamtStatService.findLatestGesamtStatDataByBundesland(gesamtStatList, bundesland.getName().toLowerCase());
    List<GesamtStat> latestGesamtStatList = gesamtStatService.findlatestGesamtStatsForBundeslaender();

    List<KrankenhausStat> krankenhausStatList = krankenhausStatService.findKrankenhausStatDataByBundesLand(bundesland.getName().toLowerCase());
    KrankenhausStat latestKrankenhausStat = krankenhausStatService.findLatestKrankenhausStatDataByBundesland(krankenhausStatList, bundesland.getName().toLowerCase());
    List<KrankenhausStat> latestKrankenhausStatList = krankenhausStatService.findLatestKrankenhausStatsForBundeslaender();

    Date LatestDate = gesamtStatService.findLatestGesamtStatDate();


    model.addAttribute("gesamtStatList", gesamtStatList);
    model.addAttribute("bundeslandList", bundeslandListe);
    model.addAttribute("latestGesamtStat", latestGesamtStat);
    model.addAttribute("latestGesamtStatList", latestGesamtStatList);
    model.addAttribute("krankenhausStatList", krankenhausStatList);
    model.addAttribute("latestKrankenhausStat", latestKrankenhausStat);
    model.addAttribute("latestKrankenhausStatList", latestKrankenhausStatList);
    model.addAttribute("bundesland", bundesland);
    model.addAttribute("latestDate", LatestDate);

    return "gesamtStats";
  }


  @PostMapping({"", "/", "/index", "/index/"})
  public String showCovidIndexPage(Model model,
                                   @ModelAttribute(name = "bundesland") Bundesland bundesland,
                                   @RequestParam(name = "startDate") @DateTimeFormat(pattern = "dd.MM.yyyy") LocalDate startDate,
                                   @RequestParam(name = "endDate") @DateTimeFormat(pattern = "dd.MM.yyyy") LocalDate endDate) {

    List<Bundesland> bundeslandListe =  bundeslandService.loadBundeslaender();

    List<GesamtStat> gesamtStatList = gesamtStatService.findGesamtStatDataByBundesland(bundesland.getName().toLowerCase(), startDate, endDate);
    GesamtStat latestGesamtStat = gesamtStatService.findLatestGesamtStatDataByBundesland(gesamtStatList, bundesland.getName().toLowerCase());
    List<GesamtStat> latestGesamtStatList = gesamtStatService.findlatestGesamtStatsForBundeslaender();

    List<KrankenhausStat> krankenhausStatList = krankenhausStatService.findKrankenhausStatDataByBundesLand(bundesland.getName().toLowerCase());
    KrankenhausStat latestKrankenhausStat = krankenhausStatService.findLatestKrankenhausStatDataByBundesland(krankenhausStatList, bundesland.getName().toLowerCase());
    List<KrankenhausStat> latestKrankenhausStatList = krankenhausStatService.findLatestKrankenhausStatsForBundeslaender();

    Date LatestDate = gesamtStatService.findLatestGesamtStatDate();

    model.addAttribute("gesamtStatList", gesamtStatList);
    model.addAttribute("bundeslandList", bundeslandListe);
    model.addAttribute("bundesland", bundesland);
    model.addAttribute("latestGesamtStat", latestGesamtStat);
    model.addAttribute("latestGesamtStatList", latestGesamtStatList);
    model.addAttribute("krankenhausStatList", krankenhausStatList);
    model.addAttribute("latestKrankenhausStat", latestKrankenhausStat);
    model.addAttribute("latestKrankenhausStatList", latestKrankenhausStatList);
    model.addAttribute("latestDate", LatestDate);


    return "gesamtStats";

  }

}
