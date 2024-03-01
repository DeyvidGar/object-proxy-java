package com.midominio.proxy.remote.models;

/**
 * POJO class that represent of a domain of service simulated remote.
 *
 * @author David G.
 * @version 1.0
 */
public class Video {

    /**
     * The name of a video.
     */
    private String name;

    /**
     * The author of a video
     */
    private String author;

    /**
     * Constructor with all arguments.
     *
     * @param name of a video.
     * @param author of a video.
     */
    public Video(String name, String author) {
        this.name = name;
        this.author = author;
    }

    // Methods Getters & Setters.
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
