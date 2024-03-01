package com.midominio.proxy.proxy;

import com.midominio.proxy.remote.models.Video;
import com.midominio.proxy.remote.ThirdPartyYouTubeLib;
import com.midominio.proxy.remote.ThirdPartyYouTubeLibImpl;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * THis class implement the Object Proxy pattern design.
 *
 * @author David G.
 * @version 1.0
 */
public class YoutubeCacheProxy implements ThirdPartyYouTubeLib {

    /**
     * The ThirdPartyYT library of simulate remote service.
     */
    private ThirdPartyYouTubeLib service;

    /**
     * The videosInCache storage a Map of Videos.
     */
    private Map<String, Video> videosInCache = new HashMap<>();

    /**
     * This {@code Map<String, Video>} storage the videos that the user get.
     */
    private Map<String, Video> videoInCache = new HashMap<>();

    /**
     * Constructor that create a new instance of class to be proxy.
     */
    public YoutubeCacheProxy() {
        this.service = new ThirdPartyYouTubeLibImpl();
    }

    /**
     * {@inheritDoc}
     *
     * @return Map of videos in simulated cache storage.
     */
    @Override
    public Map<String, Video> getAllPopularVideos() {
        System.out.println("***** Get All Videos Proxy *****");

        if (this.videosInCache.isEmpty()){

            System.out.println("***** Cache vacio... ******");
            this.videosInCache = this.service.getAllPopularVideos();

        } else {
            System.out.println("***** Obteniendo desde Cache ... *****");
        }

        System.out.println("***** End Get All Videos Proxy *****");
        return this.videosInCache;
    }

    /**
     * {@inheritDoc}
     *
     * @param id of a video to find.
     * @return a instance of a video.
     */
    @Override
    public Video getVideo(String id) {
        System.out.println("***** Get Video "+id+" Proxy *****");
        Video video = this.videoInCache.get(id);

        if(Objects.isNull(video)){

            System.out.println("***** Cache vacio... ******");
            video = this.service.getVideo(id);
            this.videoInCache.put(id, video);

        } else {
            System.out.println("***** Obteniendo desde Cache ... ******");
        }

        System.out.println("***** End Get Video Proxy *****");
        return video;
    }
}
