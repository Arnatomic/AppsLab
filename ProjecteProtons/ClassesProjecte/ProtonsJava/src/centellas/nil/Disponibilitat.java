package centellas.nil;


import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * Created by Nil on 22/05/2017.
 */
@NamedQueries({@NamedQuery(name = "Disponibilitat.getDisponibilitatsUsuari", query = "select d from Disponibilitat d where d.usuari.id = ?1 and d.deleteDispo = ?2"),
               @NamedQuery(name = "Disponibilitat.getDisponibilitatsUnaSortida", query = "select d from Disponibilitat d where d.sortida.id = ?1 and d.deleteDispo = ?2"),
               @NamedQuery(name = "Disponibilitat.getDisponibilitat", query = "select d from Disponibilitat d where d.sortida.id = ?1 and d.usuari.id = ?2 and d.deleteDispo = ?3")
             })
@Entity
@Table(name = "usuari_sortida")
public class Disponibilitat implements Serializable {
    @EmbeddedId
    private DisponibilitatPK disponibilitatPK;
    @Column(name = "usrsor_data_conf")
    private Date dataConfirmacio;
    @Basic(optional = false)
    @Column(name = "usrsor_tipus_confirmacio", nullable = false)
    private String tipusConfirmacio;
    
    @Column(name= "usrsor_delete")
    private Boolean deleteDispo;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usrsor_usr_id", referencedColumnName="usr_id", nullable=false, insertable = false, updatable = false)
    User usuari;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usrsor_sor_id", referencedColumnName="sor_id", nullable=false, insertable = false, updatable = false)
    Sortida sortida;

    
    protected Disponibilitat(){
        
    }

    public Disponibilitat(User usuari, Sortida sortida, Date dataConfirmacio, String tipusConfirmacio) {
        setUsuari(usuari);
        setSortida(sortida);
        setDataConfirmacio(dataConfirmacio);
        setTipusConfirmacio(tipusConfirmacio);
        setDeleteDispo(Boolean.FALSE);
        disponibilitatPK = new DisponibilitatPK(sortida.getId(), usuari.getId());
    }

    public DisponibilitatPK getDisponibilitatPK() {
        return disponibilitatPK;
    }
    
    public User getUsuari() {
        return usuari;
    }

    public void setUsuari(User usuari) {
        if(usuari == null){
            throw new DisponibilitatException("No es pot assignar un usuari null");
        }
        if (this.usuari != usuari) {
            this.usuari = usuari;
            usuari.addDisponibilitatSortida(this);
        }
    }

    public Sortida getSortida() {
        return sortida;
    }

    public void setSortida(Sortida sortida) {
        if(sortida == null){
            throw new DisponibilitatException("No es pot assignar una sortida null");
        }
        if (this.sortida != sortida) {
            this.sortida = sortida;
            sortida.addDisponibilitatUser(this);
        }
    }

    public Date getDataConfirmacio() {
        return (Date) dataConfirmacio.clone();
    }

    public void setDataConfirmacio(Date dataConfirmacio) {
        if(dataConfirmacio == null){
            throw new SortidaException("La data de confiramció no pot ser null");
        }
        this.dataConfirmacio = new Date(dataConfirmacio.getTime());
    }

    public String getTipusConfirmacio() {
        return tipusConfirmacio;
    }

    public void setTipusConfirmacio(String tipusConfirmacio) {
        
        if(!tipusConfirmacio.equals("S") && !tipusConfirmacio.equals("N") && !tipusConfirmacio.equals("X")){
            throw new ItemPercuException("El tipus de confirmació ha de ser: S, N o X");
        }
        this.tipusConfirmacio = tipusConfirmacio;
    }

    public Boolean getDeleteDispo() {
        return deleteDispo;
    }

    public void setDeleteDispo(Boolean delete) {
        this.deleteDispo = delete;
    }
}
