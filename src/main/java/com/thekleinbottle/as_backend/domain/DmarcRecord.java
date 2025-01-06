package com.thekleinbottle.as_backend.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


// v=DMARC1; p=reject; rua=mailto:dmarc_agg@vali.email; 
// ruf=mailto:dmarc_agg@vali.email; sp=reject; fo=0

@Entity
public class DmarcRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String rua, ruf, policy, spolicy, rf;
    private Character adkim, aspf, foption; 
    private int pct, ri;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="appuser")
    private AppUser appuser;

    public DmarcRecord() {
    }

    public DmarcRecord(String rua, String ruf, String policy, String spolicy, String rf, 
        Character adkim, Character aspf, Character foption, int pct, int ri, AppUser appuser ) {
        
        super();
        this.rua = rua;
        this.ruf = ruf;
        this.policy = policy;
        this.spolicy = spolicy;
        this.rf = rf;
        this.adkim = adkim;
        this.aspf = aspf;
        this.foption = foption;
        this.pct = pct;
        this.ri = ri;
        this.appuser = appuser;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getRuf() {
        return ruf;
    }

    public void setRuf(String ruf) {
        this.ruf = ruf;
    }

    public String getPolicy() {
        return policy;
    }

    public void setPolicy(String policy) {
        this.policy = policy;
    }

    public String getSpolicy() {
        return spolicy;
    }

    public void setSpolicy(String spolicy) {
        this.spolicy = spolicy;
    }

    public String getRf() {
        return rf;
    }

    public void setRf(String rf) {
        this.rf = rf;
    }

    public Character getAdkim() {
        return adkim;
    }

    public void setAdkim(Character adkim) {
        this.adkim = adkim;
    }

    public Character getAspf() {
        return aspf;
    }

    public void setAspf(Character aspf) {
        this.aspf = aspf;
    }

    public Character getFoption() {
        return foption;
    }

    public void setFoption(Character foption) {
        this.foption = foption;
    }

    public int getPct() {
        return pct;
    }

    public void setPct(int pct) {
        this.pct = pct;
    }

    public int getRi() {
        return ri;
    }

    public void setRi(int ri) {
        this.ri = ri;
    }

    public AppUser getUser() {
        return appuser;
    }

    public void setUser(AppUser appuser) {
        this.appuser = appuser;
    }
}
