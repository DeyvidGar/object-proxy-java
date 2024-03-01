package com.midominio.proxy.remote;

import com.midominio.proxy.remote.models.Video;

import java.util.Map;

/**
 * This interface simulate a remote service.
 *
 * @author David G.
 * @version 1.0
 */
public interface ThirdPartyYouTubeLib {

    /**
     * This method obtain all of a videos in simulate remote service.
     *
     * @return
     */
    Map<String, Video> getAllPopularVideos();

    /**
     * Method to obtain a Video by id.
     *
     * @param id of a video to find.
     * @return a instance of a Video.
     */
    Video getVideo(String id);

}
