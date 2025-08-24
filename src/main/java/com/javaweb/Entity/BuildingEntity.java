package com.javaweb.Entity;

public class BuildingEntity {
	private String Name;
	private Integer NumberOfBasement;
	private String Ward;
	private String Way;
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public Integer getNumberOfBasement() {
		return NumberOfBasement;
	}
	public void setNumberOfBasement(Integer numberOfBasement) {
		NumberOfBasement = numberOfBasement;
	}
	public String getWard() {
		return Ward;
	}
	public void setWard(String ward) {
		Ward = ward;
	}
	public String getWay() {
		return Way;
	}
	public void setWay(String way) {
		Way = way;
	}
}
