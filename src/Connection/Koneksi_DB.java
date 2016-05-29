/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Connection;

/**
 *
 * @author USER
 */
import java.sql.*;
public class Koneksi_DB
{
    public Koneksi_DB () {}
    public Connection bukakoneksi () throws SQLException
    {
        Connection con = null;
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/Akademik","root","");
            System.out.println("Sukses konek sam");
            return con;
            
        }
        catch (SQLException se)
        {
            System.out.println("No Connection Open");
            return null;
        }
        catch (Exception ex)
        {
            System.out.println("Couldn't open connection"+ex);
            return null;
        }
    }
    public static void main(String[] args) throws SQLException {
        Koneksi_DB b = new Koneksi_DB();
        b.bukakoneksi();
    }

}
