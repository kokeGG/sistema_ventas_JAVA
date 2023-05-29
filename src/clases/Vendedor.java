package clases;

/**
 *
 * @author koke
 */
public class Vendedor {
    //atributos
    String pass, nom, user;
    int id;
    
    //Constructor

    public Vendedor() {
    }

    public Vendedor(String pass, String nom, String user, int id) {
        this.pass = pass;
        this.nom = nom;
        this.user = user;
        this.id = id;
    }
    
    //Metodos de Acceso

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
}
