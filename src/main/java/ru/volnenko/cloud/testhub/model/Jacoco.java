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

    @Column(name = "artifact_id", nullable = false)
    private String artifactId;

    @Column(name = "version_id", nullable = false)
    private String versionId;

    @Column(name = "branch_id")
    private String branchId;

    @NonNull
    @Column(name = "coverage", nullable = false)
    private Float coverage = 0F;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created", nullable = false)
    private Date created;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated", nullable = false)
    private Date updated;

    @Column(name = "instruction_missed", nullable = false)
    private double instructionMissed = 0;

    @Column(name = "instruction_covered", nullable = false)
    private double instructionCovered = 0;

    @Column(name = "instruction_total", nullable = false)
    private double instructionTotal = 0;

    @Column(name = "instruction_percent", nullable = false)
    private double instructionPercent = 0;

    @Column(name = "branch_missed", nullable = false)
    private double branchMissed = 0;

    @Column(name = "branch_covered", nullable = false)
    private double branchCovered = 0;

    @Column(name = "branch_total", nullable = false)
    private double branchTotal = 0;

    @Column(name = "branch_percent", nullable = false)
    private double branchPercent = 0;

    @Column(name = "line_missed", nullable = false)
    private double lineMissed = 0;

    @Column(name = "line_covered", nullable = false)
    private double lineCovered = 0;

    @Column(name = "line_total", nullable = false)
    private double lineTotal = 0;

    @Column(name = "line_percent", nullable = false)
    private double linePercent = 0;

    @Column(name = "complexity_missed", nullable = false)
    private double complexityMissed = 0;

    @Column(name = "complexity_covered", nullable = false)
    private double complexityCovered = 0;

    @Column(name = "complexity_total", nullable = false)
    private double complexityTotal = 0;

    @Column(name = "complexity_percent", nullable = false)
    private double complexityPercent = 0;

    @Column(name = "method_missed", nullable = false)
    private double methodMissed = 0;

    @Column(name = "method_Covered", nullable = false)
    private double methodCovered = 0;

    @Column(name = "method_total", nullable = false)
    private double methodTotal = 0;

    @Column(name = "method_percent", nullable = false)
    private double methodPercent = 0;

    @Column(name = "class_missed", nullable = false)
    private double classMissed = 0;

    @Column(name = "class_covered", nullable = false)
    private double classCovered;

    @Column(name = "class_total", nullable = false)
    private double classTotal;

    @Column(name = "class_percent", nullable = false)
    private double classPercent;

}
