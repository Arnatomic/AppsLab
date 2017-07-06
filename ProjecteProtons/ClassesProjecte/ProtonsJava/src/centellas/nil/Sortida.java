package centellas.nil;

import java.awt.print.Book;
import java.io.Serializable;
import java.math.BigDecimal;
import java.security.PrivateKey;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
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
@NamedQueries({@NamedQuery(name = "Sortida.filtre", query = "select s from Sortida s where s.deleteSortida = ?1 and (?2='' or s.nom like ?2) and (?3 is null or s.dataInicial >= ?3)"),
               @NamedQuery(name = "Sortida.getSortides", query = "select s from Sortida s where s.deleteSortida = ?1")
             })
@Entity
@Table(name = "sortida")
public class Sortida implements Cloneable, Serializable{
    @Id
    @TableGenerator(name = "comptadorsProtons", table = "comptadors",
        pkColumnName = "TAULA",
        valueColumnName = "COMPTADOR", pkColumnValue = "sortides", 
        allocationSize = 1, initialValue=1)
    @GeneratedValue(strategy=GenerationType.TABLE, generator="comptadorsProtons")
    @Column(name = "sor_id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "sor_nom", length = 100, nullable = false)
    private String nom;
    @Basic(optional = false)
    @Column(name = "sor_lloc", length = 100, nullable = false)
    private String lloc;
    @Basic(optional = false)
    @Column(name = "sor_data_inicial", nullable = false)
    private Date dataInicial;
    @Basic(optional = false)
    @Column(name = "sor_data_final", nullable = false)
    private Date dataFinal;
    @Basic(optional = false)
    @Column (name = "sor_preu", precision=10, scale=2, nullable = false)
    private BigDecimal preu;
    @Column(name="sor_maps", length= 300)
    private String maps;
    @Column(name="sor_observacions", length= 500)
    private String observacions;
    @Column(name="sor_delete")
    private Boolean deleteSortida;
    @OneToMany(mappedBy = "sortida")
    private List<Disponibilitat> llistaDisponibilitatsUser = new ArrayList();
    
    protected Sortida(){
        
    }

    public Sortida(Integer id, String nom, String lloc, Date dataInicial, Date dataFinal, BigDecimal preu) {
        //setId(id);
        setNom(nom);
        setLloc(lloc);
        setDataInicial(dataInicial);
        setDataFinal(dataFinal);
        setPreu(preu);
        setDelete(Boolean.FALSE);
    }
    
     public Sortida(Integer id, String nom, String lloc, Date dataInicial, Date dataFinal, BigDecimal preu, String maps, String observacions) {
        //setId(id);
        setNom(nom);
        setLloc(lloc);
        setDataInicial(dataInicial);
        setDataFinal(dataFinal);
        setPreu(preu);
        setMaps(maps);
        setObservacions(observacions);
        setDelete(Boolean.FALSE);
    }


    public Integer getId() {
        return id;
    }

//    private void setId(Integer id) {
//        if(id<0){
//            throw new SortidaException("L'id no pot ser negatiu");
//        }
//        this.id = id;
//    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        if (nom == null || nom.compareTo("") == 0) {
//        if (nom==null || nom.length()==0) {
//        if (nom==null || nom.isEmpty()==true) {
//        if (nom==null || nom.isEmpty()) {
            throw new SortidaException("El nom no pot ser null o cadena buida");
        }
        this.nom = nom;
    }

    public String getLloc() {
        return lloc;
    }

    public void setLloc(String lloc) {
        if(lloc == null && lloc.compareTo("") == 0){
            throw new SortidaException("El lloc no pot ser null o cadena buida");
        }
        this.lloc = lloc;
    }

    public Date getDataInicial() {
        return (Date) dataInicial.clone();
    }

    public void setDataInicial(Date dataInicial) {
        if(dataInicial == null){
            throw new SortidaException("La data incial no pot ser null");
        }
        this.dataInicial = new Date(dataInicial.getTime());
    }

    public Date getDataFinal() {
        return (Date) dataFinal.clone();
    }

    public void setDataFinal(Date dataFinal) {
        if(dataFinal == null || dataFinal.before(this.dataInicial)){
            throw new SortidaException("La data final no pot ser null ni pot ser anterior a la inicial");
        }
        this.dataFinal = new Date(dataFinal.getTime());
    }

    public BigDecimal getPreu() {
        return preu;
    }

    public void setPreu(BigDecimal preu) {
        if(preu == null || preu.compareTo(BigDecimal.ZERO)<0){
            throw new SortidaException("El preu no pot ser null o inferior a 0");
        }
        this.preu = preu;
    }

    public String getMaps() {
        return maps;
    }

    public void setMaps(String maps) {
        this.maps = maps;
    }

    public String getObservacions() {
        return observacions;
    }

    public void setObservacions(String observacions) {
        this.observacions = observacions;
    }
    
    
    public Boolean getDelete() {
        return deleteSortida;
    }

    public void setDelete(Boolean delete) {
        for(Disponibilitat d : llistaDisponibilitatsUser){
            d.setDeleteDispo(Boolean.FALSE);
        }
        this.deleteSortida = delete;
    }

    @Override
    public String toString() {
        return "Sortida{" + "id=" + id + ", nom=" + nom + ", lloc=" + lloc + ", dataInicial=" + dataInicial + ", dataFinal=" + dataFinal + ", preu=" + preu + ", maps=" + maps + ", observacions=" + observacions + ", delete=" + deleteSortida + ", llistaDisponibilitatsUser=" + llistaDisponibilitatsUser + '}';
    }

    @Override
    protected Sortida clone() throws CloneNotSupportedException {
        Sortida s = (Sortida)super.clone();
        s.setDataInicial(dataInicial);
        s.setDataFinal(dataFinal);
        return s;
    }
    
    public List<Disponibilitat> getLlistaDisponibilitatsUser() {
        return llistaDisponibilitatsUser;
    }
    
    public void addDisponibilitatUser(Disponibilitat d) {
        if (!llistaDisponibilitatsUser.contains(d)) {
            llistaDisponibilitatsUser.add(d);
            if (d.getSortida() != this) {
                if (d.getSortida()!= null) {
                    /* Sempre és !=null excepte en el constructor de l'empleat */
                    d.getSortida().llistaDisponibilitatsUser.remove(d);
                }
                d.setSortida(this);
            }
        }
    }
    
    public void deleteDisponibilitatUser(Disponibilitat d){
        if(llistaDisponibilitatsUser.contains(d)){
            d.setDeleteDispo(Boolean.TRUE);
        }
    }
    

}
