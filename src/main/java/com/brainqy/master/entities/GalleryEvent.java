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
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

@Entity
@Table(name = "gallery_events")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class GalleryEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tenant_id", nullable = false)
    private Tenant tenant;

    @Column(nullable = false, length = 255)
    private String title;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date eventDate;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "gallery_event_images", joinColumns = @JoinColumn(name = "event_id"))
    @Column(name = "image_url", length = 500)
    private List<String> imageUrls;

    @Lob
    private String description;
    @Column(length = 100)
    private String location;
    private Boolean approved;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "created_by_user_id")
    private User createdByUser;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "gallery_event_attendees",
            joinColumns = @JoinColumn(name = "event_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private Set<User> attendees = new HashSet<>();
}

