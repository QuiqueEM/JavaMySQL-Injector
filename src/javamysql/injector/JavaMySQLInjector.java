package javamysql.injector;
import com.mysql.jdbc.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JavaMySQLInjector {

    //Metodo de insercion de datos
    public static String Insercion(Statement st) {

        Calendar calendario = Calendar.getInstance();

        String Valor = "Quique";
        Integer Hora = calendario.get(Calendar.HOUR_OF_DAY);
        Integer Minutos = calendario.get(Calendar.MINUTE);
        String tiempo = Hora.toString() + ":" + Minutos.toString();

        try {
            st.executeUpdate("INSERT INTO ingreso (No_ingreso, Valor, Hora) VALUES ('','" + Valor + "','" + tiempo + "')");
        } catch (SQLException ex) {
            Logger.getLogger(JavaMySQLInjector.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Valor;
    }

    //Clase Conexion
    public static void main(String[] args) throws Exception {
        String bd = "java_test";
        String usuario = "root";
        String password = "root";
        String url = "jdbc:mysql://localhost/" + bd;
        
        Connection conect = null;
        Statement st =  conect.createStatement();
        
        try {

            Class.forName("com.mysql.jdbc.Driver");
            conect = DriverManager.getConnection(url, usuario, password);
            if (conect != null) {
                System.out.println("La conexion a la base de datos " + url + " fue satisfactoria");
                System.out.println(Insercion(st));

                conect.close();
            }
        } catch (SQLException ex) {
            System.out.println("Hubo un error al intentar conectar a la base de datos " + url + ".El resultado enviado es " + conect + "");
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        }
    }
}
