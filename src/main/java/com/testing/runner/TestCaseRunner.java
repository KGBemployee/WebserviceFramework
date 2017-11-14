/*
 * Created by Costea Mihai Alexandru on 11/14/17 7:02 PM
 * Copyright (c) 2017.
 * All rights reserved.
 *
 * Last modified 11/14/17 7:02 PM
 */

package com.testing.runner;

import com.testing.base.TestCase;

import java.util.List;

public class TestCaseRunner {
    public static void runTestCasesInList(List<TestCase> testCases){
        for (TestCase test: testCases
             ) {
            test.run();
        }
    }
}
