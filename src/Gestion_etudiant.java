import java.util.*;
import java.sql.*;
@SuppressWarnings("Duplicates")

public class Gestion_etudiant
{
    public static void main (String[] args) {
int admin=0;

        System.out.println("\n 1. ESPACE ADMIN\n 2. ESPACE PROFESSEUR\n 3. ESPACE ELEVE\n");
        Scanner sc = new Scanner(System.in);
        int choix = sc.nextInt();
        if (choix == 1) {
            if (Admin.SeConnecter() == true){
                System.out.println(" 1. Gestion Eleves \n 2. Gestion Cours\n 3. Afficher une promotion\n 4. Acceder à l'espace professeur\n 5. Editer une note");
            sc = new Scanner(System.in);
            int choix2 = sc.nextInt();
            if (choix2 == 1) {
                System.out.println("Voulez-vous :\n 1. Ajouter un étudiant \n 2. Mettre à jour un étudiant ");
                sc = new Scanner(System.in);
                int choix3 = sc.nextInt();
                if (choix3 == 1) {
                    Etudiant e = new Etudiant();
                }
                if (choix3 == 2) {
                    new ModifierEtudiant();
                }
            }
            if (choix2 == 2) {
                System.out.println("1. Ajouter un cours\n2. Association d'un cours à une promo\n3. Modifier un cours\n");
                sc = new Scanner(System.in);
                int choix3 = sc.nextInt();
                if (choix3 == 1) {
                    Cours c1 = new Cours();
                }
                if (choix3 == 2) {
                    Cours.Associer_promo();
                }
                if (choix3 == 3) {
                    Cours.Modifier_Cours();
                }

            }
            if (choix2 == 3) {
                try {
                    Class.forName("com.mysql.jdbc.Driver");

                    String url = "jdbc:mysql://localhost:8889/Projet_BDD";
                    String user = "root";
                    String passwd = "root";

                    Connection conn = DriverManager.getConnection(url, user, passwd);
                    ////////////////////////////////////////////////////
                    System.out.println("Veuillez saisir la promotion (L1/L2/L3/M1/M2)");
                    sc = new Scanner(System.in);
                    String promo = sc.nextLine();
                    PreparedStatement st = conn.prepareStatement("SELECT * FROM Etudiant WHERE Promo = ?");//On selectionne une colonne qui dépend d'une variable
                    st.setString(1, promo);
                    ResultSet rs = st.executeQuery();
                    int i = 1;
                    while (rs.next()) {
                        System.out.println(rs.getString("Nom_Etudiant")+" "+rs.getString("Prenom_Etudiant"));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (choix2==4){
                choix=2;
                admin=1;
            }
            if (choix2==5){
                Professeur.Editer_Note();
            }
        }
    }
        if (choix==2){
            if(admin==1|| Professeur.SeConnecter()==true){
                System.out.println("Vous pouvez :\n1. Ajouter un note\n2. Mettre à jour une note");
                sc = new Scanner(System.in);
                int choix2 = sc.nextInt();
                if (choix2==1){
                    Professeur.Ajouter_Note();
                }
                if (choix2==2){
                    Professeur.MiseAJour();
                }
            }
        }
        if (choix==3){
            if (admin==1 || Etudiant.SeConnecter()){
            Etudiant.Afficher_Note_Etudiant();
            }
        }
            }
        }




