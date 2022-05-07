package com.skilldistillery.film.entities;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class Film {
	private int id;
	private String title;
	private String description;
	private short releaseYear;
	private int languageId;
	private int rentalDuration;
	private double rentalRate;
	private Integer length;
	private double replaceCost;
	private String rating;
	private String specialFeatures;
	private List<Actor> cast;
	private String language;
	private List<String> categories;
	private List<String> inventoryCondition;
	
	{
		cast = new ArrayList<>();
		categories = new ArrayList<>();
		inventoryCondition = new ArrayList<>();
	}

	public Film(int filmId, String title, String desc, short releaseYear, int langId, int rentDur, double rate,
			Integer length, double repCost, String rating, String features, List<Actor> actors) {
		super();
		this.id = filmId;
		this.title = title;
		this.description = desc;
		this.releaseYear = releaseYear;
		this.languageId = langId;
		this.rentalDuration = rentDur;
		this.rentalRate = rate;
		this.length = length;
		this.replaceCost = repCost;
		this.rating = rating;
		this.specialFeatures = features;
		this.cast = actors;
	}

	public Film(String title, String description, short releaseYear, int languageId, int rentalDuration,
			double rentalRate, Integer length, double replaceCost, String rating, String specialFeatures) {
		super();
		this.title = title;
		this.description = description;
		this.releaseYear = releaseYear;
		this.languageId = languageId;
		this.rentalDuration = rentalDuration;
		this.rentalRate = rentalRate;
		this.length = length;
		this.replaceCost = replaceCost;
		this.rating = rating;
		this.specialFeatures = specialFeatures;
	}

	public Film(int filmId, String title, String desc, short releaseYear, int langId, int rentDur, double rate,
			Integer length, double repCost, String rating, String features) {
		super();
		this.id = filmId;
		this.title = title;
		this.description = desc;
		this.releaseYear = releaseYear;
		this.languageId = langId;
		this.rentalDuration = rentDur;
		this.rentalRate = rate;
		this.length = length;
		this.replaceCost = repCost;
		this.rating = rating;
		this.specialFeatures = features;
	}
	
	
	public List<String> getInventoryCondition() {
		return inventoryCondition;
	}

	public void setInventoryCondition(List<String> inventoryCondition) {
		this.inventoryCondition = inventoryCondition;
	}
	
	public void addInventoryCondition(String condition) {
		inventoryCondition.add(condition);
	}
	
	public String listInventoryCondition() {
		StringBuilder sb = new StringBuilder();
		Iterator<String> it = inventoryCondition.iterator();
		sb.append("Known Conditions: ");
		while(it.hasNext()) {
			sb.append(it.next() + ", ");
		}
		sb.replace(sb.length()-2, sb.length(), "");
		sb.append("\n\n");
		
		return sb.toString();
		
	}

	
	public List<String> getCategories() {
		return categories;
	}
	
	public void addCategory(String category) {
		categories.add(category);
	}

	public void setCategories(List<String> categories) {
		this.categories = categories;
	}
	
	public String listCategories() {
		StringBuilder sb = new StringBuilder();
		sb.append("Categories: ");
		for(int i = 0; i < categories.size(); i++) {
			if(i != categories.size() -1) {
				sb.append(categories.get(i) + " ");
			} else {
				sb.append(categories.get(i) + "\n");
			}
			sb.append("\n");
		}
		return sb.toString();
	}

	
	
	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public List<Actor> getCast() {
		return cast;
	}

	public void setCast(List<Actor> actors) {
		this.cast = actors;
	}

	public String listCast() {
		StringBuilder sb = new StringBuilder();
		sb.append("");
		if(!cast.isEmpty())
			sb.append("Cast:\n");
		for (int i = 0; i < cast.size(); i++) {
			sb.append(cast.get(i).getFirstName() + " " + cast.get(i).getLastName() + "\n");
		}
			
		return sb.toString();
	}
	

	public int getId() {
		return id;
	}

	public void setId(int filmId) {
		this.id = filmId;
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

	public void setDescription(String desc) {
		this.description = desc;
	}

	
	public short getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(short releaseYear) {
		this.releaseYear = releaseYear;
	}

	
	public int getLanguageId() {
		return languageId;
	}

	public void setLanguageId(int langId) {
		this.languageId = langId;
	}

	
	public int getRentalDuration() {
		return rentalDuration;
	}

	public void setRentalDuration(int rentDur) {
		this.rentalDuration = rentDur;
	}

	
	public double getRentalRate() {
		return rentalRate;
	}

	public void setRentalRate(double rate) {
		this.rentalRate = rate;
	}

	
	public Integer getLength() {
		return length;
	}

	public void setLength(Integer length) {
		this.length = length;
	}

	
	public double getReplaceCost() {
		return replaceCost;
	}

	public void setReplaceCost(double repCost) {
		this.replaceCost = repCost;
	}

	
	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	
	public String getSpecialFeatures() {
		return specialFeatures;
	}

	public void setSpecialFeatures(String features) {
		this.specialFeatures = features;
	}


	@Override
	public int hashCode() {
		return Objects.hash(id, inventoryCondition, languageId, length, rating, releaseYear, rentalDuration, rentalRate,
				replaceCost, specialFeatures, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Film other = (Film) obj;
		return id == other.id && Objects.equals(inventoryCondition, other.inventoryCondition)
				&& languageId == other.languageId && Objects.equals(length, other.length)
				&& Objects.equals(rating, other.rating) && releaseYear == other.releaseYear
				&& rentalDuration == other.rentalDuration
				&& Double.doubleToLongBits(rentalRate) == Double.doubleToLongBits(other.rentalRate)
				&& Double.doubleToLongBits(replaceCost) == Double.doubleToLongBits(other.replaceCost)
				&& Objects.equals(specialFeatures, other.specialFeatures) && Objects.equals(title, other.title);
	}
	
	
	@Override
	public String toString() {
		return "[Title: " + title + " || ID: " + id + " || Release Year: " + releaseYear + " || Length: " + length + " minutes]\n"
				+ "[Replace Cost: " + replaceCost + " || Rental Duration: " + rentalDuration + " || Rental Rate: " + rentalRate + "]\n"
				+ "[Language: " + language + " || Rating: " + rating + " || Special Features: "
				+ specialFeatures + "]\n" + "[Description: " + description + "]\n\n" + listCategories() + listInventoryCondition() + listCast();
	}
	
	public String quickDisplay() {
		StringBuilder sb = new StringBuilder();  
		sb.append("[Title: " + title +  " || Release Year: " + releaseYear + " || Rating: " + rating + " || Language: " + language + "]\n\n");
		sb.append(description + "\n\n");
		sb.append(listCast());
		return sb.toString();
		
	}
	
	
}
