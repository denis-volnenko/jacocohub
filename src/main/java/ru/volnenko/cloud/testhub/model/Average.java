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
@Table(name = "hub_average")
public class Average {

    @Id
    @NonNull
    @Column(name = "id")
    private String id = UUID.randomUUID().toString();

    @NonNull
    @Column(name = "category_id")
    private String categoryId;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created")
    private Date created;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated")
    private Date updated;

    @NonNull
    @Column(name = "coverage", nullable = false)
    private double coverage = 0;

}
