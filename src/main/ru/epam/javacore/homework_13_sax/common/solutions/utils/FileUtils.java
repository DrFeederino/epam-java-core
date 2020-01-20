package main.ru.epam.javacore.homework_13_sax.common.solutions.utils;

import main.ru.epam.javacore.homework_13_sax.application.Application;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public final class FileUtils {

    private FileUtils() {

    }

    public static File createFileFromResource(String fileNamePrefix, String fileNameSuffix, String resourcePath) throws IOException {
        try (InputStream inputStream = Application.class.getResourceAsStream(resourcePath)) {
            Path tempFile = Files.createTempFile(fileNamePrefix, fileNameSuffix);
            Files.copy(inputStream, tempFile, REPLACE_EXISTING);
            return tempFile.toFile();
        }
    }

}
