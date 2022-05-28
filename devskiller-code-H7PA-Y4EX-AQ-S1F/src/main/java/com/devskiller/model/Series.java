package com.devskiller.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@EqualsAndHashCode
@Getter
@Setter
@Table(name = "series")
@Entity
@NoArgsConstructor
public class Series {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(unique = true, nullable = false)
    private String title;
    @Column(name = "number_of_episodes", nullable = false)
    private int numberOfEpisodes;
    @Column(nullable = false)
    private int score;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ContentType type;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "streaming_platform_id")
    private StreamingPlatform streamingPlatform;

    public enum ContentType {
        ANIMATION, SF, HORROR, DRAMA, THRILLER, ACTION, FANTASY, CARTOON
    }
}
