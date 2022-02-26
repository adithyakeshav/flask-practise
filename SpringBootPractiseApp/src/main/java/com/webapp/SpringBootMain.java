package com.webapp;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import com.webapp.entity.Product;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import static com.webapp.constants.Constants.*;

@SpringBootApplication
public class SpringBootMain {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(SpringBootMain.class);
        Properties properties = new Properties();

        try {
            Properties props= new Properties();
            props.load(new BufferedReader(new FileReader(new File(""))));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Config config = ConfigFactory.parseFile(new File(args[0]));
        properties.put(SERVER_PORT, config.getString(SERVER_PORT));
        properties.put(DATASOURCE_URL, config.getString(DATASOURCE_URL));
        properties.put(DATASOURCE_USERNAME, config.getString(DATASOURCE_USERNAME));
        properties.put(DATASOURCE_PASSWORD, config.getString(DATASOURCE_PASSWORD));
        properties.put(DRIVER_CLASS_NAME, config.getString(DRIVER_CLASS_NAME));
        app.setDefaultProperties(properties);
        app.run(args);
    }

}