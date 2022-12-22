/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HP
 */
public class HRHeadHome extends javax.swing.JFrame {

    /**
     * Creates new form HRHeadHome
     */
    public HRHeadHome() {
        initComponents();
        setSize(1280,755);
        setResizable(false);
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        cohlb = new javax.swing.JLabel();
        vclb = new javax.swing.JLabel();
        logoutlb = new javax.swing.JLabel();
        dulb = new javax.swing.JLabel();
        aulb = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/HRHeadDashboard.jpg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1280, 720);

        cohlb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cohlbMouseClicked(evt);
            }
        });
        getContentPane().add(cohlb);
        cohlb.setBounds(220, 250, 210, 80);

        vclb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                vclbMouseClicked(evt);
            }
        });
        getContentPane().add(vclb);
        vclb.setBounds(620, 260, 220, 80);

        logoutlb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoutlbMouseClicked(evt);
            }
        });
        getContentPane().add(logoutlb);
        logoutlb.setBounds(1040, 250, 220, 90);

        dulb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dulbMouseClicked(evt);
            }
        });
        getContentPane().add(dulb);
        dulb.setBounds(460, 450, 210, 80);

        aulb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                aulbMouseClicked(evt);
            }
        });
        getContentPane().add(aulb);
        aulb.setBounds(870, 450, 220, 80);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void logoutlbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutlbMouseClicked
        new MainPage().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_logoutlbMouseClicked

    private void dulbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dulbMouseClicked
        new DeleteUser().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_dulbMouseClicked

    private void aulbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aulbMouseClicked
        new AddUsers().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_aulbMouseClicked

    private void vclbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vclbMouseClicked
        new HRHeadViewComplaints("","").setVisible(true);
        this.dispose();
    }//GEN-LAST:event_vclbMouseClicked

    private void cohlbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cohlbMouseClicked
        new CheckOnHr("","").setVisible(true);
        this.dispose();
    }//GEN-LAST:event_cohlbMouseClicked

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
            java.util.logging.Logger.getLogger(HRHeadHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HRHeadHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HRHeadHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HRHeadHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HRHeadHome().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel aulb;
    private javax.swing.JLabel cohlb;
    private javax.swing.JLabel dulb;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel logoutlb;
    private javax.swing.JLabel vclb;
    // End of variables declaration//GEN-END:variables
}
