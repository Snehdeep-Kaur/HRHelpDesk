
import java.sql.ResultSet;
import java.time.LocalDate;
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
public class WriteComplaint extends javax.swing.JFrame {

    String types,issue,userid;
    public WriteComplaint(String uid) {
        
        initComponents();
        setSize(1280,755);
        setResizable(false);
        setLocationRelativeTo(null);
        userid=uid;
        eidtf.setText(userid);
        typecb.removeAllItems();
        issuecb.removeAllItems();
        typecb.addItem("Normal Complaint");
        typecb.addItem("Complaint against HR");
        eidtf.setEditable(false);
    }
    public void getissues(){
        try {
            ResultSet rs = DBLoader.executeStatement("select * from issues");
            while(rs.next()){
                String issue = rs.getString(1);
                issuecb.addItem(issue);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void gethrissues(){
        try {
            ResultSet rs = DBLoader.executeStatement("select * from hrissues");
            while(rs.next()){
                String issue = rs.getString(1);
                issuecb.addItem(issue);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void writeComplaint(){
        String body = issuebody.getText();
        LocalDate datenow = LocalDate.now();
        String date = datenow.toString();
        int deptno=0;
        try {
            String dname="";
            ResultSet rs1 = DBLoader.executeStatement("select deptno from employeedetails where eid='"+userid+"'");
            if(rs1.next()){
                int dno = rs1.getInt(1);
                deptno=dno;
                ResultSet rs2 = DBLoader.executeStatement("select deptname from departments where deptno="+dno+"");
                if(rs2.next()){
                    dname=rs2.getString(1);
                }
            }
            if(types.equals("Normal Complaint")){
                ResultSet rs = DBLoader.executeStatement("select * from ncomplaints");
                rs.moveToInsertRow();
                rs.updateString("eid", userid);
                rs.updateInt("deptno", deptno);
                rs.updateString("issue", issue);
                rs.updateString("body", body);
                rs.updateString("cdate", date);
                rs.insertRow();
                JOptionPane.showMessageDialog(this, "Complaint lodged successfully");
                new UserHome(userid).setVisible(true);
                this.dispose();
            }else{
                ResultSet rs = DBLoader.executeStatement("select * from hrcomplaints");
                rs.moveToInsertRow();
                rs.updateString("eid", userid);
                rs.updateInt("deptno", deptno);
                rs.updateString("issue", issue);
                rs.updateString("issuebody", body);
                rs.updateString("cdate", date);
                rs.insertRow();
                JOptionPane.showMessageDialog(this, "Complaint lodged successfully");
                new UserHome(userid).setVisible(true);
                this.dispose();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        eidtf = new javax.swing.JTextField();
        typecb = new javax.swing.JComboBox<>();
        issuecb = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        issuebody = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        submitlb = new javax.swing.JLabel();
        backlb = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        eidtf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eidtfActionPerformed(evt);
            }
        });
        getContentPane().add(eidtf);
        eidtf.setBounds(940, 90, 290, 60);

        typecb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        typecb.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                typecbItemStateChanged(evt);
            }
        });
        getContentPane().add(typecb);
        typecb.setBounds(760, 300, 370, 50);

        issuecb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        issuecb.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                issuecbItemStateChanged(evt);
            }
        });
        getContentPane().add(issuecb);
        issuecb.setBounds(760, 420, 370, 50);

        issuebody.setColumns(20);
        issuebody.setRows(5);
        jScrollPane1.setViewportView(issuebody);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(30, 80, 570, 530);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FileComplaint.jpg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1280, 720);

        submitlb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                submitlbMouseClicked(evt);
            }
        });
        getContentPane().add(submitlb);
        submitlb.setBounds(860, 560, 160, 40);

        backlb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backlbMouseClicked(evt);
            }
        });
        getContentPane().add(backlb);
        backlb.setBounds(440, 640, 150, 50);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void typecbItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_typecbItemStateChanged
        types = evt.getItem().toString();
        if(types.equals("Normal Complaint")){
            issuecb.removeAllItems();
            getissues();
        }else{
            issuecb.removeAllItems();
            gethrissues();
        }
    }//GEN-LAST:event_typecbItemStateChanged

    private void issuecbItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_issuecbItemStateChanged
        issue = evt.getItem().toString();
    }//GEN-LAST:event_issuecbItemStateChanged

    private void eidtfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eidtfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_eidtfActionPerformed

    private void backlbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backlbMouseClicked
       new UserHome(userid).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backlbMouseClicked

    private void submitlbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_submitlbMouseClicked
       writeComplaint();
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
            java.util.logging.Logger.getLogger(WriteComplaint.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(WriteComplaint.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(WriteComplaint.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(WriteComplaint.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new WriteComplaint().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel backlb;
    private javax.swing.JTextField eidtf;
    private javax.swing.JTextArea issuebody;
    private javax.swing.JComboBox<String> issuecb;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel submitlb;
    private javax.swing.JComboBox<String> typecb;
    // End of variables declaration//GEN-END:variables
}
