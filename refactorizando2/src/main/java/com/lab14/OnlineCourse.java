package com.lab14;

public class OnlineCourse extends Course {
    private String platform;

    public OnlineCourse(String name, int duration, String platform) {
        super(name, duration);
        setPlatform(platform);
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        if (platform == null || platform.isBlank()) {
            throw new IllegalArgumentException("Platform cannot be null or empty");
        }
        this.platform = platform;
    }

    @Override
    public String showInformation() {
        return "[Online] " + getName() + " (" + getDuration() + " hs) - Platform: " + platform;
    }
}
