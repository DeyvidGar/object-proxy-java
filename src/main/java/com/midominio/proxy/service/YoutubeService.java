package com.midominio.proxy.service;

import com.midominio.proxy.remote.ThirdPartyYouTubeLib;
import com.midominio.proxy.remote.models.Video;

import java.util.Map;

/**
 * This class represents the logic of bisness for the app.
 */
public class YoutubeService {

    /**
     * Obtain de data of a video or videos.
     */
    private ThirdPartyYouTubeLib data;

    /**
     * Constructor of this class.
     *
     * @param data obtain the information of a videos.
     */
    public YoutubeService(ThirdPartyYouTubeLib data) {
        this.data = data;
    }

    /**
     * This method render in console all videos in the yt.
     */
    public void renderAllVideos() {
        System.out.println("***** Showing all videos *****");
        Map<String, Video> videos = this.data.getAllPopularVideos();

        for (Map.Entry<String, Video> map: videos.entrySet()) {
            showVideo(map.getValue());
        }

        System.out.println("***** End showing all videos *****");
    }

    /**
     * This method render in console the video in the yt.
     *
     * @param id of a video to show.
     */
    public void renderVideo(String id) {
        System.out.println("***** Show video *****");
        Video video = this.data.getVideo(id);
        showVideo(video);
        System.out.println("***** End show video *****");
    }

    /**
     * This method show the information in console of a video.
     *
     * @param video to render in console.
     */
    private void showVideo(Video video) {
        System.out.println("**********");
        System.out.println("Name: ".concat(video.getName()));
        System.out.println("Author: ".concat(video.getAuthor()));
        System.out.println("**********");
    }
}
