package machine.learning.controler;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import machine.learning.model.Parameters;
import machine.learning.model.RecognClass;

public class Methods {


    public static int[] getAvg(int[][] Mat) {
        int[] avg=new int[Parameters.getK_oznaka()];
        for(int i=0;i<Parameters.getK_oznaka();i++){
            for(int j=0;j<Parameters.getK_realiz();j++){
                avg[i]=avg[i]+Mat[j][i];
            }
            avg[i]=(int)avg[i]/Parameters.getK_realiz();
        }
        return avg;
    }
    
    public static int[][] toBinar(int[][] Mat) {
        int[][] bm=new int[Parameters.getK_realiz()][Parameters.getK_oznaka()];
        for(int r=0;r<Parameters.getK_realiz();r++){
            for(int o=0;o<Parameters.getK_oznaka();o++){
                bm[r][o]=0;
                if((Mat[r][o]>Parameters.getNd(o))&&(Mat[r][o]<Parameters.getVd(o))){bm[r][o]=1;}
            }
        }
        return bm;
    }
    public static int[] getItEtalon(int[][]bm,int rs){
        int[] temp=new int[Parameters.getK_oznaka()];
        int uno=0;//amount of 1 in matrix
            for(int o=0;o<Parameters.getK_oznaka();o++){
                uno=0;
                for(int r=0;r<rs;r++){
                    if(bm[r][o]==1){uno++;}
                }
                if(uno>=Parameters.getK_realiz()/2){temp[o]=1;}
                else{temp[o]=0;}
            }
        return temp;
    }
    public static int[] getItEtalon(int[][]bm){
        int[] temp=getItEtalon(bm,Parameters.getK_realiz());
        return temp;
    }
    public static int calculeteDistance(int[] a,int[] b){
        int dist=0;
            for(int o=0;o<Parameters.getK_oznaka();o++){
                if(a[o]!=b[o]){dist++;}
            }
        return dist;
    }

    public static void getNeighbour(RecognClass r,ArrayList<RecognClass> recclasses) {
            int nId=-1;
            int mindist=Parameters.getK_oznaka();
            int dist=-1;
            for(RecognClass k:recclasses){
                if(!r.getName().equalsIgnoreCase(k.getName())){
                    dist=calculeteDistance(r.getEtalon(),k.getEtalon());
                    if(mindist>=dist){
                    mindist=dist;
                    nId=k.getId();
                    }
                }
            }
            r.setNeigh(recclasses.get(nId).getName());
            r.setNid(nId);
            r.setDist_to_neig(dist);
    
    }
    static void writeOutData(RecognClass r) throws IOException{
            File file = new File(Parameters.getOutdirectory()+r.getId()+"_"+r.getName()+"_radius.txt");
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("radius\t E\t area\t D1\t betta\t NeighbourID\t toNeighbour\n");
            
            for(int i=0;i<Parameters.getK_oznaka();i++){
                bufferedWriter.write(i+"-"+r.getRadius()+"\t"+r.getE(i)+"\t"+r.getArea(i)+"\t"+r.getD1(i)+"\t"+r.getBetta(i)+"\t"+r.getNid()+"\t"+r.getDist_to_neig()+"\n");
            }
            bufferedWriter.close();

    }
     public static void limits(int avg[]){
        int vtemp[]=new int[Parameters.getK_oznaka()];
        int ntemp[]=new int[Parameters.getK_oznaka()];
        for(int o=0;o<Parameters.getK_oznaka();o++){
            vtemp[o]=avg[o]+Parameters.getDelta();
            ntemp[o]=avg[o]-Parameters.getDelta();
           
        }
        Parameters.setVd(vtemp);
        Parameters.setNd(ntemp);
    }
   
    static int[][] createMatr(int[][] a,int[][] b){
        int[][] result = new int[Parameters.getK_realiz()][Parameters.getK_oznaka()];

        for(int i=0;i<Parameters.getK_realiz();i++){
            for(int j=0;j<Parameters.getK_oznaka();j++){
                if(a[i][j]==b[i][j]){
                result[i][j]=a[i][j];}
                else{result[i][j]=0;}
            }
        }
        return result;
    }

}