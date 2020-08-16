/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author MECHREVO
 */
@Entity
//@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "findAllUsers", query = "SELECT u FROM Users u")
    , @NamedQuery(name = "findUserByUserid", query = "SELECT u FROM Users u WHERE u.userid = :userid")
    , @NamedQuery(name = "findUserByUsername", query = "SELECT u FROM Users u WHERE u.username = :username")
    , @NamedQuery(name = "findUserByFirstName", query = "SELECT u FROM Users u WHERE u.firstName = :firstName")
    , @NamedQuery(name = "findUserByLastName", query = "SELECT u FROM Users u WHERE u.lastName = :lastName")
    , @NamedQuery(name = "findUserByEmail", query = "SELECT u FROM Users u WHERE u.email = :email")
    , @NamedQuery(name = "findUserByGender", query = "SELECT u FROM Users u WHERE u.gender = :gender")
    , @NamedQuery(name = "findUserByPassword", query = "SELECT u FROM Users u WHERE u.password = :password")
    , @NamedQuery(name = "findUserByPhone", query = "SELECT u FROM Users u WHERE u.phone = :phone")
    , @NamedQuery(name = "findUserByItemid", query = "SELECT u FROM Users u WHERE u.itemid = :itemid")
})
@Table(name = "USERS")
public class Users implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "USERID")
    private Integer userid;
    @Basic(optional = false)
    @Column(name = "USERNAME", nullable=false, length=50)
    private String username;
    @Basic(optional = false)
    @Column(name = "FIRST_NAME", nullable=false, length=50)
    private String firstName;
    @Basic(optional = false)
    @Column(name = "LAST_NAME", nullable=false, length=50)
    private String lastName;
    @Basic(optional = false)
    @Column(name = "EMAIL", nullable=false, length=50)
    private String email;
    @Column(name = "GENDER")
    private String gender;
    @Basic(optional = false)
    @Column(name = "PASSWORD", nullable=false, length=50)
    private String password;
    @Column(name = "PHONE")
    private String phone;
    @Column(name = "ITEMID")
    private Integer itemid;

    public Users() {
    }

    public Users(Integer userid) {
        this.userid = userid;
    }
    
     public Users(String username, String firstName, String lastName, String email, String password) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }
    
    public Users(String email, String name, String password) {
        this.username = name;
        this.email = email;
        this.password = password;
    }

    public Users(Integer userid, String username, String firstName, String lastName, String email, String password) {
        this.userid = userid;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getItemid() {
        return itemid;
    }

    public void setItemid(Integer itemid) {
        this.itemid = itemid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userid != null ? userid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Users)) {
            return false;
        }
        Users other = (Users) object;
        if ((this.userid == null && other.userid != null) || (this.userid != null && !this.userid.equals(other.userid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Users[ userid=" + userid + " ]";
    }
    
}
