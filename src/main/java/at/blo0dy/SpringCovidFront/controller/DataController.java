package at.blo0dy.SpringCovidFront.controller;

import at.blo0dy.SpringCovidFront.service.GesamtStatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"/covid", "/covid/", "/covid/index", "covid/index/"})
public class DataController {

  GesamtStatService gesamtStatService;

  @Autowired
  public DataController(GesamtStatService gesamtStatService) {
    this.gesamtStatService = gesamtStatService;
  }

  @GetMapping
  public String showCovidIndexPage() {

    return "index";



  }






}
