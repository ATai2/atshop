package com.atshop.search.controller;

import io.searchbox.client.JestClient;
import io.searchbox.client.JestClientFactory;
import io.searchbox.client.JestResult;
import io.searchbox.client.config.HttpClientConfig;
import io.searchbox.indices.CreateIndex;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class SearchControllerTest {

    private JestClient client;

    @Before
    public void setUp() throws Exception {
        JestClientFactory factory = new JestClientFactory();
        factory.setHttpClientConfig(
                new HttpClientConfig.Builder("http://81.68.202.192:9200")
                        .multiThreaded(true)
                        .defaultMaxTotalConnectionPerRoute(2)
                        .maxTotalConnection(10)
                        .build());
        client = factory.getObject();
    }

    @Test
    public void list() throws IOException {
        JestResult employee = client.execute(new CreateIndex.Builder("employee").build());
        System.out.println(employee.getJsonString());
    }
    @Test
    public void add() throws IOException {
        JestResult employee = client.execute(new CreateIndex.Builder("employee").build());
        System.out.println(employee.getJsonString());
    }
}