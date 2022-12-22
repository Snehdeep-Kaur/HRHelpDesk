
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
public class DeleteUser extends javax.swing.JFrame {

    String utype;
    public DeleteUser() {
        initComponents();
        setSize(1280,755);
        setLocationRelativeTo(null);
        setResizable(false);
        koecb.removeAllItems();
        koecb.addItem("HR");
        koecb.addItem("Normal Employee");
    }

    public void DeleteUser(){
        String eid = empidtf.getText();
        if(eid.equals("")){
            JOptionPane.showMessageDialog(this, "Please enter ID");
        }else{
            if(utype.equals("HR")){
                try {
                    ResultSet rs = DBLoader.executeStatement("select * from hrlogin where hrid='"+eid+"'");
                    rs.next();
                    rs.deleteRow();
                    ResultSet rs2 = DBLoader.executeStatement("select * from hrdetails where hrid='"+eid+"'");
                    rs2.next();
                    rs2.deleteRow();
                    JOptionPane.showMessageDialog(this, "HR Deleted Successfully");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }else{
                try {
                    ResultSet rs = DBLoader.executeStatement("select * from userlogin where userid='"+eid+"'");
                    rs.next();
                    rs.deleteRow();
                    ResultSet rs2 = DBLoader.executeStatement("select * from employeedetails where eid='"+eid+"'");
                    rs2.next();
                    rs2.deleteRow();
                    
                    JOptionPane.showMessageDialog(this, "Employee Deleted Successfully");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        koecb = new javax.swing.JComboBox<>();
        empidtf = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        deletelb = new javax.swing.JLabel();
        backlb = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        koecb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        koecb.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                koecbItemStateChanged(evt);
            }
        });
        getContentPane().add(koecb);
        koecb.setBounds(150, 400, 360, 40);
        getContentPane().add(empidtf);
        empidtf.setBounds(270, 510, 280, 40);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/DeleteUser.jpg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1280, 720);

        deletelb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deletelbMouseClicked(evt);
            }
        });
        getContentPane().add(deletelb);
        deletelb.setBounds(210, 600, 220, 50);

        backlb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backlbMouseClicked(evt);
            }
        });
        getContentPane().add(backlb);
        backlb.setBounds(1110, 680, 160, 30);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void koecbItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_koecbItemStateChanged
        utype = evt.getItem().toString();
    }//GEN-LAST:event_koecbItemStateChanged

    private void backlbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backlbMouseClicked
        new HRHeadHome().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backlbMouseClicked

    private void deletelbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deletelbMouseClicked
        DeleteUser();
    }//GEN-LAST:event_deletelbMouseClicked

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
            java.util.logging.Logger.getLogger(DeleteUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DeleteUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DeleteUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DeleteUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DeleteUser().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel backlb;
    private javax.swing.JLabel deletelb;
    private javax.swing.JTextField empidtf;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JComboBox<String> koecb;
    // End of variables declaration//GEN-END:variables
}
