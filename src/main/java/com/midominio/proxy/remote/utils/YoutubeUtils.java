package com.midominio.proxy.remote.utils;

import com.midominio.proxy.remote.models.Video;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Utils class for simulate remote connection on yt.
 *
 * @author David G.
 * @version 1.0
 */
public class YoutubeUtils {

    /**
     * Method to simulate values in the database.
     *
     * @return {@code Map<String, Video} data of simulate db.
     */
    public static Map<String, Video> getVideos() {
        System.out.println("***** Obteneniendo videos de BD simulacion *****");

        Map<String, Video> videos = new HashMap<>();
        videos.put("gatos1", new Video("la casa de gatos", "Catman"));
        videos.put("pepsi1", new Video("El refresco mas grande", "Pepsi"));
        videos.put("cocacola1", new Video("Repartiendo sonrisas", "Coca-cola"));
        videos.put("dogs2", new Video("Casa de perros", "Dogman"));

        System.out.println("***** Videos obtenidos simulacion *****");
        return videos;
    }

    /**
     * Method that simulate obtain a video on the database.
     *
     * @param id of a video in the uri.
     * @return {@code Video} instance.
     */
    public static Video getVideo(String id) {
        System.out.println("***** obteniendo el video ".concat(id).concat(" *****"));
        System.out.println("***** Video obtenido *****");
        return getVideos().get(id);
    }

    /**
     * Metodo para simular conexion a una bd, es decir tiempo de latencia aleatoria
     * @param uri
     * @throws InterruptedException
     */
    /**
     * Method to simulate the latency of a database.
     *
     * @param uri to show in console the api simulate connection.
     * @throws InterruptedException for time to sleep.
     */
    public static void simulateConnTo(String uri) throws InterruptedException {
        System.out.println("***** Conectando con servicio: "+uri+" *****");

        int timeLatency = randomLatency();
        for (int i = 0; i <= timeLatency; i++) TimeUnit.MILLISECONDS.sleep(100L);
        System.out.println("Tiempo de latencia: "+ timeLatency*100 + " milisegundo");

        System.out.println("***** Conexion exitosa *****");
    }

    /**
     * Generate de random value between 0 to 10.
     *
     * @return {@code Double} value between 0-10.
     */
    private static int randomLatency() {
        Double latency = Math.random() * 10L;

        return latency.intValue();
    }

}
