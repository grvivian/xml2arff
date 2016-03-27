package query;

/**
 *
 * @author glaucio
 */
public abstract class Query {

  protected static int records;

  public static int getRecords() {
    return records;
  }

  public abstract String query(String xq) throws Exception;

}
