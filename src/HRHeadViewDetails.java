
public class HRHeadViewDetails extends javax.swing.JFrame {

    String gcid, geid, gename, gphn, gemail, gdept, giss, gbody, gst, gcdate, gladate;
    public HRHeadViewDetails(String cid, String eid, String ename, String phn, String email, String dept, String iss, String body, String st, String cdate, String ladate) {
        initComponents();
        gcid = cid;
        geid = eid;
        gename = ename;
        gphn = phn;
        gemail = email;
        gdept = dept;
        giss = iss;
        gbody = body;
        gst = st;
        gcdate = cdate;
        gladate = ladate;
        setSize(1280,755);
        cidtf.setEditable(false);
        eidtf.setEditable(false);
        enametf.setEditable(false);
        deptf.setEditable(false);
        contf.setEditable(false);
        etf.setEditable(false);
        cldtf.setEditable(false);
        sttf.setEditable(false);
        laptf.setEditable(false);
        issuetf.setEditable(false);
        issuebodyta.setEditable(false);
        displayDetails();
        setLocationRelativeTo(null);
        setResizable(false);
    }

    public void displayDetails(){
        cidtf.setText(gcid);
        eidtf.setText(geid);
        enametf.setText(gename);
        deptf.setText(gdept);
        contf.setText(gphn);
        etf.setText(gemail);
        cldtf.setText(gcdate);
        sttf.setText(gst);
        laptf.setText(gladate);
        issuetf.setText(giss);
        issuebodyta.setText(gbody);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        issuebodyta = new javax.swing.JTextArea();
        sttf = new javax.swing.JTextField();
        cidtf = new javax.swing.JTextField();
        eidtf = new javax.swing.JTextField();
        enametf = new javax.swing.JTextField();
        issuetf = new javax.swing.JTextField();
        deptf = new javax.swing.JTextField();
        contf = new javax.swing.JTextField();
        etf = new javax.swing.JTextField();
        cldtf = new javax.swing.JTextField();
        laptf = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        backlb = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        issuebodyta.setEditable(false);
        issuebodyta.setColumns(20);
        issuebodyta.setRows(5);
        jScrollPane1.setViewportView(issuebodyta);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(60, 280, 780, 350);
        getContentPane().add(sttf);
        sttf.setBounds(890, 470, 280, 40);

        cidtf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cidtfActionPerformed(evt);
            }
        });
        getContentPane().add(cidtf);
        cidtf.setBounds(250, 50, 190, 40);
        getContentPane().add(eidtf);
        eidtf.setBounds(250, 120, 180, 40);

        enametf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enametfActionPerformed(evt);
            }
        });
        getContentPane().add(enametf);
        enametf.setBounds(890, 360, 280, 40);
        getContentPane().add(issuetf);
        issuetf.setBounds(890, 580, 280, 40);
        getContentPane().add(deptf);
        deptf.setBounds(290, 210, 170, 40);
        getContentPane().add(contf);
        contf.setBounds(650, 50, 170, 40);

        etf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                etfActionPerformed(evt);
            }
        });
        getContentPane().add(etf);
        etf.setBounds(650, 120, 160, 40);
        getContentPane().add(cldtf);
        cldtf.setBounds(1090, 50, 180, 40);
        getContentPane().add(laptf);
        laptf.setBounds(1090, 130, 180, 40);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/HRHeadViewDetails_1.jpg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1280, 720);

        backlb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backlbMouseClicked(evt);
            }
        });
        getContentPane().add(backlb);
        backlb.setBounds(1140, 680, 140, 30);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cidtfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cidtfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cidtfActionPerformed

    private void enametfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enametfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_enametfActionPerformed

    private void etfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_etfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_etfActionPerformed

    private void backlbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backlbMouseClicked
        new HRHeadViewComplaints(giss,gst).setVisible(true);
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
            java.util.logging.Logger.getLogger(ViewDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new ViewDetails().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel backlb;
    private javax.swing.JTextField cidtf;
    private javax.swing.JTextField cldtf;
    private javax.swing.JTextField contf;
    private javax.swing.JTextField deptf;
    private javax.swing.JTextField eidtf;
    private javax.swing.JTextField enametf;
    private javax.swing.JTextField etf;
    private javax.swing.JTextArea issuebodyta;
    private javax.swing.JTextField issuetf;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField laptf;
    private javax.swing.JTextField sttf;
    // End of variables declaration//GEN-END:variables
}
