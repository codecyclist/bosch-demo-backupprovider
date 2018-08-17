package com.devolo.hc.backupprovider.minimaldemo;

import com.prosyst.mbs.services.backup.BackupProvider;
import java.util.Dictionary;
import java.util.Hashtable;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {

    private OsgiLogger log;
    private ServiceRegistration backupProviderService;

    private static final String BACKUPPROVIDER_SYMBOLIC_NAME = " devolo.backupdemo,com.devolo.homecontrol.backupdemo";

    public void start(BundleContext context) throws Exception {
        log = new OsgiLogger(context, "mxd");
        log.debug("action=start");

        backupProviderService = registerBackupProvider(context, log);
        log.debug("Backup provider registration="+backupProviderService);
    }

    private ServiceRegistration registerBackupProvider(BundleContext context, OsgiLogger log) {        
        BackupProviderDemo backupProvider = new BackupProviderDemo(log);
        Dictionary registrationProperties = new Hashtable();
        registrationProperties.put(BackupProvider.BACKUP_ALIASES_PROPERTY, BACKUPPROVIDER_SYMBOLIC_NAME);
        return context.registerService(BackupProvider.class.getName(), backupProvider, registrationProperties);
    }

    public void stop(BundleContext context) throws Exception {
        if(backupProviderService!=null) {
            backupProviderService.unregister();
        }
    }

}
