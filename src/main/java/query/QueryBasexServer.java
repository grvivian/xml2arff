package query;

import config.Config;
import javax.xml.xquery.*;
//import javax.xml.namespace.QName;
import net.xqj.basex.BaseXXQDataSource;

public class QueryBasexServer extends Query {

  @Override
  public String query(String xd) throws Exception {
    XQDataSource xqs = new BaseXXQDataSource();
    Config c = new Config();
    c.lerConfig();
    xqs.setProperty("serverName", c.getHost());
    xqs.setProperty("port", c.getPort());
    XQConnection conn = xqs.getConnection(c.getUser(), c.getPassword());

    XQPreparedExpression xqpe = conn.prepareExpression(xd);

    XQResultSequence rs = xqpe.executeQuery();

    StringBuilder sb = new StringBuilder();
    records = 0;
    while (rs.next()) {
      sb.append(rs.getItemAsString(null));
      sb.append("\n");
      records++;
    }

    conn.close();

    return sb.toString();
  }

}
