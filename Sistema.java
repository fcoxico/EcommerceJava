import java.util.HashMap;
import java.util.Map;

public class Sistema {
    private Map<String, String> admins = new HashMap<>();
    private Map<String, String> users = new HashMap<>();
    private DatabaseManager databaseManager;


    public Sistema() {
        // Inicializar com alguns dados para teste
        admins.put("admin", "admin");
        users.put("user", "user");
    }

    public Sistema(String databaseUrl) {
        this.databaseManager = new DatabaseManager(databaseUrl);
    }

    public DatabaseManager getDatabaseManager() {
        return this.databaseManager;
    }

    public boolean login(String username, String password, boolean isAdmin) {
        if (isAdmin) {
            return password.equals(admins.get(username));
        } else {
            return password.equals(users.get(username));
        }
    }
}
