package pojo;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author glaucio
 */
public class Atribute {

  private final ArrayList<String> values = new ArrayList<>();

  public ArrayList<String> getValues() {
    return values;
  }

  private static boolean isNumeric(String x) {
    x = x.replace(",", ".");
    try {
      double r = Double.parseDouble(x);
      return true;
    } catch (Exception ex) {

    }

    return false;
  }

  public String getTypeFromDistinctsValues(int maxDistincValuesToNominal) {
    int conNumeric = 0, contVazio = 0;

    HashMap<String, String> v = new HashMap<>();
    for (int i = 0; i < values.size(); i++) {
      String va = values.get(i);

      if (isNumeric(va)) {
        conNumeric++;
      } else if (va.equals("?") || va.equals("")) {
        contVazio++;
      }

      if (!v.containsKey(va)) {
        v.put(va, va);

      }
    }

    if ((conNumeric + contVazio) == values.size()) {
      return "numeric";
    } else if (v.keySet().size() < maxDistincValuesToNominal) {
      return "nominal";
    } else {
      return "string";
    }
  }

  public void addValue(String value) {
    this.values.add(value);
  }

  public void cleanValues() {
    values.clear();
  }

}
