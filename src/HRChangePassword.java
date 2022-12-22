
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HP
 */
public class HRChangePassword extends javax.swing.JFrame {

    String userid;
    
    public HRChangePassword(String usd) {
        initComponents();
        userid=usd;
        System.out.println(userid);
        setSize(1280,755);
        setResizable(false);
        setLocationRelativeTo(null);
        useridtf.setEditable(false);
        useridtf.setText(userid);
    }

    public void ChangePass(String userid){   
        String npass = new String(npasspf.getPassword());
        String repass = new String(repasspf.getPassword());
        if(npass.equals(repass)){
            try {
                ResultSet rs = DBLoader.executeStatement("select * from hrlogin where hrid='"+userid+"' ");
                if(rs.next()){
                    String oldpass = rs.getString(3);
                    if(oldpass.equals(npass)){
                        JOptionPane.showMessageDialog(this, "New password cannot be same as Old Password");
                    }else{
                        rs.updateString("password",npass);
                        rs.updateRow();
                        JOptionPane.showMessageDialog(this,"Password Changed");
                        this.dispose();
                        new HRHome(userid).setVisible(true);
                    }
                    
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else{
            JOptionPane.showMessageDialog(this, "New password and re-password does not match");
        }
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        useridtf = new javax.swing.JTextField();
        repasspf = new javax.swing.JPasswordField();
        npasspf = new javax.swing.JPasswordField();
        submitlb = new javax.swing.JLabel();
        backlb = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        getContentPane().add(useridtf);
        useridtf.setBounds(280, 310, 300, 56);
        getContentPane().add(repasspf);
        repasspf.setBounds(280, 500, 300, 50);
        getContentPane().add(npasspf);
        npasspf.setBounds(280, 410, 300, 50);

        submitlb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                submitlbMouseClicked(evt);
            }
        });
        getContentPane().add(submitlb);
        submitlb.setBounds(210, 600, 230, 70);

        backlb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backlbMouseClicked(evt);
            }
        });
        getContentPane().add(backlb);
        backlb.setBounds(1120, 670, 150, 50);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ChangePasswordHR.jpg"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 0, 1300, 720);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backlbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backlbMouseClicked
        this.dispose();
        new HRHome(userid).setVisible(true);
    }//GEN-LAST:event_backlbMouseClicked

    private void submitlbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_submitlbMouseClicked
         ChangePass(userid);
    }//GEN-LAST:event_submitlbMouseClicked

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
            java.util.logging.Logger.getLogger(ChangePassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChangePassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChangePassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChangePassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new HRChangePassword().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel backlb;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPasswordField npasspf;
    private javax.swing.JPasswordField repasspf;
    private javax.swing.JLabel submitlb;
    private javax.swing.JTextField useridtf;
    // End of variables declaration//GEN-END:variables
}
