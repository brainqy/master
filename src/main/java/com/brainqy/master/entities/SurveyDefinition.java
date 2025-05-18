package com.brainqy.master.entities;

/**
 * Description of the class or file.
 *
 * @author Dnyaneshwar Somwanshi
 * @version 1.0
 * @project master
 * @since 17-05-2025
 */
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;


@Entity
@Table(name = "survey_definitions")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class SurveyDefinition {

    @Id
    @Column(length = 100)
    private String id;

    @Column(nullable = false, length = 255)
    private String name;
    @Lob
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tenant_id")
    private Tenant tenant;

    @Lob
    @Column(nullable = false, columnDefinition = "TEXT")
    private String stepsJson;
}

