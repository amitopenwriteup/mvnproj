package com.handson.training.example.helper;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CommonTest {

    Common common;
    private static final Logger logger = LoggerFactory.getLogger(Common.class);
    @Before
    public void setup(){
        common = new Common();

    }

    @Test
    public void test1() {
        common.test();
    }
}