package com.lab14;

public class Course {
    private String name;
    private int duration;

    public Course(String name, int duration) {
        setName(name);
        setDuration(duration);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        this.name = name;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        if (duration <= 0) {
            throw new IllegalArgumentException("Duration must be positive");
        }
        this.duration = duration;
    }

    public String showInformation() {
        return name + " (" + duration + " hs)";
    }
}
