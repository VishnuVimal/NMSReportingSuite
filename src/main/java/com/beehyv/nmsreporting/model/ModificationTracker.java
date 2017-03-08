package com.beehyv.nmsreporting.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by beehyv on 28/2/17.
 */
@Entity
@Table(name = "MODIFICATION_TABLE")
public class ModificationTracker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "modification_id")
    private Integer modificationId;

    @ManyToOne
    @JoinColumn(name = "modified_user_id")
    private User modifiedUserId;

    @Column(name = "modification_date")
    private Date modificationDate;

    @Column(name = "modification_type")
    private String modificationType = ModificationType.CREATE.getModificationType();

    @Column(name = "modification_details")
    private String modificationDetails;

    @ManyToOne
    @JoinColumn(name = "modified_by_user_id")
    private User modifiedByUserId;

    public Integer getModificationId() {
        return modificationId;
    }

    public void setModificationId(Integer modificationId) {
        this.modificationId = modificationId;
    }

    public User getModifiedUserId() {
        return modifiedUserId;
    }

    public void setModifiedUserId(User modifiedUserId) {
        this.modifiedUserId = modifiedUserId;
    }

    public Date getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(Date modificationDate) {
        this.modificationDate = modificationDate;
    }

    public String getModificationType() {
        return modificationType;
    }

    public void setModificationType(String modificationType) {
        this.modificationType = modificationType;
    }

    public String getModificationDetails() {
        return modificationDetails;
    }

    public void setModificationDetails(String modificationDetails) {
        this.modificationDetails = modificationDetails;
    }

    public User getModifiedByUserId() {
        return modifiedByUserId;
    }

    public void setModifiedByUserId(User modifiedByUserId) {
        this.modifiedByUserId = modifiedByUserId;
    }
}
