
import java.sql.ResultSet;
import java.time.LocalDate;
import javax.swing.JOptionPane;


public class WriteResponse extends javax.swing.JFrame {

    String gcid, gcdate, gladate, gst, giss,status,empid,uid;
    public WriteResponse(String cid, String eid, String cdate, String ladate, String status, String iss, String username) {
        initComponents();
        statuscb.removeAllItems();
        gcid=cid;
        gcdate=cdate;
        gladate=ladate;
        gst=status;
        giss=iss;
        empid=eid;
        uid = username;
        cidtf.setEditable(false);
        cldtf.setEditable(false);
        cstf.setEditable(false);
        laptf.setEditable(false);
        issuetf.setEditable(false);
        displayDetails();
        getstatus();
        setSize(1280,755);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    public void writeResponse(){
        String res = responseta.getText();
        LocalDate datenow = LocalDate.now();
        String date = datenow.toString();
        try {
            ResultSet rs = DBLoader.executeStatement("select * from responses");
            rs.moveToInsertRow();
            rs.updateString("cid", gcid);
            rs.updateString("eid", empid);
            rs.updateString("issue", giss);
            rs.updateString("response",res);
            rs.updateString("rdate", date);
            rs.updateString("status", status);
            rs.insertRow();
            ResultSet rs1 = DBLoader.executeStatement("select * from ncomplaints where cid='"+gcid+"'");
            if(rs1.next()){
                rs1.updateString("status", status);
                rs1.updateString("lad", date);
                rs1.updateRow();
                JOptionPane.showMessageDialog(this, "Response recorded successfully");
                this.dispose();
                new ViewComplaints("","",uid).setVisible(true);
            }
        } catch (Exception e) {
        }
    }
     public void displayDetails(){
        cidtf.setText(gcid);
        cldtf.setText(gcdate);
        cstf.setText(gst);
        laptf.setText(gladate);
        issuetf.setText(giss);
     }
     
    public void getstatus(){
        try {
            ResultSet rs = DBLoader.executeStatement("select * from status");
            while(rs.next()){
                String status = rs.getString(1);
                statuscb.addItem(status);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        responseta = new javax.swing.JTextArea();
        statuscb = new javax.swing.JComboBox<>();
        issuetf = new javax.swing.JTextField();
        cidtf = new javax.swing.JTextField();
        cldtf = new javax.swing.JTextField();
        laptf = new javax.swing.JTextField();
        cstf = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        backlb = new javax.swing.JLabel();
        responselb = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        responseta.setColumns(20);
        responseta.setRows(5);
        jScrollPane1.setViewportView(responseta);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(70, 290, 730, 360);

        statuscb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        statuscb.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                statuscbItemStateChanged(evt);
            }
        });
        getContentPane().add(statuscb);
        statuscb.setBounds(900, 370, 280, 40);
        getContentPane().add(issuetf);
        issuetf.setBounds(900, 500, 280, 40);

        cidtf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cidtfActionPerformed(evt);
            }
        });
        getContentPane().add(cidtf);
        cidtf.setBounds(270, 50, 250, 40);

        cldtf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cldtfActionPerformed(evt);
            }
        });
        getContentPane().add(cldtf);
        cldtf.setBounds(350, 150, 250, 40);
        getContentPane().add(laptf);
        laptf.setBounds(960, 50, 250, 40);
        getContentPane().add(cstf);
        cstf.setBounds(960, 130, 250, 40);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/HRResponse.jpg"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 0, 1280, 720);

        backlb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backlbMouseClicked(evt);
            }
        });
        getContentPane().add(backlb);
        backlb.setBounds(1140, 680, 130, 30);

        responselb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                responselbMouseClicked(evt);
            }
        });
        getContentPane().add(responselb);
        responselb.setBounds(940, 550, 190, 50);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void statuscbItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_statuscbItemStateChanged
        status = evt.getItem().toString();
    }//GEN-LAST:event_statuscbItemStateChanged

    private void cidtfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cidtfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cidtfActionPerformed

    private void cldtfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cldtfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cldtfActionPerformed

    private void backlbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backlbMouseClicked
        this.dispose();
        new ViewComplaints(giss,gst,uid).setVisible(true);
    }//GEN-LAST:event_backlbMouseClicked

    private void responselbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_responselbMouseClicked
       writeResponse();
    }//GEN-LAST:event_responselbMouseClicked

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
            java.util.logging.Logger.getLogger(WriteResponse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(WriteResponse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(WriteResponse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(WriteResponse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new WriteResponse().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel backlb;
    private javax.swing.JTextField cidtf;
    private javax.swing.JTextField cldtf;
    private javax.swing.JTextField cstf;
    private javax.swing.JTextField issuetf;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField laptf;
    private javax.swing.JLabel responselb;
    private javax.swing.JTextArea responseta;
    private javax.swing.JComboBox<String> statuscb;
    // End of variables declaration//GEN-END:variables
}
