package com.devskiller.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode
@Getter
@Setter
@Entity
@Table(name = "streaming_platform")
@NoArgsConstructor
public class StreamingPlatform {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(unique = true, nullable = false)
    private String name;
    @Column(nullable = false)
    private String headquarter;
    @Column(nullable = false)
    private String website;
    @Column(columnDefinition = "DATE", nullable = false)
    private LocalDate launched;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "streamingPlatform")
    private List<Series> series = new ArrayList<>();
}
