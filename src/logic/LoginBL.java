package logic;


import security.Login;

public class LoginBL {
    

    public boolean verify(String dni, String clave) {

        if(dni.length() == 8 && clave.length() <= 6){
            return true;
        }
        return false;
    }

    public static Login login(String dni, String clave) {
        return data.LoginDAL.loginTo(dni, clave);
    }

    
}
