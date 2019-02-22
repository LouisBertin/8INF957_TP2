import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * The type Config.
 */
public class Config {

    /**
     * The Input stream.
     */
    private static InputStream inputStream;

    /**
     * Gets prop values.
     *
     * @param param the param
     * @return the prop values
     */
    public static String getPropValues(String param) {
        String result = "";

        try {
            Properties prop = new Properties();
            String propFileName = "ressources/config.properties";

            inputStream = Config.class.getClassLoader().getResourceAsStream(propFileName);

            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }

            // return prop
            return prop.getProperty(param);
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}
