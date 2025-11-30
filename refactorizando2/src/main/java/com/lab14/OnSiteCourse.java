package com.lab14;

public class OnSiteCourse extends Course {
    private String classroom;

    public OnSiteCourse(String name, int duration, String classroom) {
        super(name, duration);
        setClassroom(classroom);
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        if (classroom == null || classroom.isBlank()) {
            throw new IllegalArgumentException("Classroom cannot be null or empty");
        }
        this.classroom = classroom;
    }

    @Override
    public String showInformation() {
        return "[On Site] " + getName() + " (" + getDuration() + " hs) - Room: " + classroom;
    }
}
