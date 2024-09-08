import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class conectaDAO {

    public Connection connectDB() {
        Connection conn = null;
        try {
            // URL de conexão com SSL desabilitado
            conn = DriverManager.getConnection("jdbc:mysql://localhost/uc11?useSSL=false", "root", "usermath1");
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ConectaDAO: " + erro.getMessage());
        }
        return conn;
    }
}