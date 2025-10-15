package ru.volnenko.cloud.testhub.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "hub_jacoco")
public class Jacoco {

    @Id
    @NonNull
    @Column(name = "id")
    private String id = UUID.randomUUID().toString();

    @Column(name = "release_id", nullable = false)
    private String releaseId;

    @Column(name = "artifact_id", nullable = false)
    private String artifactId;

    @Column(name = "version_id", nullable = false)
    private String versionId;

    @Column(name = "branch_id")
    private String branchId;

    @NonNull
    @Column(name = "coverage", nullable = false)
    private Float coverage = 0F;

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
