package com.framework.utils;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogUtils {
    private static final Logger logger = LogManager.getLogger(LogUtils.class);

    public static void info(String msg){
         logger.info(msg);
    }
    public static void warn(String msg){
        logger.warn(msg);
    }
    public static void debug(String msg){ logger.debug(msg);}
    public static void error(String msg){
        logger.error(msg);
    }

}
