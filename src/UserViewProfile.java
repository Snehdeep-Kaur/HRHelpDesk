
import java.sql.ResultSet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HP
 */
public class UserViewProfile extends javax.swing.JFrame {

    String userid;
    public UserViewProfile(String uid) {
        initComponents();
        userid=uid;
        eidtf.setEditable(false);
        enametf.setEditable(false);
        phonetf.setEditable(false);
        emailtf.setEditable(false);
        deptnotf.setEditable(false);
        dnametf.setEditable(false);
        setSize(1280,755);
        setResizable(false);
        setLocationRelativeTo(null);
        displayDetails(userid);
    }

    public void displayDetails(String userid){
        try {
            ResultSet rs = DBLoader.executeStatement("select * from employeedetails where eid='"+userid+"'");
            if(rs.next()){
                String ename = rs.getString(2);
                String phone = rs.getString(3);
                String email = rs.getString(4);
                int deptno = rs.getInt(5);
                ResultSet rs1 = DBLoader.executeStatement("select deptname from departments where deptno="+deptno+"");
                if(rs1.next()){
                    String dname = rs1.getString(1);
                    eidtf.setText(userid);
                    enametf.setText(ename);
                    phonetf.setText(phone);
                    emailtf.setText(email);
                    deptnotf.setText(Integer.toString(deptno));
                    dnametf.setText(dname);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dnametf = new javax.swing.JTextField();
        eidtf = new javax.swing.JTextField();
        enametf = new javax.swing.JTextField();
        phonetf = new javax.swing.JTextField();
        emailtf = new javax.swing.JTextField();
        deptnotf = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        backlb = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        getContentPane().add(dnametf);
        dnametf.setBounds(330, 560, 290, 48);
        getContentPane().add(eidtf);
        eidtf.setBounds(310, 70, 300, 50);

        enametf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enametfActionPerformed(evt);
            }
        });
        getContentPane().add(enametf);
        enametf.setBounds(900, 330, 260, 50);
        getContentPane().add(phonetf);
        phonetf.setBounds(320, 310, 290, 50);
        getContentPane().add(emailtf);
        emailtf.setBounds(320, 190, 290, 50);
        getContentPane().add(deptnotf);
        deptnotf.setBounds(330, 430, 290, 50);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/EmployeeViewProfile.jpg"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 0, 1280, 720);

        backlb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backlbMouseClicked(evt);
            }
        });
        getContentPane().add(backlb);
        backlb.setBounds(1130, 660, 150, 60);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void enametfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enametfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_enametfActionPerformed

    private void backlbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backlbMouseClicked
         new UserHome(userid).setVisible(true);
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
            java.util.logging.Logger.getLogger(UserViewProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserViewProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserViewProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserViewProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new UserViewProfile().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel backlb;
    private javax.swing.JTextField deptnotf;
    private javax.swing.JTextField dnametf;
    private javax.swing.JTextField eidtf;
    private javax.swing.JTextField emailtf;
    private javax.swing.JTextField enametf;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField phonetf;
    // End of variables declaration//GEN-END:variables
}
