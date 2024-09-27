package solvd.laba.factory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import solvd.laba.factory.employees.ChiefManager;
import solvd.laba.factory.employees.Manager;
import solvd.laba.factory.employees.Worker;
import solvd.laba.factory.exceptions.NegativeArgumentException;
import solvd.laba.factory.multithreading.CustomConnectionPool;
import solvd.laba.factory.multithreading.Task;
import solvd.laba.factory.multithreading.TaskThread;
import solvd.laba.factory.organisation.Company;
import solvd.laba.factory.organisation.Location;
import solvd.laba.factory.organisation.Supplier;
import solvd.laba.factory.product.CarModel;
import solvd.laba.factory.product.Engine;
import solvd.laba.factory.production.Factory;
import solvd.laba.factory.production.ProductionLine;
import solvd.laba.factory.production.Workstation;
import solvd.laba.factory.util.CustomLinkedList;

import java.io.IOException;
import java.lang.reflect.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Scanner;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        LOGGER.trace("Program start");
//        System.out.println("Let's create Car company with 1 factory");
        LOGGER.info("Let's create Car company with 1 factory");

//        CarModel.declareNumberOfWheels(4);

        System.out.print("Enter planned factory opening date (yyyy-mm-dd): ");
        LocalDate openingDate = null;
//        try (Scanner scanner = new Scanner(System.in)) {
//            String dateString = scanner.next();
//            openingDate = LocalDate.parse(dateString, DateTimeFormatter.ISO_LOCAL_DATE);
//        } catch (Exception e) {
//            LOGGER.error("", e);
//        }

        Engine engine = new Engine("Type I", 100, 20000);
        CarModel carModel = new CarModel("T1", engine, 70000);
        Worker worker;
        try {
            worker = new Worker("John", "Doe", 1, openingDate, "Example of worker");
        } catch (NegativeArgumentException e) {
            LOGGER.error("Problem with id while creating worker", e);
            worker = new Worker();
        }
        Workstation workstation = new Workstation(1);
        workstation.setWorker(worker);
        CustomLinkedList<Workstation> workstations = new CustomLinkedList<>();
        workstations.add(workstation);
        Manager manager;
        try {
            manager = new Manager("Jane", "Smith", 10, openingDate);
        } catch (NegativeArgumentException e) {
            LOGGER.error("Problem with id while creating manager", e);
            manager = new Manager();
        }
        ProductionLine productionLine = new ProductionLine(manager, workstations, carModel);
        CustomLinkedList<ProductionLine> productionLines = new CustomLinkedList<>();
        productionLines.add(productionLine);

        Location location = new Location(100000, "Example 1");
        Supplier supplier = new Supplier("Supplies inc.");
        HashSet<Supplier> suppliers = new HashSet<>();
        suppliers.add(supplier);
        ChiefManager chiefManager = new ChiefManager("Adam", "Jones", 100, openingDate);
        Factory factory = new Factory(location, chiefManager, productionLines, suppliers, openingDate);
        HashSet<Factory> factories = new HashSet<>();
        factories.add(factory);
        Company company = new Company("Car company");
        company.setFactories(factories);

        try {
            company.generateReport();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //reflection for Company
        System.out.println("Reflections:");
        Class companyClass = company.getClass();
        Object companyExample;
        try {
            Constructor companyConstructor = companyClass.getConstructor(String.class);
            companyExample = companyConstructor.newInstance("Example Inc.");
            System.out.println(companyExample);
            Field[] companyfields = companyClass.getDeclaredFields();
            System.out.println(companyfields[1].getName());
            System.out.println(Modifier.toString(companyfields[1].getModifiers()));
            companyfields[1].setAccessible(true);
            companyfields[1].set(companyExample, "New Example Inc.");
            companyfields[1].setAccessible(false);
            System.out.println(companyExample);
            Method companySetter = companyClass.getDeclaredMethod("setName", String.class);
            companySetter.invoke(companyExample, "New New Example Inc.");
            System.out.println(companyExample);
        } catch (NoSuchMethodException | InvocationTargetException | InstantiationException |
                 IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        //multithreading
        System.out.println("Multithreading:");
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(120000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "Example of usage of CompletableFuture";
        });
        TaskThread taskThread = new TaskThread();
        taskThread.start();
        CustomConnectionPool connectionPool = CustomConnectionPool.getConnectionPool(5);
        ExecutorService threadPool = Executors.newFixedThreadPool(7);

        threadPool.submit(new Task(1, connectionPool));
        threadPool.submit(new Task(2, connectionPool));
        threadPool.submit(new Task(3, connectionPool));
        threadPool.submit(new Task(4, connectionPool));
        threadPool.submit(new Task(5, connectionPool));
        threadPool.submit(new Task(6, connectionPool));
        threadPool.submit(new Task(7, connectionPool));

        threadPool.shutdown();
        connectionPool.close();

        System.out.println(completableFuture.get());
    }
}