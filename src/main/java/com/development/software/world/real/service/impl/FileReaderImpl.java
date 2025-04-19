package com.development.software.world.real.service.impl;

import com.development.software.world.real.service.FileReader;
import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@ApplicationScoped
public class FileReaderImpl implements FileReader {

    @ConfigProperty(name = "file.reader.default.path", defaultValue = "src/main/resources")
    String resources;

    @Override
    public List<String> readAllLines(String stringPath) throws IOException {
        return Files.readAllLines(Path.of(resources + stringPath));
    }
}
