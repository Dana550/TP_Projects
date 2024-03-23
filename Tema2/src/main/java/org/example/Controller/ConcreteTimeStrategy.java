package org.example.Controller;

import org.example.Model.Client;
import org.example.Model.Server;

import java.util.Iterator;
import java.util.List;

public class ConcreteTimeStrategy implements Strategy{
    @Override
    public void addClient(List<Server> servers, Client client) {
        //the smallest waiting period for a server gets a client
        Server nextServer=servers.get(0);
        for(Server server:servers){
            if(server.getWaitingPeriod().get()<nextServer.getWaitingPeriod().get()){
                nextServer=server;
            }
        }
        nextServer.addClient(client);
    }
}
