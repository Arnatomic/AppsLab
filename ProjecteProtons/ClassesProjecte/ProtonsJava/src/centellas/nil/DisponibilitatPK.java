/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package centellas.nil;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Nil
 */
@Embeddable
public class DisponibilitatPK implements Serializable {
    @Basic(optional=false)
    @Column(name = "usrsor_sor_id", nullable = false)
    private int sortidaId;
    
    @Basic(optional=false)
    @Column(name = "usrsor_usr_id", nullable=false)
    private int userId;
    
    private DisponibilitatPK(){
        
    }

    public DisponibilitatPK(int sortidaId, int userId) {
        this.sortidaId = sortidaId;
        this.userId = userId;
    }
    
    public int getSortidaId() {
        return sortidaId;
    }

    public void setSortidaId(int sortidaId) {
        this.sortidaId = sortidaId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + this.sortidaId;
        hash = 37 * hash + this.userId;
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
        final DisponibilitatPK other = (DisponibilitatPK) obj;
        if (this.sortidaId != other.sortidaId) {
            return false;
        }
        if (this.userId != other.userId) {
            return false;
        }
        return true;
    }
    
    
}
