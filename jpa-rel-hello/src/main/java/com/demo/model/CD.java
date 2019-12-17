package com.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.CascadeType.PERSIST;

@Entity
public class CD {

	@Id 
	@GeneratedValue
	private Long id;

	@Column(length = 100)
	private String title;

	@Column(length = 3000)
	private String description;

	@Column(name = "unit_cost")
	private Float unitCost;

	@Column(name = "total_duration")
	private Float totalDuration;

	private String genre;

	
	@JoinColumn
	@OneToMany(cascade = PERSIST)
	private Set<Musician> musicians = new HashSet<>();

	public CD() {
	}

	public CD(String title) {
		this.title = title;
	}

	public CD(String title, String genre) {
		this.title = title;
		this.genre = genre;
	}

	public CD(String title, String description, Float unitCost, Float totalDuration, String genre) {
		this.title = title;
		this.description = description;
		this.unitCost = unitCost;
		this.totalDuration = totalDuration;
		this.genre = genre;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Float getUnitCost() {
		return unitCost;
	}

	public void setUnitCost(Float unitCost) {
		this.unitCost = unitCost;
	}

	public Float getTotalDuration() {
		return totalDuration;
	}

	public void setTotalDuration(Float totalDuration) {
		this.totalDuration = totalDuration;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public Set<Musician> getMusicians() {
		return musicians;
	}

	public void setMusicians(Set<Musician> musicians) {
		this.musicians = musicians;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("CD{");
		sb.append("id=").append(id);
		sb.append(", title='").append(title).append('\'');
		sb.append(", genre='").append(genre).append('\'');
		sb.append(", musicans='").append(musicians).append('\'');
		sb.append('}');
		return sb.toString();
	}
}
