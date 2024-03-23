package org.example.Controller;

import org.example.Model.Client;
import org.example.Model.Server;

import java.util.List;

public interface Strategy {
    void addClient(List<Server> servers, Client client);
}
