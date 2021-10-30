package com.training.ratings.dto;

import java.util.Objects;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public class DevelopmentDto {
	
	@NotNull
	private Long developmentId;
	@NotNull
	private Long politicalLeaderId;
	@NotNull
	private String title;
	@NotNull
	@Length(min = 5, max = 100)
	private String activity;
	@NotNull
	@DecimalMin(value = "0.00", inclusive = false)
    @Digits(integer=3, fraction=2)
	private String budget;
	@NotNull
	@Length(min = 3, max = 50)
	private String state;
	@NotNull
//	@Range(min = 1, max = 12)
	private Integer activityMonth;
	@NotNull
//	@Range(min = 2020, max = 2040)
	private Integer activityYear;

	public Long getDevelopmentId() {
		return developmentId;
	}

	public void setDevelopmentId(Long developmentId) {
		this.developmentId = developmentId;
	}

	public Long getPoliticalLeaderId() {
		return politicalLeaderId;
	}

	public void setPoliticalLeaderId(Long candidateId) {
		this.politicalLeaderId = candidateId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getActivity() {
		return activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}

	public String getBudget() {
		return budget;
	}

	public void setBudget(String budget) {
		this.budget = budget;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Integer getActivityMonth() {
		return activityMonth;
	}

	public void setActivityMonth(Integer activityMonth) {
		this.activityMonth = activityMonth;
	}

	public Integer getActivityYear() {
		return activityYear;
	}

	public void setActivityYear(Integer activityYear) {
		this.activityYear = activityYear;
	}

	@Override
	public int hashCode() {
		return Objects.hash(activity, activityMonth, activityYear, budget, politicalLeaderId, developmentId, state, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DevelopmentDto other = (DevelopmentDto) obj;
		return Objects.equals(activity, other.activity) && Objects.equals(activityMonth, other.activityMonth)
				&& Objects.equals(activityYear, other.activityYear) && Objects.equals(budget, other.budget)
				&& Objects.equals(politicalLeaderId, other.politicalLeaderId) && Objects.equals(developmentId, other.developmentId)
				&& Objects.equals(state, other.state) && Objects.equals(title, other.title);
	}

}
