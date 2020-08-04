import org.apache.log4j.Logger;
import org.junit.Test;

public class Log4jTest {
    static Logger logger = Logger.getLogger(Log4jTest.class);

    @Test
    public void test() {
        logger.info("info: 测试log4j");
        logger.debug("debug: 测试log4j");
        logger.error("error:测试log4j");
    }
}
