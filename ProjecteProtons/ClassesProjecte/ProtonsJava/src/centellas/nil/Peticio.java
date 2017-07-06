package centellas.nil;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
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
@NamedQueries({@NamedQuery(name = "Peticio.getPeticions", query = "select p from Peticio p where p.deletePeticio = FALSE")})
@Entity
@Table(name = "usuari_item")
public class Peticio implements Serializable{
    
    @EmbeddedId
    private PeticioPK peticioPK;
    
    @Column(name="usrit_peticio")
    private int quantitat;
    
    @Column (name = "usrit_data_peticio")
    private Date dataPeticio;
    
    @Column (name = "usrit_delete")
    private Boolean deletePeticio;
    
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usrit_usr_id", referencedColumnName="usr_id", nullable=false, insertable = false, updatable = false)
    User usuari;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usrit_it_id", referencedColumnName="it_id", nullable=false, insertable = false, updatable = false)
    ItemPercu itemPercu;
    
    protected Peticio(){
        
    }

    public Peticio(User usuari, ItemPercu itemPercu, int quantitat, Date dataPeticio) {
        setUsuari(usuari);
        setItemPercu(itemPercu);
        setQuantitat(quantitat);
        setDataPeticio(dataPeticio);
        setDeletePeticio(Boolean.FALSE);
        peticioPK = new PeticioPK(itemPercu.getId(), usuari.getId());
    }

    public PeticioPK getPeticioPK() {
        return peticioPK;
    }

    public User getUsuari() {
        return usuari;
    }

    public void setUsuari(User usuari) {
        if(usuari == null){
            throw new DisponibilitatException("No es pot assignar un item null");
        }
        if (this.usuari != usuari) {
            this.usuari = usuari;
            usuari.addDisponibilitatItemPercu(this);
        }
        
    }

    public ItemPercu getItemPercu() {
        return itemPercu;
    }

    public void setItemPercu(ItemPercu itemPercu) {
        if(itemPercu == null){
            throw new DisponibilitatException("No es pot assignar un item null");
        }
        if (this.itemPercu != itemPercu) {
            this.itemPercu = itemPercu;
            itemPercu.addLlistaPeticionsUsers(this);
        }
    }

    public int getQuantitat() {
        return quantitat;
    }

    public void setQuantitat(int quantitat) {
        if(quantitat < 1){
            throw new PeticioException("No es pot assignar una quantitat negativa o 0");
        }
        this.quantitat = quantitat;
    }

    public Date getDataPeticio() {
        return (Date) dataPeticio.clone();
    }

    public void setDataPeticio(Date dataPeticio) {
        if(dataPeticio == null){
            throw new SortidaException("La data de petició no pot ser null");
        }
        this.dataPeticio = new Date(dataPeticio.getTime());
    }

    public Boolean getDeletePeticio() {
        return deletePeticio;
    }

    public void setDeletePeticio(Boolean deletePeticio) {
        this.deletePeticio = deletePeticio;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + Objects.hashCode(this.peticioPK);
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
        final Peticio other = (Peticio) obj;
        if (!Objects.equals(this.peticioPK, other.peticioPK)) {
            return false;
        }
        return true;
    }
    
    
}
