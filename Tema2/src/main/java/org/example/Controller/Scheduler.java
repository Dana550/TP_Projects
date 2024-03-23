package org.example.Controller;

import org.example.Model.Client;
import org.example.Model.Server;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Scheduler {
    private LinkedList<Server> servers;
    private static int maxNoServers;
    private static int maxClientsPerServer;
    private Strategy strategy;
    public Scheduler(int maxNoServers, int maxClientsPerService) {
        servers = new LinkedList<>();
        this.maxNoServers=maxNoServers;
        this.maxClientsPerServer = maxClientsPerServer;
        for (int size = 0; size < maxNoServers; size++) {
            Server server=new Server(size+1);
            servers.add( server);
            Thread thread = new Thread(server);
            thread.start();
        }

        changeStrategy(SelectionPolicy.SHORTEST_TIME);
    }
    public void changeStrategy(SelectionPolicy policy)
    {
        if(policy==SelectionPolicy.SHORTEST_QUEUE){
            strategy= (Strategy) new ConcreteQueueStrategy();
        }
        else {
            strategy= (Strategy) new ConcreteTimeStrategy();
        }
    }
    public void dispatchClient(Client client) {
        strategy.addClient(servers, client);
    }
    public LinkedList<Server> getServers() {
        return servers;
    }
    public int getMaxNoServers() {
        return maxNoServers;
    }
    public static int getMaxClientsPerServer() {
        return maxClientsPerServer;
    }
    public Strategy getStrategy() {
        return strategy;
    }
    public void setServers(LinkedList<Server> servers) {
        this.servers = servers;
    }
    public void setMaxNoServers(int maxNoServers) {
        this.maxNoServers = maxNoServers;
    }
    public void setMaxClientsPerServer(int maxClientsPerServer) {
        this.maxClientsPerServer = maxClientsPerServer;
    }
    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }
}
