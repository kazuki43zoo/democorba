package com.example.democorba.server;

import com.example.democorba.service.BytesDataHolder;
import com.example.democorba.service.GreetingServiceOperations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class GreetingServiceImpl implements GreetingServiceOperations {

    private static final Charset CHARSET = StandardCharsets.UTF_8;
    private static final Logger LOGGER = LoggerFactory.getLogger(GreetingServiceImpl.class);

    @Override
    public String hello(String message) {
        LOGGER.info("call hello with this: {} thread: {} message : {}", this, Thread.currentThread().getId(), message);
        return "Hello !! (" + message + ") by hello";
    }

    @Override
    public void execute(byte[] request, BytesDataHolder response) {
        LOGGER.info("call execute with this: {} thread: {} message : {}", this, Thread.currentThread().getId(), new String(request, CHARSET));
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            out.write("Hello !! (".getBytes(CHARSET));
            out.write(request);
            out.write(") by execute".getBytes(CHARSET));
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
        response.value = out.toByteArray();
    }

}
