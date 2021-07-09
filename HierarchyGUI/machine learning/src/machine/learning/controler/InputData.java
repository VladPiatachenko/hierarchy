package machine.learning.controler;

import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.io.File;
import java.util.Scanner;
import javax.swing.JOptionPane;
import machine.learning.model.Parameters;
import machine.learning.view.IEITFrame;

public class InputData {
    
    public static int[][] getMatrix(File f){
        try {
            Scanner sc = new Scanner(f);
            int[][] matrix = new int [Parameters.getK_realiz()][Parameters.getK_oznaka()];
            
            for(int i = 0; i< Parameters.getK_realiz(); i++)
            {
                for(int k = 0; k < Parameters.getK_oznaka(); k++)
                {
                    matrix[i][k] =sc.nextInt();
                }
            }
            
            return matrix;
        } catch (Exception ex) {
        JOptionPane.showMessageDialog(IEITFrame.jTextLearningArea,"File:"+f.getName()+"\nException occured:"+ex.toString()+"\nRestart program.\nCheck for correct version of data file with suitable parameters.");
        }
        return null;
    }
}


