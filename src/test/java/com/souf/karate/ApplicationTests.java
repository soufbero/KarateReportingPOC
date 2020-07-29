package com.souf.karate;

import com.intuit.karate.Results;
import com.intuit.karate.Runner;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ApplicationTests {

    private static final String karateOutputPath = "target/surefire-reports";
    private static final String cucumberHtmlPath = "target/cucumber-html-reports";
    private static final String pdfPath = "target/PdfReports";

    @BeforeAll
    static void runBeforeTests(){
        System.out.println("run before tests");
    }

    @Test
    void runTests(){
        List<String> paths = new ArrayList<>();
        paths.add("classpath:KarateTests");

        Results results = Runner.parallel(null,paths,5,karateOutputPath);
        generateReport();
        assertEquals(0,results.getFailCount(),results.getErrorMessages());
    }

    private static void generateReport() {
        Collection<File> jsonFiles = FileUtils.listFiles(new File(karateOutputPath), new String[]{"json"},true);
        List<String> jsonPaths = new ArrayList<>(jsonFiles.size());
        jsonFiles.forEach(file -> jsonPaths.add(file.getAbsolutePath()));
        Configuration config = new Configuration(new File("target"),"Project Testing Results");
        ReportBuilder reportBuilder = new ReportBuilder(jsonPaths,config);
        reportBuilder.generateReports();
    }

    @AfterAll
    static void runAfterTests(){
        System.out.println("run after tests");
    }
}
