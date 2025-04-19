package com.development.software.world.real.service.impl;

import jakarta.enterprise.context.ApplicationScoped;
import com.development.software.world.real.service.FileReader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@ApplicationScoped
public class FileReaderImpl implements FileReader {

    private static final String RESOURCES = "src/main/resources";


    @Override
    public List<String> readAllLines(String stringPath) throws IOException {
        return Files.readAllLines(Path.of(RESOURCES + stringPath));
    }
}
