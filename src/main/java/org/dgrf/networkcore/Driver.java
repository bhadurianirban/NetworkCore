/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dgrf.networkcore;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.jgrapht.io.ImportException;

/**
 *
 * @author dgrfi
 */
public class Driver {
    public static void main (String args[]) {
        String adjListFile = "/home/bhaduri/MEGA/DGRFFractal/testdata/network/Upload/Network.csv";
        BuildGraph bg = new BuildGraph(adjListFile);
        try {
            bg.testEdgeListDirectedUnweighted();
        } catch (ImportException ex) {
            Logger.getLogger(Driver.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
