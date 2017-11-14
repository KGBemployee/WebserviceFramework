/*
 * Created by Costea Mihai Alexandru on 11/14/17 7:05 PM
 * Copyright (c) 2017.
 * All rights reserved.
 *
 * Last modified 11/14/17 7:05 PM
 */

package com.tests.webServiceTests;

import com.testing.base.FileNameResolver;
import com.testing.runner.TestCaseRunner;
import org.junit.Test;

public class WebServiceTestOne {

    @Test
    public void testWebService() throws Exception {
        TestCaseRunner.runTestCasesInList(FileNameResolver.matchTestsToResults("address","secondAddress"));
    }
}
