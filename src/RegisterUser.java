
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
public class RegisterUser extends javax.swing.JFrame {

    /**
     * Creates new form RegisterUser
     */
    public String emailPattern = "^[a-zA-Z0-9]+[@]+[a-zA-Z0-9]+[.]+[a-zA-Z0-9]+$";
    public String mobilePattern = "^[0-9]*$";
    public int checkUsername = 0;
    
    
    public RegisterUser() {
        initComponents();
        iconLabelRU.setVisible(false);
        setLocationRelativeTo(null);
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
        txtName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtSurname = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtMobileNumber = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        iconLabelRU = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("Register User");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(265, 32, 320, -1));
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
        jLabel2.setText("Name");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, 107, -1));

        txtName.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
            }
        });
        txtName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNameKeyReleased(evt);
            }
        });
        getContentPane().add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 143, 332, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Surname");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 190, 124, -1));

        txtSurname.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(txtSurname, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 223, 332, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Phone Number");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 280, 180, 16));

        txtMobileNumber.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(txtMobileNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 320, 332, -1));

        txtEmail.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 140, 332, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Email");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 100, 180, 16));

        txtUsername.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtUsername.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtUsernameKeyReleased(evt);
            }
        });
        getContentPane().add(txtUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 230, 332, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Username");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 190, 180, 16));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Password");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 280, 180, 16));

        txtPassword.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 320, 332, -1));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/save.png"))); // NOI18N
        jButton1.setText("Save");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 400, -1, -1));

        iconLabelRU.setText("jLabel8");
        getContentPane().add(iconLabelRU, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 190, -1, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/all_pages_background.png"))); // NOI18N
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //close icon
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameActionPerformed

    // label para comprobar si el nombre existe o no
    private void txtNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNameKeyReleased
        
    }//GEN-LAST:event_txtNameKeyReleased

    // save icon
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String clientName = txtName.getText();
        String clientSurname = txtSurname.getText();
        String mobileNumber = txtMobileNumber.getText();
        String email = txtEmail.getText();
        String username = txtUsername.getText();
        String password = txtPassword.getText();
        
        if(clientName.equals("")) {
            JOptionPane.showMessageDialog(null, "Name is required");
        } else if(clientSurname.equals("")) {
            JOptionPane.showMessageDialog(null, "Surname is required");
        } else if (mobileNumber.equals("")) {
            JOptionPane.showMessageDialog(null, "Mobile number is required");
        } else if(!mobileNumber.matches(mobilePattern)|| mobileNumber.length() != 10) {
            JOptionPane.showMessageDialog(null, "Mobile number is not valid");            
        } else if (email.equals("")) {
            JOptionPane.showMessageDialog(null, "Email is required");                        
        } else if (!email.matches(emailPattern)) {
            JOptionPane.showMessageDialog(null, "Email not valid");                                    
        } else if (username.equals("")) {
             JOptionPane.showMessageDialog(null, "Username is required");                                               
        } else if (checkUsername == 1) {
            JOptionPane.showMessageDialog(null, "Username already exists");
        } else if (password.equals("")) {
             JOptionPane.showMessageDialog(null, "Password is required");                                               
        } else {
            try{
                Connection con = ConnectionProvider.getCon();
                PreparedStatement ps = con.prepareStatement("INSERT INTO AppUser(Username, UserPassword, UserRole) VALUES (?,?,?)");
                ps.setString(1, username);
                ps.setString(2, password);
                ps.setString(3, "client");
                ps.executeUpdate();
                
                PreparedStatement ps2 = con.prepareStatement("INSERT INTO Client(ClientName, ClientSurname, ClientPhoneNo, ClientEmail, ClientUsername, ClientPassword) VALUES (?,?,?,?,?,?)");
                ps2.setString(1, clientName);
                ps2.setString(2, clientSurname);
                ps2.setString(3, mobileNumber);
                ps2.setString(4, email);
                ps2.setString(5, username);
                ps2.setString(6, password);
                ps2.executeUpdate();
                
                JOptionPane.showMessageDialog(null, "User created succesfully");
                setVisible(false);
                new RegisterUser().setVisible(true);
             
            }
            catch(Exception e) {
             JOptionPane.showMessageDialog(null, e);                                               
               
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    // username check si existe o no
    private void txtUsernameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsernameKeyReleased
        String username = txtUsername.getText();
        if(!username.equals("")) {
            iconLabelRU.setVisible(true);
            iconLabelRU.setIcon(new ImageIcon("src\\Images\\yes.png"));
            iconLabelRU.setText("");
            checkUsername = 0;
            
            try{
                Connection con = ConnectionProvider.getCon();
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("select * from appUser where Username = '" + username + "'");
                while(rs.next()) {
                    checkUsername = 1;
                    iconLabelRU.setIcon(new ImageIcon("src\\Images\\no.png"));
                    iconLabelRU.setText("");
                }
            }
            catch(Exception e) {
                JOptionPane.showMessageDialog(null,e);
            }
        }
        else {
            iconLabelRU.setVisible(false);
        }
    }//GEN-LAST:event_txtUsernameKeyReleased

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
            java.util.logging.Logger.getLogger(RegisterUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegisterUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegisterUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegisterUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegisterUser().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel iconLabelRU;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtMobileNumber;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextField txtSurname;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}