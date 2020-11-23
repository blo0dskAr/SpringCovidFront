package at.blo0dy.SpringCovidFront.service.bundesland;

import at.blo0dy.SpringCovidFront.model.Bundesland;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class BundeslandServiceImpl implements BundeslandService {

  public List<Bundesland> loadBundeslaender() {

    return Arrays.asList(new Bundesland("Österreich"),
            new Bundesland("Wien"),
            new Bundesland("Niederösterreich"),
            new Bundesland("Oberösterreich"),
            new Bundesland("Steiermark"),
            new Bundesland("Kärnten"),
            new Bundesland("Tirol"),
            new Bundesland("Burgenland"),
            new Bundesland("Salzburg"),
            new Bundesland("Vorarlberg")
    ) ;
  }

}
