/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package machine.learning;

import java.util.ArrayList;

/**
 *
 * @author Erlkonig
 */
public class DataOut {
    double KFE[]=new double[Params.getK_oznaka()];
    boolean area[]= new boolean[Params.getK_oznaka()];
    
    void setKFE(int i,double t){
    KFE[i]=t;
    }
    void setArea(int i,boolean a){
    area[i]=a;
    }
    
}
