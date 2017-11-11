package com.testing.base;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileNameResolver {

    public static List<TestCase> matchTestsToResults(String testFilesRoot, String expectedResultsFilesRoot) {

        List<File> testFiles = Arrays.asList(new File(testFilesRoot).listFiles());
        List<File> expectedResultFiles = Arrays.asList(new File(expectedResultsFilesRoot).listFiles());
        List<TestCase> tests = new ArrayList<TestCase>();


        for (File testFile : testFiles
                ) {
            String[] testFileName = testFile.getName().split("_");

            for (File expectedResultFile :expectedResultFiles
                 ) {
                String[] expectedFileName = expectedResultFile.getName().split("_");

                if(testFileName[0].equals(expectedFileName[0]) && testFileName[1].equalsIgnoreCase(expectedFileName[1])){
                    tests.add(new TestCase(testFile, expectedResultFile));
                }
            }
        }

        return tests;
    }
}
