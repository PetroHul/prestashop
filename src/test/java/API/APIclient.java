package API;

import io.restassured.path.xml.XmlPath;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class APIclient {
    public static byte[] generateBytesArrayFromResource(String path) throws IOException {
        return Files.readAllBytes(Paths.get(path));
    }

}
