package machine.learning;

import java.io.IOException;

public class Params {
    private static String[] path;
    private static int k_realiz;
    private static int k_oznaka;
    private static int k_klass;
    private static double delta;
    
    private static double vd[];
    private static double nd[];

    public Params(String[] path,int k, int r,int o,double delta) {
        this.path = path;
        this.k_klass=k;
        this.k_realiz=r;
        this.k_oznaka=o;
        this.delta=delta;
    }

    public static String[] getPath() {
        return path;
    }

    public Params(String[] path,int k, int r,int o) {
        this.path = path;
        this.k_klass=k;
        this.k_realiz=r;
        this.k_oznaka=o;
        this.delta= 15;
    }
    
    public static double getVd(int i) {
        return vd[i];
    }

    public static void setVd(double[] d) {
        vd = d;
    }

    public static double getNd(int i) {
        return nd[i];
    }

    public static void setNd(double[] d) {
        nd = d;
    }

    public static double getDelta() {
        return delta;
    }

    public static int getK_realiz() {
        return k_realiz;
    }
    public static int getK_oznaka() {
        return k_oznaka;
    }
    public static int getK_klass() {
        return k_klass;
    }
    
}
