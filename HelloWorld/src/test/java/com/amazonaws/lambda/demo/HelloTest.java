package com.amazonaws.lambda.demo;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.amazonaws.services.lambda.runtime.Context;

/**
 * A simple test harness for locally invoking your Lambda function handler.
 */
public class HelloTest {

    private static Map<String, Object> input;

    @BeforeClass
    public static void createInput() throws IOException {
        // TODO: set up your sample input object here.
        input = null;
    }

    private Context createContext() {
        TestContext ctx = new TestContext();

        // TODO: customize your context here if needed.
        ctx.setFunctionName("Your Function Name");

        return ctx;
    }

    @Test
    public void testHello() {
        Hello handler = new Hello();
        Context ctx = createContext();
        //added  by mkrish
        /*input = new HashMap<>();
        input.put("a", new Integer(1));
        Object output = handler.handleRequest(input, ctx);
        System.out.println(output);*/
        // TODO: validate output here if needed.
        //Assert.assertEquals("Hello krishna", output);*/
    }
}
