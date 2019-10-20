import java.util.*;
import java.sql.*;

public class ModifierEtudiant {
    public ModifierEtudiant() {
        System.out.println("-- MODIFIER ETUDIANT --");

        try {
            Class.forName("com.mysql.jdbc.Driver");

            String url = "jdbc:mysql://localhost:8889/Projet_BDD";
            String user = "root";
            String passwd = "root";

            Connection conn = DriverManager.getConnection(url, user, passwd);

            System.out.println("Veuillez saisir le N° de matricule de l'étudiant");
            Scanner sc = new Scanner(System.in);
            int matricule_etudiant1 = sc.nextInt();
            PreparedStatement st = conn.prepareStatement("SELECT * FROM Etudiant WHERE Matricule_Etudiant = ?");//On selectionne une colonne qui dépend d'une variable
            st.setInt(1, matricule_etudiant1);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                System.out.print("Etudiant ");

                System.out.println("Nom : "+rs.getString("Nom_Etudiant")+" ");
                System.out.println("Prénom : "+rs.getString("Prenom_Etudiant")+" ");
                System.out.println("Adresse : "+rs.getString("Adresse")+" ");
                System.out.println("Code Postale : "+rs.getString("Code_Postale")+" ");
                System.out.println("Ville : "+rs.getString("Ville")+" ");
                System.out.println("Mail : "+rs.getString("Email")+" ");
                System.out.println("Classe : "+rs.getString("Promo"));

                System.out.println("Que voulez-vous modifier ?");
                System.out.println("1.Nom\n2.Prénom\n3.Adresse\n4.Code Postal\n5.Ville\n6.Telephone\n7.Mail\n8.Classe");
                sc = new Scanner(System.in);
                int choix = sc.nextInt();

                if(choix==1){
                    System.out.println("Nouveau Nom ?");
                    sc = new Scanner(System.in);
                    String nv_nom = sc.nextLine();
                    st = conn.prepareStatement("UPDATE Etudiant SET Nom_Etudiant=? WHERE Matricule_Etudiant=? ;");
                    st.setString(1, nv_nom);
                    st.setInt(2, matricule_etudiant1);

                    int i =st.executeUpdate();
                }
                if(choix==2){
                    System.out.println("Nouveau Prénom ?");
                    sc = new Scanner(System.in);
                    String nv_prenom = sc.nextLine();
                    st = conn.prepareStatement("UPDATE Etudiant SET Prenom_Etudiant=? WHERE Matricule_Etudiant=? ;");
                    st.setString(1, nv_prenom);
                    st.setInt(2, matricule_etudiant1);

                    int i =st.executeUpdate();
                }
                if(choix==3){
                    System.out.println("Nouvelle adresse ?");
                    sc = new Scanner(System.in);
                    String nv_adresse = sc.nextLine();
                    st = conn.prepareStatement("UPDATE Etudiant SET Adresse=? WHERE Matricule_Etudiant=? ;");
                    st.setString(1, nv_adresse);
                    st.setInt(2, matricule_etudiant1);

                    int i =st.executeUpdate();
                }
                if(choix==4){
                    System.out.println("Nouveau code postale ?");
                    sc = new Scanner(System.in);
                    String nv_cp = sc.nextLine();
                    st = conn.prepareStatement("UPDATE Etudiant SET Code_Postale=? WHERE Matricule_Etudiant=? ;");
                    st.setString(1, nv_cp);
                    st.setInt(2, matricule_etudiant1);

                    int i =st.executeUpdate();
                }
                if(choix==5){
                    System.out.println("Nouvelle ville ?");
                    sc = new Scanner(System.in);
                    String nv_ville = sc.nextLine();
                    st = conn.prepareStatement("UPDATE Etudiant SET Ville=? WHERE Matricule_Etudiant=? ;");
                    st.setString(1, nv_ville);
                    st.setInt(2, matricule_etudiant1);

                    int i =st.executeUpdate();
                }
                if(choix==6){
                    System.out.println("Nouveau N° téléphone ?");
                    sc = new Scanner(System.in);
                    String nv_tel = sc.nextLine();
                    st = conn.prepareStatement("UPDATE Etudiant SET Telephone=? WHERE Matricule_Etudiant=? ;");
                    st.setString(1, nv_tel);
                    st.setInt(2, matricule_etudiant1);

                    int i =st.executeUpdate();
                }
                if(choix==7){
                    System.out.println("Nouveau email ?");
                    sc = new Scanner(System.in);
                    String nv_email = sc.nextLine();
                    st = conn.prepareStatement("UPDATE Etudiant SET Email=? WHERE Matricule_Etudiant=? ;");
                    st.setString(1, nv_email);
                    st.setInt(2, matricule_etudiant1);

                    int i =st.executeUpdate();
                }
                if(choix==8){
                    System.out.println("Nouvelle promo ?");
                    sc = new Scanner(System.in);
                    String nv_classe = sc.nextLine();
                    st = conn.prepareStatement("UPDATE Etudiant SET Classe=? WHERE Matricule_Etudiant=? ;");
                    st.setString(1, nv_classe);
                    st.setInt(2, matricule_etudiant1);

                    int i =st.executeUpdate();
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

}
