package com.test.api.function;

import org.testng.Assert;

public class DataType {
    
    public void isInteger(Object data) {
        Assert.assertEquals(data.getClass().getName(), "java.lang.Integer");
    }

    public void isString(Object data) {
        Assert.assertEquals(data.getClass().getName(), "java.lang.String");
    }
}