/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Nilai.java
 *
 * Created on Feb 10, 2014, 8:12:40 AM
 */

package Frame;

/**
 *
 * @author USER
 */
import Connection.*;
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
public class Nilai extends javax.swing.JFrame {
String kode,nilaihuruf,nilaiangka;
    /** Creates new form Nilai */
    public Nilai()  {
        initComponents();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = getSize();
        setLocation(
        (screenSize.width - frameSize.width) / 2,
        (screenSize.height - frameSize.height) / 2);
        //tampiltabel();
    }

    
    void tampilpelajaran(){
        try
        {
            Koneksi_DB objkoneksi = new Koneksi_DB();
            Connection con = objkoneksi.bukakoneksi();
            Statement st = con.createStatement();
            String sql = "select *from pelajaran ";
            ResultSet set = st.executeQuery(sql);
            HasilKeluaranTabel model = new HasilKeluaranTabel (set);
            tabel.setModel (model);
        }
        catch (SQLException e)
        {
            System.out.println("gagal query ini"+e);
        }
    }
    void tampilsantri(){
        try
        {
            Koneksi_DB objkoneksi = new Koneksi_DB();
            Connection con = objkoneksi.bukakoneksi();
            Statement st = con.createStatement();
            String sql = "select *from santri ";
            ResultSet set = st.executeQuery(sql);
            HasilKeluaranTabel model = new HasilKeluaranTabel (set);
            tabel.setModel (model);
        }
        catch (SQLException e)
        {
            System.out.println("gagal query ini"+e);
        }
    }
    void tampiltabel() throws PrinterException
    {
        try
        {
            Koneksi_DB objkoneksi = new Koneksi_DB();
            Connection con = objkoneksi.bukakoneksi();
            Statement st = con.createStatement();
            String sql = "select *from rapot";
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

//    void tambahitem()
//    {
//        try
//        {
//            Koneksi objkoneksi = new Koneksi();
//            Connection con = objkoneksi.bukakoneksi();
//            Statement st = con.createStatement();
//            String sql = "select *from nilaiun";
//            ResultSet res=st.executeQuery(sql);
//            while (res.next()) {
//                bin.setText(res.getString(2));
//                Matematika.setText(res.getString(3));
//                big.setText(res.getString(4));
//            }
//        }
//        catch (SQLException e)
//        {
//            System.out.println("gagal query ini"+e);
//        }
//    }
    void bersih()
    {
        nis.setText("");
        //nama.setText("");
        
        diniyah.setText("");
        nilai.setText("");
        pilih.setSelectedIndex(0);
        tahun.setText("");
        
    }

//    void rapot()
//    {
//        try {
//            Koneksi objkoneksi = new Koneksi();
//            Connection con =objkoneksi.bukakoneksi();
//            Statement st = con.createStatement();
//
//            String sql = "insert into rapot (NIS, Nama, Kelas, Jurusan, Mapel, NilaiAngka, NilaiHuruf)"
//                    + "values ('"+nis.getText()+"','"+nama.getText()+"','"+kelas.getText()+"','"+jurusan.getText()+"','"+mapel.getSelectedItem()+"','"+txtbin.getText()+"','"+nilaihuruf+"')";
//            int row =st.executeUpdate(sql);
//            if (row==1)
//            {
//                JOptionPane.showMessageDialog(null,"Data sudah ditambahkan ke database","informasi",JOptionPane.INFORMATION_MESSAGE);
//            }
//        }
//        catch (SQLException e)
//        {
//            JOptionPane.showMessageDialog(null,"data tidak ditambahkan ke database","informasi",JOptionPane.INFORMATION_MESSAGE);
//            System.out.println(e);
//        }
//    }
   
    
    void nilai()
    {
        try {
            Koneksi_DB objkoneksi = new Koneksi_DB();
            Connection con =objkoneksi.bukakoneksi();
            Statement st = con.createStatement();

            String sql = "insert into rapot (NIS,KodePelajaran,nilai,status,tahun)"
                    + "values ('"+nis.getText()+"','"+diniyah.getText()+"','"+nilai.getText()+"','"+pilih.getSelectedItem()+"','"+tahun.getText()+"')";
            int row =st.executeUpdate(sql);
            if (row==1)
            {
                JOptionPane.showMessageDialog(null,"Data sudah ditambahkan ke database","informasi",JOptionPane.INFORMATION_MESSAGE);
            }
        }
        catch (SQLException e)
        {
//            JOptionPane.showMessageDialog(null,"data tidak ditambahkan ke database","informasi",JOptionPane.INFORMATION_MESSAGE);
        }
    }

//    void mapel()
//    {
//        try {
//            Koneksi objkoneksi = new Koneksi();
//            Connection con =objkoneksi.bukakoneksi();
//            Statement st = con.createStatement();
//            String sql = "select kodepelajaran from pelajaran where mapel ='"+mapel.getSelectedItem()+"'";
//            ResultSet rs = st.executeQuery(sql);
//            if(rs.next())
//            {
//                kode=rs.getString(1);
//            }
//            }
//        catch (SQLException e)
//        {
//            //JOptionPane.showMessageDialog(null,"data tidak ditambahkan ke database"+e,"informasi",JOptionPane.INFORMATION_MESSAGE);
//        }
//        nilaiangka=txtbin.getText();
//        int na = Integer.parseInt(nilaiangka);
//        if(na>=80){ nilaihuruf="A";}
//        else if(na>=70) { nilaihuruf="B";}
//        else if(na>=60) { nilaihuruf="C";}
//        else { nilaihuruf="D";}
//    }

    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        nis = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        back = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();
        batal = new javax.swing.JButton();
        simpan = new javax.swing.JButton();
        bin = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        nilai = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        pilih = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        tahun = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        diniyah = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Data Nilai");

        jLabel1.setText("NIS");

        nis.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nisKeyPressed(evt);
            }
        });

        jLabel5.setText("Mata Pelajaran :");

        back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Back.png"))); // NOI18N
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

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

        batal.setBackground(new java.awt.Color(0, 204, 255));
        batal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/remove_32.png"))); // NOI18N
        batal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                batalActionPerformed(evt);
            }
        });

        simpan.setBackground(new java.awt.Color(0, 204, 255));
        simpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Addnew toolbar.png"))); // NOI18N
        simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanActionPerformed(evt);
            }
        });

        bin.setText("KodeDiniyah");

        jLabel3.setText("Nilai");

        jTextField2.setText("Pilih semester");

        pilih.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Semester", "Semester 1", "Semester 2" }));

        jLabel4.setText("Tahun ajaran");

        jLabel7.setText("INPUT NILAI SANTRI");

        jButton1.setText("Pelajaran");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Santri");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel5)
                            .addComponent(bin)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(nilai)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(diniyah, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(0, 54, Short.MAX_VALUE)
                                                .addComponent(jLabel7))
                                            .addComponent(nis, javax.swing.GroupLayout.Alignment.LEADING))
                                        .addGap(26, 26, 26)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(simpan)
                                    .addComponent(batal))
                                .addGap(94, 94, 94))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(tahun, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(pilih, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(32, 32, 32)
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(back)
                .addGap(26, 26, 26))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel7)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(simpan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(batal))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5))
                            .addComponent(nis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bin)
                            .addComponent(diniyah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(nilai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pilih, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tahun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(16, 16, 16)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(back))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        dispose();
        new DashboardPondok().setVisible(true);
    }//GEN-LAST:event_backActionPerformed

    private void nisKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nisKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER)

        {
                try
                {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                Connection koneksi = DriverManager.getConnection("jdbc:mysql://localhost/Akademik", "root", "");
                Statement state = koneksi.createStatement();
                String query = "select *from rapot where NIS = '"+nis.getText()+"'";
                ResultSet rs = state.executeQuery(query);
                HasilKeluaranTabel model = new HasilKeluaranTabel (rs);
                    tabel.setModel (model);
//                if(rs.next())
//                {
//                    
//                    String sql = "select *from rapot where NIS ='"+nis.getText()+"'";
//                    ResultSet set = state.executeQuery(sql);
//                    HasilKeluaranTabel model = new HasilKeluaranTabel (set);
//                    tabel.setModel (model);
//                }

                }
                catch(Exception ex)
                {
                    System.out.println(ex);
                }
                }
    }//GEN-LAST:event_nisKeyPressed

    private void simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanActionPerformed
        nilai();
        bersih();
    try {
        tampiltabel();
    } catch (PrinterException ex) {
        Logger.getLogger(Nilai.class.getName()).log(Level.SEVERE, null, ex);
    }
        nis.setEditable(true);
       // nama.setEditable(true);
    }//GEN-LAST:event_simpanActionPerformed

    private void batalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_batalActionPerformed
        bersih();
        nis.setEditable(true);
    }//GEN-LAST:event_batalActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        tampilpelajaran();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        tampilsantri();
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Nilai().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JButton batal;
    private javax.swing.JLabel bin;
    private javax.swing.JTextField diniyah;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField nilai;
    private javax.swing.JTextField nis;
    private javax.swing.JComboBox<String> pilih;
    private javax.swing.JButton simpan;
    private javax.swing.JTable tabel;
    private javax.swing.JTextField tahun;
    // End of variables declaration//GEN-END:variables

}
