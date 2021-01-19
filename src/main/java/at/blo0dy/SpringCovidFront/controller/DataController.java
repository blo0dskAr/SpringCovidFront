package at.blo0dy.SpringCovidFront.controller;


import at.blo0dy.SpringCovidFront.model.Bundesland;
import at.blo0dy.SpringCovidFront.model.DatumForm;
import at.blo0dy.SpringCovidFront.model.GesamtStat;
import at.blo0dy.SpringCovidFront.model.KrankenhausStat;
import at.blo0dy.SpringCovidFront.service.bundesland.BundeslandService;
import at.blo0dy.SpringCovidFront.service.gesamtStat.GesamtStatService;
import at.blo0dy.SpringCovidFront.service.krankenhausStat.KrankenhausStatService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
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

    Bundesland bundesland = new Bundesland("Österreich") ;
    DatumForm datumForm = new DatumForm(LocalDate.of(2020,02,20), LocalDate.now(), bundesland);

    LocalDate startDate = datumForm.getStartDate();
    LocalDate endDate = datumForm.getEndDate();

    List<Bundesland> bundeslandListe = bundeslandService.loadBundeslaender();

    List<GesamtStat> gesamtStatList = gesamtStatService.findGesamtStatDataByBundesland(bundesland.getName().toLowerCase(), startDate, endDate);
    GesamtStat latestGesamtStat = gesamtStatService.findLatestGesamtStatDataByBundesland(gesamtStatList, bundesland.getName().toLowerCase());
    List<GesamtStat> latestGesamtStatList = gesamtStatService.findlatestGesamtStatsForBundeslaender();

    List<KrankenhausStat> krankenhausStatList = krankenhausStatService.findKrankenhausStatDataByBundesLand(bundesland.getName().toLowerCase(), startDate, endDate);
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
    model.addAttribute("latestDate", LatestDate);
    model.addAttribute("datumForm", datumForm);

    return "gesamtStats";
  }


  @PostMapping({"", "/", "/index", "/index/"})
  public String showCovidIndexPage(Model model,
                                   @ModelAttribute(name = "bundesland") Bundesland bundesland,
                                   @Valid @ModelAttribute(name = "datumForm") DatumForm datumForm, BindingResult bindingResult) {

    LocalDate startDate;
    LocalDate endDate;

    if (bindingResult.hasErrors()) {
      log.debug("DatumValidation Error erhalten");
      startDate = LocalDate.of(2020,02,20);
      endDate = LocalDate.now();
    } else {
      startDate = datumForm.getStartDate();
      endDate = datumForm.getEndDate();
    }

    List<Bundesland> bundeslandListe =  bundeslandService.loadBundeslaender();

    List<GesamtStat> gesamtStatList = gesamtStatService.findGesamtStatDataByBundesland(bundesland.getName().toLowerCase(), startDate, endDate);
    GesamtStat latestGesamtStat = gesamtStatService.findLatestGesamtStatDataByBundesland(gesamtStatList, bundesland.getName().toLowerCase());
    List<GesamtStat> latestGesamtStatList = gesamtStatService.findlatestGesamtStatsForBundeslaender();

    List<KrankenhausStat> krankenhausStatList = krankenhausStatService.findKrankenhausStatDataByBundesLand(bundesland.getName().toLowerCase(), startDate, endDate);
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
    model.addAttribute("latestDate", LatestDate);

    return "gesamtStats";

  }

}
