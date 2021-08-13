package com.github.ChrisJose.posSystem.Connection;

import com.datastax.oss.driver.api.core.CqlSession;

public class Connection {

    private final String keyspaceName = "testKeyspace";
    public CqlSession session;

    public void run() {

        Cassandra connector = new Cassandra();
        connector.connect();
        session = connector.getSession();

        Keyspace keyspace = new Keyspace(session);
        keyspace.createKeyspace(keyspaceName, 1);
        keyspace.useKeyspace(keyspaceName);

    }

    public String getKeyspaceName() {
        return keyspaceName;
    }

    public CqlSession getSession() {
        return session;
    }

    public void close() {
        session.close();
    }






}
