
import org.extism.sdk.Plugin;
import org.extism.sdk.manifest.Manifest;
import org.extism.sdk.wasm.PathWasmSource;

import java.util.List;
import java.util.Map;

public class EnhanceSsrWasm {
    public static void main(String[] args) {
        try {
            // Hint: path starts from the root of the java project
            String wasmPath = "./enhance-ssr.wasm";
            String wasmName = "enhance-ssr";

            Manifest manifest = new Manifest(List.of(new PathWasmSource(wasmName, wasmPath, null)));
            Plugin plugin = new Plugin(manifest, true, null);

            Map<String, Object> input = Map.of(
                    "markup", "<my-header>Hello world!</my-header>",
                    "elements", Map.of(
                            "my-header", "function MyHeader({ html }) { return html`<h1><slot></slot></h1> ` }"
                    ),
                    "initialState", List.of()
            );

            String inputJson = new com.google.gson.Gson().toJson(input);

            String output = plugin.call("ssr", inputJson);

            System.out.println("Output: " + output);

            plugin.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
