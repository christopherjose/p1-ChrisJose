package com.github.ChrisJose.posSystem;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.ChrisJose.posSystem.Connection.*;
import com.datastax.oss.driver.api.core.CqlSession;
import com.github.ChrisJose.posSystem.Model.Customer;
import com.github.ChrisJose.posSystem.Model.CustomerRepository;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.netty.http.server.HttpServer;

import java.io.ByteArrayOutputStream;
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

        Flux<Customer> customerAll = Flux.fromIterable(customers.selectAll(keyspaceName));

        Mono<Customer> cust1 = Mono.just(customerAll.get(0));
        ObjectMapper objectmapper = new ObjectMapper();





        HttpServer.create()
                .port(8080)
                .route(routes ->

                        routes.get("/customer/{param}", (request, response) ->
                                response.send(Console.get(request.param("param")).map(Console::toByteBuf)))
                .bindNow()
                .onDispose()
                .block();// Starts the server in a blocking fas

        // customerAll.forEac h(x -> LOG.info(x.toString()));
       // connection.close();

    }

    static ByteBuf toByteBuf(Object o) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        return ByteBufAllocator.DEFAULT.buffer().writeBytes(out.toByteArray());
    }

    static public Mono<Customer> get(String index, List<Customer> customerAll) {
        String index2 = index.toString();
        return Mono.just(customerAll.get(index2));
    }
}

