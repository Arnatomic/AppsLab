/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package centellas.nil;

import java.io.Serializable;
import java.util.Objects;
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
public class PeticioPK implements Serializable{
    
    @Basic(optional=false)
    @Column(name = "usrit_it_id", nullable = false)
    private int itemId;
    
    @Basic(optional=false)
    @Column(name = "usrit_usr_id", nullable=false)
    private int userId;
    
    private PeticioPK(){
        
    }

    public PeticioPK(int itemId, int userId) {
        this.itemId = itemId;
        this.userId = userId;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
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
        hash = 71 * hash + this.itemId;
        hash = 71 * hash + this.userId;
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
        final PeticioPK other = (PeticioPK) obj;
        if (this.itemId != other.itemId) {
            return false;
        }
        return true;
    }
    
}
