/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myprojects.myworld.hibernate.pojo;

import com.google.gson.Gson;
import com.myprojects.myworld.daoimpl.UserException;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import org.apache.commons.codec.digest.DigestUtils;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.classic.Session;
import org.hibernate.engine.SessionImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author srividyak
 */
@Entity
@Table(name = "users")
@XmlRootElement
@Transactional
@NamedQueries({
    @NamedQuery(name = "Users.findAll", query = "SELECT u FROM Users u"),
    @NamedQuery(name = "Users.findByFirstName", query = "SELECT u FROM Users u WHERE u.firstName = :firstName"),
    @NamedQuery(name = "Users.findByMiddleName", query = "SELECT u FROM Users u WHERE u.middleName = :middleName"),
    @NamedQuery(name = "Users.findByLastName", query = "SELECT u FROM Users u WHERE u.lastName = :lastName"),
    @NamedQuery(name = "Users.findByDob", query = "SELECT u FROM Users u WHERE u.dob = :dob"),
    @NamedQuery(name = "Users.findByUuid", query = "SELECT u FROM Users u WHERE u.uuid = :uuid"),
    @NamedQuery(name = "Users.findByPhoneNum", query = "SELECT u FROM Users u WHERE u.phoneNum = :phoneNum"),
    @NamedQuery(name = "Users.findByGender", query = "SELECT u FROM Users u WHERE u.gender = :gender"),
    @NamedQuery(name = "Users.findByRelStatus", query = "SELECT u FROM Users u WHERE u.relStatus = :relStatus"),
    @NamedQuery(name = "Users.findByEmail", query = "SELECT u FROM Users u WHERE u.email = :email"),
    @NamedQuery(name = "Users.findByTimestamp", query = "SELECT u FROM Users u WHERE u.timestamp = :timestamp"),
    @NamedQuery(name = "Users.findByFriendsCount", query = "SELECT u FROM Users u WHERE u.friendsCount = :friendsCount"),
    @NamedQuery(name = "Users.findByDisabled", query = "SELECT u FROM Users u WHERE u.disabled = :disabled")})
public class Users implements Serializable, IdentifierGenerator {

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
    @GenericGenerator(name = "uuid", strategy = "com.myprojects.myworld.hibernate.pojo.Users")
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
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Column(name = "friendsCount")
    private Integer friendsCount;
    @Column(name = "disabled")
    private String disabled;

    public Users() {
    }

    public Users(String uuid) {
        this.uuid = uuid;
    }

    public void generateUUID() {
        long now = new Date().getTime();
        String currentTime = String.valueOf(now);
        String dobString = String.valueOf(this.getDob());
        String comboString = currentTime + this.getFirstName() + this.getLastName() + dobString;
        this.uuid = DigestUtils.md5Hex(comboString);
    }

    public Users(String firstName, String lastName, Date dob, boolean gender, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.gender = gender;
        this.email = email;
        this.generateUUID();
        this.timestamp = new Date().getTime();
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

    public boolean getGender() {
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (uuid != null ? uuid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Users)) {
            return false;
        }
        Users other = (Users) object;
        if ((this.uuid == null && other.uuid != null) || (this.uuid != null && !this.uuid.equals(other.uuid))) {
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

    public static Users fromJson(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, Users.class);
    }

    /**
     * updates the persistent object based on non null properties of the object
     *
     * @param session
     */
    public void update(Session session) throws UserException {
        Transaction tx = session.beginTransaction();
        try {
            Class clazz = this.getClass();
            this.setLastUpdate();
            Field fields[] = clazz.getDeclaredFields();
            String queryBeg = "update Users set ";
            String queryEnd = " where uuid = :uuid";
            String queryParams = "", queryString = "";
            Query query;
            List<Class> qParamsTypes = new LinkedList<Class>();
            List<Object> qParamsValues = new LinkedList<Object>();
            for (Field f : fields) {
                String fieldName = f.getName();
                Class fieldClass = f.getType();
                String modifiedFieldName = fieldName;
                if (fieldName.length() > 1) {
                    modifiedFieldName = fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
                } else {
                    modifiedFieldName = fieldName.toUpperCase();
                }
                String methodName = "get" + modifiedFieldName;
                try {
                    Method method = clazz.getMethod(methodName);
                    try {
                        Object o = method.invoke(this);
                        if (o != null) {
                            qParamsTypes.add(fieldClass);
                            qParamsValues.add(o);
                            queryParams += fieldName + " = ?" + ",";
                        }
                    } catch (IllegalAccessException ex) {
                        Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IllegalArgumentException ex) {
                        Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (InvocationTargetException ex) {
                        Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } catch (NoSuchMethodException ex) {
                    Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SecurityException ex) {
                    Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            int qParamsLen = queryParams.length();
            if (qParamsLen > 0) { //remove trailing comma
                queryParams = queryParams.substring(0, qParamsLen - 1);
                queryString = queryBeg + queryParams + queryEnd;
                query = session.createQuery(queryString);
                int index = 0;
                for (Class c : qParamsTypes) {
                    if (c.equals(java.lang.Integer.class)) {
                        query.setInteger(index, (Integer) qParamsValues.get(index));
                    } else if (c.equals(java.lang.String.class)) {
                        query.setString(index, (String) qParamsValues.get(index));
                    } else if (c.equals(java.lang.Float.class)) {
                        query.setFloat(index, (Float) qParamsValues.get(index));
                    } else if (c.equals(java.lang.Long.class)) {
                        query.setLong(index, (Long) qParamsValues.get(index));
                    } else if (c.equals(java.lang.Boolean.class) || c.equals(boolean.class)) {
                        query.setBoolean(index, (Boolean) qParamsValues.get(index));
                    }
                    index++;
                }
                query.setParameter("uuid", this.getUuid());
                query.executeUpdate();
                tx.commit();
            }
        } catch (Exception e) {
            tx.rollback();
            throw new UserException(e);
        }
        //TODO: remove this once transactions work fine
        session.close();
    }

    public Serializable generate(SessionImplementor session, Object object) throws HibernateException {
        if (this.uuid == null) {
            this.generateUUID();
        }
        return uuid;
    }

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
}
