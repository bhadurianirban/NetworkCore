/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.patronus.networkcore;

import java.io.File;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.WeightedPseudograph;
import org.jgrapht.io.CSVFormat;
import org.jgrapht.io.CSVImporter;
import org.jgrapht.io.ImportException;

/**
 *
 * @author dgrfi
 */
public final class BuildGraph {

    private final String adjListFile;
    private Graph<String, DefaultEdge> graph;

    public BuildGraph(String adjListFile) {
        this.adjListFile = adjListFile;
        readGraph();
    }
    private static final String NL = System.getProperty("line.separator");

    private <E> CSVImporter<String, DefaultEdge> createImporter(CSVFormat format, Character delimiter) {
        return new CSVImporter<>((l, a) -> l, (f, t, l, a) -> graph.getEdgeSupplier().get(), format, delimiter);
    }

    public void readGraph()  {
        CSVFormat format = CSVFormat.EDGE_LIST;
        Character delimiter = ',';
        File f = new File(adjListFile);

        graph = new WeightedPseudograph<>(DefaultEdge.class);

        CSVImporter<String, DefaultEdge> importer = createImporter(format, delimiter);

        importer.setParameter(CSVFormat.Parameter.EDGE_WEIGHTS, true);

        try {
            importer.importGraph(graph, f);
        } catch (ImportException ex) {
            Logger.getLogger(BuildGraph.class.getName()).log(Level.SEVERE, "Error in input file", ex);
        }

    }
    

    //public void testEdgeListDirectedUnweighted() throws ImportException {
        // @formatter:on
        
      //  readGraph(f, , );

//        DefaultEdge de = graph.getEdge("7", "39");
//        Double w = graph.getEdgeWeight(de);
//        System.out.println(w);
//        Set<String> vt = graph.vertexSet();
//        for (String v : vt) {
//            System.out.println(v);
//        }
    //}

    public Graph<String, DefaultEdge> getGraph() {
        return graph;
    }

}
