package com.dwbook.phonebook;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

/**
 * Hello world!
 *
 */
public class App extends Application<PhonebookConfiguration> {
    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

    public static void main( String[] args ) throws Exception {
        new App().run(args);
    }

    @Override
    public void initialize(Bootstrap<PhonebookConfiguration> b) {

    }

    @Override
    public void run(PhonebookConfiguration phonebookConfig , Environment environment) throws Exception {
        LOGGER.info("Method App#run() called");

        // this message is sent to the console
        System.out.println("Helloworld, by Dropwizard");

        for (int i=0; i < phonebookConfig.getMessageRepetitions(); i++) {
            System.out.println(phonebookConfig.getMessage());
        }
    }
}
