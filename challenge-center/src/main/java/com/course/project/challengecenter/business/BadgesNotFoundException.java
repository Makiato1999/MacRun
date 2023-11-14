package com.course.project.challengecenter.business;

public class BadgesNotFoundException extends RuntimeException {

    public BadgesNotFoundException(Long id) {
        super("Could not find workout #" + id);
    }

}
