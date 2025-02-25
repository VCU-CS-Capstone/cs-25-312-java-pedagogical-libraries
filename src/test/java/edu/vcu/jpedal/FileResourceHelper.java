package edu.vcu.jpedal;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileResourceHelper {
    /**
     * Takes a String filename from the class resources and returns its corresponding Path.
     *
     * @param resourceName a String of the resource's name
     * @return a Path pointing to the resource
     * @throws IOException if the resource can't be found
     */
    public static Path getResource(String resourceName) throws IOException {
        // TODO: elaborate on ClassLoader
        // Rather than hard-coding a filename we grab it from the resource folder
        // By convention this is located in /src/test/resources -dc
        ClassLoader classLoader = FileResourceHelper.class.getClassLoader();
        URL resourceURL = classLoader.getResource(resourceName);
        if (resourceURL == null) {
            throw new IOException("Resource " + resourceName + " not found in the classpath");
        }

        URI resourceURI;
        try {
            resourceURI = resourceURL.toURI();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
        return Paths.get(resourceURI);
    }
}
