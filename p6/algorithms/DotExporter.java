package es.ua.dlsi.prog3.p6.algorithms;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

import es.ua.dlsi.prog3.p6.graph.Edge;
import es.ua.dlsi.prog3.p6.graph.Graph;
import es.ua.dlsi.prog3.p6.graph.Node;

/**
 * It exports a graph to DOT format used by GraphViz.
 * Package visibility for force clients using the facade Algorithms class
 * @author drizo
 */
class DotExporter<NodeLabelType, EdgeLabelType> {
	/**
	 * Used to avoid creating the same object several times
	 */
	private static final String EMPTY_STRING = "";

	/**
	 * DOT requires ids starting with an alphabetic character
	 * @param uniqueID Object implementing this interface
	 * @return Normalized ID for DOT
	 */
	private String generateDotID(Node<?> uniqueID) {
		return "s" + uniqueID.getUniqueID(); 
	}
	
	/**
	 * Used to replace any " for \" in the string
	 * @param label Label to be escaped. It may be null
	 * @return New string
	 */
	private String escapeLabel(Object label) {
		return label == null ? EMPTY_STRING : label.toString().replace("\"", "\\\"");
	}
	
	/**
	 * It prints all nodes of the graph
	 * @param os Output stream
	 * @param graph Graph to be printed
	 */
    private void printNodes(PrintStream os, Graph<NodeLabelType, EdgeLabelType> graph) {
        for (Node<NodeLabelType> node : graph.getNodes()) {
            String label = node.getLabel() == null ? "" : escapeLabel(node.getLabel());
            os.println(generateDotID(node) + "[label=\"" + label + "\", shape=circle];");
        }
    }

    /**
     * Out writes all edges in the graph
     * @param os Output stream
     * @param graph The graph to be exported 
     */
    private void printEdges(PrintStream os, Graph<NodeLabelType, EdgeLabelType> graph) {
        for (Edge<NodeLabelType, EdgeLabelType> edge : graph.getEdges()) {
            String label = edge.getLabel() == null ? "" : "[label=\"" + escapeLabel(edge.getLabel()) + "\"]";
            os.println(generateDotID(edge.getSource()) + " -> " + generateDotID(edge.getTarget()) + label);
        }
    }

    /**
     * It exports the graph in the given file
     * @param file Output file
     * @param graph Graph to be exported
     * @throws FileNotFoundException When the file to be written cannot be found
     */
    public void export(File file, Graph<NodeLabelType, EdgeLabelType> graph) throws FileNotFoundException {
        try (PrintStream os = new PrintStream(new FileOutputStream(file))) {
            os.println("digraph prog3 {");
            printNodes(os, graph);
            printEdges(os, graph);
            os.println("}");
        }
    }
}