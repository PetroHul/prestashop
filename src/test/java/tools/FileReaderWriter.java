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

    public static String generateStringFromXML(String path) throws IOException {
        File xmlFile = new File(path);
        Reader fileReader = new FileReader(xmlFile);
        BufferedReader bufReader = new BufferedReader(fileReader);
        StringBuilder sb = new StringBuilder();
        String line = bufReader.readLine();
        while (line != null) {
            sb.append(line).append("\n");
            line = bufReader.readLine();
        }
        String xmlString = sb.toString();

        return xmlString;
    }

}
