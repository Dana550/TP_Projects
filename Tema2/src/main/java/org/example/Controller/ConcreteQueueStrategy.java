package org.example.Controller;

import org.example.Model.Client;
import org.example.Model.Server;

import java.util.List;

public class ConcreteQueueStrategy implements Strategy{
    @Override
    public void addClient(List<Server> servers, Client client) {
        if(Scheduler.getMaxClientsPerServer()>0){
            int min=servers.get(0).getClientSyncronizedSize();
            Server nextServer=servers.get(0);
            int i=1;
            while(i!=Scheduler.getMaxClientsPerServer()){
                if(servers.get(i).getClientSyncronizedSize()<min){
                    min=servers.get(i).getClientSyncronizedSize();
                    nextServer=servers.get(i);
                }
                i++;
            }
            nextServer.addClient(client);
        }
    }
}
