package com.bmt.bookmyticket.model;

import jakarta.persistence.*;

import com.bmt.bookmyticket.enums.SeatType;
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
@Table(name = "theater_seats")
@NoArgsConstructor
@Builder
@AllArgsConstructor
@ToString
public class TheaterSeatsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "seat_number", nullable = false)
    private String seatNumber;

    @Column(name = "rate", nullable = false)
    private int rate;

    @Enumerated(EnumType.STRING)
    @Column(name = "seat_type", nullable = false)
    private SeatType seatType;

    @ManyToOne
    @JsonIgnore
    private TheaterEntity theater;
}