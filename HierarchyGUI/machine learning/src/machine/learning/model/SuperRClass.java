package machine.learning.model;

import machine.learning.controler.Methods;
import java.io.IOException;

public class SuperRClass extends RecognClass {
    private final RecognClass a;
    private final RecognClass b;
    
    public SuperRClass(RecognClass a,RecognClass b) throws IOException {
        this.name=a.getName()+b.getName();
        this.id=count;
        count++;
        this.BM=concatMatr(a.getBM(),b.getBM());
        this.etalon=Methods.getItEtalon(BM);
        this.a=a;
        this.b=b;
        a.setNid(b.id);
        b.setNid(a.id);
    }
    public int[][] createMatr(int[][] a,int[][] b){
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
    
    public int[][] concatMatr(int[][] a,int[][] b){
        int aLen = a.length;
        int bLen = b.length;
        
        int[][] result = new int[aLen+bLen][];

        System.arraycopy(a, 0, result, 0, aLen);
        System.arraycopy(b, 0, result, aLen, bLen);
        return result;
    }
      public String getName() {
        return name;//change for imgs
    }
}
