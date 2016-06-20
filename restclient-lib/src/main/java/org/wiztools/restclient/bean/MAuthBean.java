package org.wiztools.restclient.bean;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Objects;
import java.util.Scanner;

public class MAuthBean implements MAuth {

  private String appUUID;
  private String privateKeyFile;

  @Override
  public String getAppUUID() {
    return appUUID;
  }

  public void setAppUUID(String appUUID) {
    this.appUUID = appUUID;
  }

  @Override
  public String getPrivateKeyFile() {
    return privateKeyFile;
  }

  @Override
  public String getPrivateKeyFromFile() throws FileNotFoundException {
    return readFile(privateKeyFile);
  }

  public void setPrivateKeyFile(String privateKeyFile) {
    this.privateKeyFile = privateKeyFile;
  }

  private String readFile(String path) throws FileNotFoundException {
    Scanner scanner = new Scanner(new File(path));
    String privateKeyText = scanner.useDelimiter("\\A").next();
    scanner.close();
    return privateKeyText;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    MAuthBean mAuthBean = (MAuthBean) o;
    return Objects.equals(appUUID, mAuthBean.appUUID) &&
        Objects.equals(privateKeyFile, mAuthBean.privateKeyFile);
  }

  @Override
  public int hashCode() {
    return Objects.hash(appUUID, privateKeyFile);
  }

  @Override
  public String toString() {
    return "MAuthBean{" +
        "appUUID='" + appUUID + '\'' +
        ", privateKeyFile='" + privateKeyFile + '\'' +
        '}';
  }
}
