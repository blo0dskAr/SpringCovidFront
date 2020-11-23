package at.blo0dy.SpringCovidFront.model;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Bundesland {

  private String name;

  public Bundesland(String name) {
    this.name = name;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
