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
@Table(name = "pages")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pages.findAll", query = "SELECT p FROM Pages p"),
    @NamedQuery(name = "Pages.findByPageId", query = "SELECT p FROM Pages p WHERE p.pageId = :pageId"),
    @NamedQuery(name = "Pages.findByOwner", query = "SELECT p FROM Pages p WHERE p.owner = :owner"),
    @NamedQuery(name = "Pages.findByTitle", query = "SELECT p FROM Pages p WHERE p.title = :title"),
    @NamedQuery(name = "Pages.findByPrivacyLevel", query = "SELECT p FROM Pages p WHERE p.privacyLevel = :privacyLevel"),
    @NamedQuery(name = "Pages.findByShareCount", query = "SELECT p FROM Pages p WHERE p.shareCount = :shareCount"),
    @NamedQuery(name = "Pages.findByDisabled", query = "SELECT p FROM Pages p WHERE p.disabled = :disabled"),
    @NamedQuery(name = "Pages.findByTimestamp", query = "SELECT p FROM Pages p WHERE p.timestamp = :timestamp"),
    @NamedQuery(name = "Pages.findByUpRatingsCount", query = "SELECT p FROM Pages p WHERE p.upRatingsCount = :upRatingsCount"),
    @NamedQuery(name = "Pages.findByDownRatingsCount", query = "SELECT p FROM Pages p WHERE p.downRatingsCount = :downRatingsCount"),
    @NamedQuery(name = "Pages.findByAbuseFlag", query = "SELECT p FROM Pages p WHERE p.abuseFlag = :abuseFlag")})
public class Pages implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "pageId")
    private String pageId;
    @Basic(optional = false)
    @Column(name = "owner")
    private String owner;
    @Column(name = "title")
    private String title;
    @Lob
    @Column(name = "description")
    private String description;
    @Lob
    @Column(name = "tags")
    private String tags;
    @Column(name = "privacyLevel")
    private String privacyLevel;
    @Column(name = "shareCount")
    private BigInteger shareCount;
    @Column(name = "disabled")
    private String disabled;
    @Column(name = "timestamp")
    private BigInteger timestamp;
    @Column(name = "upRatingsCount")
    private BigInteger upRatingsCount;
    @Column(name = "downRatingsCount")
    private BigInteger downRatingsCount;
    @Column(name = "abuseFlag")
    private String abuseFlag;

    public Pages() {
    }

    public Pages(String pageId) {
        this.pageId = pageId;
    }

    public Pages(String pageId, String owner) {
        this.pageId = pageId;
        this.owner = owner;
    }

    public String getPageId() {
        return pageId;
    }

    public void setPageId(String pageId) {
        this.pageId = pageId;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
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

    public String getPrivacyLevel() {
        return privacyLevel;
    }

    public void setPrivacyLevel(String privacyLevel) {
        this.privacyLevel = privacyLevel;
    }

    public BigInteger getShareCount() {
        return shareCount;
    }

    public void setShareCount(BigInteger shareCount) {
        this.shareCount = shareCount;
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

    public BigInteger getUpRatingsCount() {
        return upRatingsCount;
    }

    public void setUpRatingsCount(BigInteger upRatingsCount) {
        this.upRatingsCount = upRatingsCount;
    }

    public BigInteger getDownRatingsCount() {
        return downRatingsCount;
    }

    public void setDownRatingsCount(BigInteger downRatingsCount) {
        this.downRatingsCount = downRatingsCount;
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
        hash += (pageId != null ? pageId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pages)) {
            return false;
        }
        Pages other = (Pages) object;
        if ((this.pageId == null && other.pageId != null) || (this.pageId != null && !this.pageId.equals(other.pageId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.myprojects.myworld.hibernate.pojo.Pages[ pageId=" + pageId + " ]";
    }
    
}
