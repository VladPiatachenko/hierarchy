package machine.learning.view;

import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import machine.learning.controler.HierarchyDist;
import machine.learning.model.Parameters;


public class IEITFrame extends javax.swing.JFrame {

    public IEITFrame() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextClasses = new javax.swing.JTextField();
        jTextRealiz = new javax.swing.JTextField();
        jTextAttrib = new javax.swing.JTextField();
        jTextDelta = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextParamsArea = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextClassArea = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextLearningArea = new javax.swing.JTextArea();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("IEIT Machine Learning");
        setLocation(new java.awt.Point(0, 0));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Parameters");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 13, -1, -1));

        jLabel2.setText("Classes");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 41, -1, -1));

        jLabel3.setText("Realizations");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 72, -1, -1));

        jLabel4.setText("Attributes");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 101, -1, -1));

        jLabel5.setText("Delta");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 130, -1, -1));

        jTextClasses.setText("6");
        getContentPane().add(jTextClasses, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 38, 54, -1));

        jTextRealiz.setText("20");
        jTextRealiz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextRealizActionPerformed(evt);
            }
        });
        getContentPane().add(jTextRealiz, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 69, 54, -1));

        jTextAttrib.setText("1000");
        getContentPane().add(jTextAttrib, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 98, 54, -1));

        jTextDelta.setText("130");
        jTextDelta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextDeltaActionPerformed(evt);
            }
        });
        getContentPane().add(jTextDelta, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 127, 54, -1));

        jTextParamsArea.setColumns(20);
        jTextParamsArea.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jTextParamsArea.setRows(5);
        jScrollPane1.setViewportView(jTextParamsArea);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 40, 560, 112));

        jButton1.setText("Set Parameters");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 40, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Classes");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 167, -1, -1));

        jButton2.setText("Select Files");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 202, 111, -1));

        jButton3.setText("Print Selected");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 240, -1, -1));

        jTextClassArea.setColumns(20);
        jTextClassArea.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jTextClassArea.setRows(5);
        jScrollPane2.setViewportView(jTextClassArea);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(182, 167, 689, 116));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Learning");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 308, -1, -1));

        jButton4.setText("Start Learning");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 338, -1, -1));

        jTextLearningArea.setColumns(20);
        jTextLearningArea.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jTextLearningArea.setRows(5);
        jScrollPane3.setViewportView(jTextLearningArea);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(182, 308, 689, 167));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 480, 900, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 2, 13)); // NOI18N
        jLabel8.setText("Hierarchial IEIT machine learning");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 480, -1, -1));

        getAccessibleContext().setAccessibleName("IEITMachineLearning");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
   
              try{
        int amclass=Integer.valueOf(jTextClasses.getText());
        int amrealiz=Integer.valueOf(jTextRealiz.getText());
        int amattr=Integer.valueOf(jTextAttrib.getText());
        int delta=Integer.valueOf(jTextDelta.getText());
if(amclass<=0||amrealiz<=0||amattr<=0||delta<=0){
        amclass=6;
        amrealiz=20;
        amattr=1000;
        delta=130;
        jTextParamsArea.setText("Unsupposed values.\nParameters must be positive integers.\nSaved default values.\n"
                + "Amount of classes= "+amclass
                +"\nAmount of realizations= "+amrealiz
                +"\nAmount of attributes= "+amattr
                +"\nDelta= "+delta);
        }
else{

        jTextParamsArea.setText("Parameters saved.\nAmount of classes= "+amclass
                +"\nAmount of realizations= "+amrealiz
                +"\nAmount of attributes= "+amattr
                +"\nDelta= "+delta);}
        Parameters.setK_klass(amclass);
        Parameters.setK_realiz(amrealiz);
        Parameters.setK_oznaka(amattr);
        Parameters.setDelta(delta);
        Parameters.CreatePath();
      }catch(NumberFormatException ex){
        jTextParamsArea.setText("Unsupposed values. \nParameters must be positive integers.");
      }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextDeltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextDeltaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextDeltaActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if(Parameters.valid()){
        int result=jFileChooser1.showOpenDialog(jLabel1);
            if(result==0){
                Parameters.setInPath(jFileChooser1.getSelectedFile().getAbsoluteFile());
                jTextClassArea.append("Added "+jFileChooser1.getName(jFileChooser1.getSelectedFile())+"\n");
            }
        }
        else{jTextClassArea.setText("Class filling limit reached.");
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        jTextClassArea.setText("List of Recognition Classes:\n");
        String[] temp=Parameters.getPath();
        for(int i=0;i<Parameters.getPath().length;i++){
            jTextClassArea.append((i+1)+". "+temp[i]+"\n");
        }

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        String output="";
        if(Parameters.allowLearning()){
          
           try {
            output=   HierarchyDist.learning();
           } catch (IOException ex) {
               Logger.getLogger(IEITFrame.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
       else{jTextLearningArea.append("Set parameters and select classes first");
        }
       jTextLearningArea.append(Parameters.getLog()+"\n");
       jTextLearningArea.append(output);
       
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTextRealizActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextRealizActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextRealizActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosing
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(IEITFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IEITFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IEITFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IEITFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IEITFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextAttrib;
    private javax.swing.JTextArea jTextClassArea;
    private javax.swing.JTextField jTextClasses;
    private javax.swing.JTextField jTextDelta;
    public static javax.swing.JTextArea jTextLearningArea;
    private javax.swing.JTextArea jTextParamsArea;
    private javax.swing.JTextField jTextRealiz;
    // End of variables declaration//GEN-END:variables
}
