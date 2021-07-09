package machine.learning.model;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import machine.learning.controler.InputData;
import machine.learning.controler.Methods;
import machine.learning.model.Para;

public class RecognClass {

    protected int id;
    protected static int count = 0;
    protected String name;
    private String path;
    private int[] avg;
    protected int[] etalon = new int[Parameters.getK_oznaka()];
    private int[][] Mat;
    protected int[][] BM;
    private int dist_to_neig;
    private String neig;
    private int Nid;
    private int radius;
  
    private double E[]=new double[Parameters.getK_oznaka()];
    private boolean area[]=new boolean[Parameters.getK_oznaka()];
    private double d1[]=new double[Parameters.getK_oznaka()];
    private double betta[]=new double[Parameters.getK_oznaka()];

    private ArrayList<Para> distances=new ArrayList<Para>();
    private int ParentA=-1;
    private int ParentB=-1;

    public ArrayList<Para> getDistances() {
        return distances;
    }
    
    
    public RecognClass() {
    }
    public RecognClass(String name,int a,int b,int[][]Binar) {
    this.name=name;
    this.BM=Binar;
    this.ParentA=a;
    this.ParentB=b;
    this.id=count;
    count++;
    this.etalon=Methods.getItEtalon(Binar);
    }
  
    @Override
    public String toString(){
        return("Id:"+id+" Class:"+getName());
    }
      public void setId(int id) {
        this.id = id;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public RecognClass(File f) throws IOException {
        this.path=f.getAbsolutePath();
        this.name= f.getName().substring(0,f.getName().length()-4);
        this.Mat=InputData.getMatrix(f);
        this.id=count;
        count++;
    }

    public int[] getItAvg() {
        return avg;
    }

    public int[] getEtalon() {
        return etalon;
    }

    public int[][] getMat() {
        return Mat;
    }
     public int[] getVector(int i) {
        int t[]=new int[Parameters.getK_oznaka()];
        for(int k=0;k<Parameters.getK_oznaka();k++){
        t[k]=BM[i][k];
        }
        return t;
    }
    public int getMat(int i,int j) {
        return Mat[i][j];
        }
    public int[][] getBM() {
        return BM;
    }

    public String getPath() {
        return name;
    }
    
    public String getName() {
        return name;
    }

    public void setBM(int[][] bm) throws IOException {
    this.BM=bm;
    }

    public void setEtalon(int[] et) {
    this.etalon=et;
    }

    public void setNeigh(String neighbourName) {
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

    public void setAvg(int[] avg) {
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

    public double getE(int i) {
        return E[i];
    }

    public boolean getArea(int i) {
        return area[i];
    }

    public double getD1(int i) {
        return d1[i];
    }

    public int getParentA() {
        return ParentA;
    }

    public void setParentA(int ParentA) {
        this.ParentA = ParentA;
    }

    public int getParentB() {
        return ParentB;
    }

    public void setParentB(int ParentB) {
        this.ParentB = ParentB;
    }

    public double getBetta(int i) {
        return betta[i];
    }

    public void setE(int rad, double d) {
        this.E[rad]=d;
    }

    public void setBetta(int rad, double t_betta) {
        this.betta[rad]=t_betta;
    }

    public void setD1(int rad, double t_d1) {
        this.d1[rad]=t_d1;
    }

    public void setArea(int rad, boolean b) {
        this.area[rad]=b;
    }

    public void addDistance(Para idDist) {
        this.distances.add(idDist);
    }
  
}
