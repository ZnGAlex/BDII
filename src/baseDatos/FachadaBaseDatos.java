package baseDatos;

import aplicacion.Categoria;
import aplicacion.Desarrolladora;
import aplicacion.Usuario;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import aplicacion.Juego;
import aplicacion.Jugador;

public class FachadaBaseDatos {
    private aplicacion.FachadaAplicacion fa;
    private java.sql.Connection conexion;
    private DAOUsuarios daoUsuarios;
    private DAOCategorias daoCategorias;
    private DAODesarrolladoras daoDesarrolladoras;
    private DAOJuegos daoJuegos;
    
    public FachadaBaseDatos (aplicacion.FachadaAplicacion fa){
        
        Properties configuracion = new Properties();
        this.fa=fa;
        FileInputStream arqConfiguracion;

        try {
            arqConfiguracion = new FileInputStream("baseDatos.properties");
            configuracion.load(arqConfiguracion);
            arqConfiguracion.close();

            Properties usuario = new Properties();
     

            String gestor = configuracion.getProperty("gestor");

            usuario.setProperty("user", configuracion.getProperty("usuario"));
            usuario.setProperty("password", configuracion.getProperty("clave"));
            this.conexion=java.sql.DriverManager.getConnection("jdbc:"+gestor+"://"+
                    configuracion.getProperty("servidor")+":"+
                    configuracion.getProperty("puerto")+"/"+
                    configuracion.getProperty("baseDatos"),
                    usuario);
            daoUsuarios = new DAOUsuarios(conexion, fa);
            daoCategorias = new DAOCategorias(conexion, fa);
            daoDesarrolladoras = new DAODesarrolladoras(conexion,fa);
            daoJuegos = new DAOJuegos(conexion,fa);
        } catch (FileNotFoundException f){
            System.out.println(f.getMessage());
            // fa.muestraExcepcion(f.getMessage());
        } catch (IOException i){
            System.out.println(i.getMessage());
            // fa.muestraExcepcion(i.getMessage());
        } 
        catch (java.sql.SQLException e){
            System.out.println(e.getMessage());
            // fa.muestraExcepcion(e.getMessage());
        }
    }
    
    public Usuario validarUsuario(String login, String pw){
        return daoUsuarios.validarUsuario(login, pw);
    }
    
    public void registrarUsuario(String login, String pw, String correo, java.util.Date fechaNacimiento) {
        daoUsuarios.registrarUsuario(login, pw, correo, fechaNacimiento);
    }
    
    public java.util.List<Categoria> obtenerCategorias(){
        return daoCategorias.obtenerCategorias();
    }
    
    public java.util.List<Desarrolladora> obtenerDesarrolladoras() {
        return daoDesarrolladoras.obtenerDesarrolladoras();
    }

    public void jugar(Jugador j, Juego ju){
        daoUsuarios.jugar(j, ju);
    }
    
    public void dejarJugar(Jugador j, Juego ju){
        daoUsuarios.dejarJugar(j, ju);
    }
    
    public void retransmitir(Jugador j, Juego ju){
        daoUsuarios.retrasnmitir(j, ju);
    }
    
    public void dejarRetransmitir(Jugador j, Juego ju){
        daoUsuarios.dejarRetransmitir(j, ju);
    }
    
    public java.util.List<Juego> consultarJuegosTienda(String categoria, String desarrolladora, String nombre){
        return daoJuegos.consultarJuegosTienda(categoria, desarrolladora, nombre);
    }
    
    public java.util.List<Juego> consultarJuegosPropios(String categoria, String desarrolladora, String nombre, Jugador jugador){
        return daoJuegos.consultarJuegosPropios(categoria, desarrolladora, nombre, jugador);
    }
    
    public boolean usuarioTieneJuego(String nick,Integer idJuego){
        return daoUsuarios.usuarioTieneJuego(nick,idJuego);
    }
    
}
