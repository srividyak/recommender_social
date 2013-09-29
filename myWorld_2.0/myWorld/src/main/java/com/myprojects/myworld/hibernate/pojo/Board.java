/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myprojects.myworld.hibernate.pojo;

import com.google.gson.Gson;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import org.apache.commons.codec.digest.DigestUtils;
import org.hibernate.HibernateException;
import org.hibernate.classic.Session;
import org.hibernate.engine.SessionImplementor;
import org.hibernate.id.IdentifierGenerator;

/**
 *
 * @author srividyak
 */
@Entity
@Table(name = "board")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Board.findAll", query = "SELECT b FROM Board b"),
    @NamedQuery(name = "Board.findByBoardId", query = "SELECT b FROM Board b WHERE b.boardId = :boardId"),
    @NamedQuery(name = "Board.findByShareCount", query = "SELECT b FROM Board b WHERE b.shareCount = :shareCount"),
    @NamedQuery(name = "Board.findByUpRatingsCount", query = "SELECT b FROM Board b WHERE b.upRatingsCount = :upRatingsCount"),
    @NamedQuery(name = "Board.findByDownRatingsCount", query = "SELECT b FROM Board b WHERE b.downRatingsCount = :downRatingsCount"),
    @NamedQuery(name = "Board.findByType", query = "SELECT b FROM Board b WHERE b.type = :type"),
    @NamedQuery(name = "Board.findByTitle", query = "SELECT b FROM Board b WHERE b.title = :title"),
    @NamedQuery(name = "Board.findByTimestamp", query = "SELECT b FROM Board b WHERE b.timestamp = :timestamp"),
    @NamedQuery(name = "Board.findByUuid", query = "SELECT b FROM Board b WHERE b.uuid = :uuid"),
    @NamedQuery(name = "Board.findByAbuseFlag", query = "SELECT b FROM Board b WHERE b.abuseFlag = :abuseFlag"),
    @NamedQuery(name = "Board.findByCommentsCount", query = "SELECT b FROM Board b WHERE b.commentsCount = :commentsCount"),
    @NamedQuery(name = "Board.findByTargetUuid", query = "SELECT b FROM Board b WHERE b.targetUuid = :targetUuid")})
public class Board implements Serializable, IdentifierGenerator {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "boardId")
    private String boardId;
    @Column(name = "shareCount")
    private Long shareCount;
    @Column(name = "upRatingsCount")
    private Long upRatingsCount;
    @Column(name = "downRatingsCount")
    private Long downRatingsCount;
    @Column(name = "type")
    private String type;
    @Column(name = "title")
    private String title;
    @Lob
    @Column(name = "description")
    private String description;
    @Lob
    @Column(name = "content")
    private String content;
    @Basic(optional = false)
    @Column(name = "timestamp")
    private Long timestamp;
    @Basic(optional = false)
    @Column(name = "updatedTimestamp")
    private Long updatedTimestamp;

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public Long getUpdatedTimestamp() {
        return updatedTimestamp;
    }

    public void setUpdatedTimestamp(Long updatedTimestamp) {
        this.updatedTimestamp = updatedTimestamp;
    }
    @Basic(optional = false)
    @Column(name = "uuid")
    private String uuid;
    @Column(name = "abuseFlag")
    private String abuseFlag;
    @Lob
    @Column(name = "tags")
    private String tags;
    @Column(name = "commentsCount")
    private Long commentsCount;
    @Column(name = "targetUuid")
    private String targetUuid;

    public Board() {
    }

    public Board(String boardId) {
        this.boardId = boardId;
    }

    public Board(String boardId, String uuid) {
        this.boardId = boardId;
        this.uuid = uuid;
    }

    public String getBoardId() {
        return boardId;
    }

    public void setBoardId(String boardId) {
        this.boardId = boardId;
    }

    public Long getShareCount() {
        return shareCount;
    }

    public void setShareCount(Long shareCount) {
        this.shareCount = shareCount;
    }

    public Long getUpRatingsCount() {
        return upRatingsCount;
    }

    public void setUpRatingsCount(Long upRatingsCount) {
        this.upRatingsCount = upRatingsCount;
    }

    public Long getDownRatingsCount() {
        return downRatingsCount;
    }

    public void setDownRatingsCount(Long downRatingsCount) {
        this.downRatingsCount = downRatingsCount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getAbuseFlag() {
        return abuseFlag;
    }

    public void setAbuseFlag(String abuseFlag) {
        this.abuseFlag = abuseFlag;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public Long getCommentsCount() {
        return commentsCount;
    }

    public void setCommentsCount(Long commentsCount) {
        this.commentsCount = commentsCount;
    }

    public String getTargetUuid() {
        return targetUuid;
    }

    public void setTargetUuid(String targetUuid) {
        this.targetUuid = targetUuid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (boardId != null ? boardId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Board)) {
            return false;
        }
        Board other = (Board) object;
        if ((this.boardId == null && other.boardId != null) || (this.boardId != null && !this.boardId.equals(other.boardId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
    
    @PreUpdate
    @PrePersist
    public void setLastUpdate() {
        this.setUpdatedTimestamp(new Date().getTime());
    }
    
    @PrePersist
    public void setCreateTime() {
        this.setTimestamp(new Date().getTime());
    }

    public Serializable generate(SessionImplementor session, Object object) throws HibernateException {
        if (this.boardId == null) {
            this.generateBoardId();
        }
        return boardId;
    }

    private void generateBoardId() {
        this.boardId = DigestUtils.md5Hex(this.uuid + (new Date()).getTime() + this.title + this.description);
    }
    
    public void update(Session session) {
        
    }
    
}
