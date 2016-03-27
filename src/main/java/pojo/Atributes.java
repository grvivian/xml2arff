package pojo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;

/**
 *
 * @author glaucio
 */
public class Atributes {

  private final LinkedHashMap<Integer, Atribute> atributes = new LinkedHashMap<>();

  public void clean() {
    Iterator<Atribute> it = atributes.values().iterator();
    while (it.hasNext()) {
      it.next().cleanValues();
    }
    atributes.clear();
  }

  public Atribute addAtribute(int id, String value) {
    Atribute a = atributes.get(id);

    if (a == null) {
      Atribute a1 = new Atribute();
      a1.addValue(value);
      atributes.put(id, a1);
      return a1;
    } else {
      a.addValue(value);
      return a;
    }
  }

  public LinkedHashMap<Integer, Atribute> getAtributes() {
    return atributes;
  }

  public ArrayList<String> getValuesFromAtribute(int id) {
    Atribute a = atributes.get(id);
    return a.getValues();
  }

  public String getDistinctsValuesFromAtribute(int id, boolean ignoreEmpty) {
    Atribute a = atributes.get(id);
    ArrayList<String> l = a.getValues();

    String ret = "";
    HashMap<String, String> v = new HashMap<>();
    for (int i = 0; i < l.size(); i++) {
      String va = l.get(i);
      if ((ignoreEmpty) && (va.equals("?"))) {
        continue;
      }
      va = va.replaceAll("[ ]", "_");//nominal nao pode ter espaço vazio
      if (!v.containsKey(va)) {
        v.put(va, va);
        ret += va + ",";
      }
    }

    return ret.replaceAll("[,]$", "");
  }

}
