package com.testing.base;

import java.io.File;

public class TestCase {

    private File testFile;
    private File expectedResultFile;

    public TestCase(File testFile, File expectedResultFile) {
        this.testFile = testFile;
        this.expectedResultFile = expectedResultFile;
    }

    public void run(){
        // TODO: 11/11/2017 add code that will run the test and report on the result
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
