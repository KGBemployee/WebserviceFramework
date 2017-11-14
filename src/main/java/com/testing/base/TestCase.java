/*
 * Created by Costea Mihai Alexandru on 11/11/17 4:05 PM
 * Copyright (c) 2017.
 * All rights reserved.
 *
 * Last modified 11/11/17 3:21 PM
 */

package com.testing.base;

import org.junit.Assert;
import org.xmlunit.builder.DiffBuilder;
import org.xmlunit.builder.Input;
import org.xmlunit.diff.Diff;

import java.io.File;

public class TestCase {

    private File testFile;
    private File expectedResultFile;

    public TestCase(File testFile, File expectedResultFile) {
        this.testFile = testFile;
        this.expectedResultFile = expectedResultFile;
    }

    public void run(){
        String requestResponse = HttpRequestExecutor.invokeWebService(testFile, PropertiesHandler.getInstance()
                .getValue("meteringWebService"));

        Diff differences = DiffBuilder.compare(Input.fromFile(expectedResultFile)).withNodeFilter(node -> !node.getNodeName()
                .equalsIgnoreCase("DocumentPeriod")).withNodeFilter(node -> !node.getNodeName()
                .equalsIgnoreCase("DocumentId")).withTest(Input.fromString(requestResponse)).build();

        Assert.assertFalse(differences.toString(),differences.hasDifferences());
    }

    public File getTestFile() {
        return testFile;
    }

    public void setTestFile(File testFile) {
        this.testFile = testFile;
    }

    public File getExpectedResultFile() {
        return expectedResultFile;
    }

    public void setExpectedResultFile(File expectedResultFile) {
        this.expectedResultFile = expectedResultFile;
    }

    @Override
    public String toString() {
        return "TestCase{" +
                "testFile=" + testFile +
                ", expectedResultFile=" + expectedResultFile +
                '}';
    }
}
