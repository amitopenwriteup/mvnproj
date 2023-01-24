package com.handson.training.example.controller;

import org.apache.commons.io.FileUtils;
import org.hamcrest.CoreMatchers;
import org.junit.*;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ResourceLoader;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;

public class WebPageControllerTest {

    WebPageController webPageController;
    ResourceLoader resourceLoader;
    private static final Logger logger = LoggerFactory.getLogger(WebPageControllerTest.class);
    @Before
    public void setup(){

        webPageController=
                new WebPageController(resourceLoader);

    }

    @Test
    public void indexShouldNotBeNull() {
        String defaultMessage = webPageController.index();
        logger.info("Default Message is "+defaultMessage);
        Assert.assertNotNull(defaultMessage);


    }

    @Test
    public void indexMustHaveContainsHTMLTag() {
        String defaultMessage = webPageController.index();
        logger.info("Default Message is "+defaultMessage);
        Assert.assertThat(defaultMessage, CoreMatchers.containsString("<html>"));
    }

    @Test(expected = NullPointerException.class)
    public void welcomeWithUserNameAsNull() throws IOException, URISyntaxException {
        String output = webPageController.welcome(null);
        logger.info("Default output is "+output);
        Assert.assertThat(output, CoreMatchers.containsString("<b> Participant </b>"));
    }

    @Test
    public void welcomeWithUserNameAsElon() throws IOException, URISyntaxException {
        String htmlString = getString();
        String output = webPageController.getString("Elon",htmlString);
        logger.info("Default output is "+output);
        Assert.assertThat(output, CoreMatchers.containsString("Elon"));
    }

    @Test
    public void welcomeWithUserNameAsRishi() throws IOException, URISyntaxException {
        String htmlString = getString();
        String output = webPageController.getString("Rishi",htmlString);
        logger.info("Default output is "+output);
        Assert.assertThat(output, CoreMatchers.containsString("Rishi"));
    }

    @Test
    public void validateHTMLString() throws IOException, URISyntaxException {
        String htmlString = getString();
        webPageController.validateHTMLString(htmlString);
    }


    @Test(expected = NullPointerException.class)
    public void validateHTMLStringWithBlankValue() throws IOException, URISyntaxException {
        webPageController.validateHTMLString("");
    }
    @Test
    public void welcomeWithUserNameAsDevops() throws IOException,URISyntaxException{
        String data= getService();
        String output =webPageController.getService("DevOps",data);
        logger.info("Default output is"+output);
        Assert.assertThat(output, CoreMatchers.containsString("<b>DevOps</b>"));

    }
    @Test(expected = NullPointerException.class)
    public void NullValueService() throws IOException, URISyntaxException{
        String output=webPageController.service("null");
        logger.info("Default output is "+output);
        Assert.assertThat(output, CoreMatchers.containsString("<devOps>"));

    }
    @Ignore
    @Test
    public void ServiceMustHaveTag() throws IOException , URISyntaxException{
        String TagMessage=webPageController.service("devops");
        logger.info("Defalut message is" +TagMessage);
        Assert.assertThat(TagMessage, CoreMatchers.containsString("<body>"));

    }
    @Test(expected = NullPointerException.class)
    public void HtmlServiceWithBlankValue() throws IOException, URISyntaxException{
         webPageController.validateHTMLService("");

    }
    @Test
    public void ValidHtmlService() throws IOException, URISyntaxException{
        String servicedata=getService();
        webPageController.validateHTMLService(servicedata);
    }

    private String getString() throws URISyntaxException, IOException {
        File htmlTemplateFile;
        URL resource = getClass().getClassLoader().getResource("welcome.html");
        if (resource == null) {
            throw new IllegalArgumentException("file not found!");
        } else {
            logger.info("URI is "+resource.toURI().toString());
            htmlTemplateFile =  new File(resource.toURI());
        }

        return FileUtils.readFileToString(htmlTemplateFile, Charset.defaultCharset());
    }
    private String getService() throws URISyntaxException, IOException {
        File htmlTemplateFile;
        URL resource = getClass().getClassLoader().getResource("service.html");
        if (resource == null) {
            throw new IllegalArgumentException("file not found!");
        } else {
            logger.info("URI is "+resource.toURI().toString());
            htmlTemplateFile =  new File(resource.toURI());
        }

        return FileUtils.readFileToString(htmlTemplateFile, Charset.defaultCharset());
    }
}
