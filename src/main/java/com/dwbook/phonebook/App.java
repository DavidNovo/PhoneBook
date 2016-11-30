package com.dwbook.phonebook;

import com.dwbook.phonebook.resources.ContactResource;
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

    /**
     * This method parses the yaml file and creates a POJO.
     * The POJO represents configurations for the application.
     * @param b
     */
    @Override
    public void initialize(Bootstrap<PhonebookConfiguration> b) {

    }

    /**
     * This defines the runtime or execution environment. This method defines which
     * resources and configurations are available when the application runs.
     *
     * @param phonebookConfig
     * @param environment
     * @throws Exception
     */
    @Override
    public void run(PhonebookConfiguration phonebookConfig , Environment environment) throws Exception {
        LOGGER.info("Method App#run() called");

        // this message is sent to the console
        System.out.println("Helloworld, by Dropwizard");

        for (int i=0; i < phonebookConfig.getMessageRepetitions(); i++) {
            System.out.println(phonebookConfig.getMessage());
        }

        // add resource to the environment
        // in this case I am using a jersey instannce
        environment.jersey().register(new ContactResource());
    }
}
