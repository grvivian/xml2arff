package query;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import net.sf.saxon.Configuration;
import net.sf.saxon.s9api.Processor;
import net.sf.saxon.s9api.Serializer;
import net.sf.saxon.s9api.XQueryCompiler;
import net.sf.saxon.s9api.XQueryEvaluator;
import net.sf.saxon.s9api.XQueryExecutable;

/**
 *
 * @author glaucio
 */
public class QuerySaxon extends Query {

  @Override
  public String query(String xq) throws Exception {
    Configuration saxonConfig = new Configuration();
    Processor processor = new Processor(saxonConfig);
    XQueryCompiler xqueryCompiler = processor.newXQueryCompiler();
    XQueryExecutable xqueryExec = xqueryCompiler.compile(xq); //"<a b='c'>{5+2}</a>"
    XQueryEvaluator xqueryEval = xqueryExec.load();
    //xqueryEval.setSource(new SAXSource(new InputSource(new StringReader(tableXml))));

    Serializer out = new Serializer();
    out.setOutputProperty(Serializer.Property.METHOD, "xml");
    out.setOutputProperty(Serializer.Property.INDENT, "yes");
    out.setOutputProperty(Serializer.Property.OMIT_XML_DECLARATION, "yes");
    OutputStream ret = new ByteArrayOutputStream();
    out.setOutputStream(ret);
    xqueryEval.run(out);

    return ret.toString();
  }

}
