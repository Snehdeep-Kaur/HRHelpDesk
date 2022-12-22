
import java.sql.ResultSet;
import java.time.LocalDate;
import javax.swing.JOptionPane;


public class CheckOnHrWR extends javax.swing.JFrame {

    String gcid, gcdate, gladate, gst, giss,status,empid;
    public CheckOnHrWR(String cid, String eid, String cdate, String ladate, String status, String iss) {
        initComponents();
        statuscb.removeAllItems();
        gcid=cid;
        gcdate=cdate;
        gladate=ladate;
        gst=status;
        giss=iss;
        empid=eid;
        cidtf.setEditable(false);
        cldtf.setEditable(false);
        cstf.setEditable(false);
        laptf.setEditable(false);
        issuetf.setEditable(false);
        displayDetails();
        getstatus();
        setSize(1280,755);
    }

    public void writeResponse(){
        String res = responseta.getText();
        LocalDate datenow = LocalDate.now();
        String date = datenow.toString();
        try {
            ResultSet rs = DBLoader.executeStatement("select * from hrresponses");
            rs.moveToInsertRow();
            rs.updateString("hrcid", gcid);
            rs.updateString("eid", empid);
            rs.updateString("issue", giss);
            rs.updateString("response",res);
            rs.updateString("rdate", date);
            rs.updateString("status", status);
            rs.insertRow();
            ResultSet rs1 = DBLoader.executeStatement("select * from hrcomplaints where hrcid='"+gcid+"'");
            if(rs1.next()){
                rs1.updateString("status", status);
                rs1.updateString("ladate", date);
                rs1.updateRow();
                JOptionPane.showMessageDialog(this, "Response recorded successfully");
                this.dispose();
                new CheckOnHr("","").setVisible(true);
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
        resposnelb = new javax.swing.JLabel();

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
        statuscb.setBounds(910, 360, 260, 40);
        getContentPane().add(issuetf);
        issuetf.setBounds(910, 500, 250, 40);

        cidtf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cidtfActionPerformed(evt);
            }
        });
        getContentPane().add(cidtf);
        cidtf.setBounds(280, 50, 250, 40);

        cldtf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cldtfActionPerformed(evt);
            }
        });
        getContentPane().add(cldtf);
        cldtf.setBounds(350, 130, 250, 40);
        getContentPane().add(laptf);
        laptf.setBounds(940, 50, 250, 40);
        getContentPane().add(cstf);
        cstf.setBounds(860, 130, 250, 40);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CheckOnHrRespond.jpg"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 0, 1280, 720);

        backlb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backlbMouseClicked(evt);
            }
        });
        getContentPane().add(backlb);
        backlb.setBounds(1140, 680, 130, 40);

        resposnelb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                resposnelbMouseClicked(evt);
            }
        });
        getContentPane().add(resposnelb);
        resposnelb.setBounds(960, 570, 150, 30);

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

    private void resposnelbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resposnelbMouseClicked
        writeResponse();
    }//GEN-LAST:event_resposnelbMouseClicked

    private void backlbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backlbMouseClicked
        this.dispose();
        new CheckOnHr(giss,gst).setVisible(true);
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
    private javax.swing.JTextArea responseta;
    private javax.swing.JLabel resposnelb;
    private javax.swing.JComboBox<String> statuscb;
    // End of variables declaration//GEN-END:variables
}
