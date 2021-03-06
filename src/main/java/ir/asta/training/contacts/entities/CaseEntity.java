package ir.asta.training.contacts.entities;


import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="CASE")
public class CaseEntity {

    Long id;
    Date sendDate;
    int referrerNumbers;
    int topic;
    int proceedingStatus;
    int satisfactionStatus;

    List<ReferrerEntity> referrerEntities = new ArrayList<>();


    public CaseEntity(Date sendDate, int topic, int proceedingStatus, int satisfactionStatus, List<ReferrerEntity> referrerEntities,int referrerNumbers) {
        this.referrerNumbers = referrerNumbers;
        this.sendDate = sendDate;
        this.topic = topic;
        this.proceedingStatus = proceedingStatus;
        this.satisfactionStatus = satisfactionStatus;
        this.referrerEntities = referrerEntities;
    }

    public CaseEntity() {
    }


    @Basic
    @Column(name="REFERRER_NUMBERS")
    public int getReferrerNumbers() {
        return referrerNumbers;
    }

    public void setReferrerNumbers(int referrerNumbers) {
        this.referrerNumbers = referrerNumbers;
    }

    @Id
    @Column(name = "CASE_ID")
    @GeneratedValue(strategy=GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "SEND_DATE")
    @JsonFormat(shape = JsonFormat.Shape.STRING ,pattern = "yyyy-MM-dd")
    public Date getSendDate() {
        return sendDate;
    }

    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }

    @Basic
    @Column(name="TOPIC")
    public int getTopic() {
        return topic;
    }

    public void setTopic(int topic) {
        this.topic = topic;
    }

    @Basic
    @Column(name="PROCEEDING_STATUS")
    public int getProceedingStatus() {
        return proceedingStatus;
    }

    public void setProceedingStatus(int proceedingStatus) {
        this.proceedingStatus = proceedingStatus;
    }

    @Basic
    @Column(name="SATISFACTION_STATUS")
    public int getSatisfactionStatus() {
        return satisfactionStatus;
    }

    public void setSatisfactionStatus(int satisfactionStatus) {
        this.satisfactionStatus = satisfactionStatus;
    }

    @OneToMany(mappedBy = "caseEntity",cascade = CascadeType.ALL, orphanRemoval = true)
    @ElementCollection(targetClass=ReferrerEntity.class)
    public List<ReferrerEntity> getReferrerEntities() {
        return referrerEntities;
    }

    public void setReferrerEntities(List<ReferrerEntity> referrerEntities) {
        this.referrerEntities = referrerEntities;
    }
}
