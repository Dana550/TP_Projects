package org.example.Controller;

import org.example.Model.Client;
import org.example.Model.Server;
import org.example.View.SimulationFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

import static org.example.Controller.SelectionPolicy.SHORTEST_QUEUE;
import static org.example.Controller.SelectionPolicy.SHORTEST_TIME;

public class SimulationManager implements Runnable {
    public static int nrOfClients;
    public static int nrOfQueues;
    public static int simulationInterval;

    public static int minArrivalTime;
    public static int maxArrivalTime;
    public static int minServiceTime;
    public static int maxServiceTime;
    public static SelectionPolicy selectionPolicy;


    private Scheduler scheduler;
    private static SimulationFrame simulationFrame;
    private List<Client> generatedClients = new LinkedList<Client>();
    private static int averageWaitingTime = 0;
    private static int sum1=0;
    private static int sum2=0;

    private static int averageServiceTime = 0;
    private double peakHour = 0.0;
    private int timePeakHour = 0;
    private String logText;
    private int currentTime;

    public SimulationManager(SimulationFrame frame) {

        generatedNRandomClients();
        logText = "";
        currentTime = 0;
        scheduler = new Scheduler(nrOfQueues, nrOfClients);
    }

    private void acLogText() {
        logText += "Time: " + currentTime + "\n";
        logText += "Waiting Clients: " + "";
        for (Client client : generatedClients) {
            logText += "(" + client.getID() + ", " + client.getArrivalTime() + ", " + client.getServiceTime() + ");";
        }
        logText += "\n";
        for (Server server : scheduler.getServers()) {
            logText += "Queue " + server.getId() + ": ";
            if (server.getClientSyncronizedSize() == 0) {
                logText += "closed";
            } else {
                for (Client client : server.getClients()) {
                    logText += "(" + client.getID() + ", " + client.getArrivalTime() + ", " + client.getServiceTime() + ");";
                }
            }
            logText += "\n";
        }
        logText += "\n";
        System.out.println(currentTime);
    }

    private void generatedNRandomClients() {
        generatedClients = Collections.synchronizedList(new ArrayList<>());
        Random random = new Random();
        for (int i = 0; i < nrOfClients; i++) {
            Client client = new Client(i, random.nextInt(minArrivalTime, maxArrivalTime), random.nextInt(minServiceTime, maxServiceTime));
            generatedClients.add(client);
        }
        generatedClients.sort(new Comparator<Client>() {
            @Override
            public int compare(Client o1, Client o2) {
                return o1.getArrivalTime() - o2.getArrivalTime();
            }
        });

    }
    public static void addAverageWaitingTime(int number) {
        sum1=averageWaitingTime+number;
    }
    public static void addAverageServiceTime(int number) {
        sum2=averageServiceTime+number;
    }

    @Override
    public void run() {
        while (currentTime < simulationInterval) {
            while (true) {
                if (generatedClients.size() > 0) {
                    Client client = generatedClients.get(0);
                    if (client.getArrivalTime() == currentTime) {
                        scheduler.dispatchClient(client);//pune clientul in coada care trebuie
                        addAverageWaitingTime(client.getArrivalTime());
                        addAverageWaitingTime(client.getServiceTime());
                        generatedClients.remove(client);
                    } else {
                        if (client.getArrivalTime() > currentTime) {//clienti serviti
                            break;
                        }
                    }
                }
                if (generatedClients.size() == 0) {
                    break;
                }
            }
            acLogText();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            try {
                FileWriter writer = new FileWriter("log.txt");
                logText+="\naverage wating time:"+sum1/nrOfClients;
                logText+="\naverage service time: "+sum2/nrOfClients;
                logText+="\n";
                writer.write(logText);

                writer.close();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            currentTime++;
        }
    }

    public static void main(String[] args) {
        SimulationFrame frame = new SimulationFrame();
        frame.getStartSimulation().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    nrOfClients = Integer.parseInt(frame.getNrOfClients1().getText());
                    //System.out.println(nrOfClients);
                    nrOfQueues = Integer.parseInt(frame.getNrOfQueues1().getText());
                    simulationInterval = Integer.parseInt(frame.getSimulationInterval1().getText());
                    minArrivalTime = Integer.parseInt(frame.getMinArrivalTime1().getText());
                    maxArrivalTime = Integer.parseInt(frame.getMaxArrivalTime1().getText());
                    minServiceTime = Integer.parseInt(frame.getMinServiceTime1().getText());
                    maxServiceTime = Integer.parseInt(frame.getMaxServiceTime1().getText());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Content Missing");
                }
                if (!(minArrivalTime <= maxArrivalTime) && (minServiceTime <= maxServiceTime) &&
                        (minServiceTime > 0) && (minArrivalTime > 0) && nrOfClients > 0 && nrOfQueues > 0
                        && nrOfQueues <= nrOfClients) {
                    JOptionPane.showMessageDialog(null, "Wrong Input");
                }

                if(frame.getShortestTimeQueueStrategy().isSelected()){
                    selectionPolicy=SHORTEST_TIME;
                }else{
                    if(frame.getShortestQueueStrategy().isSelected()){
                        selectionPolicy=SHORTEST_QUEUE;
                    }
                }
                simulationFrame = frame;
                SimulationManager manager = new SimulationManager(frame);
                //System.out.println(simulationInterval);
                Thread thread = new Thread(manager);
                thread.start();

            }

        });

    }


}