import com.google.gson.Gson;
import readers.FileReader;
import readers.FileReaderImpl;
import validators.SellerValidator;
import validators.Validator;
import writers.FileWriter;
import writers.FileWriterImpl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    private static final String RESULT_FILE_PATH = "D:\\Java2\\SalesMan\\src\\main\\resources\\result.txt";

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Gson gson = new Gson();
        FileReader fileReader = new FileReaderImpl();
        PrintWriter resultWriter = new PrintWriter(new java.io.FileWriter(RESULT_FILE_PATH));
        Validator validator = new SellerValidator();


        String dataFilePath = scanner.nextLine();
        String reportFilePath = scanner.nextLine();

        FileWriter fileWriter = new FileWriterImpl(fileReader , gson, resultWriter, validator);
        fileWriter.write(dataFilePath, reportFilePath);
    }
}
