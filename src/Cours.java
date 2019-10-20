import java.sql.*;
import java.util.Scanner;
@SuppressWarnings("Duplicates")

public class Cours {
    int code;
    String nom_cours;
    String description_cours;
    int promo;
    float coeff_cours;
    float pourcentage_DE;
    float pourcentage_TP;
    float pourcentage_PJ;
    int matricule_prof;

    public Cours() {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            String url = "jdbc:mysql://localhost:8889/Projet_BDD";
            String user = "root";
            String passwd = "root";

            Connection conn = DriverManager.getConnection(url, user, passwd);

            System.out.println("-- AJOUT COURS --");

            System.out.println(" Code cours ?");
            Scanner sc = new Scanner(System.in);
            int code = sc.nextInt();
            System.out.println("Nom du cours ?");
            sc = new Scanner(System.in);
             nom_cours = sc.nextLine();
            System.out.println("Description cours ?");
            sc = new Scanner(System.in);
             description_cours = sc.nextLine();
            System.out.println("Année du cours ?");
            sc = new Scanner(System.in);
             promo = sc.nextInt();
            System.out.println("Coeff du cours : "+nom_cours);
            sc = new Scanner(System.in);
            coeff_cours = sc.nextFloat();
            System.out.println(" Pourcentage DE");
            sc = new Scanner(System.in);
            pourcentage_DE = sc.nextFloat();
            System.out.println("Pourcentage TP ?");
            sc = new Scanner(System.in);
            pourcentage_TP = sc.nextFloat();
            System.out.println("Pourcentage PJ ?");
            sc = new Scanner(System.in);
            pourcentage_PJ = sc.nextFloat();
            System.out.println("Matricule prof ?");
            sc = new Scanner(System.in);
            matricule_prof = sc.nextInt();
            Statement smt = conn.createStatement() ;
            int rs = smt.executeUpdate("INSERT INTO Cours(Code_Cours, Nom_Cours, Description_Cours, Promo_Cours,Coeff_Cours,Pourcentage_DE,Pourcentage_TP,Pourcentage_Projet,Matricule_Prof) VALUES ('"+code+"','"+nom_cours+"', '"+description_cours+"','"+promo+"','"+coeff_cours+"','"+pourcentage_DE+"','"+pourcentage_TP+"','"+pourcentage_PJ+"','"+matricule_prof+"');");


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void Associer_promo(){
        try{
            Class.forName("com.mysql.jdbc.Driver");

            String url = "jdbc:mysql://localhost:8889/Projet_BDD";
            String user = "root";
            String passwd = "root";

            Connection conn = DriverManager.getConnection(url, user, passwd);

            System.out.println("Quel est le code du cours concerné ?");
            Scanner sc = new Scanner(System.in);
            int code_cours = sc.nextInt();
            PreparedStatement st = conn.prepareStatement("SELECT * FROM Cours WHERE Code_Cours = ?");//On selectionne une colonne qui dépend d'une variable
            st.setInt(1, code_cours);
            ResultSet rs = st.executeQuery();
            rs.next();
            System.out.println("Le cours : "+rs.getString("Nom_Cours")+" sera associé à quelle promo ?");
             sc = new Scanner(System.in);
            int promo = sc.nextInt();
            st = conn.prepareStatement("UPDATE Cours SET Promo_Cours=? WHERE Code_Cours=? ;");
            st.setInt(1, promo);
            st.setInt(2, code_cours);
            System.out.println("Le cours : "+rs.getString("Nom_Cours")+" a été associé à la promo "+promo);
            st.executeUpdate();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void Modifier_Cours(){
        try {
            Class.forName("com.mysql.jdbc.Driver");

            String url = "jdbc:mysql://localhost:8889/Projet_BDD";
            String user = "root";
            String passwd = "root";

            Connection conn = DriverManager.getConnection(url, user, passwd);

            System.out.println("Quelle est le code du cours ?");
            Scanner sc = new Scanner(System.in);
            int code = sc.nextInt();

            int choix3=1;
            while (choix3!=0) {
                PreparedStatement st = conn.prepareStatement("SELECT * FROM Cours WHERE Code_Cours = ?");//On selectionne une colonne qui dépend d'une variable
                st.setInt(1, code);
                ResultSet rs = st.executeQuery();
                rs.next();
            System.out.println("1. Nom du cours : "+rs.getString("Nom_Cours"));
            System.out.println("2. Description du cours : "+rs.getString("Description_Cours"));
            System.out.println("3. Coefficient : "+rs.getString("Coeff_Cours"));
            System.out.println("4. Pourcentage DE : "+rs.getString("Pourcentage_DE"));
            System.out.println("5. Pourcentage TP : "+rs.getString("Pourcentage_TP"));
            System.out.println("6. Pourcentage PJ : "+rs.getString("Pourcentage_Projet"));
                PreparedStatement st2 = conn.prepareStatement("SELECT Nom_Prof,Prenom_Prof FROM Professeurs WHERE Matricule_Prof = ?");//On selectionne une colonne qui dépend d'une variable
                st2.setInt(1, rs.getInt("Matricule_Prof"));
                ResultSet rs2 = st2.executeQuery();
                rs2.next();
            System.out.println("7. Professeur : "+rs2.getString(1)+" "+rs2.getString(2));

                System.out.println("Tapez 0 pour quitter");

                System.out.println("Que voulez-vous modifier ?");
                sc = new Scanner(System.in);
                choix3 = sc.nextInt();
                if (choix3 == 1) {
                    System.out.println("Entrer le nouveau nom du cours");
                    sc = new Scanner(System.in);
                    String nom = sc.nextLine();
                    st = conn.prepareStatement("UPDATE Cours SET Nom_Cours=? WHERE Code_Cours=? ;");
                    st.setString(1, nom);
                    st.setInt(2, code);
                    st.executeUpdate();
                }
                if (choix3 == 2) {
                    System.out.println("Entrer la nouvelle description du cours");
                    sc = new Scanner(System.in);
                    String describe = sc.nextLine();
                    st = conn.prepareStatement("UPDATE Cours SET Description_Cours=? WHERE Code_Cours=? ;");
                    st.setString(1, describe);
                    st.setInt(2, code);
                    st.executeUpdate();
                }
                if (choix3 == 3) {
                    System.out.println("Entrer le nouveau coefficient du cours");
                    sc = new Scanner(System.in);
                    float coeff = sc.nextFloat();
                    st = conn.prepareStatement("UPDATE Cours SET Coeff_Cours=? WHERE Code_Cours=? ;");
                    st.setFloat(1, coeff);
                    st.setFloat(2, code);
                    st.executeUpdate();
                }
                if (choix3 == 4) {
                    System.out.println("Entrer le nouveau pourcentage du DE");
                    sc = new Scanner(System.in);
                    float DE = sc.nextFloat();
                    st = conn.prepareStatement("UPDATE Cours SET Pourcentage_DE=? WHERE Code_Cours=? ;");
                    st.setFloat(1, DE);
                    st.setFloat(2, code);
                    st.executeUpdate();
                }
                if (choix3 == 5) {
                    System.out.println("Entrer le nouveau pourcentage du TP");
                    sc = new Scanner(System.in);
                    float TP = sc.nextFloat();
                    st = conn.prepareStatement("UPDATE Cours SET Pourcentage_TP=? WHERE Code_Cours=? ;");
                    st.setFloat(1, TP);
                    st.setFloat(2, code);
                    st.executeUpdate();
                }
                if (choix3 == 6) {
                    System.out.println("Entrer le nouveau pourcentage du projet");
                    sc = new Scanner(System.in);
                    float PJ = sc.nextFloat();
                    st = conn.prepareStatement("UPDATE Cours SET Pourcentage_Projet=? WHERE Code_Cours=? ;");
                    st.setFloat(1, PJ);
                    st.setFloat(2, code);
                    st.executeUpdate();
                }
                if (choix3==7){
                    System.out.println("Entrer le matricule du professeur de ce cours");
                    sc = new Scanner(System.in);
                    String nom = sc.nextLine();
                    st = conn.prepareStatement("UPDATE Cours SET Description_Cours=? WHERE Code_Cours=? ;");
                    st.setString(1, nom);
                    st.setInt(2, code);
                    st.executeUpdate();

                }

            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
