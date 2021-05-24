/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloVO;

/**
 *
 * @author JUAN DAVID PACHON
 */
public class UsuarioVO {
    
    private String usuId,usuLogin,usuPassword;
    public UsuarioVO(){
    }
    
    public UsuarioVO(String usuId, String usuLogin, String usuPassword) {
        this.usuId = usuId;
        this.usuLogin = usuLogin;
        this.usuPassword = usuPassword;
    }


    

    public String getUsuId() {
        return usuId;
    }

    public void setUsuId(String usuId) {
        this.usuId = usuId;
    }

    public String getUsuLogin() {
        return usuLogin;
    }

    public void setUsuLogin(String usuLogin) {
        this.usuLogin = usuLogin;
    }

    public String getUsuPassword() {
        return usuPassword;
    }

    /*como id no se opera para nada lo puedo dejar String "id"*/
    public void setUsuPassword(String usuPassword) {
        this.usuPassword = usuPassword;
    }

        
    
}
