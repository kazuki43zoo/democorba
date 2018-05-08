package com.example.democorba.support;

import org.springframework.util.FileCopyUtils;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class IorFileSupport {

    private final Path iorFile;

    public IorFileSupport() {
        this.iorFile = Paths.get("target/GreetingService.ior");
    }

    public void write(String ior) {
        try {
            if (Files.exists(iorFile)) {
                Files.delete(iorFile);
            }
            FileCopyUtils.copy(ior, Files.newBufferedWriter(iorFile));
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    public String read() {
        try (InputStream in = Files.newInputStream(iorFile)) {
            return StreamUtils.copyToString(in, StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

}
