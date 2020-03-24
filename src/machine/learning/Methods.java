package machine.learning;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Methods {

private static String path[] = {"E:\\hierarchy_java\\DataReader\\gestures\\close_hand.txt",
		"E:\\hierarchy_java\\DataReader\\gestures\\close_hand_extend.txt",
		"E:\\hierarchy_java\\DataReader\\gestures\\close_hand_flex.txt",
		"E:\\hierarchy_java\\DataReader\\gestures\\close_hand_pronation.txt",
		"E:\\hierarchy_java\\DataReader\\gestures\\close_hand_supination.txt",
		"E:\\hierarchy_java\\DataReader\\gestures\\extend_hand.txt",
		"E:\\hierarchy_java\\DataReader\\gestures\\extend_hand_pronation.txt",
		"E:\\hierarchy_java\\DataReader\\gestures\\extend_hand_supination.txt",
		"E:\\hierarchy_java\\DataReader\\gestures\\flex_hand.txt",
		"E:\\hierarchy_java\\DataReader\\gestures\\flex_hand_pronation.txt",
		"E:\\hierarchy_java\\DataReader\\gestures\\flex_hand_supination.txt",
		"E:\\hierarchy_java\\DataReader\\gestures\\open_hand.txt",
		"E:\\hierarchy_java\\DataReader\\gestures\\open_hand_extend.txt",
		"E:\\hierarchy_java\\DataReader\\gestures\\open_hand_flex.txt",
		"E:\\hierarchy_java\\DataReader\\gestures\\open_hand_pronation.txt",
		"E:\\hierarchy_java\\DataReader\\gestures\\open_hand_supination.txt",
		"E:\\hierarchy_java\\DataReader\\gestures\\pronation.txt",
		"E:\\hierarchy_java\\DataReader\\gestures\\supination.txt"};

    public static String getPath(int i) {
        return path[i];
    }

    
public static Params getInputs(){
    Params a = new Params(path,18,8,36000);
    return a;
}

static double[][] getMatrix(String path) throws FileNotFoundException, IOException{
    Scanner sc = new Scanner(new FileReader(path));
        double[][] matrix = new double [Params.getK_realiz()][Params.getK_oznaka()];
        for(int i = 0; i< Params.getK_realiz(); i++)
        {
           for(int k = 0; k < Params.getK_oznaka(); k++) 
           {
                matrix[i][k] = 100*sc.nextFloat();
           }
           }
        return matrix;
    }

    static double[] getAvg(double[][] Mat) {
        double[] avg=new double[Params.getK_oznaka()];
        for(int i=0;i<Params.getK_oznaka();i++){
            for(int j=0;j<Params.getK_realiz();j++){
                avg[i]=avg[i]+Mat[j][i];
            }
            avg[i]=avg[i]/Params.getK_realiz();
        }
        return avg;
    }
    static int[][] toBinar(double[][] Mat) {
        int[][] bm=new int[Params.getK_realiz()][Params.getK_oznaka()];
        for(int r=0;r<Params.getK_realiz();r++){
            for(int o=0;o<Params.getK_oznaka();o++){
                if((Mat[r][o]>=Params.getNd(o))&&(Mat[r][o]<=Params.getVd(o))){bm[r][o]=1;}
                else {bm[r][o]=0;}
            }
        }
        return bm;
    }
    static int[] getItEtalon(int[][]bm){
        int[] temp=new int[Params.getK_oznaka()];
        int t=0;
            for(int o=0;o<Params.getK_oznaka();o++){
                for(int r=0;r<Params.getK_realiz();r++){
                    t=t+bm[r][o];
                }
                if(t>=Params.getK_realiz()/2){temp[o]=1;}
                else{temp[o]=0;}
            }
        return temp;
    }
    static int calculeteDistance(int[] a,int[] b){
        int dist=0;
            for(int o=0;o<Params.getK_oznaka();o++){
                if(a[o]!=b[o]){dist++;}
            }
        return dist;
    }

    static void getNeighbour(RecognClass r,ArrayList<RecognClass> recclasses) {
            int nId=-1;
            int mindist=Params.getK_oznaka();
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
            //System.out.println(r.getNid()+"  "+r.getNeig());
    
    }

    static void writeOutMatr(String filename,int[][] b) throws IOException{
            File file = new File(filename);
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for(int i=0;i<Params.getK_realiz();i++){
            for(int j=0;j<Params.getK_oznaka();j++){
                bufferedWriter.write(b[i][j]+"  ");
            }
            bufferedWriter.write("\n");
            }
            bufferedWriter.close();

    }
    static void writeOutData(RecognClass r) throws IOException{
            File file = new File(r.getName()+"_radius.txt");
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for(int i=0;i<Params.getK_oznaka();i++){
                bufferedWriter.write(i+"\t"+r.getData().KFE[i]+"\t"+r.getData().area[i]+"\n");
            }
            bufferedWriter.close();

    }
    
    
     public static void limits(double avg[]){
        System.out.println(Params.getDelta()+" "+Params.getK_oznaka());
        double vtemp[]=new double[Params.getK_oznaka()];
        double ntemp[]=new double[Params.getK_oznaka()];
        for(int o=0;o<Params.getK_oznaka();o++){
            vtemp[o]=avg[o]+Params.getDelta();
            ntemp[o]=avg[o]-Params.getDelta();
        }
        Params.setVd(vtemp);
        Params.setNd(ntemp);
    }
   
     public static void optRadius(RecognClass r,RecognClass n){
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
                                r.getData().setKFE(rad,d1_b * Math.log((1.0 + d1_b + 0.1) / (1.0 - d1_b + 0.1)) / Math.log(2.0));
				r.getData().setArea(rad, false);
				if ((t_d1 >= 0.5)&&(t_betta < 0.5)) {
                                    //System.out.println("true");
                                    r.getData().setArea(rad, true);
                                }
            }
         
        }
     }


