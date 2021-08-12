package com.github.ChrisJose.posSystem;
import com.datastax.oss.driver.api.core.CqlIdentifier;
import com.datastax.oss.driver.api.core.cql.ResultSet;
import com.datastax.oss.driver.api.core.cql.SimpleStatement;
import com.datastax.oss.driver.api.core.type.DataTypes;
import com.datastax.oss.driver.api.querybuilder.QueryBuilder;
import com.datastax.oss.driver.api.querybuilder.SchemaBuilder;
import com.datastax.oss.driver.api.querybuilder.insert.RegularInsert;
import com.datastax.oss.driver.api.querybuilder.schema.CreateTable;

import java.util.UUID;

public class Customer {

    private UUID customerId;
    private String firstName;
    private String lastName;
    private String primaryPhoneNo;
    private String emailAddress;
    private String address;
    private String address2;
    private String city;
    private String state;
    private String zip;
    private static final String table_name = "customerAccounts";

    Customer(String customerId,
             String firstName, String lastName, String primaryPhoneNo, String emailAddress,
             String address, String address2, String city, String state, String zip) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setPrimaryPhoneNo(primaryPhoneNo);
        this.setEmailAddress(emailAddress);
        this.setAddress(address);
        this.setAddress2(address2);
        this.setCity(city);
        this.setState(state);
        this.setZip(zip);
    }

    public void createTableCustomer(String keyspace) {
        CreateTable createTable = SchemaBuilder.createTable(table_name)
                .withPartitionKey("customerId", DataTypes.UUID)
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

    public UUID insertCustomer(Customer customer, String keyspace) {

        customer.setCustomerId(UUID.randomUUID());

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


    }


















    //GETTER & SETTER Statements
    public UUID getCustomerId() {
        return customerId;
    }

    public void setCustomerId(UUID customerId) {
        this.customerId = customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPrimaryPhoneNo() {
        return primaryPhoneNo;
    }

    public void setPrimaryPhoneNo(String primaryPhoneNo) {
        this.primaryPhoneNo = primaryPhoneNo;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }





}
