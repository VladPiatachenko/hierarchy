package machine.learning;

import java.io.IOException;
import java.util.ArrayList;

public class MachineLearning {

    public static void main(String[] args) throws IOException {
      //Preparations
        Params Currents = Methods.getInputs();
        RecognClass CurrentClass;
        double[][] input;
        ArrayList<RecognClass> recclasses = new ArrayList<RecognClass>();
        for(String cpath:Currents.getPath()){
            input=Methods.getMatrix(cpath);
            CurrentClass= new RecognClass(cpath,input);
            recclasses.add(CurrentClass);
            }
      //Start base learning
        Learning.learning(recclasses);//writing to files allowed
      //Optimised delta
        
      //Hierarchy
      //  Hierarchy.hierarchy();
    }
}
