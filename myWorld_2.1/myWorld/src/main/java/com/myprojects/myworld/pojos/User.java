/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myprojects.myworld.pojos;

import com.google.gson.Gson;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.apache.commons.codec.digest.DigestUtils;
import org.hibernate.HibernateException;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.engine.SessionImplementor;
import org.hibernate.id.IdentifierGenerator;

/**
 *
 * @author srividyak
 */
@Entity
@Table(name = "users")
public class User implements Serializable, IdentifierGenerator {

    @Column(name = "timestamp")
    private Long timestamp;
    @Column(name = "updatedTimestamp")
    private Long updatedTimestamp;
    @Basic(optional = false)
    @Column(name = "firstName")
    private String firstName;
    @Column(name = "middleName")
    private String middleName;
    @Basic(optional = false)
    @Column(name = "lastName")
    private String lastName;
    @Basic(optional = false)
    @Column(name = "dob")
    @Temporal(TemporalType.DATE)
    private Date dob;
    @Id
    @Basic(optional = false)
    @GenericGenerator(name = "uuid", strategy = "com.myprojects.myworld.pojos.User")
    @GeneratedValue(generator = "uuid")
    @Column(name = "uuid")
    private String uuid;
    @Lob
    @Column(name = "interests")
    private String interests;
    @Column(name = "phoneNum")
    private String phoneNum;
    @Basic(optional = false)
    @Column(name = "gender")
    private boolean gender;
    @Column(name = "relStatus")
    private String relStatus;
    @Lob
    @Column(name = "lang")
    private String lang;
    @Lob
    @Column(name = "locations")
    private String locations;
    @Lob
    @Column(name = "homeTown")
    private String homeTown;
    @Lob
    @Column(name = "education")
    private String education;
    @Lob
    @Column(name = "about")
    private String about;
    @Lob
    @Column(name = "company")
    private String company;

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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getInterests() {
        return interests;
    }

    public void setInterests(String interests) {
        this.interests = interests;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getRelStatus() {
        return relStatus;
    }

    public void setRelStatus(String relStatus) {
        this.relStatus = relStatus;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getLocations() {
        return locations;
    }

    public void setLocations(String locations) {
        this.locations = locations;
    }

    public String getHomeTown() {
        return homeTown;
    }

    public void setHomeTown(String homeTown) {
        this.homeTown = homeTown;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getFriendsCount() {
        return friendsCount;
    }

    public void setFriendsCount(Integer friendsCount) {
        this.friendsCount = friendsCount;
    }

    public String getDisabled() {
        return disabled;
    }

    public void setDisabled(String disabled) {
        this.disabled = disabled;
    }
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Column(name = "friendsCount")
    private Integer friendsCount;
    @Column(name = "disabled")
    private String disabled;

    @Override
    public Serializable generate(SessionImplementor session, Object object) throws HibernateException {
        User u = (User) object;
        if(u.uuid == null) {
            u.generateUUID();
        }
        return u.uuid;
    }

    public void generateUUID() {
        long now = new Date().getTime();
        String currentTime = String.valueOf(now);
        String dobString = String.valueOf(this.getDob());
        String comboString = currentTime + this.getFirstName() + this.getLastName() + dobString;
        this.uuid = DigestUtils.md5Hex(comboString);
    }

    public User() {
    }

    public User(String uuid) {
        this.uuid = uuid;
    }

    public User(String firstName, String lastName, Date dob, boolean gender, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.gender = gender;
        this.email = email;
        this.generateUUID();
        this.timestamp = new Date().getTime();
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.uuid == null && other.uuid != null) || (this.uuid != null && !this.uuid.equals(other.uuid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }

    public static User fromJson(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, User.class);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (uuid != null ? uuid.hashCode() : 0);
        return hash;
    }
}
