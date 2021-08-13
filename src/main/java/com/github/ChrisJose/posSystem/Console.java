package com.github.ChrisJose.posSystem;

import com.github.ChrisJose.posSystem.Connection.*;
import com.datastax.oss.driver.api.core.CqlSession;
import com.github.ChrisJose.posSystem.Model.Customer;
import com.github.ChrisJose.posSystem.Model.CustomerRepository;

import java.util.List;

public class Console {

    public void run() {

        Connection connection = new Connection();
        connection.run();

        String keyspaceName = connection.getKeyspaceName();
        CqlSession session = connection.getSession();

        CustomerRepository customers = new CustomerRepository(session);
        customers.createTableCustomer();

        customers.insertCustomer(new Customer(
                "C0000", "Bobby",
                "Frank", "415-313-3135",
                "bobbyfrank@gmail.com",
                "812 Noriega St","",
                "San Francisco","CA","94103"), keyspaceName);
        customers.insertCustomer(new Customer(
                "C0001", "Bobby",
                "Frank", "415-313-3135",
                "bobbyfrank@gmail.com",
                "812 Noriega St","",
                "San Francisco","CA","94103"), keyspaceName);
        customers.insertCustomer(new Customer(
                "C0002", "Bobby",
                "Frank", "415-313-3135",
                "bobbyfrank@gmail.com",
                "812 Noriega St","",
                "San Francisco","CA","94103"), keyspaceName);

        List<Customer> customerAll = customers.selectAll(keyspaceName);

        // customerAll.forEac h(x -> LOG.info(x.toString()));
        connection.close();

    }
}
