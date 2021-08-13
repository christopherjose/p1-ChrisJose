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

public class OrderRepository {

    private CqlSession session;
    private String keyspace;
    private static final String table_name = "OrderAccounts";

    public OrderRepository(CqlSession session) {
        this.session = session;
    }
    public String getKeyspace() {
        return keyspace;
    }
    public void setKeyspace(String keyspace) {
        this.keyspace = keyspace;
    }

    public void createTableOrder() {
        createTableOrder(null);
    }

    public void createTableOrder(String keyspace) {
        CreateTable createTable = SchemaBuilder.createTable(table_name)
                .ifNotExists()
                .withPartitionKey("customer_id", DataTypes.TEXT)
                .withColumn("order_id", DataTypes.TEXT)
                .withColumn("status", DataTypes.TEXT)
                .withColumn("comment", DataTypes.TEXT)
                .withColumn("sales_associate", DataTypes.TEXT)
                .withColumn("order_date", DataTypes.TEXT)
                .withColumn("sub_total", DataTypes.FLOAT)
                .withColumn("sales_tax", DataTypes.FLOAT)
                .withColumn("total_amt", DataTypes.FLOAT)
                .withColumn("payment", DataTypes.FLOAT)
                .withColumn("financing", DataTypes.FLOAT)
                .withColumn("balance_due", DataTypes.FLOAT);
        executeTableKeyspace(createTable.build(), keyspace);
    }

    private ResultSet executeTableKeyspace(SimpleStatement statement, String keyspace) {
        if (keyspace != null) {
            statement.setKeyspace(CqlIdentifier.fromCql(keyspace));
        }
        return session.execute(statement);
    }

    public void insertOrder(Order Order, String keyspace) {

        RegularInsert insertInto = QueryBuilder.insertInto(table_name)
                .value("customer_id", QueryBuilder.bindMarker())
                .value("order_id", QueryBuilder.bindMarker())
                .value("status", QueryBuilder.bindMarker())
                .value("comment", QueryBuilder.bindMarker())
                .value("sales_associate", QueryBuilder.bindMarker())
                .value("order_date", QueryBuilder.bindMarker())
                .value("sub_total", QueryBuilder.bindMarker())
                .value("sales_tax", QueryBuilder.bindMarker())
                .value("total_amt", QueryBuilder.bindMarker())
                .value("payment", QueryBuilder.bindMarker())
                .value("financing", QueryBuilder.bindMarker())
                .value("balance_due", QueryBuilder.bindMarker())
                ;

        SimpleStatement insertStatement = insertInto.build();
        if (keyspace !=null) {  insertStatement = insertStatement.setKeyspace(keyspace); }

        PreparedStatement preparedStatement = session.prepare(insertStatement);
        BoundStatement statement = preparedStatement.bind()
                .setString(0, Order.getCustomerId())
                .setString(1, Order.getOrderId())
                .setString(2, Order.getStatus())
                .setString(3, Order.getComment())
                .setString(4, Order.getSalesAssociate())
                .setString(5, Order.getOrderDate())
                .setFloat(6, Order.getSubTotal())
                .setFloat(7, Order.getSalesTax())
                .setFloat(8, Order.getTotalAmt())
                .setFloat(9, Order.getPayment())
                .setFloat(9, Order.getFinancing())
                .setFloat(9, Order.getBalanceDue())
                ;
        session.execute(statement);

        // return OrderId;
        //source: https://www.baeldung.com/cassandra-datastax-java-driver
    }


    /*
    public List<Order> selectAll(String keyspace) {
        Select select = QueryBuilder.selectFrom(table_name).all();
        ResultSet resultSet = executeTableKeyspace(select.build(), keyspace);
        List<Order> result = new ArrayList<>();

        resultSet.forEach(j -> result.add(
                new Order(
                        j.getString("order_id"),
                        j.getString("customer_id"),
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
         */

    }



