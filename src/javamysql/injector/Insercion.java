
package javamysql.injector;
import com.mysql.jdbc.Statement;
import java.util.Calendar;
import java.util.Date;


public class Insercion {
    
    Calendar calendario = Calendar.getInstance();
    
    public String Valor;
    public Integer Hora = calendario.get(Calendar.HOUR_OF_DAY);
    public Integer Minutos = calendario.get(Calendar.MINUTE);
    
    Statament st = query.createStatament();


    
}
