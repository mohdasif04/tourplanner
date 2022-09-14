package com.tourplanner.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tourplanner.dto.TripDto;
import com.tourplanner.entities.Trip;
import com.tourplanner.repositories.TripRepository;

@Service
public class TripService {

	@Autowired
	private TripRepository tripRepository;

	@Transactional(readOnly = false)
	public int newTrip(TripDto tripDto) {
		Trip trip = null;

		trip = Trip.builder().build();
		BeanUtils.copyProperties(tripDto, trip);
		trip = tripRepository.save(trip);

		return trip.getTripNo();
	}

	@Transactional(readOnly = true)
	public List<TripDto> getAllTrips() {
		return tripRepository.findAll().stream().map(e -> {
			TripDto tripDto = new TripDto();
			BeanUtils.copyProperties(e, tripDto);
			return tripDto;
		}).collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public TripDto findTrip(int tripNo) {

		TripDto tripDto = null;
		Optional<Trip> trip = tripRepository.findById(tripNo);
		if (trip.isPresent()) {
			tripDto = new TripDto();
			BeanUtils.copyProperties(trip, tripDto);
		}
		return tripDto;
	}

	@Transactional(readOnly = false)
	public void deleteTrip(int tripNo) {

		Trip trip = null;
		trip = Trip.builder().tripNo(tripNo).build();

		tripRepository.delete(trip);
	}

	public List<TripDto> getAllTrips(int pageSize, int pageNo) {

		return tripRepository.findAll(Pageable.ofSize(pageSize).withPage(pageNo)).stream().map(e -> {
			TripDto tripDto = new TripDto();
			BeanUtils.copyProperties(e, tripDto);
			return tripDto;
		}).collect(Collectors.toList());
	}

	public List<TripDto> getTrips(String sortColumn) {

		return tripRepository.findAll(Sort.by(sortColumn)).stream().map(e -> {
			TripDto tripDto = new TripDto();
			BeanUtils.copyProperties(e, tripDto);
			return tripDto;
		}).collect(Collectors.toList());

	}

}
