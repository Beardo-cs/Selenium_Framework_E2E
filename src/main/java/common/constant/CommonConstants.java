package common.constant;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.Duration;

import static common.constant.Browser.CHROME;


public class CommonConstants {
    private final static Logger logger = LogManager.getLogger();
    public static final String BROWSER_NAME = getBrowserName();
    public static final String EXECUTION_ENV_NAME = getEnvironmentName();
    public static final Duration IMPLICIT_WAIT_IN_SECONDS = Duration.ofSeconds(60);
    public static final Duration EXPLICIT_WAIT_IN_SECONDS = Duration.ofSeconds(60);

    private static String getBrowserName() {
        String browserNameFromPomXml = System.getProperty("browser");
        String browserName;

        if (browserNameFromPomXml != null)
            browserName = browserNameFromPomXml;
        else {
            logger.warn("The Maven Profile is missing the platform configuration.");
            browserName = CHROME;
            logger.warn("The default platform '{}' will be enabled for this run.", browserName);
        }

        return browserName.toLowerCase();
    }

    private static String getEnvironmentName() {
        String environmentNameFromPomXml = System.getProperty("environment");
        String envName;

        if (environmentNameFromPomXml != null)
            envName = environmentNameFromPomXml;
        else {
            logger.warn("The Maven Profile is missing the environment configuration.");
            logger.warn("The default environment 'dev' will be enabled for this run.");
            envName = "dev";
        }

        return envName.toLowerCase();
    }
}
