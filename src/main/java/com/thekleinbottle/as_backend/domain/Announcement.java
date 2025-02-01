package com.thekleinbottle.as_backend.domain;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import lombok.Data;

@Data
@Entity
public class Announcement {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable=false, updatable=false)
    private Long id;
    
    private String title, description;
    private Date date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="author")
    private AppUser author;

    public Announcement() {}

    public Announcement(String title, String description, Date date, AppUser author) {
        this.title = title;
        this.description = description;
        this.date = date;
        this.author = author;
    }

}
