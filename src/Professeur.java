import java.sql.*;
import java.util.Scanner;
@SuppressWarnings("Duplicates")

public class Professeur {

    static int matricule_prof;

    public static void MiseAJour(){
        try {
            Class.forName("com.mysql.jdbc.Driver");

            String url = "jdbc:mysql://localhost:8889/Projet_BDD";
            String user = "root";
            String passwd = "root";

            Connection conn = DriverManager.getConnection(url, user, passwd);
            PreparedStatement st = conn.prepareStatement("SELECT Promo_Cours,Nom_Cours,Code_Cours FROM Cours WHERE Matricule_Prof = ?");//On selectionne une colonne qui dépend d'une variable
            st.setInt(1, matricule_prof);
            ResultSet rs = st.executeQuery();
            //rs.next();
            System.out.println("Vos cours :");
            while(rs.next()){
                System.out.println(rs.getString("Nom_Cours")+" promo : "+rs.getString("Promo_Cours")+" matricule : "+rs.getString("Code_Cours"));
            }
            System.out.println("\nVeuillez entrer le matricule du cours concerné :");
            Scanner sc = new Scanner(System.in);
            int choisir_matricule = sc.nextInt();
            PreparedStatement st2 = conn.prepareStatement("SELECT * FROM Cours WHERE Code_Cours = ?");//On selectionne une colonne qui dépend d'une variable
            st2.setInt(1, choisir_matricule);
            ResultSet rs2 = st2.executeQuery();
            rs2.next();
            String promo_concerne = rs2.getString("Promo_Cours");

            PreparedStatement st3 = conn.prepareStatement("SELECT e.Nom_Etudiant,e.Prenom_Etudiant,e.Matricule_Etudiant FROM Etudiant e INNER JOIN Assister a ON e.Matricule_Etudiant = a.Matricule_Etudiant AND a.Code_Cours=?");//On selectionne une colonne qui dépend d'une variable
            st3.setInt(1,choisir_matricule);
            ResultSet rs3 = st3.executeQuery();
            System.out.println("\nVoici la liste des élèves ayant déjà des notes dans ce cours :\n");

            while (rs3.next()){
                System.out.println(rs3.getString("Nom_Etudiant")+" "+rs3.getString("Prenom_Etudiant")+" matricule : "+rs3.getString("Matricule_Etudiant"));
            }
            System.out.println("\nVeuillez saisir le matricule de l'édudiant");
            sc = new Scanner(System.in);
            int matricule_eleve = sc.nextInt();
            PreparedStatement st4 = conn.prepareStatement("SELECT * FROM Assister WHERE Matricule_Etudiant = ? AND Code_Cours=?");//On selectionne une colonne qui dépend d'une variable
            st4.setInt(1, matricule_eleve);
            st4.setInt(2, choisir_matricule);
            ResultSet rs4 = st4.executeQuery();
            rs4.next();
            if (rs4.getBoolean("edite")==false) {
                System.out.println("Voici ses notes :");
                System.out.println("DE : " + rs4.getFloat("Note_DE"));
                System.out.println("TP : " + rs4.getFloat("Note_TP"));
                System.out.println("Projet : " + rs4.getFloat("Note_Projet"));
                System.out.println("\nQue voulez vous modifier ?\n1. DE\n2. TP\n3. Projet");
                sc = new Scanner(System.in);
                int choix = sc.nextInt();
                if (choix == 1) {
                    System.out.println("Quelle est sa nouvelle note au DE ?");
                    sc = new Scanner(System.in);
                    float note = sc.nextFloat();
                    st = conn.prepareStatement("UPDATE Assister SET Note_DE=? WHERE Matricule_Etudiant=? ;");
                    st.setFloat(1, note);
                    st.setInt(2, matricule_eleve);
                    st.executeUpdate();
                    System.out.println("Sa note a bien été modifié !");
                }
                if (choix == 2) {
                    System.out.println("Quelle est sa nouvelle note au TP ?");
                    sc = new Scanner(System.in);
                    float note = sc.nextFloat();
                    st = conn.prepareStatement("UPDATE Assister SET Note_TP=? WHERE Matricule_Etudiant=? ;");
                    st.setFloat(1, note);
                    st.setInt(2, matricule_eleve);
                    st.executeUpdate();
                    System.out.println("Sa note a bien été modifié !");
                }
                if (choix == 3) {
                    System.out.println("Quelle est sa nouvelle note au projet ?");
                    sc = new Scanner(System.in);
                    float note = sc.nextFloat();
                    st = conn.prepareStatement("UPDATE Assister SET Note_Projet=? WHERE Matricule_Etudiant=? ;");
                    st.setFloat(1, note);
                    st.setInt(2, matricule_eleve);
                    st.executeUpdate();
                    System.out.println("Sa note a bien été modifié !");
                }
            }
            else{
                System.out.println("La note a déjà été édité");
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void Ajouter_Note(){
        try {
            Class.forName("com.mysql.jdbc.Driver");

            String url = "jdbc:mysql://localhost:8889/Projet_BDD";
            String user = "root";
            String passwd = "root";

            Connection conn = DriverManager.getConnection(url, user, passwd);
            PreparedStatement st = conn.prepareStatement("SELECT Promo_Cours,Nom_Cours,Code_Cours FROM Cours WHERE Matricule_Prof = ?");//On selectionne une colonne qui dépend d'une variable
            st.setInt(1, matricule_prof);
            ResultSet rs = st.executeQuery();
            //rs.next();
            System.out.println("Vos cours :");
            while(rs.next()){
                System.out.println(rs.getString("Nom_Cours")+" promo : "+rs.getString("Promo_Cours")+" matricule : "+rs.getString("Code_Cours"));
            }
            System.out.println("Veuillez entrer le matricule du cours concerné :");
            Scanner sc = new Scanner(System.in);
            int choisir_matricule = sc.nextInt();
            PreparedStatement st2 = conn.prepareStatement("SELECT * FROM Cours WHERE Code_Cours = ?");//On selectionne une colonne qui dépend d'une variable
            st2.setInt(1, choisir_matricule);
            ResultSet rs2 = st2.executeQuery();
            rs2.next();
            String promo_concerne = rs2.getString("Promo_Cours");

            PreparedStatement st3 = conn.prepareStatement("SELECT * FROM Etudiant WHERE promo = ?");//On selectionne une colonne qui dépend d'une variable
            st3.setString(1, promo_concerne);
            ResultSet rs3 = st3.executeQuery();
            System.out.println("\nVoici la liste des élèves de ce cours :\n");

            while (rs3.next()){
                System.out.println(rs3.getString("Nom_Etudiant")+" "+rs3.getString("Prenom_Etudiant")+" matricule : "+rs3.getString("Matricule_Etudiant"));
            }
            System.out.println("Veuillez saisir le matricule de l'édudiant");
            sc = new Scanner(System.in);
            int matricule_eleve = sc.nextInt();
            System.out.println("Quelle est sa note de DE ?");
            sc = new Scanner(System.in);
            int DE = sc.nextInt();
            System.out.println("Quelle est sa note de TP ?");
            sc = new Scanner(System.in);
            int TP = sc.nextInt();
            System.out.println("Quelle est sa note de projet ?");
            sc = new Scanner(System.in);
            int PJ = sc.nextInt();
            Statement smt = conn.createStatement() ;
            int rs4 = smt.executeUpdate("INSERT INTO Assister(Code_Cours, Matricule_Etudiant, Note_DE, Note_TP,Note_Projet) VALUES ('"+choisir_matricule+"','"+matricule_eleve+"', '"+DE+"','"+TP+"','"+PJ+"');");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean SeConnecter(){
        try {
            Class.forName("com.mysql.jdbc.Driver");

            String url = "jdbc:mysql://localhost:8889/Projet_BDD";
            String user = "root";
            String passwd = "root";

            Connection conn = DriverManager.getConnection(url, user, passwd);
            int x=0;
            while (x==0) {
                System.out.println("--PAGE DE CONNEXION--\n");
                System.out.println("Entrer votre matricule professeur");
                Scanner sc = new Scanner(System.in);
                int matricule = sc.nextInt();
                matricule_prof=matricule;
                System.out.println("Entrer votre mot de passe");
                sc = new Scanner(System.in);
                String mdp = sc.nextLine();
                PreparedStatement st = conn.prepareStatement("SELECT * FROM Professeurs WHERE Matricule_Prof = ?");//On selectionne une colonne qui dépend d'une variable
                st.setInt(1, matricule);
                ResultSet rs = st.executeQuery();
                rs.next();
                if (mdp.equals(rs.getString("password"))) {
                    System.out.println("Bonjour M. " + rs.getString("Nom_Prof"));
                    return true;
                }
                System.out.println("Matricule ou mot de passe incorrect");
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return false;

    }
    public static void Editer_Note(){
        try {
            Class.forName("com.mysql.jdbc.Driver");

            String url = "jdbc:mysql://localhost:8889/Projet_BDD";
            String user = "root";
            String passwd = "root";

            Connection conn = DriverManager.getConnection(url, user, passwd);

            System.out.println("Quelle promo?\n1. L1\n2. L2\n3. L3\n4. M1\n5. M2\n");
            Scanner sc = new Scanner(System.in);
            int promo = sc.nextInt();
            String promo2="0";
            switch (promo){
                case 1:promo2="L1";break;
                case 2:promo2="L2";break;
                case 3:promo2="L3";break;
                case 4:promo2="M1";break;
                case 5:promo2="M2";break;
            }

            PreparedStatement st = conn.prepareStatement("SELECT Promo_Cours,Nom_Cours,Code_Cours FROM Cours WHERE Promo_Cours=?");//On selectionne une colonne qui dépend d'une variable
            st.setString(1,promo2);
            ResultSet rs = st.executeQuery();
            System.out.println(rs.getRow());
            System.out.println("Liste des cours :\n");
            while(rs.next()){
                System.out.println(rs.getString("Nom_Cours")+" promo : "+rs.getString("Promo_Cours")+" matricule : "+rs.getString("Code_Cours"));
            }
            System.out.println("\nVeuillez entrer le matricule du cours concerné :");
             sc = new Scanner(System.in);
            int choisir_matricule = sc.nextInt();
            PreparedStatement st2 = conn.prepareStatement("SELECT * FROM Cours WHERE Code_Cours = ?");//On selectionne une colonne qui dépend d'une variable
            st2.setInt(1, choisir_matricule);
            ResultSet rs2 = st2.executeQuery();
            rs2.next();
            String promo_concerne = rs2.getString("Promo_Cours");

            PreparedStatement st3 = conn.prepareStatement("SELECT e.Nom_Etudiant,e.Prenom_Etudiant,e.Matricule_Etudiant FROM Etudiant e INNER JOIN Assister a ON e.Matricule_Etudiant = a.Matricule_Etudiant AND a.Code_Cours=?");//On selectionne une colonne qui dépend d'une variable
            st3.setInt(1,choisir_matricule);
            ResultSet rs3 = st3.executeQuery();
            System.out.println("\nVoici la liste des élèves ayant déjà des notes dans ce cours :\n");

            while (rs3.next()){
                System.out.println(rs3.getString("Nom_Etudiant")+" "+rs3.getString("Prenom_Etudiant")+" matricule : "+rs3.getString("Matricule_Etudiant"));
            }
            System.out.println("\nVeuillez saisir le matricule de l'édudiant");
            sc = new Scanner(System.in);
            int matricule_eleve = sc.nextInt();
            PreparedStatement st4 = conn.prepareStatement("SELECT * FROM Assister WHERE Matricule_Etudiant = ? AND Code_Cours=?");//On selectionne une colonne qui dépend d'une variable
            st4.setInt(1, matricule_eleve);
            st4.setInt(2, choisir_matricule);
            ResultSet rs4 = st4.executeQuery();
            rs4.next();
            System.out.println("Voici ses notes :");
            System.out.println("DE : "+rs4.getFloat("Note_DE"));
            System.out.println("TP : "+rs4.getFloat("Note_TP"));
            System.out.println("Projet : "+rs4.getFloat("Note_Projet"));

            System.out.println("Tapez 1 pour editer ce bulletin");
            sc = new Scanner(System.in);
            int ed = sc.nextInt();
            if(ed==1){
                st = conn.prepareStatement("UPDATE Assister SET Edite=? WHERE Matricule_Etudiant=? AND Code_Cours=?;");
                st.setBoolean(1, true);
                st.setInt(2, matricule_eleve);
                st.setInt(3, choisir_matricule);
                st.executeUpdate();
                System.out.println("Sa note est publié !");
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
