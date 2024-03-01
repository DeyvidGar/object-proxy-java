package com.midominio.proxy.remote;

import com.midominio.proxy.remote.models.Video;
import com.midominio.proxy.remote.utils.YoutubeUtils;
import java.util.Map;

/**
 * This class simulate the real connection to service and database connection.
 *
 * @author David G.
 * @version 1.0
 */
public class ThirdPartyYouTubeLibImpl implements ThirdPartyYouTubeLib {

    /**
     * {@inheritDoc}
     *
     * @return a {@code Map} of a videos in the yt connection.
     */
    @Override
    public Map<String, Video> getAllPopularVideos() {
        System.out.println("***** Get All Videos Remote *****");

        try {
            YoutubeUtils.simulateConnTo("www.yt.com");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("***** End Get All Videos Remote *****");
        return YoutubeUtils.getVideos();
    }

    /**
     * {@inheritDoc}
     *
     * @return a instance of a {@code Video} in the database.
     */
    @Override
    public Video getVideo(String id) {
        System.out.println("***** Get Video "+id+" Remote *****");

        try {
            YoutubeUtils.simulateConnTo("www.yt.com/".concat(id));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("***** End Get Video Remote *****");
        return YoutubeUtils.getVideo(id);
    }
}
