package com.thekleinbottle.as_backend.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
public class DmarcItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable=false, updatable=false)
    private Long id;

    private int count;
    private String disposition;
    private boolean passesDkim, passesSpf;

    private String srcIp, emailTo, emailFrom, headerDomain;
    private String dkimDomain, dkimSelector, spfDomain, spfScope;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="report")
    private DmarcReport report;

    public DmarcItem() {}

    public DmarcItem(int count, String disposition, boolean passesDkim, boolean passesSpf, String srcIp, String emailTo, String emailFrom, 
            String headerDomain, String dkimDomain, String dkimSelector, String spfDomain, String spfScope, DmarcReport report) {
        this.count = count;
        this.disposition = disposition;
        this.passesDkim = passesDkim;
        this.passesSpf = passesSpf;
        this.srcIp = srcIp;
        this.emailTo = emailTo;
        this.emailFrom = emailFrom;
        this.headerDomain = headerDomain;
        this.dkimDomain = dkimDomain;
        this.dkimSelector = dkimSelector;
        // this.dkimResult
        this.spfDomain = spfDomain;
        this.spfScope = spfScope;
        // this.spfResult
        this.report = report;
    }
}
