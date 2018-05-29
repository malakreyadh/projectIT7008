/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Exceptions.*;
import Logic.Company;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author malakreyadh
 */
public class NewDepFrame extends javax.swing.JFrame {
    
    private MainMenu main = new MainMenu();
    /**
     * Creates new form NewDepFrame
     */
    public NewDepFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Title = new javax.swing.JPanel();
        jLblTitle = new javax.swing.JLabel();
        Footer = new javax.swing.JPanel();
        jBtnCreate = new javax.swing.JButton();
        jBtnReturn = new javax.swing.JButton();
        Main = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLbl = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTxtDepName = new javax.swing.JTextField();
        jTxtDepLocation = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLblTitle.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        jLblTitle.setText("Add New Department");
        Title.add(jLblTitle);

        getContentPane().add(Title, java.awt.BorderLayout.PAGE_START);

        Footer.setLayout(new java.awt.GridLayout(1, 0, 100, 0));

        jBtnCreate.setText("Create");
        jBtnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCreateActionPerformed(evt);
            }
        });
        Footer.add(jBtnCreate);

        jBtnReturn.setText("Return To Main Menu");
        jBtnReturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnReturnActionPerformed(evt);
            }
        });
        Footer.add(jBtnReturn);

        getContentPane().add(Footer, java.awt.BorderLayout.PAGE_END);

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLbl.setText("Department Name:");

        jLabel3.setText("Department Location:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTxtDepName, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                    .addComponent(jTxtDepLocation))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLbl)
                    .addComponent(jTxtDepName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTxtDepLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout MainLayout = new javax.swing.GroupLayout(Main);
        Main.setLayout(MainLayout);
        MainLayout.setHorizontalGroup(
            MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MainLayout.createSequentialGroup()
                .addContainerGap(84, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71))
        );
        MainLayout.setVerticalGroup(
            MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MainLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(65, Short.MAX_VALUE))
        );

        getContentPane().add(Main, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnReturnActionPerformed
        new MainMenu().setVisible(true);
        
        this.setVisible(false);
        
        
    }//GEN-LAST:event_jBtnReturnActionPerformed

    private void jBtnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCreateActionPerformed
        //declare varaibles of String type and initialize to null
        String loc = null, name = null;
        
        
        try {
                
            //getting the text from the textboxes and storing in the string varaibles
            loc = jTxtDepLocation.getText();
            name = jTxtDepName.getText();
            if (loc.isEmpty() || name.isEmpty()){
              throw new TextFieldEmptyException("Text Field is empty."
                      + "\nPlease enter all the details to create department.");
            }

            /* Invoking the getCompany method which returns Company class
            object in order to invoke the addDep method of that object */
            
            main.getCompany().addDep(loc,name); // passing loc and name values
            
            //Showing the user a message of confirmation
            JOptionPane.showMessageDialog(null, "Department added."); 
            
        } 
        
        catch (DepartmentExistsInTheList ex) {
            //Logger used to track the error source
            Logger.getLogger(NewDepFrame.class.getName())
                    .log(Level.SEVERE, null, ex);
            // Showing the user the error message
            JOptionPane.showMessageDialog(null, ex, "Error", JOptionPane.ERROR_MESSAGE);   
        }
            
        catch(TextFieldEmptyException xe){
        
            JOptionPane.showMessageDialog(null, xe, "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_jBtnCreateActionPerformed
    
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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NewDepFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewDepFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewDepFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewDepFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewDepFrame().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Footer;
    private javax.swing.JPanel Main;
    private javax.swing.JPanel Title;
    private javax.swing.JButton jBtnCreate;
    private javax.swing.JButton jBtnReturn;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLbl;
    private javax.swing.JLabel jLblTitle;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextField jTxtDepLocation;
    private javax.swing.JTextField jTxtDepName;
    // End of variables declaration//GEN-END:variables
}
