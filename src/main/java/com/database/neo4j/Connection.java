package com.database.neo4j;

import org.neo4j.driver.v1.AuthTokens;
import org.neo4j.driver.v1.Driver;
import org.neo4j.driver.v1.GraphDatabase;

public class Connection {

    public static Driver createConnection(String uri, String userName, String password) {
        return GraphDatabase.driver(uri, AuthTokens.basic(userName, password));
    }

}
