package machine.learning;

import java.io.IOException;
import java.util.ArrayList;

public class RecognClass {

    private int size;
    private int id;
    private static int count = 0;
    private String name;
    private double[] avg;
    private int[] etalon = new int[size];
    private double[][] Mat;
    private int[][] BM;
    private int dist_to_neig;
    private String neig;
    private int Nid;
    private int radius;
    private DataOut data;

    public int getRadius() {
        return radius;
    }

    public DataOut getData() {
        return data;
    }

    public void setData(DataOut data) {
        this.data = data;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public RecognClass(String name,double[][] m) throws IOException {
        this.name=name;
        this.size = Params.getK_oznaka();
        this.Mat=m;
        this.id=count;
        count++;
        data=new DataOut();
    }

    public double[] getItAvg() {
        return avg;
    }

    public int[] getEtalon() {
        return etalon;
    }

    public double[][] getMat() {
        return Mat;
    }
     public int[] getVector(int i) {
        int t[]=new int[size];
        for(int k=0;k<size;k++){
        t[k]=BM[i][k];
        }
        return t;
    }
    public double getMat(int i,int j) {
        return Mat[i][j];
        }
    public int[][] getBM() {
        return BM;
    }

    public String getPath() {
        return name;
    }
    
    public String getName() {
        return name.substring(38,name.length()-4);
    }

    void setBM(int[][] bm) throws IOException {
    this.BM=bm;
    }

    void setEtalon(int[] et) {
    this.etalon=et;
    }

    void setNeigh(String neighbourName) {
    this.neig=neighbourName;
    }
    
    public void setDist_to_neig(int dist_to_neig) {
        this.dist_to_neig = dist_to_neig;
    }

    public int getDist_to_neig() {
        return dist_to_neig;
    }

    public String getNeig() {
        return neig;
    }

    void setAvg(double[] avg) {
    this.avg=avg;
    }
     public void setNid(int Nid) {
        this.Nid = Nid;
    }

    public int getId() {
        return id;
    }

    public int getNid() {
        return Nid;
    }
    
}
