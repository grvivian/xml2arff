package config;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

/**
 * @author glaucio
 */
public class Config {

  private static final String FILE_CONFIG = "./configXml2Arff.properties";
  private String typeOfConection = "s";
  private String host = "127.0.0.1";
  private String port = "1984";
  private String user = "admin";
  private String password = "1234";
  private String local = "en";

  public void salvarConfig() throws Exception {
    Properties p = new Properties();

    p.setProperty("typeOfConection", typeOfConection);
    p.setProperty("host", host);
    p.setProperty("port", port);
    p.setProperty("user", user);
    p.setProperty("password", password);
    p.setProperty("local", local);

    FileOutputStream arq = new FileOutputStream(FILE_CONFIG);
    p.storeToXML(arq, "", "UTF-8");
    arq.close();
  }

  public void lerConfig() throws Exception {
    Properties p = new Properties();
    FileInputStream arq = new FileInputStream(FILE_CONFIG);
    p.loadFromXML(arq);
    arq.close();

    typeOfConection = p.getProperty("typeOfConection");
    host = p.getProperty("host");
    port = p.getProperty("port");
    user = p.getProperty("user");
    password = p.getProperty("password");
    local = p.getProperty("local");
  }

  public String getTypeOfConection() {
    return typeOfConection;
  }

  public void setTypeOfConection(String typeOfConection) {
    this.typeOfConection = typeOfConection;
  }

  public String getHost() {
    return host;
  }

  public void setHost(String host) {
    this.host = host;
  }

  public String getPort() {
    return port;
  }

  public void setPort(String port) {
    this.port = port;
  }

  public String getUser() {
    return user;
  }

  public void setUser(String user) {
    this.user = user;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getLocal() {
    return local;
  }

  public void setLocal(String local) {
    this.local = local;
  }

}
