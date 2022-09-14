package com.tourplanner.test;

import java.time.LocalDate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.tourplanner.config.RootConfig;
import com.tourplanner.dto.TripDto;
import com.tourplanner.service.TripService;

public class TourPlannerTest {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(RootConfig.class);
		TripService tripService = context.getBean(TripService.class);

		/*
		 * TripDto tripDto =
		 * TripDto.builder().source("Allahabad").destination("Nagpur").
		 * tripName("Orange city trip") .plannedDate(LocalDate.of(2022, 9,
		 * 22)).estimatedCost(2150000).days(10).build();
		 * 
		 * int tripNo = tripService.newTrip(tripDto); System.out.println("tripNo : " +
		 * tripNo);
		 * 
		 * 
		 * 
		 * TripDto tripDto = tripService.findTrip(4); System.out.println("trip no :: " +
		 * tripDto);
		 * 
		 * tripService.deleteTrip(3);
		 */

//		tripService.getAllTrips().forEach(System.out::println);
//		System.out.println("=================================================");
		// tripService.deleteTrip(2);
//		TripDto tripDto = tripService.findTrip(4);
		// System.out.println(tripDto);
		// tripService.getAllTrips(1, 4).forEach(System.out::println);

		tripService.getTrips("days").forEach(System.out::println);

	}
}
