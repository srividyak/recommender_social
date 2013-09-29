/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myprojects.myworld.hibernate.pojo;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author srividyak
 */
@Entity
@Table(name = "groups")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Groups.findAll", query = "SELECT g FROM Groups g"),
    @NamedQuery(name = "Groups.findByGroupId", query = "SELECT g FROM Groups g WHERE g.groupId = :groupId"),
    @NamedQuery(name = "Groups.findByNumMembers", query = "SELECT g FROM Groups g WHERE g.numMembers = :numMembers"),
    @NamedQuery(name = "Groups.findByOwner", query = "SELECT g FROM Groups g WHERE g.owner = :owner"),
    @NamedQuery(name = "Groups.findByPrivacyLevel", query = "SELECT g FROM Groups g WHERE g.privacyLevel = :privacyLevel"),
    @NamedQuery(name = "Groups.findByTitle", query = "SELECT g FROM Groups g WHERE g.title = :title"),
    @NamedQuery(name = "Groups.findByDisabled", query = "SELECT g FROM Groups g WHERE g.disabled = :disabled"),
    @NamedQuery(name = "Groups.findByTimestamp", query = "SELECT g FROM Groups g WHERE g.timestamp = :timestamp"),
    @NamedQuery(name = "Groups.findByAbuseFlag", query = "SELECT g FROM Groups g WHERE g.abuseFlag = :abuseFlag")})
public class Groups implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "groupId")
    private String groupId;
    @Column(name = "numMembers")
    private BigInteger numMembers;
    @Basic(optional = false)
    @Column(name = "owner")
    private String owner;
    @Lob
    @Column(name = "moderators")
    private String moderators;
    @Column(name = "privacyLevel")
    private String privacyLevel;
    @Column(name = "title")
    private String title;
    @Lob
    @Column(name = "description")
    private String description;
    @Lob
    @Column(name = "tags")
    private String tags;
    @Column(name = "disabled")
    private String disabled;
    @Column(name = "timestamp")
    private BigInteger timestamp;
    @Column(name = "abuseFlag")
    private String abuseFlag;

    public Groups() {
    }

    public Groups(String groupId) {
        this.groupId = groupId;
    }

    public Groups(String groupId, String owner) {
        this.groupId = groupId;
        this.owner = owner;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public BigInteger getNumMembers() {
        return numMembers;
    }

    public void setNumMembers(BigInteger numMembers) {
        this.numMembers = numMembers;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getModerators() {
        return moderators;
    }

    public void setModerators(String moderators) {
        this.moderators = moderators;
    }

    public String getPrivacyLevel() {
        return privacyLevel;
    }

    public void setPrivacyLevel(String privacyLevel) {
        this.privacyLevel = privacyLevel;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getDisabled() {
        return disabled;
    }

    public void setDisabled(String disabled) {
        this.disabled = disabled;
    }

    public BigInteger getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(BigInteger timestamp) {
        this.timestamp = timestamp;
    }

    public String getAbuseFlag() {
        return abuseFlag;
    }

    public void setAbuseFlag(String abuseFlag) {
        this.abuseFlag = abuseFlag;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (groupId != null ? groupId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Groups)) {
            return false;
        }
        Groups other = (Groups) object;
        if ((this.groupId == null && other.groupId != null) || (this.groupId != null && !this.groupId.equals(other.groupId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.myprojects.myworld.hibernate.pojo.Groups[ groupId=" + groupId + " ]";
    }
    
}
