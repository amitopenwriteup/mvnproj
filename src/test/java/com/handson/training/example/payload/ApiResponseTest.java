package com.handson.training.example.payload;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ApiResponseTest {

    ApiResponse apiResponse;
    private static final Logger logger = LoggerFactory.getLogger(ApiResponseTest.class);
    @Before
    public void setup(){
        apiResponse=
                new ApiResponse(true, "test");
    }

    @Test
    public void getSuccess() {
        Boolean message = apiResponse.getSuccess();
        Assert.assertTrue(message);
    }

    @Test
    public void getMessage() {
        String message = apiResponse.getMessage();
        Assert.assertThat(message, CoreMatchers.containsString("test"));
    }
}