package org.example.Model;

public class Client implements Comparable<Client>{
    private int ID;
    private int arrivalTime;
    private int serviceTime;

    public Client(int ID, int arrivalTime, int serviceTime) {
        this.ID = ID;
        this.arrivalTime=arrivalTime;
        this.serviceTime=serviceTime;
    }

    public int getID() {
        return ID;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public int getServiceTime() {
        return serviceTime;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public void setServiceTime(int serviceTime) {
        this.serviceTime = serviceTime;
    }

    @Override
    public String toString() {
        return "Client{" +
                "ID=" + ID +
                ", arrivalTime=" + arrivalTime +
                ", serviceTime=" + serviceTime +
                '}';
    }

    @Override
    public int compareTo(Client o) {
        return Integer.compare(this.arrivalTime, o.arrivalTime);
    }
}
