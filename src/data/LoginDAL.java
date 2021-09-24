package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import model.Cliente;
import model.CostoMovimiento;
import model.Cuenta;
import model.Moneda;
import security.Login;
import singleton.Conexion;

public class LoginDAL {

    private static Connection cn = null;
    private static PreparedStatement ps = null;
    // private static Statement st = null;
    private static ResultSet rs = null;

    public static Login loginTo(String dni, String clave) {
        Cliente cliente = new Cliente();
        Cuenta cuenta = new Cuenta();
        CostoMovimiento costoMovimiento = new CostoMovimiento();
        Moneda moneda = new Moneda();
        try {
            cn = Conexion.getConexion();
            String sql = "SELECT * FROM cuenta AS C INNER JOIN cliente AS CL ON CL.cliecodigo = C.cliecodigo INNER JOIN moneda AS M ON M.monecodigo = C.monecodigo INNER JOIN costomovimiento AS CM ON CM.monecodigo = M.monecodigo WHERE CL.cliedni =? AND C.cuenclave =?";
            ps = cn.prepareStatement(sql);
            ps.setString(1, dni);
            ps.setString(2, clave);
            rs = ps.executeQuery();
            while (rs.next()) {
                // TODO: instancia de cliente
                cliente.setCodigo(rs.getString("cliecodigo"));
                cliente.setApellidoMaterno(rs.getString("cliematerno"));
                cliente.setApellidoPaterno(rs.getString("cliepaterno"));
                cliente.setNombre(rs.getString("clienombre"));
                cliente.setDni(rs.getString("cliedni"));
                cliente.setCiudad(rs.getString("clieciudad"));
                cliente.setDireccion(rs.getString("cliedireccion"));
                cliente.setTelefono(rs.getString("clietelefono"));
                cliente.setEmail(rs.getString("clieemail"));
                // TODO: instanacia de cuenta
                cuenta.setCliente(cliente);
                cuenta.setCodigo(rs.getString("cuencodigo"));
                cuenta.setSaldo(rs.getFloat("cuensaldo"));
                cuenta.setEstado(rs.getString("cuenestado"));
                cuenta.setClave(rs.getString("cuenclave"));
                cuenta.setContadorMovimiento(rs.getInt("cuencontmov"));
                // TODO: instancia coste por movimiento
                costoMovimiento.setImporte(rs.getFloat("costimporte"));
                moneda.setCodigo(rs.getString("monecodigo"));
                moneda.setDescripcion(rs.getString("monedescripcion"));
                cuenta.setMoneda(moneda);
                return new Login(cuenta, cliente,costoMovimiento);
            }
        } catch (SQLException ex) {
            // TODO: handle exception
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } finally {
            try {
                ps.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
        return null;
    }

}
