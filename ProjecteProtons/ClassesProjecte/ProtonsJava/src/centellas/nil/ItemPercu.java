package centellas.nil;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Transient;

/**
 * Created by Usuari on 19/5/2017.
 */
@NamedQueries({@NamedQuery(name = "ItemPercu.getInventari", query = "select i from ItemPercu i")})
@Entity
@Table(name = "item")
public class ItemPercu implements Serializable, Cloneable{
    @Id
    @TableGenerator(name = "comptadorsProtons", table = "comptadors",
        pkColumnName = "TAULA",
        valueColumnName = "COMPTADOR", pkColumnValue = "items", 
        allocationSize = 1, initialValue=1)
    @GeneratedValue(strategy=GenerationType.TABLE, generator="comptadorsProtons")
    @Column(name = "it_id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "it_nom", length = 100, nullable = false)
    private String nom;
    @Column(name = "it_marca", length = 100)
    private String marca;
    @Column(name = "it_model", length = 100)
    private String model;
    @Basic(optional = false)
    @Column(name = "it_quantitat", nullable = false)
    private Integer quantitat;
    @Column (name="it_foto", columnDefinition="MEDIUMBLOB")
    private byte[]foto;
   
    @Basic(optional = false)
    @Column(name = "it_tipus", length= 1, nullable = false)
    private String tipus;

    @OneToMany(mappedBy = "itemPercu")
    private List<Peticio> llistaPeticionsUsers = new ArrayList();
    
    protected ItemPercu(){
        
    }

    public ItemPercu(Integer id, String nom, Integer quantitat, String tipus) {
        this.id = id;
        this.nom = nom;
        this.quantitat = quantitat;
        this.tipus = tipus;
    }
    
    

    public Integer getId() {
        return id;
    }

    private void setId(Integer id) {
        if(id<0){
            throw new ItemPercuException("L'id no pot ser negatiu");
        }
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        if (nom == null || nom.compareTo("") == 0) {
            throw new ItemPercuException("El nom no pot ser null o cadena buida");
        }
        this.nom = nom;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getQuantitat() {
        return quantitat;
    }

    public void setQuantitat(Integer quantitat) {
        if(quantitat == null || quantitat <0){
            throw new ItemPercuException("La quantitat no pot ser null o negativa");
        }
        this.quantitat = quantitat;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public String getTipus() {
        return tipus;
    }

    public void setTipus(String tipus) {
        if(tipus == null || tipus.compareTo("") == 0){
            throw new ItemPercuException("El tipus no pot ser null o cadena buida");
        }
        if(!tipus.equals("I") && !tipus.equals("M")){
            throw new ItemPercuException("El tipus ha de ser: I (insturment) o M (material)");
        }
        this.tipus = tipus;
    }

    public List<Peticio> getLlistaPeticionsUsers() {
        return llistaPeticionsUsers;
    }

    public void addLlistaPeticionsUsers(Peticio p) {
        if (!llistaPeticionsUsers.contains(p)) {
            llistaPeticionsUsers.add(p);
            if (p.getItemPercu()!= this) {
                if (p.getItemPercu()!= null) {
                    /* Sempre és !=null excepte en el constructor de l'empleat */
                    p.getItemPercu().llistaPeticionsUsers.remove(p);
                }
                p.setItemPercu(this);
            }
        }
    }
    
    public void deleteDisponibilitatUser(Peticio p){
        if(llistaPeticionsUsers.contains(p)){
            p.setDeletePeticio(Boolean.TRUE);
        }
    }
    
    

    @Override
    public String toString() {
        return "ItemPercu{" + "id=" + id + ", nom=" + nom + ", marca=" + marca + ", model=" + model + ", quantitat=" + quantitat + ", foto=" + foto + ", tipus=" + tipus + ", llistaPeticionsUsers=" + llistaPeticionsUsers + '}';
    }
    
    

    @Override
    protected ItemPercu clone() throws CloneNotSupportedException {
        ItemPercu it = (ItemPercu)super.clone();
        return it; 
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.id);
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
        final ItemPercu other = (ItemPercu) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
    
    
    
    
}
