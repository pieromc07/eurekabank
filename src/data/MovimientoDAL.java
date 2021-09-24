package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JOptionPane;

import model.Cliente;
import model.Cuenta;
import model.Moneda;
import security.Login;
import singleton.Conexion;

public class MovimientoDAL {

    private static Connection cn = null;
    private static PreparedStatement ps = null;
    // private static Statement st = null;
    private static ResultSet rs = null;

    public static boolean retirar(int monto, String cuenta) {
        float saldo = 0.0f, cargo = 0.0f;
        int contador = 0;
        try {
            cn = Conexion.getConexion();
            String sqlS = "SELECT C.cuensaldo, C.cuencontmov, CM.costimporte FROM cuenta AS C INNER JOIN moneda AS M ON M.monecodigo = C.monecodigo INNER JOIN costomovimiento AS CM ON CM.monecodigo = M.monecodigo WHERE cuencodigo =?";
            ps = cn.prepareStatement(sqlS);
            ps.setString(1, cuenta);
            rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println("in");
                // TODO: instancia de cliente
                saldo = rs.getFloat("cuensaldo");
                contador = rs.getInt("cuencontmov");
                cargo = rs.getFloat("costimporte");
            }
            String sql = "UPDATE cuenta SET cuensaldo =? ,cuencontmov=?  WHERE cuencodigo =?";
            ps = cn.prepareStatement(sql);
            ps.setFloat(1, (saldo - (monto + cargo)));
            ps.setInt(2, (contador + 1));
            ps.setString(3, cuenta);

            if (ps.execute()) {

                return true;
            }
            insertMovimiento(cuenta, (contador + 1), "004", (monto), null);
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
        return true;
    }

