/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dgrf.networkcore;

import java.io.File;
import java.io.StringReader;
import java.util.Set;
import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DirectedPseudograph;
import org.jgrapht.graph.DirectedWeightedPseudograph;
import org.jgrapht.graph.Pseudograph;
import org.jgrapht.graph.WeightedPseudograph;
import org.jgrapht.io.CSVFormat;
import org.jgrapht.io.CSVImporter;
import org.jgrapht.io.ImportException;

/**
 *
 * @author dgrfi
 */
public class BuildGraph {

    private String adjListFile;

    public BuildGraph(String adjListFile) {
        this.adjListFile = adjListFile;
    }
    private static final String NL = System.getProperty("line.separator");

    public <E> CSVImporter<String, E> createImporter(Graph<String, E> g, CSVFormat format, Character delimiter) {
        return new CSVImporter<>((l, a) -> l, (f, t, l, a) -> g.getEdgeSupplier().get(), format, delimiter);
    }

    public <E> Graph<String, E> readGraph(
            File input, CSVFormat format, Character delimiter, Class<? extends E> edgeClass,
            boolean directed, boolean weighted)
            throws ImportException {
        Graph<String, E> g;
        if (directed) {
            if (weighted) {
                g = new DirectedWeightedPseudograph<>(edgeClass);
            } else {
                g = new DirectedPseudograph<>(edgeClass);
            }
        } else {
            if (weighted) {
                g = new WeightedPseudograph<>(edgeClass);
            } else {
                g = new Pseudograph<>(edgeClass);
            }
        }

        CSVImporter<String, E> importer = createImporter(g, format, delimiter);

        if ((format == CSVFormat.EDGE_LIST || format == CSVFormat.ADJACENCY_LIST) && weighted) {
            importer.setParameter(CSVFormat.Parameter.EDGE_WEIGHTS, true);
        }

        importer.importGraph(g, input);

        return g;
    }

    public void testEdgeListDirectedUnweighted()
            throws ImportException {
        String input = "1,2,1.0\n"
                + "2,3,2.0\n"
                + "3,4,3.0\n"
                + "4,1,4.9\n";
        // @formatter:on
        File f = new File(adjListFile);
        Graph<String, DefaultEdge> g
                = readGraph(f, CSVFormat.EDGE_LIST, ',', DefaultEdge.class, false, true);
        
//        DefaultEdge de = g.getEdge("4", "1");
//        Double f = g.getEdgeWeight(de);
//        System.out.println(f);
        Set<String> vt = g.vertexSet();
        for (String v : vt) {
            System.out.println(v);
        }
    }

}
