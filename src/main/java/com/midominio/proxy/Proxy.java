package com.midominio.proxy;

import com.midominio.proxy.proxy.YoutubeCacheProxy;
import com.midominio.proxy.remote.ThirdPartyYouTubeLibImpl;
import com.midominio.proxy.service.YoutubeService;

/**
 * Principal class to test the functionality of a class with Proxy and without Proxy.
 *
 * @author David G.
 * @version 1.0
 */
public class Proxy {

    /**
     * This main method obtain the time of completion of service with Proxy and without Proxy.
     *
     * @param args of array String.
     */
    public static void main(String[] args) {

        YoutubeService withoutProxy = new YoutubeService(new ThirdPartyYouTubeLibImpl());
        YoutubeService withProxy = new YoutubeService(new YoutubeCacheProxy());

        long currentTimeNoProxy = test(withoutProxy);
        System.out.println("currentTimeNoProxy = " + currentTimeNoProxy);

        long currentTimeProxy = test(withProxy);
        System.out.println("currentTimeProxy = " + currentTimeProxy);

        System.out.print("Time saved by caching proxy: " + (currentTimeNoProxy - currentTimeProxy) + "ms");
    }

    /**
     * Method to simulate the user of a user.
     *
     * @param service the service of our application.
     * @return
     */
    private static long test(YoutubeService service) {

        long timeMillis = System.currentTimeMillis();
        System.out.println("timeMillis = " + timeMillis);

        //primera peticion a nuestros datos
        service.renderAllVideos();
        service.renderVideo("gatos1");

        //segunda peticion datos que deberian estar en 'cache'
        service.renderAllVideos();
        service.renderVideo("gatos1");

        long estimateTime = System.currentTimeMillis();
        System.out.println("estimateTime = " + estimateTime);

        System.out.println("Time elapsed: " + (estimateTime - timeMillis));
        return estimateTime - timeMillis;


    }

}
