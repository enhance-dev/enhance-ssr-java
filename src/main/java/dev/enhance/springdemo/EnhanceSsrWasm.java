package dev.enhance.springdemo;
import org.extism.sdk.Plugin;
import org.extism.sdk.manifest.Manifest;
import org.extism.sdk.wasm.PathWasmSource;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import dev.enhance.springdemo.EnhanceSsrWasmResponse;

public class EnhanceSsrWasm {

    private static Map<String, String> readElements(String directory) {
        File folder = new File(directory);
        Map<String, String> elements = new HashMap<String, String>();

        for (final File fileEntry : folder.listFiles()) {
            if (!fileEntry.isDirectory()) {
                try {
                    String name = fileEntry.getName();
                    Path fileName = Path.of(fileEntry.getAbsolutePath());
                    String value = Files.readString(fileName);

                    elements.put(name.substring(0, name.lastIndexOf(".")), value);
                } catch (IOException ioe) {
                    System.out.println("Failed to read file");
                }
            }
        }

        return elements;
    }
    public static String ssr(String document) {
        EnhanceSsrWasmResponse response = null;
        try {
            // Hint: path starts from the root of the java project
            String wasmPath = "./enhance-ssr.wasm";
            String wasmName = "enhance-ssr";

            Manifest manifest = new Manifest(List.of(new PathWasmSource(wasmName, wasmPath, null)));
            Plugin plugin = new Plugin(manifest, true, null);

            Map<String, Object> input = Map.of(
                    "markup", document,
                    "elements", readElements("elements"),
                    "initialState", List.of()
            );

            String inputJson = new Gson().toJson(input);
            String output = plugin.call("ssr", inputJson);
            Gson gson = new Gson();
            response = gson.fromJson(output, EnhanceSsrWasmResponse.class);

            plugin.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return response.getDocument();
    }
}
