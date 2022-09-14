package com.tourplanner.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Setter
public class TripDto {

	private int tripNo;
	private String tripName;
	private String source;
	private String destination;
	private LocalDate plannedDate;
	private int days;
	private double estimatedCost;

}
