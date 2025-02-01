package com.thekleinbottle.as_backend.domain;

import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
public class DmarcReport {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable=false, updatable=false)
    private Long id;

    private String organization, email, reportId;
    private Date startDate, endDate;

    private String policyDomain, policyAdkim, policyAspf, policyAction, policySubdomain;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "report")
    private List<DmarcItem> dmarcitems;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="account")
    private Account account;

    public DmarcReport() {}

    public DmarcReport(String org, String email, String reportId, Date startDate, Date endDate, String policyDomain, 
            String policyAdkim, String policyAspf, String policyAction, String policySubdomain, Account account) {
        this.organization = org;
        this.email = email;
        this.reportId = reportId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.policyDomain = policyDomain;
        this.policyAdkim = policyAdkim;
        this.policyAspf = policyAspf;
        this.policyAction = policyAction;
        this.policySubdomain = policySubdomain;
        this.account = account;
    }

    public List<DmarcItem> getDmarcItems() {
        return dmarcitems;
    }
}
