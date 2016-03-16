import java.sql.*;

public class Main {
    public static final String USERNAME = "root";
    public static final String PASSWORD = "toor";
    public static final String SCHEMA = "sample";

    public static void main(String[] args) {
        System.out.println("H2 liquibase sample");
        try {
            Class.forName("org.h2.Driver");
            Connection con = DriverManager.getConnection("jdbc:h2:./h2/" + SCHEMA, USERNAME, PASSWORD);
            con.setAutoCommit(false);

            // insert data
            Statement stmt = con.createStatement();
            stmt.executeUpdate( "INSERT INTO users ( name ) " +
                    "VALUES ('Bernasconi'), ('Janus'), ('Artus'), ('Pektus'), ('Saktus')" );
            con.commit();

            // select data
            ResultSet rs = stmt.executeQuery("SELECT id_user, name FROM users");
            while (rs.next()) {
                System.out.println(rs.getInt("id_user") + ": " + rs.getString("name"));
            }
            stmt.close();
            con.close();
        }
        catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
    }
}
