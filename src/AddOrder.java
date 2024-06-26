
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
import dao.ConnectionProvider;
import javax.swing.ImageIcon;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
/**
 *
 * @author maria
 */
public class AddOrder extends javax.swing.JFrame {
    private String username = "";
    private int restaurantID;
    private String Restaurantname;
    private boolean orderIDGenerated = false;
    int orderID =0;
    int clientID =1 ;
    /**
     * Creates new form AddOrder
     */
    public AddOrder() {
        initComponents();
    }

    public AddOrder(String tempUsername, String tempRestaurantName) {
        initComponents();
        username = tempUsername;
        Restaurantname =  tempRestaurantName;
        System.out.println(username);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("Add Order");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 40, 210, -1));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 82, 850, 10));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/close.png"))); // NOI18N
        jButton2.setText("close");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(775, 0, -1, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "MealName", "MealDescription", "MealPrice"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jTable1.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jTable1ComponentShown(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, 730, 249));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/all_pages_background.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //close icon
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    
    private void jTable1ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jTable1ComponentShown
     
    }//GEN-LAST:event_jTable1ComponentShown

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int index = jTable1.getSelectedRow();
        TableModel model = jTable1.getModel();
        int mealID = 0;
        int numberofplates = 1;
        String mealName = model.getValueAt(index, 0).toString();
        int a = JOptionPane.showConfirmDialog(null, "Do you want to add this meal?");
        if (a == 0) {
            try {
                Connection con = ConnectionProvider.getCon();
                Statement st = con.createStatement();
                ResultSet rs2 = st.executeQuery("select mealID from Meal where MealName ='" + mealName + "'");
                while (rs2.next()) {
                    mealID = rs2.getInt("MealID");
                    System.out.println(mealID);
                }
                
                ResultSet rs3 = st.executeQuery("select mealID from OrderItems where mealID =" + mealID + " and orderID =" + orderID);

                boolean orderItemExists = rs3.next(); // Verificar si existe el OrderItem

                if (orderItemExists) {
                    // Si ya existe, realizar una actualización
                    numberofplates++;
                    PreparedStatement psUpdateOrderItems = con.prepareStatement("UPDATE OrderItems SET NumberOfPlatesOrder = ? WHERE mealID = ? AND orderID = ?");
                    psUpdateOrderItems.setInt(1, numberofplates);
                    psUpdateOrderItems.setInt(2, mealID);
                    psUpdateOrderItems.setInt(3, orderID);
                    psUpdateOrderItems.executeUpdate();
                } else {
                    // Si no existe, realizar una inserción
                    PreparedStatement psOrderItems = con.prepareStatement("INSERT INTO OrderItems (OrderID, MealID, ClientID, NumberOfPlatesOrder) VALUES (?,?,?,?)");
                    psOrderItems.setInt(1, orderID);
                    psOrderItems.setInt(2, mealID);
                    psOrderItems.setInt(3, clientID);
                    psOrderItems.setInt(4, numberofplates);
                    psOrderItems.executeUpdate();
                }

                // Cerrar rs3 después de usarlo
                rs3.close();

                JOptionPane.showMessageDialog(null, "Meal added successfully");
                setVisible(true);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }

    }//GEN-LAST:event_jTable1MouseClicked

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        String status = "ordered";
        Date orderDate = new Date(System.currentTimeMillis()); // obtén la fecha actual
        try{
            Connection con = ConnectionProvider.getCon();
            Statement st = con.createStatement();
            // Obtener el ID del restaurante
            ResultSet rs4 = st.executeQuery("SELECT RestaurantID FROM Restaurant WHERE RestaurantName = '" + Restaurantname + "'");
            if (rs4.next()) {
                restaurantID = rs4.getInt("RestaurantID");

                // Obtener los datos de RestaurantMeal y Meal mediante JOIN
                ResultSet rs = st.executeQuery("SELECT M.MealName, M.MealDescription, M.MealPrice " +
                                               "FROM RestaurantMeal RM " +
                                               "JOIN Meal M ON RM.MealID = M.MealID " +
                                               "WHERE RM.RestaurantID = " + restaurantID);

                while (rs.next()) {
                    model.addRow(new Object[] { rs.getString("MealName"), rs.getString("MealDescription"), rs.getFloat("MealPrice") });
                }
            }
            if (!orderIDGenerated) {
                    ResultSet rs = st.executeQuery("SELECT MAX(OrderID) AS maxID FROM Orders");
                    if (rs.next()) {
                        orderID = rs.getInt("maxID") + 1;
                    }
                    orderIDGenerated = true; // Marcar que el orderID se ha generado
                }
                System.out.println("OrderID es:" + orderID);
                ResultSet rs1 = st.executeQuery("select ClientId from Client where ClientUsername = '"+username+"'");
                while(rs1.next()){
                    clientID=rs1.getInt("ClientID"); 
                    System.out.println("clientID es:" + clientID);
                    PreparedStatement ps = con.prepareStatement("insert into Orders (OrderID, ClientID, OrderDate, Status) values(?,?,?,?)");
                    ps.setInt(1, orderID);
                    ps.setInt(2, clientID);
                    ps.setDate(3, new java.sql.Date(orderDate.getTime()));
                    ps.setString(4, status);
                    ps.executeUpdate();
                    PreparedStatement ps2 = con.prepareStatement("insert into OrderRestaurant (OrderID, RestaurantID) values(?,?)");
                    ps2.setInt(1, orderID);
                    ps2.setInt(2, restaurantID);
                    ps2.executeUpdate();
                }
            


        } catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_formComponentShown

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
            java.util.logging.Logger.getLogger(AddOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddOrder().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
