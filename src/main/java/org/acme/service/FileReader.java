package org.acme.service;

import java.io.IOException;
import java.util.List;

public interface FileReader {

    List<String> readAllLines(String fileName) throws IOException;
}
