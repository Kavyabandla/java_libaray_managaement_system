/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package JFrame;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Kavya
 */
public class ViewAllRecord extends javax.swing.JFrame {

    /**
     * Creates new form ViewAllRecord
     */
    DefaultTableModel model;
    public ViewAllRecord() {
        initComponents();
        setIssueBookDetails();
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width/2-getWidth()/2,size.height/2-getHeight()/2);
    }

   public void setIssueBookDetails()
    {

        try{
           Class.forName("com.mysql.cj.jdbc.Driver");
           Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_ms","root","root");
           Statement st = con.createStatement();
           ResultSet rs = st.executeQuery("select * from issue_book_details");
         
           while(rs.next()){
               String id = rs.getString("id");
               String bookName = rs.getString("book_name");
               String studentName = rs.getString("Name");
               String issueDate = rs.getString("issue_date");
               String dueDate = rs.getString("due_date");
               String status = rs.getString("status");
               
               Object[] obj = {id,bookName,studentName,issueDate,dueDate,status};
               model = (DefaultTableModel)tbl_issueBookDetails.getModel();
               model.addRow(obj);
           }
         }
       catch(Exception e){
           e.printStackTrace();
       }
    }
   
   public void clearTable(){
        DefaultTableModel model = (DefaultTableModel)tbl_issueBookDetails.getModel();
        model.setRowCount(0);
    }

    
