package at.blo0dy.SpringCovidFront.controller;


import at.blo0dy.SpringCovidFront.model.Bundesland;
import at.blo0dy.SpringCovidFront.model.GesamtStat;
import at.blo0dy.SpringCovidFront.model.KrankenhausStat;
import at.blo0dy.SpringCovidFront.service.bundesland.BundeslandService;
import at.blo0dy.SpringCovidFront.service.gesamtStat.GesamtStatService;
import at.blo0dy.SpringCovidFront.service.krankenhausStat.KrankenhausStatService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Slf4j
@RequestMapping("/covid")
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

  @GetMapping({"/", "/index", "/index/"})
  public String showCovidIndexPage(Model model) {

    Bundesland bundesland = new Bundesland("Österreich") ;
    List<Bundesland> bundeslandListe = bundeslandService.loadBundeslaender();

    List<GesamtStat> gesamtStatList = gesamtStatService.findGesamtStatDataByBundesLand(bundesland.getName().toLowerCase());
    GesamtStat latestGesamtStat = gesamtStatService.findLatestGesamtStatDataByBundesland(gesamtStatList, bundesland.getName().toLowerCase());


    List<KrankenhausStat> krankenhausStatList = krankenhausStatService.findKrankenhausStatDataByBundesLand(bundesland.getName().toLowerCase());
    KrankenhausStat latestKrankenhausStat = krankenhausStatService.findLatestKrankenhausStatDataByBundesland(krankenhausStatList, bundesland.getName().toLowerCase());


    model.addAttribute("gesamtStatList", gesamtStatList);
    model.addAttribute("bundeslandList", bundeslandListe);
    model.addAttribute("latestGesamtStat", latestGesamtStat);
    model.addAttribute("krankenhausStatList", krankenhausStatList);
    model.addAttribute("latestKrankenhausStat", latestKrankenhausStat);
    model.addAttribute("bundesland", bundesland);

    return "gesamtStats";
  }


  @PostMapping("/index")
  public String showCovidIndexPage(Model model,
                                   @ModelAttribute(name = "bundesland") Bundesland bundesland) {

    List<Bundesland> bundeslandListe =  bundeslandService.loadBundeslaender();
    List<GesamtStat> gesamtStatList = gesamtStatService.findGesamtStatDataByBundesLand(bundesland.getName().toLowerCase());
    GesamtStat latestGesamtStat = gesamtStatService.findLatestGesamtStatDataByBundesland(gesamtStatList, bundesland.getName().toLowerCase());


    List<KrankenhausStat> krankenhausStatList = krankenhausStatService.findKrankenhausStatDataByBundesLand(bundesland.getName().toLowerCase());
    KrankenhausStat latestKrankenhausStat = krankenhausStatService.findLatestKrankenhausStatDataByBundesland(krankenhausStatList, bundesland.getName().toLowerCase());

    model.addAttribute("gesamtStatList", gesamtStatList);
    model.addAttribute("bundeslandList", bundeslandListe);
    model.addAttribute("bundesland", bundesland);
    model.addAttribute("latestGesamtStat", latestGesamtStat);
    model.addAttribute("krankenhausStatList", krankenhausStatList);
    model.addAttribute("latestKrankenhausStat", latestKrankenhausStat);


    return "gesamtStats";

  }

}
