package at.blo0dy.SpringCovidFront.controller;

import at.blo0dy.SpringCovidFront.model.GesamtStat;
import at.blo0dy.SpringCovidFront.service.GesamtStatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Controller
@RequestMapping({"/", "",})
public class BeispielPageController {

  GesamtStatService gesamtStatService;

  @Autowired
  public BeispielPageController(GesamtStatService gesamtStatService) {
    this.gesamtStatService = gesamtStatService;
  }

  @GetMapping
  public String showIndexPage(Model model) {
    Map<Date, Integer> mymap = new TreeMap<Date, Integer>();
    mymap = gesamtStatService.findAllNeueCovidFaelleGesamt();
    model.addAttribute("test", gesamtStatService.findAllNeueCovidFaelleGesamt());

    String bundesland = "österreich" ;

    List<GesamtStat> gesamtStatList = gesamtStatService.findGesamtStatDataByBundesLand(bundesland);

    model.addAttribute("gesamtStatList", gesamtStatList);

    return "beispiel";
  }



}