public void search () {
Date ufromDate = date_fromDate.getDatoFecha(); 
Date utoDate = lbl_toDate.getDatoFecha(); 
         long l1  = ufromDate.getTime();
         long l2 = utoDate.getTime();
java.sql.Date fromDate = new java.sql.Date (11); 
java.sql.Date toDate = new java.sql.Date(12);
try {
Connection con = DBConnection.getConnection();
String sql = "select * from issue_book_details where issue_date BETWEEN ? and ?";
PreparedStatement pst = con.prepareStatement(sql);
pst.setDate(1,fromDate);
pst.setDate(2,toDate);
ResultSet rs = pst.executeQuery();
if(rs.next()== false){
    JOptionPane.showMessageDialog(this,"No record found");
}
else{
while(rs.next()){
    String id = rs.getString("id");
               String bookName = rs.getString("book_name");
               String studentName = rs.getString("Name");
               String issueDate = rs.getString("issue_date");
               String dueDate = rs.getString("due_date");
               String status = rs.getString("status");
               
               Object[] obj = {id,bookName,studentName,issueDate,dueDate,status};
               model = (DefaultTableModel)tbl_issueBookDetails.getModel();
               model.addRow(obj);
}
} 
}
catch(Exception e){
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

        jPanel2 = new javax.swing.JPanel();
        jPanel27 = new javax.swing.JPanel();
        jLabel78 = new javax.swing.JLabel();
        date_fromDate = new rojeru_san.componentes.RSDateChooser();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        lbl_toDate = new rojeru_san.componentes.RSDateChooser();
        rSMaterialButtonCircle1 = new necesario.RSMaterialButtonCircle();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        rSMaterialButtonCircle2 = new necesario.RSMaterialButtonCircle();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_issueBookDetails = new rojeru_san.complementos.RSTableMetro();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(102, 102, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel27.setBackground(new java.awt.Color(255, 255, 255));
        jPanel27.setPreferredSize(new java.awt.Dimension(284, 5));

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 170, -1, -1));

        jLabel78.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 25)); // NOI18N
        jLabel78.setForeground(new java.awt.Color(255, 255, 255));
        jLabel78.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Literature_100px_1.png"))); // NOI18N
        jLabel78.setText("viewAllDetails ");
        jPanel2.add(jLabel78, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 50, -1, -1));

        date_fromDate.setColorBackground(new java.awt.Color(255, 51, 51));
        date_fromDate.setColorButtonHover(new java.awt.Color(255, 51, 51));
        date_fromDate.setColorDiaActual(new java.awt.Color(255, 51, 51));
        date_fromDate.setColorForeground(new java.awt.Color(255, 51, 51));
        jPanel2.add(date_fromDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 210, -1, -1));

        jLabel13.setBackground(new java.awt.Color(51, 51, 255));
        jLabel13.setFont(new java.awt.Font("Quicksand", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 51, 51));
        jLabel13.setText("Issue Date");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 220, 80, 30));

        jLabel14.setBackground(new java.awt.Color(51, 51, 255));
        jLabel14.setFont(new java.awt.Font("Quicksand", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 51, 51));
        jLabel14.setText("Issue Date");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 220, 80, 30));

        lbl_toDate.setColorBackground(new java.awt.Color(255, 51, 51));
        lbl_toDate.setColorButtonHover(new java.awt.Color(255, 51, 51));
        lbl_toDate.setColorDiaActual(new java.awt.Color(255, 51, 51));
        lbl_toDate.setColorForeground(new java.awt.Color(255, 51, 51));
        jPanel2.add(lbl_toDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 210, -1, -1));

        rSMaterialButtonCircle1.setText("SEARCH");
        rSMaterialButtonCircle1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle1ActionPerformed(evt);
            }
        });
        jPanel2.add(rSMaterialButtonCircle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 110, 160, 60));

        jLabel2.setBackground(new java.awt.Color(255, 0, 51));
        jLabel2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        jLabel2.setText("     X");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1610, 0, 80, 40));

        jPanel4.setBackground(new java.awt.Color(102, 102, 255));
        jPanel4.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.setToolTipText("");

        jLabel4.setBackground(new java.awt.Color(102, 102, 255));
        jLabel4.setFont(new java.awt.Font("Javanese Text", 2, 21)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("  X");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 12, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1400, 0, -1, -1));

        jPanel1.setBackground(new java.awt.Color(255, 51, 51));

        jLabel1.setFont(new java.awt.Font("Ubuntu Mono", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Rewind_48px.png"))); // NOI18N
        jLabel1.setText("Back");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 13, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        rSMaterialButtonCircle2.setText("ALL");
        rSMaterialButtonCircle2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle2ActionPerformed(evt);
            }
        });
        jPanel2.add(rSMaterialButtonCircle2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1340, 110, 120, 60));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1480, 280));

        tbl_issueBookDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Book Name", "Student Name", "Issue Date", "Due Date", "Status"
            }
        ));
        tbl_issueBookDetails.setColorBackgoundHead(new java.awt.Color(102, 102, 255));
        tbl_issueBookDetails.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        tbl_issueBookDetails.setColorSelBackgound(new java.awt.Color(255, 51, 51));
        tbl_issueBookDetails.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 25)); // NOI18N
        tbl_issueBookDetails.setFuenteFilas(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        tbl_issueBookDetails.setFuenteFilasSelect(new java.awt.Font("Yu Gothic UI Semibold", 1, 20)); // NOI18N
        tbl_issueBookDetails.setRowHeight(40);
        tbl_issueBookDetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_issueBookDetailsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_issueBookDetails);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(378, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 830, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(272, 272, 272))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(128, 128, 128)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(129, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 1480, 550));

        setSize(new java.awt.Dimension(1481, 830));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void rSMaterialButtonCircle1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle1ActionPerformed
if(date_fromDate.getDatoFecha()!= null && lbl_toDate.getDatoFecha()!= null){
     clearTable();
        search();
     }   
else{
     JOptionPane.showMessageDialog(this,"Please enter the date");
}
       
    }//GEN-LAST:event_rSMaterialButtonCircle1ActionPerformed

    private void tbl_issueBookDetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_issueBookDetailsMouseClicked
        
    }//GEN-LAST:event_tbl_issueBookDetailsMouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked

    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        HomePage home = new HomePage();
        home.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void rSMaterialButtonCircle2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle2ActionPerformed
        clearTable();
        setIssueBookDetails();
    }//GEN-LAST:event_rSMaterialButtonCircle2ActionPerformed

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
            java.util.logging.Logger.getLogger(ViewAllRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewAllRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewAllRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewAllRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewAllRecord().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.componentes.RSDateChooser date_fromDate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private rojeru_san.componentes.RSDateChooser lbl_toDate;
    private necesario.RSMaterialButtonCircle rSMaterialButtonCircle1;
    private necesario.RSMaterialButtonCircle rSMaterialButtonCircle2;
    private rojeru_san.complementos.RSTableMetro tbl_issueBookDetails;
    // End of variables declaration//GEN-END:variables

    

    
}