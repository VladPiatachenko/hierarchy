package machine.learning.model;

import java.io.File;

public class Parameters {
    private static int iterator=0;
    private static String[] path;
    private static String outdirectory="";
    private static File[] recfiles;
    private static int k_realiz;
    private static int k_oznaka;
    private static int k_klass;
    private static int delta;
    private static int vd[];
    private static int nd[];
    private static boolean allow=false;
    private static String log="";

    public static String getLog() {
        return log;
    }

    public static String getOutdirectory() {
        return outdirectory;
    }

    public static void addLog(String tlog) {
        Parameters.log=log.concat("\n"+tlog);
    }
    
    
    public static void CreatePath(){
        path=new String[k_klass];
        recfiles=new File[k_klass];
    }
    public static boolean valid(){
        if(iterator<k_klass){return true;}
        else{return false;}
    }
    
    public static void setInPath(File fl){
        if(valid()){
        path[iterator]=fl.getName();
        recfiles[iterator]=fl;
        if(outdirectory==""){outdirectory=fl.getAbsolutePath().substring(0, fl.getAbsolutePath().length()-fl.getName().length());}
        iterator++;}
        if(iterator==k_klass){allow=true;}
    }
    
    public static String[] getPath() {
        return path;
    }

    public static File[] getFiles() {
        return recfiles;
    }
    public static void setPath(String[] path) {
        Parameters.path = path;
    }

    public static int getK_realiz() {
        return k_realiz;
    }

    public static void setK_realiz(int k_realiz) {
        Parameters.k_realiz = k_realiz;
    }

    public static int getK_oznaka() {
        return k_oznaka;
    }

    public static void setK_oznaka(int k_oznaka) {
        Parameters.k_oznaka = k_oznaka;
    }

    public static int getK_klass() {
        return k_klass;
    }

    public static void setK_klass(int k_klass) {
        Parameters.k_klass = k_klass;
    }

    public static int getDelta() {
        return delta;
    }

    public static void setDelta(int delta) {
        Parameters.delta = delta;
    }

    public static int[] getVd() {
        return vd;
    }

    public static void setVd(int[] vd) {
        Parameters.vd = vd;
    }

    public static int[] getNd() {
        return nd;
    }

    public static void setNd(int[] nd) {
        Parameters.nd = nd;
    }

    public static int getNd(int o) {
        return nd[o];
    }

    public static int getVd(int o) {
        return vd[o];
    }

    public static boolean allowLearning() {
        return allow;
    }

}