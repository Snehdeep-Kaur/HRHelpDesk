
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pc
 */
public class UserLogin extends javax.swing.JFrame {

    /**
     * Creates new form UserLogin
     */
    public UserLogin() {
        initComponents();
        setSize(1286,755);
        setResizable(false);
        setLocationRelativeTo(null);
    }

   public void LoginControl(){
       String userid = usertf.getText();
       String pass = new String(passpf.getPassword());
       if(userid.equals("")||pass.equals("")){
           JOptionPane.showMessageDialog(this, "Please enter both userid and password");
       }else{
           try {
                ResultSet rs = DBLoader.executeStatement("select * from userlogin where userid='"+userid+"'");
                if(rs.next()){
                     String dpass = rs.getString(3);
                     if(dpass.equals(pass)){
                         JOptionPane.showMessageDialog(this, "Login Successful");
                         this.dispose();
                         new UserHome(userid).setVisible(true);
                     }else{
                         JOptionPane.showMessageDialog(this, "The Password you have entered is wrong");
                     }
                }else{
                    JOptionPane.showMessageDialog(this, "User does not exist");
                }
           } catch (Exception e) {
               e.printStackTrace();
       }
       }
       
   }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        usertf = new javax.swing.JTextField();
        passpf = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        submitlb = new javax.swing.JLabel();
        backlb = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        getContentPane().add(usertf);
        usertf.setBounds(490, 320, 300, 40);
        getContentPane().add(passpf);
        passpf.setBounds(490, 480, 300, 40);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserLogin.jpg"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 0, 1280, 720);

        submitlb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                submitlbMouseClicked(evt);
            }
        });
        getContentPane().add(submitlb);
        submitlb.setBounds(530, 570, 230, 50);

        backlb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backlbMouseClicked(evt);
            }
        });
        getContentPane().add(backlb);
        backlb.setBounds(1120, 650, 140, 60);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void submitlbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_submitlbMouseClicked
        LoginControl();
    }//GEN-LAST:event_submitlbMouseClicked

    private void backlbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backlbMouseClicked
        new MainPage().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backlbMouseClicked

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
            java.util.logging.Logger.getLogger(UserLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel backlb;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPasswordField passpf;
    private javax.swing.JLabel submitlb;
    private javax.swing.JTextField usertf;
    // End of variables declaration//GEN-END:variables
}
