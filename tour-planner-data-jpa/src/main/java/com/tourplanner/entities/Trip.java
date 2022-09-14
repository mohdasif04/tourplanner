package com.tourplanner.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "trip")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Trip {

	@Id
	@Column(name = "trip_no")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int tripNo;
	@Column(name = "trip_name")
	private String tripName;
	private String source;
	private String destination;
	@Column(name = "planned_dt")
	private LocalDate plannedDate;
	private int days;
	@Column(name = "estimated_cost")
	private double estimatedCost;

}
