
import java.sql.ResultSet;
import java.util.StringTokenizer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HP
 */
public class UserTrackResponse extends javax.swing.JFrame {

    String empid;
    public UserTrackResponse(String eid) {
        initComponents();
        setSize(1280,750);
        setResizable(false);
        setLocationRelativeTo(null);
        empid =eid;
        getResponses(empid);
    }
    public void getResponses(String eid) {
        try {
            ResultSet rs,rs2;
            rs = DBLoader.executeStatement("select * from responses where eid='"+eid+"'");
            rs2 = DBLoader.executeStatement("select * from hrresponses where eid='"+eid+"'");
            int y = 10;
            while(rs.next()){
                String all="";
                ResponsePanel obj = new ResponsePanel();
                obj.setBounds(10, y, 770, 290);
                vrpnl.add(obj);
                int cid = rs.getInt(2);
                String issue = rs.getString(4);
                String status = rs.getString(5);
                String resp = rs.getString(6);
                String rdate = rs.getString(7);
                ResultSet rs1 = DBLoader.executeStatement("select cdate from ncomplaints where cid="+cid+"");
                String cdate="";
                if(rs1.next()){
                    cdate = rs1.getString(1);
                }

                all=all+"##"+cid+"##"+issue+"##"+status+"##"+resp+"##"+rdate+"##"+cdate+"##"+eid;
                System.out.println(all);
                StringTokenizer stt = new StringTokenizer(all, "##");
                while(stt.hasMoreTokens()){
                    String a = stt.nextToken();
                    String b = stt.nextToken();
                    String c = stt.nextToken();
                    String d = stt.nextToken();
                    String e = stt.nextToken();
                    String f = stt.nextToken();
                    String g = stt.nextToken();
                    obj.setSize(1000,200);
                    obj.isslb.setText("Issue:   " + issue);
                    obj.cdlb.setText("Complaint Date:   " + cdate);
                    obj.stlb.setText("Status:   " + status);
                    obj.vdbtn.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                            UserTrackResponse.this.dispose();
                            new ViewDetailsResponse(a,b,c,d,e,f,g).setVisible(true);
                    }
                });
                }
                
                            
                y = y + 220;
            }
            while(rs2.next()){
                String all="";
                ResponsePanel obj = new ResponsePanel();
                obj.setBounds(10, y, 770, 290);
                vrpnl.add(obj);
                int cid = rs2.getInt(2);
                String issue = rs2.getString(4);
                String status = rs2.getString(5);
                String resp = rs2.getString(6);
                String rdate = rs2.getString(7);
                ResultSet rs1 = DBLoader.executeStatement("select cdate from hrcomplaints where hrcid="+cid+"");
                String cdate="";
                if(rs1.next()){
                    cdate = rs1.getString(1);
                }

                all=all+"##"+cid+"##"+issue+"##"+status+"##"+resp+"##"+rdate+"##"+cdate+"##"+eid;
                System.out.println(all);
                StringTokenizer stt = new StringTokenizer(all, "##");
                while(stt.hasMoreTokens()){
                    String a = stt.nextToken();
                    String b = stt.nextToken();
                    String c = stt.nextToken();
                    String d = stt.nextToken();
                    String e = stt.nextToken();
                    String f = stt.nextToken();
                    String g = stt.nextToken();
                    obj.setSize(1000,200);
                    obj.isslb.setText("Issue:   " + issue);
                    obj.cdlb.setText("Complaint Date:   " + cdate);
                    obj.stlb.setText("Status:   " + status);
                    obj.vdbtn.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                            UserTrackResponse.this.dispose();
                            new ViewDetailsResponse(a,b,c,d,e,f,g).setVisible(true);
                    }
                });
                }
                
                            
                y = y + 220;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        vrpnl = new javax.swing.JPanel();
        backlb = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        javax.swing.GroupLayout vrpnlLayout = new javax.swing.GroupLayout(vrpnl);
        vrpnl.setLayout(vrpnlLayout);
        vrpnlLayout.setHorizontalGroup(
            vrpnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1624, Short.MAX_VALUE)
        );
        vrpnlLayout.setVerticalGroup(
            vrpnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 833, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(vrpnl);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(80, 80, 1120, 560);

        backlb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backlbMouseClicked(evt);
            }
        });
        getContentPane().add(backlb);
        backlb.setBounds(1120, 680, 140, 40);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserTrackResponse.jpg"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 0, 1280, 720);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backlbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backlbMouseClicked
       new UserHome(empid).setVisible(true);
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
            java.util.logging.Logger.getLogger(UserTrackResponse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserTrackResponse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserTrackResponse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserTrackResponse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new UserTrackResponse().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel backlb;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel vrpnl;
    // End of variables declaration//GEN-END:variables
}
