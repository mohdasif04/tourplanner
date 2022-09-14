package com.tourplanner.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tourplanner.entities.Trip;

public interface TripRepository extends JpaRepository<Trip, Integer> {

}
