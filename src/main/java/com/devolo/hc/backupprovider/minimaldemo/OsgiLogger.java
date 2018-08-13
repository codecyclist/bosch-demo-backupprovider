package com.devolo.hc.backupprovider.minimaldemo;

import org.osgi.framework.BundleContext;
import org.osgi.service.log.LogService;
import org.osgi.util.tracker.ServiceTracker;

/**
 *
 * @author manfreddreese
 */
public class OsgiLogger{

    private final String prefix;

    private ServiceTracker logServiceTracker = null;

    public OsgiLogger(BundleContext context, String prefix) {
        this.prefix = prefix;
        logServiceTracker = new ServiceTracker(context,
                org.osgi.service.log.LogService.class.getName(), null);
        logServiceTracker.open();
    }

    private void log(int i, String s) {
        LogService logService = (LogService) logServiceTracker.getService();
        if (logService != null) {
            logService.log(i, "[" + prefix + "] " + s);
        }
    }

    /* (non-Javadoc)
	 * @see com.devolo.hc.mqttpublisher.ILogger#debug(java.lang.String)
     */    
    public void debug(String msg) {
        log(LogService.LOG_DEBUG, msg);
    }

    /* (non-Javadoc)
	 * @see com.devolo.hc.mqttpublisher.ILogger#info(java.lang.String)
     */    
    public void info(String msg) {
        log(LogService.LOG_INFO, msg);
    }

    /* (non-Javadoc)
	 * @see com.devolo.hc.mqttpublisher.ILogger#warn(java.lang.String)
     */    
    public void warn(String msg) {
        log(LogService.LOG_WARNING, msg);
    }

    /* (non-Javadoc)
	 * @see com.devolo.hc.mqttpublisher.ILogger#error(java.lang.String)
     */    
    public void error(String msg) {
        log(LogService.LOG_ERROR, msg);
    }
}
