/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myprojects.myworld.hibernate.pojo;

import com.google.gson.Gson;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author srividyak
 */
@Entity
@Table(name = "friends")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Friends.findAll", query = "SELECT f FROM Friends f"),
    @NamedQuery(name = "Friends.findByMyUuid", query = "SELECT f FROM Friends f WHERE f.friendsPK.myUuid = :myUuid"),
    @NamedQuery(name = "Friends.findByFriendUuid", query = "SELECT f FROM Friends f WHERE f.friendsPK.friendUuid = :friendUuid"),
    @NamedQuery(name = "Friends.findByRelation", query = "SELECT f FROM Friends f WHERE f.relation = :relation"),
    @NamedQuery(name = "Friends.findByViewCount", query = "SELECT f FROM Friends f WHERE f.viewCount = :viewCount"),
    @NamedQuery(name = "Friends.findByAuxViewCount", query = "SELECT f FROM Friends f WHERE f.auxViewCount = :auxViewCount"),
    @NamedQuery(name = "Friends.findByReverseViewCount", query = "SELECT f FROM Friends f WHERE f.reverseViewCount = :reverseViewCount"),
    @NamedQuery(name = "Friends.findByReverseAuxViewCount", query = "SELECT f FROM Friends f WHERE f.reverseAuxViewCount = :reverseAuxViewCount"),
    @NamedQuery(name = "Friends.findByTimestamp", query = "SELECT f FROM Friends f WHERE f.timestamp = :timestamp"),
    @NamedQuery(name = "Friends.findByReverseTimestamp", query = "SELECT f FROM Friends f WHERE f.reverseTimestamp = :reverseTimestamp"),
    @NamedQuery(name = "Friends.findByTimeSent", query = "SELECT f FROM Friends f WHERE f.timeSent = :timeSent"),
    @NamedQuery(name = "Friends.findByTimeAccepted", query = "SELECT f FROM Friends f WHERE f.timeAccepted = :timeAccepted"),
    @NamedQuery(name = "Friends.findByTimeTerminated", query = "SELECT f FROM Friends f WHERE f.timeTerminated = :timeTerminated")})
public class Friends implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected FriendsPK friendsPK;
    @Column(name = "relation")
    private String relation;
    @Column(name = "viewCount")
    private Integer viewCount;
    @Column(name = "auxViewCount")
    private Integer auxViewCount;
    @Column(name = "reverseViewCount")
    private Integer reverseViewCount;
    @Column(name = "reverseAuxViewCount")
    private Integer reverseAuxViewCount;
    @Column(name = "timestamp")
    private Long timestamp;
    @Column(name = "reverseTimestamp")
    private Long reverseTimestamp;
    @Column(name = "timeSent")
    private Long timeSent;
    @Column(name = "timeAccepted")
    private Long timeAccepted;
    @Column(name = "timeTerminated")
    private Long timeTerminated;

    public Friends() {
    }

    public Friends(FriendsPK friendsPK) {
        this.friendsPK = friendsPK;
    }

    public Friends(String myUuid, String friendUuid) {
        this.friendsPK = new FriendsPK(myUuid, friendUuid);
    }

    public FriendsPK getFriendsPK() {
        return friendsPK;
    }

    public void setFriendsPK(FriendsPK friendsPK) {
        this.friendsPK = friendsPK;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public Integer getViewCount() {
        return viewCount;
    }

    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }

    public Integer getAuxViewCount() {
        return auxViewCount;
    }

    public void setAuxViewCount(Integer auxViewCount) {
        this.auxViewCount = auxViewCount;
    }

    public Integer getReverseViewCount() {
        return reverseViewCount;
    }

    public void setReverseViewCount(Integer reverseViewCount) {
        this.reverseViewCount = reverseViewCount;
    }

    public Integer getReverseAuxViewCount() {
        return reverseAuxViewCount;
    }

    public void setReverseAuxViewCount(Integer reverseAuxViewCount) {
        this.reverseAuxViewCount = reverseAuxViewCount;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public Long getReverseTimestamp() {
        return reverseTimestamp;
    }

    public void setReverseTimestamp(Long reverseTimestamp) {
        this.reverseTimestamp = reverseTimestamp;
    }

    public Long getTimeSent() {
        return timeSent;
    }

    public void setTimeSent(Long timeSent) {
        this.timeSent = timeSent;
    }

    public Long getTimeAccepted() {
        return timeAccepted;
    }

    public void setTimeAccepted(Long timeAccepted) {
        this.timeAccepted = timeAccepted;
    }

    public Long getTimeTerminated() {
        return timeTerminated;
    }

    public void setTimeTerminated(Long timeTerminated) {
        this.timeTerminated = timeTerminated;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (friendsPK != null ? friendsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Friends)) {
            return false;
        }
        Friends other = (Friends) object;
        if ((this.friendsPK == null && other.friendsPK != null) || (this.friendsPK != null && !this.friendsPK.equals(other.friendsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
