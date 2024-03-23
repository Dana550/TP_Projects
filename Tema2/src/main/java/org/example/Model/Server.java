package org.example.Model;

import javax.swing.*;
import java.util.Collections;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class Server implements Runnable{
    private LinkedBlockingQueue<Client> clients;
    private AtomicInteger waitingPeriod;
    private int id;

    public Server(int id) {
        clients= new LinkedBlockingQueue<>();
        waitingPeriod=new AtomicInteger();
        this.id=id;
    }
    public void addClient(Client client)
    {
        try{
            clients.add(client);
            waitingPeriod.addAndGet(client.getServiceTime());
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"Wrong Input");
        }

    }

    @Override
    public void run()
    {

        while(true){
            Client nextClient=clients.peek();

            if(nextClient!=null){
                nextClient.setServiceTime(nextClient.getServiceTime()-1);
                decrement();
                if(nextClient.getServiceTime()==0){
                    try {
                        clients.take();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
            try{
                Thread.sleep(1000);
            }catch(InterruptedException e){
                JOptionPane.showMessageDialog(null,"Wrong Input");
            }
        }
    }
    public synchronized void decrement()
    {
        waitingPeriod.decrementAndGet();
    }
    public Client[] getClients() {
        Client[] clientArray=new Client[clients.size()];
        int counter=0;
        for(Client client: clients){
            clientArray[counter++]=client;
        }
        return clientArray;
    }

    public AtomicInteger getWaitingPeriod() {
        return waitingPeriod;
    }

    public int getId() {
        return id;
    }
    public synchronized int getClientSyncronizedSize(){
        return clients.size();
    }

}
