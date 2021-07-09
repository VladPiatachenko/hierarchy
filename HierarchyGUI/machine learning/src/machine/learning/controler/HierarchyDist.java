package machine.learning.controler;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import machine.learning.model.Para;
import machine.learning.model.Parameters;
import machine.learning.model.RecognClass;

public class HierarchyDist {
    public static String learning() throws IOException{
        ArrayList<RecognClass> rclas = new ArrayList<>();
        
        for(int t=0;t<Parameters.getK_klass();t++){
            File files[]=Parameters.getFiles();
            RecognClass CurrentClass= new RecognClass(files[t].getAbsoluteFile());
            Parameters.addLog("Class :"+files[t].getName()+" from file "+files[t].getAbsolutePath());
            rclas.add(CurrentClass);
            }
       
        for(RecognClass k:rclas){
        RecognClass base =rclas.get(0);
        base.setAvg(Methods.getAvg(base.getMat()));
        Methods.limits(base.getItAvg());
        for(RecognClass r:rclas){
            if(!k.equals(r)){
            r.setBM(Methods.toBinar(r.getMat()));
            r.setEtalon(Methods.getItEtalon(r.getBM()));
            int dist=Methods.calculeteDistance(k.getEtalon(), r.getEtalon());
            Para idDist=new Para(r.getId(),dist);
            k.addDistance(idDist);
           
            } 
        }
        }
        int pcls[]=new int[2*(Parameters.getK_klass()-1)];
        ArrayList<RecognClass> temp=rclas;
        ArrayList<RecognClass> processed=new ArrayList(rclas);
        ArrayList<RecognClass> all=new ArrayList(rclas);
        ArrayList<RecognClass> supers=new ArrayList();
         for(int i=0;i<Parameters.getK_klass()-1;i++){
             RecognClass sc=GetClosest(temp);
             if(sc.getName()==null){break;}
             Parameters.addLog("Closest: "+sc.getParentA()+" and "+sc.getParentB());
             pcls[sc.getParentA()]=sc.getParentB();
             pcls[sc.getParentB()]=sc.getParentA();
             supers.add(sc);
             temp.remove(getListedClass(temp,sc.getParentA()));
             temp.remove(getListedClass(temp,sc.getParentB()));
            
             if(isListed(processed,sc.getParentA()))
            {
                processed.remove(getListedClass(temp,sc.getParentA()));
            }
              if(isListed(processed,sc.getParentB()))
            {
                processed.remove(getListedClass(temp,sc.getParentB()));
            } 
            temp.add(sc);
             all.add(sc);
             for(RecognClass rc:temp){
                if(!rc.equals(sc)){
                    Parameters.addLog(rc.getName());
                        int dist=Methods.calculeteDistance(rc.getEtalon(), sc.getEtalon());
                        Para idDist=new Para(sc.getId(),dist);
                        rc.addDistance(idDist);
             }
             }
        }
        Parameters.addLog("Radius optimization...");
        for(int k=0;k<10;k++){
        optRadius(all.get(k),all.get(pcls[k]));
        Methods.writeOutData(all.get(k));
        Parameters.addLog("\tClass:"+k);
        }
        return "Execution finished. Results printed to id_classname_radius.txt files.";
        }
     
    public static String optRadius(RecognClass r,RecognClass n){
         n.setNid(r.getId());
         n.setDist_to_neig(r.getDist_to_neig());
         double d=-1,maxE=-1;
         for(int rad=0;rad<Parameters.getK_oznaka();rad++){
         double k1=0,k2,k3=0,k4;
         double t_d1,t_d2,t_alpha, t_betta, d1_b, kfe = 0;
         
            for (int i = 0; i < Parameters.getK_realiz(); i++){ 
                if (Methods.calculeteDistance(r.getEtalon(), r.getVector(i)) <= rad) { k1++;}
                if (Methods.calculeteDistance(r.getEtalon(), n.getVector(i)) <= rad) { k3++;}
				}
            
				k4 = Parameters.getK_realiz() - k3;
				k2 = Parameters.getK_realiz() - k1;
				t_d1 = k1 / Parameters.getK_realiz();
                                t_d2= k2 /  Parameters.getK_realiz();
                                t_alpha= k4 / Parameters.getK_realiz();
				t_betta = k3 / Parameters.getK_realiz();
        			d1_b = t_d1 - t_betta;
                                
                                d=d1_b * Math.log((1.0 + d1_b + 0.1) / (1.0 - d1_b + 0.1)) / Math.log(2.0);
                                r.setE(rad,d);
                                r.setBetta(rad,t_betta);
                                r.setD1(rad,t_d1);
	                        
                                if ((t_d1 >= 0.5)&&(t_betta < 0.5)) {
                                        r.setArea(rad,true);
                                if(d>maxE){
                                    maxE=d;
                                    r.setRadius(rad);
                                }    
                                }
                                else{
                                    r.setArea(rad,false);}
            
         
         }
         return "";
        }




    
    static RecognClass GetClosest(ArrayList<RecognClass> temp) throws IOException{
        int mind=Integer.MAX_VALUE;
        RecognClass ca=new RecognClass();
        RecognClass cb=new RecognClass();
        for(RecognClass rc:temp){
            for(Para idist:rc.getDistances()){  
                if(isListed(temp,idist.getA())){
                    if(mind>idist.getB()){
                        mind=idist.getB();
                        rc.setNid(idist.getA());
                        ca=rc;
                        cb=getListedClass(temp,idist.getA());
                        rc.setDist_to_neig(Methods.calculeteDistance(ca.getEtalon(), cb.getEtalon()));
                        }
                }
            } 
        }  
        if((ca.getName()==null)||(cb.getName()==null)){return null;}
        int[][] BM=Methods.createMatr(ca.getBM(),cb.getBM());
        RecognClass sp = new RecognClass(ca.getName()+cb.getName(),ca.getId(),cb.getId(),BM);
        return sp;
    }
    
    
    static ArrayList removeByClassId(ArrayList<RecognClass> r,int num){
        int out = -1;
        for(RecognClass current:r){
        if(current.getId()==num){
            out=r.indexOf(current);
        }}
        r.remove(out);
        return r;
    }

    static RecognClass getListedClass(ArrayList<RecognClass> rc, int num){
         for(RecognClass current:rc){
            if(current.getId()==num){
                return current;
            }
         }
        return null;
    }

    static boolean isListed(ArrayList<RecognClass> rc, int num) {
       for(RecognClass current:rc){
            if(current.getId()==num){
                return true;
            }
         }
        return false;
    }
    
    
}
