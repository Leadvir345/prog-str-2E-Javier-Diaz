package com.example.demolistview.repositories;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class PersonsFileRepositories {

    private final Path filePath = Paths.get("data","persons.csv");

    private void ensureFIle()throws IOException{
        if(Files.notExists(filePath)){
            Files.createFile(filePath);
        }
    }

    public List<String> readAllLines()throws IOException {
        ensureFIle();
        return Files.readAllLines(filePath);
    }

    public void appendNew(String line)throws IOException{
        ensureFIle();
        Files.writeString(filePath,line+System.lineSeparator(), StandardCharsets.UTF_8, StandardOpenOption.APPEND);
    }
}
