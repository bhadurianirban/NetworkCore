/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.patronus.networkcore;

import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;

/**
 *
 * @author dgrfi
 */
public class AssortitivityCoefficient {
    private final String adjListFile;
    private final Double assortitivityCoeffient;
    public AssortitivityCoefficient(String adjListFile) {
        this.adjListFile = adjListFile;
        BuildGraph bg = new BuildGraph(adjListFile);
        Graph<String, DefaultEdge> graph = bg.getGraph();
        
        assortitivityCoeffient = calculate(graph);
    }
    public Double calculate (Graph<String, DefaultEdge> graph) {
        Double assortitivityCoeffient;
        double edgeCount = graph.edgeSet().size();
        double n1 = 0, n2 = 0, dn = 0;

        for (DefaultEdge e : graph.edgeSet()) {
            int d1 = graph.degreeOf(graph.getEdgeSource(e));
            int d2 = graph.degreeOf(graph.getEdgeTarget(e));

            n1 += d1 * d2;
            n2 += d1 + d2;
            dn += d1 * d1 + d2 * d2;
        }
        n1 /= edgeCount;
        n2 = (n2 / (2 * edgeCount)) * (n2 / (2 * edgeCount));
        dn /= (2 * edgeCount);
        assortitivityCoeffient = (n1 - n2) / (dn - n2);
        return assortitivityCoeffient;
    }

    public Double getAssortitivityCoeffient() {
        return assortitivityCoeffient;
    }

    
}
