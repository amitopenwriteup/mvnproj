package com.handson.training.example.helper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Common {
    public static final String FUTURE_EFFECTIVE_PATTERN = "[a-zA-Z]*";
    public static final String MODEL_NAME_PATTERN = "([A-Za-z]+[0-9]|[0-9]+[A-Za-z])[A-Za-z0-9]*";
    private static final Logger logger = LoggerFactory.getLogger(Common.class);
    public void test(){
        logger.info(FUTURE_EFFECTIVE_PATTERN);
        logger.info(MODEL_NAME_PATTERN);
    }
}
