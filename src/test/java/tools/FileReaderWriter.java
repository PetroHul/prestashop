package tools;

import java.io.*;

public class FileReaderWriter {


    public static String getFromFile(String path) throws IOException {
        String id = "";
        BufferedReader br = new BufferedReader(new FileReader(path));
        String line = "";
        while ((line = br.readLine()) != null) {
            String[] data = line.split(" ");
            id = data[0];
        }

        return id;
    }

    public static void saveInFile(String path, String id) throws IOException {

        BufferedWriter bw = new BufferedWriter(new FileWriter(path));

        String data = id;
        try {
            bw.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
        bw.close();
    }


}
