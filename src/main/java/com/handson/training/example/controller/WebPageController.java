package com.handson.training.example.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.core.io.Resource;

import javax.imageio.IIOException;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.URISyntaxException;

import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;
import java.time.Clock;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class WebPageController {

    public WebPageController(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    private static final Logger logger = LoggerFactory.getLogger(WebPageController.class);

    @Autowired
    ResourceLoader resourceLoader;

    @GetMapping("/")
    public String index() {
        return "<html> <b><font color='blue' size='5'>This is Java based SpringBoot Application for Demonstration.</b></html>";
    }

    @GetMapping(value={"/service","/service/{name}"})
    public String service(@PathVariable(required = false) String name) throws IOException, URISyntaxException {
        String htmlService=null;
        Resource resource2= loadServiceHtmlFileWithResourceLoader();
        InputStream inputStream= resource2.getInputStream();
        try{
            byte[] servicedata= FileCopyUtils.copyToByteArray(inputStream);
            htmlService= new String(servicedata, StandardCharsets.UTF_8);
            logger.info(htmlService);

        }
        catch(IOException e){
            logger.error("IOException", e);

        }
        validateHTMLService(htmlService);
        String customeName = StringUtils.isEmpty(name)?"devops":name;
        htmlService=getService(customeName, htmlService);

    return htmlService;
    }

    @GetMapping(value = {"/welcome", "/welcome/{user}"})
    public String welcome(@PathVariable(required = false) String user) throws IOException, URISyntaxException {
        String htmlString = null;
        Resource resource1 = loadWelComeHtmlFileWithResourceLoader();
        InputStream inputStream = resource1.getInputStream();
        try {
            byte[] bdata = FileCopyUtils.copyToByteArray(inputStream);
            htmlString = new String(bdata, StandardCharsets.UTF_8);
            logger.info(htmlString);
        } catch (IOException e) {
            logger.error("IOException", e);
        }

        validateHTMLString(htmlString);
        htmlString = getString(user, htmlString);

        return htmlString;

    }

    public void validateHTMLString(String htmlString) {
        if(StringUtils.isEmpty(htmlString)){
            logger.info("File content is : "+ htmlString);
            logger.error("File content is NULL");
            throw new NullPointerException();
        }
    }

    public  void validateHTMLService(String htmlService){
        if(StringUtils.isEmpty(htmlService)){
            logger.info("service page is running:"+htmlService);
            logger.error("there is no content in the service page");
            throw new NullPointerException();
        }


    }

    public String getString(String user, String htmlString) throws UnknownHostException {
        String userName = StringUtils.isEmpty(user) ? "Participant" : user;
        htmlString = htmlString.replace("$userName", userName);
        htmlString = htmlString.replace("$date", java.time.LocalDate.now().toString());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss:SS");
        htmlString = htmlString.replace("$time",java.time.LocalTime.now().format(formatter));
        htmlString = htmlString.replace("$hostName", InetAddress.getLocalHost().getHostName());
        return htmlString;
    }
    public String getService(String name, String htmlService) throws UnknownHostException{
        htmlService=htmlService.replace("$name", name);
        return htmlService;

    }

    public Resource loadWelComeHtmlFileWithResourceLoader() {
        return resourceLoader.getResource(
                "classpath:welcome.html");
    }
    public Resource loadServiceHtmlFileWithResourceLoader(){
        return resourceLoader.getResource("classpath:service.html");
    }
}
