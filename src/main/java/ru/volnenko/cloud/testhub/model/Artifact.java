package ru.volnenko.cloud.testhub.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import ru.volnenko.cloud.testhub.enumerated.ArtifactType;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "hub_artifact")
public class Artifact {

    @Id
    @NonNull
    @Column(name = "id")
    private String id = UUID.randomUUID().toString();

    @NonNull
    @Column(name = "group_id")
    private String groupId;

    @NonNull
    @Column(name = "name", unique = true)
    private String name = "";

    @NonNull
    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private ArtifactType type = ArtifactType.APPLICATION;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created")
    private Date created;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated")
    private Date updated;

}


