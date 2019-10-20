import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;
@SuppressWarnings("Duplicates")

public class Admin {

public static boolean SeConnecter(){
    try {
        Class.forName("com.mysql.jdbc.Driver");

        String url = "jdbc:mysql://localhost:8889/Projet_BDD";
        String user = "root";
        String passwd = "root";

        Connection conn = DriverManager.getConnection(url, user, passwd);

        System.out.println("id?");
        Scanner sc=new Scanner(System.in);
        String id=sc.nextLine();
        System.out.println("Mot de passe?");
        sc=new Scanner(System.in);
        String password=sc.nextLine();
        PreparedStatement st = conn.prepareStatement("SELECT * FROM Admin WHERE id = ?");//On selectionne une colonne qui dépend d'une variable
        st.setString(1, id);
        ResultSet rs = st.executeQuery();
        rs.next();

        if (password.equals(rs.getString("password_admin"))){
            System.out.println("Bonjour patron !\n");
            return true;
        }
    }
    catch (Exception e) {
        e.printStackTrace();
    }
return false;
}
}

