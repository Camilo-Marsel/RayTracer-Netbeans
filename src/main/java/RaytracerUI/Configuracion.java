/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package RaytracerUI;

/**
 *
 * @author deibh
 */
public class Configuracion extends javax.swing.JFrame {

    /**
     * Creates new form Configuracion
     */
    public Configuracion() {
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        AnchotxtField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        Altotxtfield = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        PixelBar = new javax.swing.JSlider();
        jLabel5 = new javax.swing.JLabel();
        Pixeltxt = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setMinimumSize(new java.awt.Dimension(480, 690));
        setPreferredSize(new java.awt.Dimension(480, 690));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Ancho");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, 20));

        AnchotxtField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AnchotxtFieldActionPerformed(evt);
            }
        });
        AnchotxtField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                AnchotxtFieldKeyTyped(evt);
            }
        });
        jPanel1.add(AnchotxtField, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, 90, -1));

        jLabel2.setText("Relacion de aspecto");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 30, 110, 20));

        Altotxtfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AltotxtfieldActionPerformed(evt);
            }
        });
        jPanel1.add(Altotxtfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 30, 100, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 420, 80));

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PixelBar.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                PixelBarStateChanged(evt);
            }
        });
        jPanel2.add(PixelBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 60, 230, -1));

        jLabel5.setText("Muestras por Pixel");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        Pixeltxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PixeltxtActionPerformed(evt);
            }
        });
        jPanel2.add(Pixeltxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, 40, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 420, 100));

        jButton1.setText("Actualizar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 230, -1, -1));

        getAccessibleContext().setAccessibleName("Configuracion");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AnchotxtFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AnchotxtFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AnchotxtFieldActionPerformed

    private void PixeltxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PixeltxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PixeltxtActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    AnchotxtField.setText(Integer.toString(super.getWidth()));
    Altotxtfield.setText(Integer.toString(super.getHeight()));
    
    }//GEN-LAST:event_jButton1ActionPerformed

    private void AnchotxtFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_AnchotxtFieldKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_AnchotxtFieldKeyTyped

    private void PixelBarStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_PixelBarStateChanged
    Pixeltxt.setText(Integer.toString(PixelBar.getValue()));
    // TODO add your handling code here:
    }//GEN-LAST:event_PixelBarStateChanged

    private void AltotxtfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AltotxtfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AltotxtfieldActionPerformed

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
            java.util.logging.Logger.getLogger(Configuracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Configuracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Configuracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Configuracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Configuracion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Altotxtfield;
    private javax.swing.JTextField AnchotxtField;
    private javax.swing.JSlider PixelBar;
    private javax.swing.JTextField Pixeltxt;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}