    private static void insertMovimiento(String cuenta, int contador, String tipo, float importe,
            String cuentaReferencia) {
        GregorianCalendar f = new GregorianCalendar();
        int dia = f.get(Calendar.DAY_OF_MONTH);
        int mes = f.get(Calendar.MONTH);
        int año = f.get(Calendar.YEAR);
        String date = año + "-" + mes + "-" + dia;
        try {
            cn = Conexion.getConexion();

            String sql = "INSERT INTO movimiento VALUES (?,?,?,?,?,?,?)";
            ps = cn.prepareStatement(sql);
            ps.setString(1, cuenta);
            ps.setInt(2, contador);
            ps.setString(3, date);
            ps.setString(4, "0001");
            ps.setString(5, tipo);
            ps.setFloat(6, importe);
            ps.setString(7, cuentaReferencia);
            ps.executeUpdate();

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

    }

    public static boolean transferir(int monto, String cuenta, String cuentaReferencia) {
        float saldo = 0.0f, cargo = 0.0f;
        int contador = 0;
        try {
            cn = Conexion.getConexion();
            String sqlS = "SELECT C.cuensaldo, C.cuencontmov, CM.costimporte FROM cuenta AS C INNER JOIN moneda AS M ON M.monecodigo = C.monecodigo INNER JOIN costomovimiento AS CM ON CM.monecodigo = M.monecodigo WHERE cuencodigo =?";
            ps = cn.prepareStatement(sqlS);
            ps.setString(1, cuenta);
            rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println("in");
                // TODO: instancia de cliente
                saldo = rs.getFloat("cuensaldo");
                contador = rs.getInt("cuencontmov");
                cargo = rs.getFloat("costimporte");
            }
            String sql = "UPDATE cuenta SET cuensaldo =? ,cuencontmov=?  WHERE cuencodigo =?";
            ps = cn.prepareStatement(sql);
            ps.setFloat(1, (saldo - (monto + cargo)));
            ps.setInt(2, (contador + 1));
            ps.setString(3, cuenta);
            if (ps.execute()) {

                return true;
            }
            insertMovimiento(cuenta, (contador + 1), "009", (monto), cuentaReferencia);
            depositarT(monto, cuentaReferencia);
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
        return true;
    }

    public static boolean depositarT(int monto, String cuenta) {
        float saldo = 0.0f, cargo = 0.0f;
        int contador = 0;
        try {
            cn = Conexion.getConexion();
            String sqlS = "SELECT C.cuensaldo, C.cuencontmov, CM.costimporte FROM cuenta AS C INNER JOIN moneda AS M ON M.monecodigo = C.monecodigo INNER JOIN costomovimiento AS CM ON CM.monecodigo = M.monecodigo WHERE cuencodigo =?";
            ps = cn.prepareStatement(sqlS);
            ps.setString(1, cuenta);
            rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println("in");
                // TODO: instancia de cliente
                saldo = rs.getFloat("cuensaldo");
                contador = rs.getInt("cuencontmov");
                cargo = rs.getFloat("costimporte");
            }
            String sql = "UPDATE cuenta SET cuensaldo =? WHERE cuencodigo =?";
            ps = cn.prepareStatement(sql);
            ps.setFloat(1, (saldo + (monto)));
            ps.setString(2, cuenta);
            if (ps.execute()) {
                insertMovimiento(cuenta, (contador + 1), "008", (monto), null);
                return true;
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
        return true;
    }

    public static boolean depositar(int monto, String cuenta) {
        float saldo = 0.0f, cargo = 0.0f;
        int contador = 0;
        try {
            cn = Conexion.getConexion();
            String sqlS = "SELECT C.cuensaldo, C.cuencontmov, CM.costimporte FROM cuenta AS C INNER JOIN moneda AS M ON M.monecodigo = C.monecodigo INNER JOIN costomovimiento AS CM ON CM.monecodigo = M.monecodigo WHERE cuencodigo =?";
            ps = cn.prepareStatement(sqlS);
            ps.setString(1, cuenta);
            rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println("in");
                // TODO: instancia de cliente
                saldo = rs.getFloat("cuensaldo");
                contador = rs.getInt("cuencontmov");
                cargo = rs.getFloat("costimporte");
            }
            String sql = "UPDATE cuenta SET cuensaldo =? WHERE cuencodigo =?";
            ps = cn.prepareStatement(sql);
            ps.setFloat(1, (saldo + (monto)));
            ps.setInt(2, (contador + 1));
            ps.setString(3, cuenta);
            if (ps.execute()) {
                insertMovimiento(cuenta, (contador + 1), "003", (monto), null);
                return true;
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
        return true;
    }

    public static Login getCuenta(String codigo) {
        Cliente cliente = new Cliente();
        Cuenta cuenta = new Cuenta();
        Moneda moneda = new Moneda();
        try {
            cn = Conexion.getConexion();
            String sql = "SELECT * FROM cuenta AS C INNER JOIN cliente AS CL ON CL.cliecodigo = C.cliecodigo INNER JOIN moneda AS M ON M.monecodigo = C.monecodigo WHERE C.cuencodigo = ?";
            ps = cn.prepareStatement(sql);
            ps.setString(1, codigo);
            rs = ps.executeQuery();
            while (rs.next()) {

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
                moneda.setCodigo(rs.getString("monecodigo"));
                moneda.setDescripcion(rs.getString("monedescripcion"));
                cuenta.setMoneda(moneda);
            }

            return new Login(cuenta, cliente, null);
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

    public static String getMovimientos(String codigo) {

        String mensaje = "===================================================================\n"
                + "FECHA ------- TIPO DE MOVIMIENTO ------- TIPO ACCION ------ IMPORTE\n\n";
        try {
            cn = Conexion.getConexion();
            String sql = "SELECT M.movifecha, TM.tipodescripcion, TM.tipoaccion, M.moviimporte FROM movimiento AS M INNER JOIN tipomovimiento AS TM ON TM.tipocodigo = M.tipocodigo WHERE M.cuencodigo = ? ORDER BY M.movifecha ASC";
            ps = cn.prepareStatement(sql);
            ps.setString(1, codigo);
            rs = ps.executeQuery();
            while (rs.next()) {
                mensaje += "|  " + rs.getString("movifecha") + "        " + rs.getString("tipodescripcion") + "         "
                        + rs.getString("tipoaccion") + "         " + rs.getString("moviimporte")+"  |\n\n";
            }

            return mensaje;
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
