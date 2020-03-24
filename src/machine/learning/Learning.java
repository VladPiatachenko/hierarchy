/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package machine.learning;

import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author klass
 */
public class Learning {
    public static void learning(ArrayList<RecognClass> recclasses) throws IOException{
    learning(recclasses,true); 
    }
    public static void learning(ArrayList<RecognClass> recclasses,boolean write) throws IOException {
        RecognClass base=recclasses.get(0);
        base.setAvg(Methods.getAvg(base.getMat()));
        Methods.limits(base.getItAvg());
        
        for(RecognClass r:recclasses){
            r.setBM(Methods.toBinar(r.getMat()));
            r.setEtalon(Methods.getItEtalon(r.getBM()));
        }
        for(RecognClass r:recclasses){
            Methods.getNeighbour(r,recclasses);
            Methods.optRadius(r,recclasses.get(r.getNid()));
            System.out.println(r.getName());
            Methods.writeOutData(r);
        }
        
        }
    
}


