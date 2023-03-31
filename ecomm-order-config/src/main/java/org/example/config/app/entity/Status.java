package org.example.config.app.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="status")
public class Status {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="status_id")
    private Long statusId;

    @Column(name="description")
    private String statusDescription;
}
