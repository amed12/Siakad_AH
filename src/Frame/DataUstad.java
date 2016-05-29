/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * DataGuru.java
 *
 * Created on Feb 5, 2014, 3:09:02 PM
 */

package Frame;

import Connection.HasilKeluaranTabel;
import Connection.Koneksi_DB;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.print.PrinterException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author USER
 */
public class DataUstad extends javax.swing.JFrame {

    /** Creates new form DataGuru */
    public DataUstad() {
        initComponents();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = getSize();
        setLocation(
        (screenSize.width - frameSize.width) / 2,
        (screenSize.height - frameSize.height) / 2);
        try
        {
            int kodee = 0;

            Koneksi_DB objkoneksi = new Koneksi_DB();
            Connection con =objkoneksi.bukakoneksi();
            Statement st = con.createStatement();
            String SQL = "select kode from enabled";
            ResultSet RS=st.executeQuery(SQL);
            while(RS.next())
                {
                    kodee=RS.getInt(1);
                }
           if (kodee==2)
                {
                    edit.setEnabled(false);
                    hapus.setEnabled(false);
                }
          else if(kodee==5)
                {
                    simpan.setEnabled(false);
                    edit.setEnabled(false);
                }
          else if(kodee==8)
                {
                    simpan.setEnabled(false);
                    hapus.setEnabled(false);
                }
        }
        catch (SQLException e){}
        bersih();
    }

    void bersih()
    {
        kode.setText("");
        //nip.setText("");
        nama.setText("");
        alamat.setText("");
        telp.setText("");
        jenis.setSelectedIndex(0);
        kode.setEditable(true);
    }

    void simpan()
    {
        int pilih = 0;
        if (jenis.getSelectedItem().equals("Satu Awaliyah")){
            pilih = 1;
        } else if (jenis.getSelectedItem().equals("Dua Awaliyah")){
            pilih = 2;
        } else if (jenis.getSelectedItem().equals("Satu Wustho")){
            pilih = 3;
        }else if (jenis.getSelectedItem().equals("Dua Wustho")){
            pilih = 4;
        }else if (jenis.getSelectedItem().equals("Satu Ulya")){
            pilih = 5;
        } else if (jenis.getSelectedItem().equals("Dua Ulya")){
          pilih = 6;
    }
         try {
            Koneksi_DB objkoneksi = new Koneksi_DB();
            Connection con =objkoneksi.bukakoneksi();
            Statement st = con.createStatement();
            
            //INSERT INTO `Akademik`.`guru` (`KodeUstad`, `Nama`, `Alamat`, `id_kelas`, `Telepon`, `KodePelajaran`) VALUES ('2', 'Ustad Toto', 'Malang', 2, 322332, 3);
            String sql = "insert into guru (KodeUstad, Nama, Alamat, id_kelas, Telepon, KodePelajaran)"
                    
                    + "values ('"+kode.getText()+"','"+nama.getText()+"','"+alamat.getText()+"','"+pilih+"','"+telp.getText()+"','"+pelajaran.getText()+"')";
                    
            int row =st.executeUpdate(sql);
            if (row==1)
            {
                JOptionPane.showMessageDialog(null,"Data sudah ditambahkan ke database","informasi",JOptionPane.INFORMATION_MESSAGE);
                con.close();
            }
        }
        catch (SQLException e)
        {
            JOptionPane.showMessageDialog(null,"data tidak ditambahkan ke database"+e,"informasi",JOptionPane.INFORMATION_MESSAGE);
        }
         tampiltabel();
    }
    
