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
@Table(name = "comment")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Comment.findAll", query = "SELECT c FROM Comment c"),
    @NamedQuery(name = "Comment.findByCommentId", query = "SELECT c FROM Comment c WHERE c.commentId = :commentId"),
    @NamedQuery(name = "Comment.findByShareCount", query = "SELECT c FROM Comment c WHERE c.shareCount = :shareCount"),
    @NamedQuery(name = "Comment.findByUpRatingsCount", query = "SELECT c FROM Comment c WHERE c.upRatingsCount = :upRatingsCount"),
    @NamedQuery(name = "Comment.findByDownRatingsCount", query = "SELECT c FROM Comment c WHERE c.downRatingsCount = :downRatingsCount"),
    @NamedQuery(name = "Comment.findByTimestamp", query = "SELECT c FROM Comment c WHERE c.timestamp = :timestamp"),
    @NamedQuery(name = "Comment.findByParentId", query = "SELECT c FROM Comment c WHERE c.parentId = :parentId"),
    @NamedQuery(name = "Comment.findByAbuseFlag", query = "SELECT c FROM Comment c WHERE c.abuseFlag = :abuseFlag"),
    @NamedQuery(name = "Comment.findByTitle", query = "SELECT c FROM Comment c WHERE c.title = :title"),
    @NamedQuery(name = "Comment.findByUuid", query = "SELECT c FROM Comment c WHERE c.uuid = :uuid"),
    @NamedQuery(name = "Comment.findByCommentsCount", query = "SELECT c FROM Comment c WHERE c.commentsCount = :commentsCount")})
public class Comment implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "commentId")
    private String commentId;
    @Column(name = "shareCount")
    private BigInteger shareCount;
    @Column(name = "upRatingsCount")
    private BigInteger upRatingsCount;
    @Column(name = "downRatingsCount")
    private BigInteger downRatingsCount;
    @Basic(optional = false)
    @Column(name = "timestamp")
    private long timestamp;
    @Column(name = "parentId")
    private String parentId;
    @Lob
    @Column(name = "tags")
    private String tags;
    @Column(name = "abuseFlag")
    private String abuseFlag;
    @Column(name = "title")
    private String title;
    @Lob
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @Column(name = "uuid")
    private String uuid;
    @Column(name = "commentsCount")
    private BigInteger commentsCount;

    public Comment() {
    }

    public Comment(String commentId) {
        this.commentId = commentId;
    }

    public Comment(String commentId, long timestamp, String uuid) {
        this.commentId = commentId;
        this.timestamp = timestamp;
        this.uuid = uuid;
    }

    public String getCommentId() {
        return commentId;
    }

    public void setCommentId(String commentId) {
        this.commentId = commentId;
    }

    public BigInteger getShareCount() {
        return shareCount;
    }

    public void setShareCount(BigInteger shareCount) {
        this.shareCount = shareCount;
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

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getAbuseFlag() {
        return abuseFlag;
    }

    public void setAbuseFlag(String abuseFlag) {
        this.abuseFlag = abuseFlag;
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

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public BigInteger getCommentsCount() {
        return commentsCount;
    }

    public void setCommentsCount(BigInteger commentsCount) {
        this.commentsCount = commentsCount;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (commentId != null ? commentId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comment)) {
            return false;
        }
        Comment other = (Comment) object;
        if ((this.commentId == null && other.commentId != null) || (this.commentId != null && !this.commentId.equals(other.commentId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.myprojects.myworld.hibernate.pojo.Comment[ commentId=" + commentId + " ]";
    }
    
}
