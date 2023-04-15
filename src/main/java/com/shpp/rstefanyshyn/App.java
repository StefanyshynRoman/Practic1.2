package com.shpp.rstefanyshyn;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import java.nio.charset.StandardCharsets;
import java.util.Objects;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {
    static String username;
    static String sysTurn;
    private static final Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        Properties prop = new Properties();
        logger.info("Create massage.");
        logger.info("Just a log message. ");
        try {
            logger.warn("Read username.");
            InputStreamReader ree = new InputStreamReader((Objects.requireNonNull(App.class.getClassLoader().getResourceAsStream("config.properties"))), StandardCharsets.UTF_8);
            prop.load(ree);
            username = prop.getProperty("username");
            logger.debug("Username is - " + prop.getProperty("username"));
        } catch (NullPointerException e) {
            logger.error("Error in program: file -" + "- not found");
            System.exit(1);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        logger.warn("Read user type value.");
        try {
            sysTurn = System.getProperty("type").toLowerCase();
        } catch (NullPointerException e) {
            sysTurn = "Json";
        }

        try {
            Message msg = new Message("Привіт " + username + "!");
            if (Objects.equals(sysTurn, "xml")) {
                ObjectMapper xmlMapper = new XmlMapper();
                logger.info("________XML___________");
                String xml = xmlMapper.writeValueAsString(msg);
                logger.error(xml);
                logger.info("If you want output in JSON, write command '-Dtype=JSON'");
            } else {
                logger.info("________JSON____________");
                ObjectMapper jsonMapper = new ObjectMapper();
                String json = jsonMapper.writeValueAsString(msg);
                logger.error(json);
                logger.info("If you want output in XML, write command '-Dtype=xml'");
            }
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
