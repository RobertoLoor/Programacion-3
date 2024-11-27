package es.ua.dlsi.prog3.p6.network;

import es.ua.dlsi.prog3.p6.algorithms.Algorithms;
import es.ua.dlsi.prog3.p6.algorithms.GraphAlgorithmException;
import es.ua.dlsi.prog3.p6.algorithms.ICostOperators;
import es.ua.dlsi.prog3.p6.graph.Graph;
import es.ua.dlsi.prog3.p6.graph.Node;
import es.ua.dlsi.prog3.p6.graph.NodeNotFoundException;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.*;

/**
 * Network class representing a network of devices and their latencies
 */
public class Network {
    /**
     * Graph storing the devices and latencies
     */
    private Graph<Device, Double> graph;

    /**
     * Map of devices to their corresponding graph nodes
     */
    private Map<Device, Node<Device>> deviceNodes;

    /**
     * Default constructor
     */
    public Network() {
        this.graph = new Graph<>();
        this.deviceNodes = new HashMap<>();
    }

    /**
     * Adds a device to the network
     * @param device The device to be added
     */
    public void addDevice(Device device) {
        Node<Device> node = this.graph.addNode(device);
        this.deviceNodes.put(device, node);
    }

    /**
     * Retrieves the node corresponding to a device
     * @param device The device
     * @return The corresponding node
     */
    private Node<Device> getNode(Device device) {
        Node<Device> result = deviceNodes.get(device);
        if (result == null) {
            throw new RuntimeException("Cannot find device " + device);
        }
        return result;
    }

    /**
     * Adds a latency measurement to the network
     * @param fromDevice Source device
     * @param toDevice Target device
     * @param milliseconds Latency measured in milliseconds
     */
    public void addLatency(Device fromDevice, Device toDevice, Double milliseconds) {
        Node<Device> fromNode = getNode(fromDevice);
        Node<Device> toNode = getNode(toDevice);
        try {
            this.graph.addEdge(fromNode, milliseconds, toNode);
        } catch (NodeNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Prints the network in DOT format to a file
     * @param file Output file
     * @throws FileNotFoundException If the file cannot be written
     */
    public void printNetwork(File file) throws FileNotFoundException {
        Algorithms.exportDot(file, graph);
    }

    /**
     * Computes the best latencies between all given devices
     * @param devices List of devices
     * @return Sorted set of latencies
     */
    public SortedSet<Latency> computeLatencyMap(List<? extends Device> devices) {
        ICostOperators<Double> costOperators = new ICostOperators<Double>() {
            @Override
            public Double zero() {
                return 0.0;
            }

            @Override
            public Double maximumValue() {
                return Double.MAX_VALUE;
            }

            @Override
            public Double add(Double a, Double b) {
                return a + b;
            }
        };

        TreeSet<Latency> result = new TreeSet<>();
        for (Device fromDevice : devices) {
            Node<Device> fromNode = getNode(fromDevice);
            for (Device toDevice : devices) {
                Node<Device> toNode = getNode(toDevice);
                try {
                    Double cost = Algorithms.shortestPathCost(graph, fromNode, toNode, costOperators);
                    result.add(new Latency(fromDevice, toDevice, cost));
                } catch (NodeNotFoundException | GraphAlgorithmException e) {
                    System.err.println("Cannot compute latency between " + fromDevice + " and " + toDevice + ": " + e.getMessage());
                }
            }
        }
        return result;
    }

    /**
     * Prints the best latencies between all given devices
     * @param devices List of devices
     */
    public void printLatencyMap(List<? extends Device> devices) {
        Set<Latency> latencies = computeLatencyMap(devices);
        System.out.println("From device\tTo device\tLatency");
        DecimalFormat formatter = new DecimalFormat("#0.00");
        for (Latency latency : latencies) {
            System.out.println(latency.getSource() + "\t" + latency.getTarget() + "\t" + formatter.format(latency.getTime()));
        }
    }

    /**
     * Inner class to represent latency between devices
     */
    public static class Latency implements Comparable<Latency> {
        private Device source;
        private Device target;
        private double time;

        public Latency(Device source, Device target, double time) {
            this.source = source;
            this.target = target;
            this.time = time;
        }

        public Device getSource() {
            return source;
        }

        public Device getTarget() {
            return target;
        }

        public double getTime() {
            return time;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Latency)) return false;
            Latency latency = (Latency) o;
            return Double.compare(latency.time, time) == 0 && source.equals(latency.source) && target.equals(latency.target);
        }

        @Override
        public int hashCode() {
            return Objects.hash(source, target, time);
        }

        @Override
        public int compareTo(Latency o) {
            int from = source.compareTo(o.source);
            if (from == 0) {
                return target.compareTo(o.target);
            } else {
                return from;
            }
        }
    }

    /**
     * Example code to demonstrate usage
     * @param args Not used
     */
    public static void main(String[] args) {
        Network network = new Network();
        Computer c1 = new Computer("Computer #1", "192.168.1.2");
        Computer c2 = new Computer("Computer #2", "192.168.1.32");
        Router r = new Router("Main router", "192.168.1.1");

        network.addDevice(c1);
        network.addDevice(c2);
        network.addDevice(r);

        network.addLatency(r, c1, 20.2);
        network.addLatency(c1, r, 19.6);
        network.addLatency(r, c2, 11.3);
        network.addLatency(c2, r, 12.1);
        network.addLatency(c1, c2, 44.2);
        network.addLatency(c2, c1, 42.9);

        List<Computer> computers = Arrays.asList(c1, c2);
        network.printLatencyMap(computers);
    }
}