package org.example.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SimulationFrame  extends JFrame {
        private JPanel panel;
        private JLabel  nrOfClients0;
        private JTextField  nrOfClients1;
        private JLabel  nrOfQueues0;
        private JTextField  nrOfQueues1;
        private JLabel  simulationInterval0;
        private JTextField  simulationInterval1;
        private JLabel  minArrivalTime0;
        private JTextField  minArrivalTime1;
        private JLabel  maxArrivalTime0;
        private JTextField  maxArrivalTime1;

        private JLabel  minServiceTime0;
        private JTextField  minServiceTime1;
        private JLabel  maxServiceTime0;
        private JTextField  maxServiceTime1;
        private JRadioButton shortestQueueStrategy;
        private JRadioButton shortestTimeQueueStrategy;
        private JButton startSimulation;
        ArrayList<Integer> inputsQueue;

    public SimulationFrame() {
            super("MANAGEMENT QUEUE");
            setSize(500, 500);

            panel = new JPanel();
            panel.setLayout(new GridLayout(11, 2));

            nrOfClients0 = new JLabel("NUMBER OF CLIENTS: ");
            nrOfClients1 = new JTextField();
            nrOfQueues0 = new JLabel("NUMBER OF QUEUES: ");
            nrOfQueues1 = new JTextField();
            simulationInterval0 = new JLabel("SIMULATION INTERVAL: ");
            simulationInterval1 = new JTextField();

            minArrivalTime0 = new JLabel("MINIMUM ARRIVAL TIME: ");
            minArrivalTime1 = new JTextField();
            maxArrivalTime0 = new JLabel("MAXIMUM ARRIVAL TIME: ");
            maxArrivalTime1 = new JTextField();

            minServiceTime0 = new JLabel("MINIMUM SERVICE TIME: ");
            minServiceTime1 = new JTextField();
            maxServiceTime0 = new JLabel("MAXIMUM SERVICE TIME: ");
            maxServiceTime1 = new JTextField();

            shortestTimeQueueStrategy=new JRadioButton("SHORTEST TIME STRATEGY");
            shortestQueueStrategy=new JRadioButton("SHORTEST QUEUE STRATEGY");
            shortestTimeQueueStrategy.setHorizontalAlignment(SwingConstants.LEFT);

            startSimulation=new JButton("START SIMULATION");

            panel.add(nrOfClients0);
            panel.add(nrOfClients1);
            panel.add(nrOfQueues0);
            panel.add(nrOfQueues1);
            panel.add(simulationInterval0);
            panel.add(simulationInterval1);
            panel.add(minArrivalTime0);
            panel.add(minArrivalTime1);
            panel.add(maxArrivalTime0);
            panel.add(maxArrivalTime1);
            panel.add(minServiceTime0);
            panel.add(minServiceTime1);
            panel.add(maxServiceTime0);
            panel.add(maxServiceTime1);
            panel.add(shortestQueueStrategy);
            panel.add(shortestTimeQueueStrategy);
            panel.add(startSimulation);

            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            setContentPane(panel);
            //pack();
            setLocationRelativeTo(null);
            setVisible(true);
            setResizable(true);
        }

    public JPanel getPanel() {
        return panel;
    }

    public JLabel getNrOfClients0() {
        return nrOfClients0;
    }

    public JTextField getNrOfClients1() {
        return nrOfClients1;
    }

    public JLabel getNrOfQueues0() {
        return nrOfQueues0;
    }

    public JTextField getNrOfQueues1() {
        return nrOfQueues1;
    }

    public JLabel getSimulationInterval0() {
        return simulationInterval0;
    }

    public JTextField getSimulationInterval1() {
        return simulationInterval1;
    }

    public JLabel getMinArrivalTime0() {
        return minArrivalTime0;
    }

    public JTextField getMinArrivalTime1() {
        return minArrivalTime1;
    }

    public JLabel getMaxArrivalTime0() {
        return maxArrivalTime0;
    }

    public JTextField getMaxArrivalTime1() {
        return maxArrivalTime1;
    }

    public JLabel getMinServiceTime0() {
        return minServiceTime0;
    }

    public JTextField getMinServiceTime1() {
        return minServiceTime1;
    }

    public JLabel getMaxServiceTime0() {
        return maxServiceTime0;
    }

    public JTextField getMaxServiceTime1() {
        return maxServiceTime1;
    }

    public JRadioButton getShortestQueueStrategy() {
        return shortestQueueStrategy;
    }
    public JRadioButton getShortestTimeQueueStrategy() {
        return shortestTimeQueueStrategy;
    }

    public JButton getStartSimulation() {
        return startSimulation;
    }
    public ArrayList<Integer> getInputsQueue() {
        return inputsQueue;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }

    public void setNrOfClients0(JLabel nrOfClients0) {
        this.nrOfClients0 = nrOfClients0;
    }

    public void setNrOfClients1(JTextField nrOfClients1) {
        this.nrOfClients1 = nrOfClients1;
    }

    public void setNrOfQueues0(JLabel nrOfQueues0) {
        this.nrOfQueues0 = nrOfQueues0;
    }

    public void setNrOfQueues1(JTextField nrOfQueues1) {
        this.nrOfQueues1 = nrOfQueues1;
    }

    public void setSimulationInterval0(JLabel simulationInterval0) {
        this.simulationInterval0 = simulationInterval0;
    }

    public void setSimulationInterval1(JTextField simulationInterval1) {
        this.simulationInterval1 = simulationInterval1;
    }

    public void setMinArrivalTime0(JLabel minArrivalTime0) {
        this.minArrivalTime0 = minArrivalTime0;
    }

    public void setMinArrivalTime1(JTextField minArrivalTime1) {
        this.minArrivalTime1 = minArrivalTime1;
    }

    public void setMaxArrivalTime0(JLabel maxArrivalTime0) {
        this.maxArrivalTime0 = maxArrivalTime0;
    }

    public void setMaxArrivalTime1(JTextField maxArrivalTime1) {
        this.maxArrivalTime1 = maxArrivalTime1;
    }

    public void setMinServiceTime0(JLabel minServiceTime0) {
        this.minServiceTime0 = minServiceTime0;
    }

    public void setMinServiceTime1(JTextField minServiceTime1) {
        this.minServiceTime1 = minServiceTime1;
    }

    public void setMaxServiceTime0(JLabel maxServiceTime0) {
        this.maxServiceTime0 = maxServiceTime0;
    }

    public void setMaxServiceTime1(JTextField maxServiceTime1) {
        this.maxServiceTime1 = maxServiceTime1;
    }

    public void setShortestQueueStrategy(JRadioButton shortestQueueStrategy) {
        this.shortestQueueStrategy = shortestQueueStrategy;
    }

    public void setShortestTimeQueueStrategy(JRadioButton shortestTimeQueueStrategy) {
        this.shortestTimeQueueStrategy = shortestTimeQueueStrategy;
    }

    public void setStartSimulation(JButton startSimulation) {
        this.startSimulation = startSimulation;
    }

    public void setInputsQueue(ArrayList<Integer> inputsQueue) {
        this.inputsQueue = inputsQueue;
    }

    public void setStartVisible(boolean value) {
        startSimulation.setEnabled(value);
    }

}

