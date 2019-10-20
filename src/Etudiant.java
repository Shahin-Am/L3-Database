import java.sql.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;
@SuppressWarnings("Duplicates")

public class Etudiant {
    static int matricule_etudiant;
    String nom;
    String prenom;
    String adresse;
    String cp;
    String ville;
    String tel;
    String mail;
    String classe;

    public Etudiant() {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            String url = "jdbc:mysql://localhost:8889/Projet_BDD";
            String user = "root";
            String passwd = "root";

            Connection conn = DriverManager.getConnection(url, user, passwd);

            System.out.println("-- AJOUT ETUDIANT --");
            System.out.println("Matricule étudiant ?");

            Scanner sc = new Scanner(System.in);
            int matricule_etudiant = sc.nextInt();
            System.out.println("Nom ?");
            sc = new Scanner(System.in);
            String nom_etudiant = sc.nextLine();
            System.out.println("Prénom ?");
            sc = new Scanner(System.in);
            String prenom_etudiant = sc.nextLine();
            System.out.println("Adresse ?");
            sc = new Scanner(System.in);
            String adresse_etudiant = sc.nextLine();
            System.out.println("Code postale ?");
            sc = new Scanner(System.in);
            String cp = sc.nextLine();
            System.out.println("Ville ?");
            sc = new Scanner(System.in);
            String ville = sc.nextLine();
            System.out.println("Numéro de téléphone ?");
            sc = new Scanner(System.in);
            String tel = sc.nextLine();
            System.out.println("Email ?");
            sc = new Scanner(System.in);
            String email = sc.nextLine();
            System.out.println("Promo ? (L1/L2/L3/M1/M2)");
            sc = new Scanner(System.in);
            String promo = sc.nextLine();

            Statement smt = conn.createStatement() ;
            int rs = smt.executeUpdate("INSERT INTO Etudiant(Matricule_Etudiant, Nom_Etudiant, Prenom_Etudiant, Adresse,Code_Postale,Ville,Email,Promo) VALUES ('"+matricule_etudiant+"','"+nom_etudiant+"', '"+prenom_etudiant+"','"+adresse_etudiant+"','"+cp+"','"+ville+"','"+email+"','"+promo+"');");


            System.out.println("\n--Identité--\n");
            System.out.println("Sexe ? (Tapez 0 pour femme ou 1 pour homme)");
            sc = new Scanner(System.in);
            int sexe = sc.nextInt();
            System.out.println("Date de naissance ? (dd/mm/aaaa)");
            sc = new Scanner(System.in);
            String date = sc.nextLine();
            System.out.println("Ville de naissance ?");
            sc = new Scanner(System.in);
            String ville_naissance = sc.nextLine();
            System.out.println("Pays de naissance ?");
            sc = new Scanner(System.in);
            String pays = sc.nextLine();
             smt = conn.createStatement() ;
             rs = smt.executeUpdate("INSERT INTO Identite(Matricule_Etudiant, Date_Naissance, Ville_Naissance, Pays_Naissance,Sexe) VALUES ('"+matricule_etudiant+"','"+date+"', '"+ville+"','"+pays+"','"+sexe+"');");

             System.out.println(prenom_etudiant+"a bien été ajouté(e)");
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
                    System.out.println("Entrer votre matricule");
                    Scanner sc = new Scanner(System.in);
                    int matricule = sc.nextInt();
                    System.out.println("Entrer votre mot de passe");
                    sc = new Scanner(System.in);
                    String mdp = sc.nextLine();
                    PreparedStatement st = conn.prepareStatement("SELECT * FROM Etudiant WHERE Matricule_Etudiant = ?");//On selectionne une colonne qui dépend d'une variable
                    st.setInt(1, matricule);
                    ResultSet rs = st.executeQuery();
                    rs.next();
                    if (mdp.equals(rs.getString("password_Etudiant"))) {
                        System.out.println("Bonjour M. " + rs.getString("Nom_Etudiant"));
                        matricule_etudiant=matricule;
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

        public static void Afficher_Note_Etudiant(){
            try {
                Class.forName("com.mysql.jdbc.Driver");

                String url = "jdbc:mysql://localhost:8889/Projet_BDD";
                String user = "root";
                String passwd = "root";

                Connection conn = DriverManager.getConnection(url, user, passwd);
                PreparedStatement st = conn.prepareStatement("SELECT a.Note_DE,a.Note_TP,a.Note_Projet,c.Nom_Cours,a.Edite,c.Coeff_Cours,c.Pourcentage_DE,c.Pourcentage_TP,c.Pourcentage_Projet FROM Assister a INNER JOIN Cours c ON a.Matricule_Etudiant=? AND a.Code_Cours = c.Code_Cours");//On selectionne une colonne qui dépend d'une variable
                st.setInt(1,matricule_etudiant);
                ResultSet rs = st.executeQuery();
                    System.out.println("Voici votre relevé de note :\n");
                    float moyenne_matiere=0;
                    float moyenne=0;
                    float i=0;
                NumberFormat nf = new DecimalFormat("0.##");

                while (rs.next()){
                        if(rs.getBoolean("Edite")==true){
                            System.out.println(rs.getString("Nom_Cours")+":\nDE: "+rs.getFloat("Note_DE")+"\nTP: "+rs.getFloat("Note_TP")+"\nProjet: "+rs.getFloat("Note_Projet")+"\n");
                        moyenne_matiere=rs.getFloat("Note_DE")*rs.getFloat("Pourcentage_DE")+rs.getFloat("Note_TP")*rs.getFloat("Pourcentage_TP")+rs.getFloat("Note_Projet")*rs.getFloat("Pourcentage_Projet");
                        moyenne=moyenne+moyenne_matiere*rs.getFloat("Coeff_Cours");
                        System.out.println("Moyenne en "+rs.getString("Nom_Cours")+" : "+nf.format(moyenne_matiere)+"\n");
                        i=i+rs.getFloat("Coeff_Cours");

                        }
                        else{
                            System.out.println("Vos note de "+rs.getString("Nom_Cours")+" n'ont pas encore été édité");
                        }
                    }
                    System.out.println("Moyenne générale : "+nf.format(moyenne/i));


            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }

    @Override
    public String toString() {
        return "Etudiant n° " +
                matricule_etudiant +
                "\nnom='" + nom + '\'' +
                "\nprenom='" + prenom + '\'' +
                "\nadresse='" + adresse + '\'' +
                "\ncp='" + cp + '\'' +
                "\nville='" + ville + '\'' +
                "\ntel='" + tel + '\'' +
                "\nmail='" + mail + '\''+
                "\npromo='" + classe + '\'';
    }
}
