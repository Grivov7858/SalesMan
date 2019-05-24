package writers;

import com.google.gson.Gson;
import entities.Report;
import entities.Seller;
import readers.FileReader;
import validators.Validator;

import java.io.IOException;
import java.io.PrintWriter;

public class FileWriterImpl implements FileWriter {
    private final FileReader fileReader;
    private final Gson gson;
    private final PrintWriter resultWriter;
    private final Validator validator;

    public FileWriterImpl(FileReader fileReader, Gson gson, PrintWriter printWriter, Validator validator) {
        this.fileReader = fileReader;
        this.gson = gson;
        this.resultWriter = printWriter;
        this.validator = validator;
    }

    @Override
    public void write(String dataFilePath, String reportFilePath) throws IOException {
        String dataFile = fileReader.readFile(dataFilePath);
        String reportFile = fileReader.readFile(reportFilePath);

        Seller[] sellers = gson.fromJson(dataFile, Seller[].class);
        Report report = gson.fromJson(reportFile, Report.class);

        resultWriter.println("Name   , Score");
        for (Seller seller : sellers) {
            double sellerScore;

            if (report.isUseExperienceMultiplier()) {
                sellerScore = Math.round(
                        (seller.getTotalSales() / (seller.getSalesPeriod() * seller.getExperienceMultiplier())) * 10) / 10.0;
            } else {
                sellerScore = Math.round((seller.getTotalSales() / seller.getSalesPeriod()) * 10) / 10.0;
            }

            if (validator.isValid(seller, report, sellerScore)) {
                resultWriter.printf("%s, %.1f", seller.getName(), sellerScore);
                resultWriter.println();
            }
        }
        resultWriter.close();
    }
}