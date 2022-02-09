package hierprop;

import java.io.IOException;
import static java.lang.Math.pow;
import java.util.ArrayList;


    public class AVRHierarchy {
         public static void main(String[] args) throws IOException {
   
        int[] pcls=new int[10];
        Params Currents = Methods.getInputs();
        ArrayList<SignalClass> rclas = new ArrayList<SignalClass>();
        
        for(int t=0;t<Currents.getK_klass();t++){
            SignalClass CurrentClass= new SignalClass(Params.getPath(t));
            rclas.add(CurrentClass);
            System.out.println(CurrentClass.getName());
            }
        
          for(SignalClass sc:rclas){
              for(int i=0;i<Params.getK_realiz();i++){
                    double[][] realization=sc.getMat();
                    sc.prop[i]=proportion(realization[i]);
                    sc.prop2[i]=proportion(sc.prop[i]);
                    sc.prop3[i]=proportion(sc.prop2[i]);
                    sc.etN[i]=nepro(sc.prop[i],sc.prop2[i],sc.prop3[i]);
                }
              
          }
          
          SignalClass base =rclas.get(0);
          //for(SignalClass sc:rclas){
          
         // similarity(base.etN[0],sc); 
          //} 
          for(SignalClass r:rclas){
            r.BM=getBMed(base.etN[0],r.etN);
            r.etalon=Methods.getItEtalon(r.BM);
          }
          /*for(SignalClass sc:rclas){
          InputData.writeOutMatr("et"+sc.id+"bin",sc.BM,sc.etalon);
          }  
           
            InputData.writeOutMatr("et"+sc.id+"neprop",sc.etN);
           
            }
            */
        for(SignalClass k:rclas){
        
        for(SignalClass r:rclas){
            if(!k.equals(r)){
        // r.setEtalon(Methods.getItEtalon(r.getBM()));
            int dist=Methods.calculeteDistance(k.getEtalon(), r.getEtalon());
            Para idDist=new Para(r.id,dist);
            k.distances.add(idDist);
            //System.out.println(r.id+" -- "+idDist.b);
           
            } 
        }//System.out.println("--------------------------------------");
        }
        ArrayList<SignalClass> temp=rclas;
        ArrayList<SignalClass> processed=new ArrayList(rclas);
        ArrayList<SignalClass> all=new ArrayList(rclas);
        ArrayList<SignalClass> supers=new ArrayList();
         for(int i=0;i<Params.getK_klass()-1;i++){
             SignalClass sc=GetClosest(temp);
             if(sc.name==null){break;}
             System.out.println("Closest: "+sc.ParentA+" and "+sc.ParentB);
             pcls[sc.ParentA]=sc.ParentB;
             pcls[sc.ParentB]=sc.ParentA;
             supers.add(sc);
             temp.remove(getListedClass(temp,sc.ParentA));
             temp.remove(getListedClass(temp,sc.ParentB));
            
             if(isListed(processed,sc.ParentA))
            {
                processed.remove(getListedClass(temp,sc.ParentA));
            }
              if(isListed(processed,sc.ParentB))
            {
                processed.remove(getListedClass(temp,sc.ParentB));
            } 
            temp.add(sc);
             all.add(sc);
             for(SignalClass rc:temp){
                if(!rc.equals(sc)){
                    System.out.println(rc.name);
                        int dist=Methods.calculeteDistance(rc.getEtalon(), sc.getEtalon());
                        Para idDist=new Para(sc.id,dist);
                        rc.distances.add(idDist);
              //      System.out.println(rc.id+" -to sc-"+sc.id+" "+idDist.b);
             }
             }
        }
         System.out.println("Start learning");
        for(int k=0;k<10;k++){
        optRadius(all.get(k),all.get(pcls[k]));
        Methods.writeOutData(all.get(k));
        System.out.println(k);
        }
         
         }
         
    static double[] proportion(double[] y){
        //void proizv(double *y,double*dy_r,int n,double h)
        int i=0;
        int n=Params.getK_oznaka();
        double[] dy1=new double[2*n];
        double[] dy2=new double[2*n];
        double[] dy3=new double[2*n];
        double[] dy4=new double[2*n];
        double[] dy5=new double[2*n];
        double[] dy6=new double[2*n];
        double[] dy_t=new double[2*n];
        double[] dy_grub=new double[2*n];
    for(i=0;i<n-1;i++)
     dy1[i]=y[i+1]-y[i];
    for(i=0;i<n-2;i++)
     dy2[i]=dy1[i+1]-dy1[i];
    for(i=0;i<n-3;i++)
     dy3[i]=dy2[i+1]-dy2[i];
    for(i=0;i<n-4;i++)
     dy4[i]=dy3[i+1]-dy3[i];
    for(i=0;i<n-5;i++)
     dy5[i]=dy4[i+1]-dy4[i];
    for(i=0;i<n-6;i++)
     dy6[i]=dy5[i+1]-dy5[i];
    for(i=1;i<n-6;i++)
    {
    dy_t[i]=(dy1[i-1]+dy2[i-1]/2-dy3[i-1]/6+dy4[i-1]/12-dy5[i-1]/20+dy6[i-1]/30);
    dy_t[0]=0;
    dy_grub[i]=(y[i+1]-y[i]);// without div h
    }
    return dy_t;
    }
        
    private static void optRadius(SignalClass r, SignalClass n) {
        for(int rad=0;rad<Params.getK_oznaka();rad++){
           r.setRadius(rad);
           double k1=0,k2,k3=0,k4;
           double t_d1, t_betta, d1_b, kfe = 0;
              for (int i = 0; i < Params.getK_realiz(); i++){ 
                  if (Methods.calculeteDistance(r.getEtalon(), r.getVector(i)) <= r.getRadius()) { k1++;}
                  if (Methods.calculeteDistance(r.getEtalon(), n.getVector(i)) <= r.getRadius()) { k3++;}
                                  }
                                  k4 = Params.getK_realiz() - k3;
                                  k2 = Params.getK_realiz() - k1;
                                  t_d1 = k1 / Params.getK_realiz();
                                  t_betta = k3 / Params.getK_realiz();
                                 //System.out.println(t_d1+"---"+t_betta);
                                  d1_b = t_d1 - t_betta;
                                  double d;
                                  r.setKFE(rad,d1_b * Math.log((1.0 + d1_b + 0.1) / (1.0 - d1_b + 0.1)) / Math.log(2.0));
                                  r.setArea(rad, false);
                                  if ((t_d1 >= 0.5)&&(t_betta < 0.5)) {
                                      //System.out.println("true");
                                      r.setArea(rad, true);
                                  }
              }
           }

    private static double[] nepro(double[] d, double[] d0, double[] d1) {
    double[] z=new double[Params.getK_oznaka()];
    for(int i=0;i<Params.getK_oznaka();i++){  
    z[i]=1-pow(d0[i],2)/(d[i]*d1[i]);
    }
     return z;   
    }

    private static int[][] getBMed(double[] d, double[][] etN) {
        d[0]=0;
        
        int[][] matr=new int[Params.getK_realiz()][Params.getK_oznaka()];
        for(int j=0;j<Params.getK_realiz();j++){
        etN[j][0]=0;
            for(int i=0;i<Params.getK_oznaka();i++){
            if(Math.round(d[i]*3)/3==Math.round(etN[j][i]*3)/3){
            matr[j][i]=1;
        }
            else{matr[j][i]=0;}
            }
        }
        return matr;
    }

    private static SignalClass GetClosest(ArrayList<SignalClass> temp) {
        int mind=Params.getK_oznaka();
        SignalClass out=null;
        for(SignalClass r:temp){
            System.out.println("Counting "+r.id);
            for(SignalClass n:temp){
                System.out.print(" to "+n.id);
                if(r.id!=n.id){
                Para t=new Para(r.id,n.id);
                System.out.println("Para "+r.id+" to "+n.id+" distance="+Methods.calculeteDistance(r.getEtalon(), n.getEtalon()));
                t.dist=Methods.calculeteDistance(r.getEtalon(), n.getEtalon());
                if(t.dist>mind){mind=t.dist;out=n;}
            }
            }
        System.out.println("For class:"+r.name+" closest is - "+out.name);
        }
        
    return out;
    }

    private static int getListedClass(ArrayList<SignalClass> temp, int id) {
        int out=-1;
        for(SignalClass sc:temp){
           if(sc.id==id){out=id;} 
        }
        return out;
    }
    private static boolean isListed(ArrayList<SignalClass> processed, int id) {
        for(SignalClass sc:processed){
        if(sc.id==id){return true;}}
        return false;
    }
    }
    
