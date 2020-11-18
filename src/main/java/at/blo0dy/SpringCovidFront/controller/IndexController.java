package at.blo0dy.SpringCovidFront.controller;

import at.blo0dy.SpringCovidFront.service.AllgemeinDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

@Controller
public class IndexController {

  AllgemeinDataService allgemeinDataService;

  @Autowired
  public IndexController(AllgemeinDataService allgemeinDataService) {
    this.allgemeinDataService = allgemeinDataService;
  }

  @GetMapping("/index")
  public String showIndexPage(Model model) {
    Map<Date, Integer> mymap = new TreeMap<Date, Integer>();
    mymap = allgemeinDataService.findAllNeueCovidFaelleGesamt();

    model.addAttribute("test", allgemeinDataService.findAllNeueCovidFaelleGesamt());
      return "index";
  }



}
