/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HP
 */
public class ViewDetailsResponse extends javax.swing.JFrame {

    String gcid, gissue, gstatus, gresponse, grdate, gcdate, geid;
    public ViewDetailsResponse(String cid, String issue, String status, String response, String rdate, String cdate, String eid) {
        initComponents();
        gcid=cid;
        gissue=issue;
        gstatus=status;
        gresponse=response;
        grdate=rdate;
        gcdate=cdate;
        geid=eid;
        cidtf.setEditable(false);
        issuetf.setEditable(false);
        statustf.setEditable(false);
        respta.setEditable(false);
        cldtf.setEditable(false);
        rdatetf.setEditable(false);
        setSize(1280,755);
        setResizable(false);
        setLocationRelativeTo(null);
        displayDetails();
    }

    public void displayDetails(){
        cidtf.setText(gcid);
        issuetf.setText(gissue);
        statustf.setText(gstatus);
        respta.setText(gresponse);
        cldtf.setText(gcdate);
        rdatetf.setText(grdate);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rdatetf = new javax.swing.JTextField();
        cidtf = new javax.swing.JTextField();
        statustf = new javax.swing.JTextField();
        issuetf = new javax.swing.JTextField();
        cldtf = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        respta = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        backlb = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        getContentPane().add(rdatetf);
        rdatetf.setBounds(950, 530, 270, 60);
        getContentPane().add(cidtf);
        cidtf.setBounds(930, 40, 270, 60);
        getContentPane().add(statustf);
        statustf.setBounds(930, 130, 270, 60);
        getContentPane().add(issuetf);
        issuetf.setBounds(950, 300, 270, 60);
        getContentPane().add(cldtf);
        cldtf.setBounds(950, 420, 270, 60);

        respta.setColumns(20);
        respta.setRows(5);
        jScrollPane1.setViewportView(respta);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(20, 20, 590, 590);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ViewDetailsResponse.jpg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1280, 720);

        backlb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backlbMouseClicked(evt);
            }
        });
        getContentPane().add(backlb);
        backlb.setBounds(420, 640, 200, 60);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backlbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backlbMouseClicked
        new UserTrackResponse(geid).setVisible(true);
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
            java.util.logging.Logger.getLogger(ViewDetailsResponse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewDetailsResponse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewDetailsResponse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewDetailsResponse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new ViewDetailsResponse().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel backlb;
    private javax.swing.JTextField cidtf;
    private javax.swing.JTextField cldtf;
    private javax.swing.JTextField issuetf;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField rdatetf;
    private javax.swing.JTextArea respta;
    private javax.swing.JTextField statustf;
    // End of variables declaration//GEN-END:variables
}
