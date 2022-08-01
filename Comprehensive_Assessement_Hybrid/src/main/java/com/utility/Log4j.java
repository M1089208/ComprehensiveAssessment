package com.utility;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;


public class Log4j {


	static {
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
		System.setProperty("current.date.time", dateFormat.format(new Date()));
    }

	public Logger log = LogManager.getLogger(Log4j.class.getName());

	public void logInfo(String infomsg) {
		log.info(infomsg);
	}

	public void logWarn(String warnmsg) {
		log.warn(warnmsg);
	}

	public void logError(String errormsg) {
		log.error(errormsg);
	}

	public void logDebug(String debugmsg) {
		log.debug(debugmsg);
	}

	public void logFetal(String fetalmsg) {
		log.fatal(fetalmsg);
	}
}
