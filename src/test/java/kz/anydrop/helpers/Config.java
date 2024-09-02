package kz.anydrop.helpers;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {

    Properties properties = new Properties();

    public Config() {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        try (InputStream resourceStream = loader.getResourceAsStream("application.properties")) {
            properties.load(resourceStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String get(String valueName) {
        return properties.getProperty(valueName);
    }
    public void set(String key, String value) {
        properties.put(key, value);
    }

}
