package readers;

import java.io.*;

public class FileReaderImpl implements FileReader {

    @Override
    public String readFile(String filePath) throws IOException {
        BufferedReader reader = new BufferedReader(
        new InputStreamReader(
        new FileInputStream(
        new File(filePath))));

        StringBuilder sb = new StringBuilder();
        String line;

        while ((line = reader.readLine()) != null) {
            sb.append(line).append(System.lineSeparator());
        }

        return sb.toString().trim();
    }
}
