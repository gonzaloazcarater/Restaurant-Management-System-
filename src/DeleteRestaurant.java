import dao.ConnectionProvider;
import javax.swing.ImageIcon;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author maria
 */
public class DeleteRestaurant extends javax.swing.JFrame {

    /**
     * Creates new form DeleteRestaurant
     */
    public DeleteRestaurant() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtRestaurantName = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("Delete Restaurant");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 30, 360, -1));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 82, 850, 10));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/close.png"))); // NOI18N
        jButton2.setText("close");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 0, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Restaurant Name");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, 107, -1));

        txtRestaurantName.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtRestaurantName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRestaurantNameActionPerformed(evt);
            }
        });
        txtRestaurantName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtRestaurantNameKeyReleased(evt);
            }
        });
        getContentPane().add(txtRestaurantName, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 143, 332, -1));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/save.png"))); // NOI18N
        jButton1.setText("Delete");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 392, -1, -1));

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/search.png"))); // NOI18N
        jButton3.setText("Search");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(471, 142, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/all_pages_background.png"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //close icon
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtRestaurantNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRestaurantNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRestaurantNameActionPerformed

    private void txtRestaurantNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRestaurantNameKeyReleased
    }//GEN-LAST:event_txtRestaurantNameKeyReleased

    // Delete icon
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
String restaurantName = txtRestaurantName.getText().toLowerCase();
        if(restaurantName.equals("")){
            JOptionPane.showMessageDialog(null, "Restaurant name field is required");
        }else{
            try{
                int a = JOptionPane.showConfirmDialog(null,"Do you want to delete this restaurant?","Select",JOptionPane.YES_NO_OPTION);
                if(a==0){
                    Connection con = ConnectionProvider.getCon();
                    PreparedStatement ps2 = con.prepareStatement("delete from OrderRestaurant where RestaurantID = (Select RestaurantID from Restaurant where RestaurantName = ?)");
                    PreparedStatement ps3 = con.prepareStatement("delete from RestaurantMeal where RestaurantID = (Select RestaurantID from Restaurant where RestaurantName = ?)");
                    PreparedStatement ps = con.prepareStatement("delete from Restaurant where RestaurantName=?");
                    ps2.setString(1,restaurantName);
                    ps3.setString(1,restaurantName);
                    ps.setString(1,restaurantName);
                    ps2.executeUpdate();
                    ps3.executeUpdate();
                    ps.executeUpdate();

                    JOptionPane.showMessageDialog(null, "Restaurant deleted successfully");
                    setVisible(false);
                    new DeleteRestaurant().setVisible(true); 
                }
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null,e);
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    //search icon
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int checkRestaurantexist=0;
        String Restaurantname= txtRestaurantName.getText().toLowerCase();
        if(Restaurantname.equals("")){
            JOptionPane.showMessageDialog(null,"RestaurantName field is required");
        }
        else {
            try{
            Connection con=ConnectionProvider.getCon();
            Statement st= con.createStatement();
            ResultSet rs= st.executeQuery("select * from Restaurant where RestaurantName='"+Restaurantname+"'");
                while(rs.next()){
                    txtRestaurantName.setText(rs.getString("RestaurantName"));
                    checkRestaurantexist=1;       
                }
                
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null,e);
            }
            if (checkRestaurantexist==0){
                JOptionPane.showMessageDialog(null,"Restaurant Name does not exists" );
            }else {
                JOptionPane.showMessageDialog(null,"Restaurant Name found" );
            }
            
        }
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(DeleteRestaurant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DeleteRestaurant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DeleteRestaurant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DeleteRestaurant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DeleteRestaurant().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField txtRestaurantName;
    // End of variables declaration//GEN-END:variables
}
