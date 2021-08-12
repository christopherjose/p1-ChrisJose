package com.github.ChrisJose.posSystem;

import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.type.DataTypes;
import com.datastax.oss.driver.api.querybuilder.SchemaBuilder;
import com.datastax.oss.driver.api.querybuilder.schema.CreateKeyspace;
import com.datastax.oss.driver.api.querybuilder.schema.CreateTable;

public class App {

    public static void main(String[] args) {

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


    }
}
