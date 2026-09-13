package com.hibernate.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "energy_suggestions")
public class EnergySuggestion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int suggestionId;

    private int userId;
    private String title;
    private String category;
    private String description;
    private String recommendedAction;
    private double estimatedSaving;

    // Default constructor
    public EnergySuggestion() {
    }

    // Constructor with ID
    public EnergySuggestion(int suggestionId, int userId,
                            String title, String category,
                            String description, String recommendedAction,
                            double estimatedSaving) {

        this.suggestionId = suggestionId;
        this.userId = userId;
        this.title = title;
        this.category = category;
        this.description = description;
        this.recommendedAction = recommendedAction;
        this.estimatedSaving = estimatedSaving;
    }

    // Constructor without ID
    public EnergySuggestion(int userId, String title,
                            String category, String description,
                            String recommendedAction,
                            double estimatedSaving) {

        this.userId = userId;
        this.title = title;
        this.category = category;
        this.description = description;
        this.recommendedAction = recommendedAction;
        this.estimatedSaving = estimatedSaving;
    }

    public int getSuggestionId() {
        return suggestionId;
    }

    public void setSuggestionId(int suggestionId) {
        this.suggestionId = suggestionId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRecommendedAction() {
        return recommendedAction;
    }

    public void setRecommendedAction(String recommendedAction) {
        this.recommendedAction = recommendedAction;
    }

    public double getEstimatedSaving() {
        return estimatedSaving;
    }

    public void setEstimatedSaving(double estimatedSaving) {
        this.estimatedSaving = estimatedSaving;
    }
}