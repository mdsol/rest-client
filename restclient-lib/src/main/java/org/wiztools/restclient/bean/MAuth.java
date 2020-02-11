package org.wiztools.restclient.bean;

import java.io.FileNotFoundException;

public interface MAuth extends Auth {
  String getAppUUID();

  String getPrivateKeyFile();

  String getPrivateKeyFromFile() throws FileNotFoundException;

  boolean isV2OnlySignRequests();
}
