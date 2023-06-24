package com.bmt.bookmyticket.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@Table(name = "theaters")
@NoArgsConstructor
@Builder
@AllArgsConstructor
@ToString
public class TheaterEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "address", nullable = false)
    private String address;

    @OneToMany(mappedBy = "theater", cascade = CascadeType.ALL)
    @JsonIgnore
    @Builder.Default
    private List<ShowEntity> shows = new ArrayList<>();

    @OneToMany(mappedBy = "theater", cascade = CascadeType.ALL)
    @JsonIgnore
    @Builder.Default
    private List<TheaterSeatsEntity> seats = new ArrayList<>();
}
