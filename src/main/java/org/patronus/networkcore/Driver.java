/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.patronus.networkcore;

import java.math.BigDecimal;
import java.util.AbstractSet;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author dgrfi
 */
public class Driver {

    public static void main(String args[]) {
        String adjListFile = "/home/dgrfi/MEGA/DGRFFractal/testdata/network/Upload/Network.csv";
        BuildGraph bg = new BuildGraph(adjListFile);
        Double acc = new AverageShortestPath(adjListFile).getAverageShortestPath();
        System.out.println(acc);

//        DefaultEdge de = graph.getEdge("7", "39");
//        Double w = graph.getEdgeWeight(de);
//        System.out.println(w);
        //testSet();

    }
    public static void testSet () {
        BigDecimal bd = new BigDecimal(0);
        BigDecimal bda = new BigDecimal(2.0);
        bd = bd.add(bda);
        bd = bd.add(bda);
        bd = bd.add(bda);
        System.out.println(bd);
    }

}
