package com.beehyv.nmsreporting.model;

import com.beehyv.nmsreporting.utils.Constants;
import com.fasterxml.jackson.annotation.*;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by beehyv on 21/2/17.
 */
@Entity
@Table(name = "USER_DETAILS")
//@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property="reference_level")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "full_name")
    private String name;

    @Column(name = "user_name", unique = true)
    private String userName;

    @Column(name = "password")
    private String password;

    @Column(name = "email_id")
    private String emailId;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "role")
    private String userRole = Constants.Roles.USER_ROLE;

    @Column(name = "level")
    private String hierarchyLevel = Constants.Level.BLOCK_LEVEL;

    @Column(name = "status")
    private String accountStatus = Constants.AccountStatus.PENDING_ACTIVATION;

    @Column(name = "location")
    private String userLocation;

    @Column(name = "creation_date")
    private Date creationDate;

    @ManyToOne
    @JoinColumn(name = "created_by")
//    @JsonIgnore
    private User createdByUserId;


    @OneToMany(mappedBy = "createdByUserId")
    @LazyCollection(LazyCollectionOption.FALSE)
    @JsonIgnore
    private Set<User> createdUsers = new HashSet<>();

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public String getHierarchyLevel() {
        return hierarchyLevel;
    }

    public void setHierarchyLevel(String hierarchyLevel) {
        this.hierarchyLevel = hierarchyLevel;
    }

    public String getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }

    public String getUserLocation() {
        return userLocation;
    }

    public void setUserLocation(String userLocation) {
        this.userLocation = userLocation;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public User getCreatedByUser() {
        return createdByUserId;
    }

    public void setCreatedByUser(User createdByUserId) {
        this.createdByUserId = createdByUserId;
    }

    public Set<User> getCreatedUsers() {
        return createdUsers;
    }

    public void setCreatedUsers(Set<User> createdUsers) {
        this.createdUsers = createdUsers;
    }
}
