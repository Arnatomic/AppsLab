package centellas.nil;


import java.io.Serializable;
import java.lang.reflect.Array;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Transient;


/**
 * Created by Usuari on 19/5/2017.
 */
@NamedQueries({@NamedQuery(name = "User.getUser", query = "select u from User u where u.id = ?1"),
               @NamedQuery(name = "User.getUsers", query = "select u from User u"),
               @NamedQuery(name = "User.ferLogin", query = "select u.id from User u where u.login = ?1 and u.password = ?2")
             })
@Entity
@Table(name="usuari")
public class User implements Cloneable, Serializable {
    @Id
    @TableGenerator(name = "comptadorsProtons", table = "comptadors",
        pkColumnName = "TAULA",
        valueColumnName = "COMPTADOR", pkColumnValue = "usuaris", 
        allocationSize = 1, initialValue=1)
    @GeneratedValue(strategy=GenerationType.TABLE, generator="comptadorsProtons")
    @Column(name="usr_id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "usr_nom", length = 100, nullable = false)
    private String nom;
    @Basic(optional = false)
    @Column(name = "usr_cognoms", length = 100, nullable = false)
    private String cognoms;
    @Basic(optional = false)
    @Column(name = "usr_login", length = 100, nullable = false)
    private String login;
    @Basic(optional = false)
    @Column(name = "usr_password", length = 100, nullable = false)
    private String password;
    @Column(name = "usr_foto", columnDefinition="MEDIUMBLOB")
    private byte[] foto;
    @Column(name = "usr_admin")
    private Boolean admin;
    
    @OneToMany(mappedBy = "usuari")
    private List<Disponibilitat> llistaDisponibilitatsSortida = new ArrayList();;
    @OneToMany(mappedBy = "usuari")
    private List<Peticio> llistaPeticionsItemsPercu = new ArrayList();;
    
    protected User(){
        
    }

    public User(Integer id, String nom, String cognoms, String login, String password) {
        //setId(id);
        setNom(nom);
        setCognoms(cognoms);
        setLogin(login);
        setPassword(password);
    }

    public Integer getId() {
        return id;
    }

//    private void setId(Integer id) {
//        if(id<0){
//            throw new UserException("L'id no pot ser negatiu"); 
//        }
//        this.id = id;
//    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        if (nom == null || nom.compareTo("") == 0) {
            throw new UserException("El nom no pot ser null o cadena buida");
        }
        this.nom = nom;
    }

    public String getCognoms() {
        return cognoms;
    }

    public void setCognoms(String cognoms) {
        if (cognoms == null || cognoms.compareTo("") == 0) {
            throw new UserException("Els cognoms no poden ser null o cadena buida");
        }
        this.cognoms = cognoms;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        if (login == null || login.compareTo("") == 0) {
            throw new UserException("El login no pot ser null o cadena buida");
        }
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (login == null || login.compareTo("") == 0) {
            throw new UserException("El login no pot ser null o cadena buida");
        }
        this.password = password;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto.clone();
    }

    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        if(admin == null){
            throw new UserException("El camp admin booleà no pot ser null");
        }
        this.admin = admin;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", nom=" + nom + ", cognoms=" + cognoms + ", login=" + login + ", password=" + password + ", foto=" + foto + ", admin=" + admin + ", llistaDisponibilitatsSortida=" + llistaDisponibilitatsSortida + ", llistaPeticionsItemsPercu=" + llistaPeticionsItemsPercu + '}';
    }
    
    public List<Disponibilitat> getllistaDisponibilitatsSortida() {
        return llistaDisponibilitatsSortida;
    }
    
    public void addDisponibilitatSortida(Disponibilitat d) {
        if (!llistaDisponibilitatsSortida.contains(d)) {
            llistaDisponibilitatsSortida.add(d);
            if (d.getUsuari() != this) {
                if (d.getUsuari()!= null) {
                    /* Sempre és !=null excepte en el constructor de l'empleat */
                    d.getUsuari().llistaDisponibilitatsSortida.remove(d);
                }
                d.setUsuari(this);
            }
        }
    }
    
    public void deleteDisponibilitatSortida(Disponibilitat d){
        if(llistaDisponibilitatsSortida.contains(d)){
            d.setDeleteDispo(Boolean.TRUE);
        }
    }

    public List<Peticio> getllistaPeticionsItemsPercu() {
        return llistaPeticionsItemsPercu;
    }
    
    public void addDisponibilitatItemPercu(Peticio p) {
        if (!llistaPeticionsItemsPercu.contains(p)) {
            llistaPeticionsItemsPercu.add(p);
            if (p.getUsuari()!= this) {
                if (p.getUsuari()!= null) {
                    /* Sempre és !=null excepte en el constructor de l'empleat */
                    p.getUsuari().llistaPeticionsItemsPercu.remove(p);
                }
                p.setUsuari(this);
            }
        }
    }

    

    @Override
    protected User clone() throws CloneNotSupportedException {
        User u = (User)super.clone();
        return u;
    }
    
    

}
