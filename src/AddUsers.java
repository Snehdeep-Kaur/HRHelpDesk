
import java.sql.ResultSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
public class AddUsers extends javax.swing.JFrame {

    String utype,dept;
    public AddUsers() {
        initComponents();
        setSize(1280,755);
        setLocationRelativeTo(null);
        setResizable(false);
        koecb.removeAllItems();
        deptcb.removeAllItems();
        koecb.addItem("HR");
        koecb.addItem("Normal Employee");
        getdepartments();
    }
    public boolean isValidContact(String str){
        Pattern ptrn = Pattern.compile("(0/91)?[1-9][0-9]{9}");
        Matcher match = ptrn.matcher(str);
        return (match.find()&&match.group().equals(str));
    }
    public void getdepartments(){
        try {
            ResultSet rs = DBLoader.executeStatement("select deptname from departments");
            while(rs.next()){
                String dept = rs.getString(1);
                deptcb.addItem(dept);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void AddUsers(){
        String ename = enametf.getText();
        String contact = contacttf.getText();
        String email = emailtf.getText();
        if(ename.equals("")||contact.equals("")||email.equals("")){
            JOptionPane.showMessageDialog(this, "Please enter all the values");
        }else if((!email.contains("@")||!email.contains("."))||contact.length()>12||isValidContact(contact)){
            JOptionPane.showMessageDialog(this, "Please enter correct values");
        }else{
            if(utype.equals("HR")){
                try {
                    ResultSet rs = DBLoader.executeStatement("select * from hrdetails");
                    ResultSet rs1 = DBLoader.executeStatement("select deptno from departments where deptname='"+dept+"'");
                    int dno=0;
                    if(rs1.next()){
                        dno = rs1.getInt(1);
                    }
                    rs.moveToInsertRow();
                    rs.updateString("hrname", ename);
                    rs.updateString("phone", contact);
                    rs.updateString("email",email);
                    rs.updateInt("deptno", dno);
                    rs.insertRow();
                    ResultSet rs2 = DBLoader.executeStatement("select hrid from hrdetails where hrname='"+ename+"' and phone='"+contact+"' and email='"+email+"' and deptno="+dno+"");
                    int hrid=0;
                    if(rs2.next()){
                        hrid=rs2.getInt(1);
                    }
                    ResultSet rs3 = DBLoader.executeStatement("select * from hrlogin");
                    rs3.moveToInsertRow();
                    rs3.updateInt("hrid", hrid);
                    rs3.updateString("hrname", ename);
                    rs3.insertRow();
                    JOptionPane.showMessageDialog(this,"HR Added successfully");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                
                
            }else{
                try {
                    ResultSet rs = DBLoader.executeStatement("select * from employeedetails");
                    ResultSet rs1 = DBLoader.executeStatement("select deptno from departments where deptname='"+dept+"'");
                    int dno=0;
                    if(rs1.next()){
                        dno = rs1.getInt(1);
                    }
                    rs.moveToInsertRow();
                    rs.updateString("ename", ename);
                    rs.updateString("phone", contact);
                    rs.updateString("email",email);
                    rs.updateInt("deptno", dno);
                    rs.insertRow();
                    ResultSet rs2 = DBLoader.executeStatement("select eid from employeedetails where ename='"+ename+"' and phone='"+contact+"' and email='"+email+"' and deptno="+dno+"");
                    int hrid=0;
                    if(rs2.next()){
                        hrid=rs2.getInt(1);
                    }
                    ResultSet rs3 = DBLoader.executeStatement("select * from userlogin");
                    rs3.moveToInsertRow();
                    rs3.updateInt("userid", hrid);
                    rs3.updateString("username", ename);
                    rs3.insertRow();
                    JOptionPane.showMessageDialog(this,"Employee Added successfully");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        deptcb = new javax.swing.JComboBox<>();
        koecb = new javax.swing.JComboBox<>();
        emailtf = new javax.swing.JTextField();
        enametf = new javax.swing.JTextField();
        contacttf = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        addlb = new javax.swing.JLabel();
        backlb = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        deptcb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        deptcb.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                deptcbItemStateChanged(evt);
            }
        });
        getContentPane().add(deptcb);
        deptcb.setBounds(320, 430, 270, 40);

        koecb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        koecb.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                koecbItemStateChanged(evt);
            }
        });
        getContentPane().add(koecb);
        koecb.setBounds(880, 340, 310, 40);
        getContentPane().add(emailtf);
        emailtf.setBounds(310, 190, 280, 40);
        getContentPane().add(enametf);
        enametf.setBounds(290, 70, 280, 40);
        getContentPane().add(contacttf);
        contacttf.setBounds(310, 310, 280, 40);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddUser.jpg"))); // NOI18N
        getContentPane().add(jLabel6);
        jLabel6.setBounds(0, 0, 1310, 720);

        addlb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addlbMouseClicked(evt);
            }
        });
        getContentPane().add(addlb);
        addlb.setBounds(410, 550, 160, 50);

        backlb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backlbMouseClicked(evt);
            }
        });
        getContentPane().add(backlb);
        backlb.setBounds(1140, 660, 130, 60);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void koecbItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_koecbItemStateChanged
        utype = evt.getItem().toString();
    }//GEN-LAST:event_koecbItemStateChanged

    private void deptcbItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_deptcbItemStateChanged
        dept = evt.getItem().toString();
    }//GEN-LAST:event_deptcbItemStateChanged

    private void backlbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backlbMouseClicked
         new HRHeadHome().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backlbMouseClicked

    private void addlbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addlbMouseClicked
        AddUsers();
    }//GEN-LAST:event_addlbMouseClicked

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
            java.util.logging.Logger.getLogger(AddUsers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddUsers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddUsers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddUsers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddUsers().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel addlb;
    private javax.swing.JLabel backlb;
    private javax.swing.JTextField contacttf;
    private javax.swing.JComboBox<String> deptcb;
    private javax.swing.JTextField emailtf;
    private javax.swing.JTextField enametf;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JComboBox<String> koecb;
    // End of variables declaration//GEN-END:variables
}
