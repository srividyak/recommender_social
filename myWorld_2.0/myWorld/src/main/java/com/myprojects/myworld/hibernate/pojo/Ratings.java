/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myprojects.myworld.hibernate.pojo;

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
@Table(name = "ratings")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ratings.findAll", query = "SELECT r FROM Ratings r"),
    @NamedQuery(name = "Ratings.findByUuid", query = "SELECT r FROM Ratings r WHERE r.ratingsPK.uuid = :uuid"),
    @NamedQuery(name = "Ratings.findByThreadId", query = "SELECT r FROM Ratings r WHERE r.ratingsPK.threadId = :threadId"),
    @NamedQuery(name = "Ratings.findByLikeRating", query = "SELECT r FROM Ratings r WHERE r.likeRating = :likeRating"),
    @NamedQuery(name = "Ratings.findByShare", query = "SELECT r FROM Ratings r WHERE r.share = :share"),
    @NamedQuery(name = "Ratings.findByAbuse", query = "SELECT r FROM Ratings r WHERE r.abuse = :abuse")})
public class Ratings implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RatingsPK ratingsPK;
    @Column(name = "likeRating")
    private String likeRating;
    @Column(name = "share")
    private String share;
    @Column(name = "abuse")
    private String abuse;

    public Ratings() {
    }

    public Ratings(RatingsPK ratingsPK) {
        this.ratingsPK = ratingsPK;
    }

    public Ratings(String uuid, String threadId) {
        this.ratingsPK = new RatingsPK(uuid, threadId);
    }

    public RatingsPK getRatingsPK() {
        return ratingsPK;
    }

    public void setRatingsPK(RatingsPK ratingsPK) {
        this.ratingsPK = ratingsPK;
    }

    public String getLikeRating() {
        return likeRating;
    }

    public void setLikeRating(String likeRating) {
        this.likeRating = likeRating;
    }

    public String getShare() {
        return share;
    }

    public void setShare(String share) {
        this.share = share;
    }

    public String getAbuse() {
        return abuse;
    }

    public void setAbuse(String abuse) {
        this.abuse = abuse;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ratingsPK != null ? ratingsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ratings)) {
            return false;
        }
        Ratings other = (Ratings) object;
        if ((this.ratingsPK == null && other.ratingsPK != null) || (this.ratingsPK != null && !this.ratingsPK.equals(other.ratingsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.myprojects.myworld.hibernate.pojo.Ratings[ ratingsPK=" + ratingsPK + " ]";
    }
    
}
