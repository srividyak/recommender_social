/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myprojects.myworld.hibernate.pojo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author srividyak
 */
@Embeddable
public class RatingsPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "uuid")
    private String uuid;
    @Basic(optional = false)
    @Column(name = "threadId")
    private String threadId;

    public RatingsPK() {
    }

    public RatingsPK(String uuid, String threadId) {
        this.uuid = uuid;
        this.threadId = threadId;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getThreadId() {
        return threadId;
    }

    public void setThreadId(String threadId) {
        this.threadId = threadId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (uuid != null ? uuid.hashCode() : 0);
        hash += (threadId != null ? threadId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RatingsPK)) {
            return false;
        }
        RatingsPK other = (RatingsPK) object;
        if ((this.uuid == null && other.uuid != null) || (this.uuid != null && !this.uuid.equals(other.uuid))) {
            return false;
        }
        if ((this.threadId == null && other.threadId != null) || (this.threadId != null && !this.threadId.equals(other.threadId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.myprojects.myworld.hibernate.pojo.RatingsPK[ uuid=" + uuid + ", threadId=" + threadId + " ]";
    }
    
}
