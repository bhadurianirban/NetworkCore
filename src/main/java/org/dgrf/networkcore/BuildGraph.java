/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dgrf.networkcore;

import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;
import org.jgrapht.io.VertexProvider;

/**
 *
 * @author dgrfi
 */
public class BuildGraph {
    private String adjListFile;

    public BuildGraph(String adjListFile) {
        this.adjListFile = adjListFile;
    }
    public void createGraph () {
        Graph<Integer,DefaultWeightedEdge> g = new SimpleWeightedGraph<> (DefaultWeightedEdge.class);
        VertexProvider<Integer> vertexProvider;
    }
    
    
}