    void tampiltabelustad() throws PrinterException{
        try
        {
            Koneksi_DB objkoneksi = new Koneksi_DB();
            Connection con = objkoneksi.bukakoneksi();
            Statement st = con.createStatement();
            String sql = "select * from guru";
            ResultSet set = st.executeQuery(sql);
            HasilKeluaranTabel model = new HasilKeluaranTabel (set);
            tabel.setModel (model);
            tabel.print();
        }
        catch (SQLException e)
        {
            System.out.println("gagal query ini"+e);
        }
    }
    void tampiltabelnilaiampu() throws PrinterException{
        try
        {
            Koneksi_DB objkoneksi = new Koneksi_DB();
            Connection con = objkoneksi.bukakoneksi();
            Statement st = con.createStatement();
            String sql = "select * from guru";
            ResultSet set = st.executeQuery(sql);
            HasilKeluaranTabel model = new HasilKeluaranTabel (set);
            tabel.setModel (model);
            tabel.print();
        }
        catch (SQLException e)
        {
            System.out.println("gagal query ini"+e);
        }
    }
    void tampiltabel()
    {
        try
        {
            Koneksi_DB objkoneksi = new Koneksi_DB();
            Connection con = objkoneksi.bukakoneksi();
            Statement st = con.createStatement();
            String sql = "select KodePelajaran,Mapel from pelajaran";
            ResultSet set = st.executeQuery(sql);
            HasilKeluaranTabel model = new HasilKeluaranTabel (set);
            tabel.setModel (model);
        }
        catch (SQLException e)
        {
            System.out.println("gagal query ini"+e);
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        kode = new javax.swing.JTextField();
        nama = new javax.swing.JTextField();
        alamat = new javax.swing.JTextField();
        telp = new javax.swing.JTextField();
        simpan = new javax.swing.JButton();
        edit = new javax.swing.JButton();
        hapus = new javax.swing.JButton();
        batal = new javax.swing.JButton();
        back = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jenis = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        pelajaran = new javax.swing.JTextField();
        view_diniyah = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Data Guru");

        jLabel1.setFont(new java.awt.Font("Cooper Black", 0, 14)); // NOI18N
        jLabel1.setText("Kode Guru");

        jLabel3.setFont(new java.awt.Font("Cooper Black", 0, 14)); // NOI18N
        jLabel3.setText("Nama");

        jLabel4.setFont(new java.awt.Font("Cooper Black", 0, 14)); // NOI18N
        jLabel4.setText("Telepon");

        jLabel5.setFont(new java.awt.Font("Cooper Black", 0, 14)); // NOI18N
        jLabel5.setText("Alamat");

        kode.setFont(new java.awt.Font("Cooper Black", 0, 14)); // NOI18N
        kode.setText(" ");
        kode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kodeActionPerformed(evt);
            }
        });
        kode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                kodeKeyPressed(evt);
            }
        });

        nama.setFont(new java.awt.Font("Cooper Black", 0, 14)); // NOI18N

        alamat.setFont(new java.awt.Font("Cooper Black", 0, 14)); // NOI18N

        telp.setFont(new java.awt.Font("Cooper Black", 0, 14)); // NOI18N

        simpan.setBackground(new java.awt.Color(0, 204, 255));
        simpan.setFont(new java.awt.Font("Cooper Black", 0, 14)); // NOI18N
        simpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Addnew toolbar.png"))); // NOI18N
        simpan.setText("Simpan");
        simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanActionPerformed(evt);
            }
        });

        edit.setBackground(new java.awt.Color(0, 204, 255));
        edit.setFont(new java.awt.Font("Cooper Black", 0, 14)); // NOI18N
        edit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Edit toolbar.png"))); // NOI18N
        edit.setText("Edit");
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });

        hapus.setBackground(new java.awt.Color(0, 204, 255));
        hapus.setFont(new java.awt.Font("Cooper Black", 0, 14)); // NOI18N
        hapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Delete toolbar.png"))); // NOI18N
        hapus.setText("Hapus");
        hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusActionPerformed(evt);
            }
        });

        batal.setBackground(new java.awt.Color(0, 204, 255));
        batal.setFont(new java.awt.Font("Cooper Black", 0, 14)); // NOI18N
        batal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/remove_32.png"))); // NOI18N
        batal.setText("Batal");
        batal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                batalActionPerformed(evt);
            }
        });

        back.setBackground(new java.awt.Color(0, 204, 255));
        back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Back.png"))); // NOI18N
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Cooper Black", 0, 18)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("DATA USTAD DINIYAH PP.ANWARUL HUDA");

        tabel.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabel);

        jLabel6.setText("Mengampu kelas : ");

        jenis.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Kelas", "Satu Awaliyah", "Dua Awaliyah", "Satu Wustho", "Dua Wustho", "Satu Ulya", "Dua Ulya" }));

        jLabel2.setText("Diniyah yang diampu");

        view_diniyah.setText("Diniyah");
        view_diniyah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                view_diniyahActionPerformed(evt);
            }
        });

        jButton1.setText("Ustad");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel7.setText("liat tabel");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(pelajaran, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(view_diniyah)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton1))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(simpan)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(edit)
                                        .addGap(18, 18, 18)
                                        .addComponent(batal)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(hapus))
                                    .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel5))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(nama, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(kode, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(telp, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(73, 73, 73)
                                                .addComponent(jLabel7))
                                            .addComponent(alamat, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(3, 3, 3)
                                        .addComponent(jenis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel4))
                                .addGap(0, 106, Short.MAX_VALUE)))
                        .addContainerGap())))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {batal, edit, hapus, simpan});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel8)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(kode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(nama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(alamat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jenis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(telp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(pelajaran, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(view_diniyah)
                        .addComponent(jButton1))
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(simpan)
                    .addComponent(edit)
                    .addComponent(batal)
                    .addComponent(hapus))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(back)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {batal, edit, hapus, simpan});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanActionPerformed
       simpan();
        bersih();
    }//GEN-LAST:event_simpanActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        dispose();
        new DashboardPondok().setVisible(true);
    }//GEN-LAST:event_backActionPerformed

    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed
        int pilih = 0;
        if (jenis.getSelectedItem().equals("Satu Awaliyah")){
            pilih = 1;
        } else if (jenis.getSelectedItem().equals("Dua Awaliyah")){
            pilih = 2;
        } else if (jenis.getSelectedItem().equals("Satu Wustho")){
            pilih = 3;
        }else if (jenis.getSelectedItem().equals("Dua Wustho")){
            pilih = 4;
        }else if (jenis.getSelectedItem().equals("Satu Ulya")){
            pilih = 5;
        } else if (jenis.getSelectedItem().equals("Dua Ulya")){
          pilih = 6;
    }
        try
        {
            Koneksi_DB objkoneksi = new Koneksi_DB();
            Connection con =objkoneksi.bukakoneksi();
            Statement st = con.createStatement();
            String sql = "update guru set Nama='"+nama.getText()+"', "
                    + "Alamat = '"+alamat.getText()+"',"
                    + "id_kelas = '"+pilih+"',"
                    + "Telepon = '"+telp.getText()+"',"
                    + "KodePelajaran = '"+pelajaran.getText()+"'"
                    + "where KodeUstad ='" +kode.getText()+"'";
            int row =st.executeUpdate(sql);
            if (row==1)
            {
                JOptionPane.showMessageDialog(null,"Data sudah diupdate","informasi",JOptionPane.INFORMATION_MESSAGE);
                con.close();
            }
        }
        catch (SQLException e)
        {
            JOptionPane.showMessageDialog(null,"data tidak diubah"+ e,"informasi",JOptionPane.INFORMATION_MESSAGE);
        }
        bersih();
    }//GEN-LAST:event_editActionPerformed

    private void batalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_batalActionPerformed
        bersih();
    }//GEN-LAST:event_batalActionPerformed

    private void hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusActionPerformed
        try
        {
            Koneksi_DB objkoneksi = new Koneksi_DB();
            Connection con = objkoneksi.bukakoneksi();
            Statement st = con.createStatement();
            String sql = "delete from guru where KodeUstad= '"+kode.getText()+"'";
            int confirm =JOptionPane.showConfirmDialog(this,
            "Yakin untuk menghapus data ini?",
            "Konfirmasi Hapus ",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE);
            if (confirm==JOptionPane.YES_OPTION) {
            int row = st.executeUpdate(sql);
            if (row ==1)
            {
                JOptionPane.showMessageDialog(null,"data sudah dihapus dari database","informasi",JOptionPane.INFORMATION_MESSAGE);
                con.close();
            }}}

        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "data tidak dihapus"+e,"informasi",JOptionPane.INFORMATION_MESSAGE);
        }
        bersih();
    }//GEN-LAST:event_hapusActionPerformed

    private void kodeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_kodeKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER)

        {
                try
                {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                Connection koneksi = DriverManager.getConnection("jdbc:mysql://localhost/Akademik", "root", "");
                Statement state = koneksi.createStatement();
                String query = "select *from guru where KodeUstad = '"+kode.getText()+"'";
                ResultSet rs = state.executeQuery(query);
                if(rs.next())
                {
                    //nip.setText(rs.getString(2));
                    nama.setText(rs.getString(2));
                    alamat.setText(rs.getString(3));
                    jenis.setSelectedItem(rs.getString(4));
                    telp.setText(rs.getString(5));
                    pelajaran.setText(rs.getString(6));

                    kode.setEditable(false);
                }
                }
                catch(Exception ex)
                {
                    System.out.println(ex);
                }
        }
    }//GEN-LAST:event_kodeKeyPressed

    private void kodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kodeActionPerformed

    private void view_diniyahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_view_diniyahActionPerformed
        // TODO add your handling code here:
        tampiltabel();
    
    }//GEN-LAST:event_view_diniyahActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            // TODO add your handling code here:
            tampiltabelustad();
        } catch (PrinterException ex) {
            Logger.getLogger(DataUstad.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DataUstad().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField alamat;
    private javax.swing.JButton back;
    private javax.swing.JButton batal;
    private javax.swing.JButton edit;
    private javax.swing.JButton hapus;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> jenis;
    private javax.swing.JTextField kode;
    private javax.swing.JTextField nama;
    private javax.swing.JTextField pelajaran;
    private javax.swing.JButton simpan;
    private javax.swing.JTable tabel;
    private javax.swing.JTextField telp;
    private javax.swing.JButton view_diniyah;
    // End of variables declaration//GEN-END:variables

}
