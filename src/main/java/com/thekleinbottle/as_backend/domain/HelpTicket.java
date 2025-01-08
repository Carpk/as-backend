package com.thekleinbottle.as_backend.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class HelpTicket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title, text;
    private boolean isOpen;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="appuser")
    private AppUser appuser;

    public HelpTicket() {}

    public HelpTicket(String title, String text, AppUser appuser) {
        this.title = title;
        this.text = text;
        this.appuser = appuser;
        this.isOpen = true;
    }





}
