package solvd.laba.factory.organisation;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import solvd.laba.factory.exceptions.InvalidStringException;
import solvd.laba.factory.production.Factory;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.NoSuchFileException;
import java.util.Arrays;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;

public class Company implements DataSending {
    static final Logger LOGGER = LogManager.getLogger(Company.class);
    private String name;
    private Set<Factory> factories;

    public Company(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.isEmpty()) {
            throw new InvalidStringException("Company name should not be empty");
        }
        this.name = name;
    }

    public Optional<Set<Factory>> getFactories() {
        return Optional.ofNullable(factories);
    }

    public void setFactories(Set<Factory> factories) {
        this.factories = factories;
    }

    @Override
    public String toString() {
        return "Company " + StringUtils.capitalize(name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Company company)) return false;

        return name.equals(company.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    public void generateReport() throws IOException {
        LOGGER.info("Creating income netto report");
        File file = new File("Report.txt");
        try {
            String oldReport = FileUtils.readFileToString(file, StandardCharsets.UTF_8);
            LOGGER.info("Previous report: \n{}", oldReport);
            String[] data = StringUtils.split(oldReport, "\n");
//            int total = 0;
            int total = Arrays.stream(data)
                    .map(str -> StringUtils.split(str, ":")[1] )
                    .map(StringUtils::trim)
                    .map(Integer::parseInt)
                    .reduce(0, Integer::sum);
//            for(String str : data) {
//                total += Integer.parseInt(StringUtils.trim(StringUtils.split(str, ":")[1]));
//            }
            LOGGER.info("Previous total: {}", total);
        } catch (NoSuchFileException e) {
            LOGGER.info("Generating new file");
        }
        String newReport = createReport();
//        for (Factory factory : factories) {
//            String tmp = StringUtils.joinWith(": ", factory.toString(), String.valueOf(factory.calculateTotalIncomeNetto()));
//            tmp = StringUtils.appendIfMissing(tmp, "\n");
//            newReport = StringUtils.joinWith(newReport, tmp);
//        }
        FileUtils.write(file, newReport, StandardCharsets.UTF_8);
    }

    public void sendReport(Consumer<String> sendingFuntion) {
        sendData(sendingFuntion, this::createReport);
    }

    private String createReport() {
        AtomicReference<String> newReport = new AtomicReference<>("");
        factories.stream()
                .map(factory -> StringUtils.joinWith(": ", factory.toString(), String.valueOf(factory.calculateTotalIncomeNetto())))
                .map(tmp -> StringUtils.appendIfMissing(tmp, "\n"))
                .forEach(tmp -> newReport.set(StringUtils.joinWith(newReport.get(), tmp)));
        return String.valueOf(newReport);
    }
}
