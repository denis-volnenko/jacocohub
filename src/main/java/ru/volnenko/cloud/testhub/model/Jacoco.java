package ru.volnenko.cloud.testhub.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "hub_jacoco")
public class Jacoco {

    @Id
    @NonNull
    @Column(name = "id")
    private String id = UUID.randomUUID().toString();

    @Column(name = "release_id", nullable = false)
    private String releaseId;

    @NonNull
    @Column(name = "percent", nullable = false)
    private Float percent = 0F;

    @NonNull
    @Column(name = "instructions", nullable = false)
    private Float instructions = 0F;

    @NonNull
    @Column(name = "branches", nullable = false)
    private Float branches = 0F;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created", nullable = false)
    private Date created;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated", nullable = false)
    private Date updated;

}
