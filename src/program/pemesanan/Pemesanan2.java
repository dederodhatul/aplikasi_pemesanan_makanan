/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package program.pemesanan;

/**
 *
 * @author HP
 */
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public class Pemesanan2 extends javax.swing.JFrame {
Connection Con;
Statement State;

DefaultTableModel tableModel = new DefaultTableModel(new Object [][] {},new String[]{"Jenis Makanan","Qty","Harga","Total Harga"});

    /**
     * Creates new form Pemesanan2
     */
    public Pemesanan2() {
        initComponents();
    }
public void inisialtabel(){
    tb1Pesan.setModel(tableModel);
}
private  void noOrder() throws SQLException{
    try{
        Con = KoneksiDatabase.getKoneksi();
        State = Con.createStatement();
        String sql = "SELECT No_Order FROM headinputan";
        ResultSet rs = State.executeQuery(sql);
        int brs=0;
        while(rs.next()){
            brs = rs.getRow();
        }
        if(brs==0){
            txtorder.setText("1");
        }else{
            int nom=brs+1;
            txtorder.setText(String.valueOf(nom));
        }
        rs.close();
    } catch (SQLException e){
        System.out.println("Error :"+e);
    }
}
public void simpanDatabase() throws SQLException{
    try{
        String order=txtorder.getText();
        String meja=txtmeja.getText();
        String subtotal=txtsubtotal.getText();
        String hsql="INSERT INTO headinputan values ('"+order+"','"+meja+"','"+subtotal+"')";
        State.executeUpdate(hsql);
        for(int i=0;i<tb1Pesan.getRowCount();i++){
            String Jenis_Makanan = (String)tb1Pesan.getValueAt(i,0);
            String Qty=(String)tb1Pesan.getValueAt(i,1);
            String Harga=(String)tb1Pesan.getValueAt(i,2);
            String Total_Harga=(String)tb1Pesan.getValueAt(i,3);
            String isql = "INSERT INTO inputan values ('"+order+"'.'"+Jenis_Makanan+"','"+Qty+"','"+Harga+"','"+Total_Harga+"')";
            State.executeUpdate(isql); 
        }
    } catch (SQLException e){
        System.out.println("Error :"+e);
    }
}
public void hitungBayar(){
    try{
        int hitung=0;
        for(int i=0; i<tb1Pesan.getRowCount(); i++){
            String Total_Harga = (String)tb1Pesan.getValueAt(i,3);
            int iTotal_Harga = Integer.parseInt(Total_Harga);
            hitung = (hitung+iTotal_Harga);
        } txtsubtotal.setText(String.valueOf(hitung));
    } catch (Exception e){
        System.out.println("Error :"+e);
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

        jLabel2 = new javax.swing.JLabel();
        cmbmakanan = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtharga = new javax.swing.JTextField();
        txtmeja = new javax.swing.JTextField();
        txtqty = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtorder = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb1Pesan = new javax.swing.JTable();
        bPesan = new javax.swing.JButton();
        bReset = new javax.swing.JButton();
        bSave = new javax.swing.JButton();
        bClose = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtsubtotal = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtdeskripsi = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Century Schoolbook", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setText("Form Pemesanan");

        cmbmakanan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-List Pilihan-", "Paket A", "Paket B", "Paket C", "Paket D" }));
        cmbmakanan.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbmakananItemStateChanged(evt);
            }
        });
        cmbmakanan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbmakananActionPerformed(evt);
            }
        });

        jLabel1.setText("Jenis Makanan");

        jLabel3.setText("Harga");

        jLabel4.setText("No meja");

        jLabel5.setText("Qty");

        txtharga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txthargaActionPerformed(evt);
            }
        });

        txtmeja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtmejaActionPerformed(evt);
            }
        });

        txtqty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtqtyActionPerformed(evt);
            }
        });

        jLabel6.setText("No Order");

        jLabel7.setText("Deskripsi");

        tb1Pesan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tb1Pesan);

        bPesan.setText("Pesan");
        bPesan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bPesanActionPerformed(evt);
            }
        });

        bReset.setText("Reset");
        bReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bResetActionPerformed(evt);
            }
        });

        bSave.setText("Selesai dan save");
        bSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSaveActionPerformed(evt);
            }
        });

        bClose.setText("Close");
        bClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCloseActionPerformed(evt);
            }
        });

        jLabel8.setText("Total Pembayaran (Rp.)");

        txtdeskripsi.setColumns(20);
        txtdeskripsi.setRows(5);
        jScrollPane2.setViewportView(txtdeskripsi);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(bClose, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(39, 39, 39)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(cmbmakanan, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtharga)
                                        .addComponent(txtqty)
                                        .addComponent(txtmeja, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(60, 60, 60)
                                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(28, 28, 28)
                                            .addComponent(txtorder, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(114, 114, 114)
                                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(232, 232, 232)
                                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 776, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(325, 325, 325)
                            .addComponent(jLabel2))
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(bPesan, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(bReset, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(bSave)
                            .addGap(74, 74, 74)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(txtsubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel2)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cmbmakanan, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtorder, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtharga, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtqty, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtmeja, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bPesan, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bReset, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bSave, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtsubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bClose, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbmakananActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbmakananActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbmakananActionPerformed

    private void txtmejaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtmejaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtmejaActionPerformed

    private void bCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCloseActionPerformed
        // TODO add your handling code here:
        MenuUtama x = new MenuUtama();
        x.show();
        dispose();
    }//GEN-LAST:event_bCloseActionPerformed

    private void bSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSaveActionPerformed
  
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null,"Berhasil Disimpan!");
    try {
        noOrder();
   
        simpanDatabase();
        hitungBayar();
        
        int maxdata = tb1Pesan.getRowCount();
        for(int i=0; i<maxdata; i++){
            String hitung = (String)tb1Pesan.getValueAt(i,3);
            int ihitung=Integer.parseInt(hitung);
        }
        String order=txtorder.getText();
        String total=txtsubtotal.getText();
        String meja=txtmeja.getText();
        
    try {
        String hsql = "INSERT INTO headinputan values"+"('"+order+"','"+meja+"','"+total+"')";
        State.executeUpdate(hsql);
    } catch(SQLException ex){
        System.out.println(("Error :"+ex));
    }
    txtmeja.setText(null);
    for(int i=0; i<tb1Pesan.getRowCount(); i++){
        tb1Pesan.removeAll();
    }
     } catch (SQLException ex) {
        Logger.getLogger(Pemesanan2.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_bSaveActionPerformed

    private void bResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bResetActionPerformed
        // TODO add your handling code here:
   /*     cmbmakanan.setSelectedItem("-List Pilihan-");
        txtharga.setText(null);
        txtmeja.setText(null);
        txtqty.setText(null);
        txtdeskripsi.setText(null);
        txtsubtotal.setText(null);
    }//GEN-LAST:event_bResetActionPerformed
*/ try{
    String hsql = "DELETE FROM inputan";
    java.sql.Connection con =(Connection) KoneksiDatabase.getKoneksi();
    java.sql.PreparedStatement pstm = con.prepareStatement(hsql);
       pstm.execute();
       JOptionPane.showMessageDialog(null,"PESANAN DIHAPUS");
}catch (Exception e){
    System.out.println("ERROR :"+e);
}
    }
    private void bPesanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bPesanActionPerformed
        // TODO add your handling code here:
        if(txtdeskripsi.getText().isEmpty() || txtmeja.getText().isEmpty() || txtqty.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Data belum lengkap!");
        }else{
            int v=0;
            v=JOptionPane.showConfirmDialog(null,"Anda sudah yakin dengan pesanan anda?","Warning",JOptionPane.YES_NO_OPTION);
            if(v==JOptionPane.YES_OPTION){
                try{
                    String Jenis_Makanan = cmbmakanan.getSelectedItem().toString();
                    String Qty = txtqty.getText();
                    String Harga = txtharga.getText();
                    int iqty = Integer.parseInt(Qty);
                    int iharga = Integer.parseInt(Harga);
                    int itotal = (iqty*iharga);
                    String Total_Harga = String.valueOf(itotal);
                    tableModel.addRow(new Object[]{Jenis_Makanan,Qty,Harga,Total_Harga});
                    inisialtabel();
                } catch (Exception e){
                    System.out.println("Error :"+e);
                }
            }
            cmbmakanan.setSelectedItem("-List Pilihan-");
            txtharga.setText(null);
            txtqty.setText(null);
            txtdeskripsi.setText(null);
        }
        hitungBayar();
    }//GEN-LAST:event_bPesanActionPerformed

    private void cmbmakananItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbmakananItemStateChanged
        // TODO add your handling code here:
        String pilih = cmbmakanan.getSelectedItem().toString();
        if(pilih.equals("Paket A")){
            txtdeskripsi.setText("====Terdiri dari==="+"\n"+"Nasi"+"\n"+"Ayam Bakar"+"\n"+"Jus alpukat");
            int harga = 20000;
            txtharga.setText(String.valueOf(harga));
        } 
        else if (pilih.equals("Paket B")){
            txtdeskripsi.setText("====Terdiri dari==="+"\n"+"Nasi"+"\n"+"Iga Bakar"+"\n"+"Es Campur");
            int harga = 25000;
        }
        else if(pilih.equals("Paket C")){
            txtdeskripsi.setText("====Terdiri dari==="+"\n"+"Nasi"+"\n"+"Ikan Bakar"+"\n"+"Es jeruk");
            int harga = 15000;
            txtharga.setText(String.valueOf(harga));
        }
        else if (pilih.equals("Paket D")){
            txtdeskripsi.setText("====Terdiri dari==="+"\n"+"Nasi Goreng"+"\n"+"Es Teh Manis");
            int harga = 10000;
            txtharga.setText(String.valueOf(harga));
        }
        else{
            txtdeskripsi.setText(null);
        }
    }//GEN-LAST:event_cmbmakananItemStateChanged

    private void txthargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txthargaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txthargaActionPerformed

    private void txtqtyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtqtyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtqtyActionPerformed

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
            java.util.logging.Logger.getLogger(Pemesanan2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pemesanan2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pemesanan2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pemesanan2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pemesanan2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bClose;
    private javax.swing.JButton bPesan;
    private javax.swing.JButton bReset;
    private javax.swing.JButton bSave;
    private javax.swing.JComboBox<String> cmbmakanan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tb1Pesan;
    private javax.swing.JTextArea txtdeskripsi;
    private javax.swing.JTextField txtharga;
    private javax.swing.JTextField txtmeja;
    private javax.swing.JTextField txtorder;
    private javax.swing.JTextField txtqty;
    private javax.swing.JTextField txtsubtotal;
    // End of variables declaration//GEN-END:variables

private void x(String valueOf){
throw new UnsupportedOperationException("Not Yet Implemented");
}
}