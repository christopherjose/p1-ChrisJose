package com.github.ChrisJose.posSystem.Model;

import com.datastax.oss.driver.api.core.CqlIdentifier;
import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.cql.BoundStatement;
import com.datastax.oss.driver.api.core.cql.PreparedStatement;
import com.datastax.oss.driver.api.core.cql.ResultSet;
import com.datastax.oss.driver.api.core.cql.SimpleStatement;
import com.datastax.oss.driver.api.core.type.DataTypes;
import com.datastax.oss.driver.api.querybuilder.QueryBuilder;
import com.datastax.oss.driver.api.querybuilder.SchemaBuilder;
import com.datastax.oss.driver.api.querybuilder.insert.RegularInsert;
import com.datastax.oss.driver.api.querybuilder.schema.CreateTable;
import com.datastax.oss.driver.api.querybuilder.select.Select;

import java.util.ArrayList;
import java.util.List;

public class CustomerRepository {

    private CqlSession session;
    private String keyspace;
    private static final String table_name = "customerAccounts";

    public CustomerRepository(CqlSession session) {
        this.session = session;
    }
    public String getKeyspace() {
        return keyspace;
    }
    public void setKeyspace(String keyspace) {
        this.keyspace = keyspace;
    }

    public void createTableCustomer() {
        createTableCustomer(null);
    }

    public void createTableCustomer(String keyspace) {
        CreateTable createTable = SchemaBuilder.createTable(table_name)
                .ifNotExists()
                .withPartitionKey("customer_id", DataTypes.TEXT)
                .withColumn("first_name", DataTypes.TEXT)
                .withColumn("last_name", DataTypes.TEXT)
                .withColumn("primary_phone_no", DataTypes.TEXT)
                .withColumn("email", DataTypes.TEXT)
                .withColumn("address", DataTypes.TEXT)
                .withColumn("address2", DataTypes.TEXT)
                .withColumn("city", DataTypes.TEXT)
                .withColumn("state", DataTypes.TEXT)
                .withColumn("zip", DataTypes.TEXT)
                .withColumn("order_id", DataTypes.listOf(DataTypes.TEXT));
        executeTableKeyspace(createTable.build(), keyspace);
    }

    private ResultSet executeTableKeyspace(SimpleStatement statement, String keyspace) {
        if (keyspace != null) {
            statement.setKeyspace(CqlIdentifier.fromCql(keyspace));
        }
        return session.execute(statement);
    }

    public void insertCustomer(Customer customer, String keyspace) {

        //customer.setCustomerId(""); //UUID.randomUUID()

        RegularInsert insertInto = QueryBuilder.insertInto(table_name)
                .value("customer_id", QueryBuilder.bindMarker())
                .value("first_name", QueryBuilder.bindMarker())
                .value("last_name", QueryBuilder.bindMarker())
                .value("primary_phone_no", QueryBuilder.bindMarker())
                .value("email", QueryBuilder.bindMarker())
                .value("address", QueryBuilder.bindMarker())
                .value("address2", QueryBuilder.bindMarker())
                .value("city", QueryBuilder.bindMarker())
                .value("state", QueryBuilder.bindMarker())
                .value("zip", QueryBuilder.bindMarker())
                .value("order_id", QueryBuilder.bindMarker());

        SimpleStatement insertStatement = insertInto.build();
        if (keyspace !=null) {  insertStatement = insertStatement.setKeyspace(keyspace); }

        PreparedStatement preparedStatement = session.prepare(insertStatement);
        BoundStatement statement = preparedStatement.bind()
                .setString(0, customer.getCustomerId())
                .setString(1, customer.getFirstName())
                .setString(2, customer.getLastName())
                .setString(3, customer.getPrimaryPhoneNo())
                .setString(4, customer.getEmail())
                .setString(5, customer.getAddress())
                .setString(6, customer.getAddress2())
                .setString(7, customer.getCity())
                .setString(8, customer.getState())
                .setString(9, customer.getZip())
                //.setList(11, customer.getOrderId())
                ;
        session.execute(statement);

        // return customerId;
        //source: https://www.baeldung.com/cassandra-datastax-java-driver
    }

    public List<Customer> selectAll(String keyspace) {
        Select select = QueryBuilder.selectFrom(table_name).all();
        ResultSet resultSet = executeTableKeyspace(select.build(), keyspace);
        List<Customer> result = new ArrayList<>();

        resultSet.forEach(j -> result.add(
                new Customer(
                        j.getString("customer_id"),
                        j.getString("first_name"),
                        j.getString("last_name"),
                        j.getString("primary_phone_no"),
                        j.getString("email"),
                        j.getString("address"),
                        j.getString("address2"),
                        j.getString("city"),
                        j.getString("state"),
                        j.getString("zip")
                )));

        return result;
    }


}
