package com.mso.ph.programhelper.json;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public class JsonUtil {
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static <T> T fromJson(Reader reader, Class<T> clazz) throws IOException {
        return gson.fromJson(reader, clazz);
    }

    public static void toJson(Writer writer, Object obj) throws IOException {
        gson.toJson(obj, writer);
        writer.flush();
    }


    public static <T> T fromJsonFile(Path filePath, Class<T> clazz) throws IOException {
        try (Reader reader = Files.newBufferedReader(filePath, StandardCharsets.UTF_8)) {
            return gson.fromJson(reader, clazz);
        }
    }

    public static void toJsonFile(Path filePath, Object obj) throws IOException {
        try (Writer writer = Files.newBufferedWriter(filePath, StandardCharsets.UTF_8)) {
            gson.toJson(obj, writer);
        }
    }

    public static <T> T fromJsonResource(String resourcePath, Class<T> clazz) throws IOException {
        try (InputStream inputStream = JsonUtil.class.getResourceAsStream(resourcePath);
             Reader reader = new InputStreamReader(inputStream, StandardCharsets.UTF_8)) {
            return gson.fromJson(reader, clazz);
        }
    }
}
