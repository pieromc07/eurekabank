/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import model.Cliente;
import model.CostoMovimiento;
import model.Cuenta;
import model.Moneda;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import security.Login;

/**
 *
 * @author Piero
 */
public class LoginBLTest {
    
    public LoginBLTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of verify method, of class LoginBL.
     */
    @Test
    public void testVerify() {
        System.out.println("verify");
        String dni = "12345678";
        String clave = "123456";
        LoginBL instance = new LoginBL();
        boolean expResult = true;
        boolean result = instance.verify(dni, clave);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if(expResult != result){
            fail("The test case is a prototype.");
        }
        
    }

    /**
     * Test of login method, of class LoginBL.
     */
    @Test
    public void testLogin() {
        System.out.println("login");
        Cliente cliente = new Cliente("06914897", "9666-4457", "gcoronel@viabcp.com", "00001", "ERIC GUSTAVO", "CORONEL", "CASTILLO", "LIMA", "LOS OLIVOS");
        Cuenta cuenta = new Cuenta("00200002", new Moneda("01", "Soles"), null, null, cliente, 5796.00f, "2008-01-09", "ACTIVO", 5, "123456");
        String dni = "069148975";
        String clave = "123456";
        Login expResult = null;
//                new Login(cuenta, cliente, new CostoMovimiento(2.00f));
        Login result = LoginBL.login(dni, clave);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if(expResult != result){
            fail("The test case is a prototype.");
        }
    }
    
}
