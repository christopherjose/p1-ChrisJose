package com.github.ChrisJose.posSystem.Model;

import com.github.ChrisJose.posSystem.Console;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class App {

    private static final Logger log = LogManager.getLogger(App.class.getName());

    public static void main(String[] args) {

        log.info("Entering Application");

        Console console = new Console();
        console.run();

        log.info("Exiting Application.");

    }

}



/*
        CqlSession session = CqlSession.builder().build();

        CreateKeyspace database = SchemaBuilder.createKeyspace("database").ifNotExists()
                .withSimpleStrategy(1);
        session.execute(database.build());

        CreateTable customerAccount = SchemaBuilder.createTable("database","customerAccount")
                .ifNotExists()
                .withPartitionKey("customer_id", DataTypes.UUID)
                .withColumn("customer_name",DataTypes.TEXT);
                session.execute(customerAccount.build());
        session.close();
        */
