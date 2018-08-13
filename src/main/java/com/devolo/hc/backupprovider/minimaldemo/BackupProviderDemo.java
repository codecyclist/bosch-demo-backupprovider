package com.devolo.hc.backupprovider.minimaldemo;

import com.prosyst.mbs.services.backup.BackupProvider;
import java.io.InputStream;
import java.io.OutputStream;

/**
 *
 * @author manfreddreese
 */
public class BackupProviderDemo implements BackupProvider {

    private final OsgiLogger logger;

    public BackupProviderDemo(OsgiLogger logger) {
        this.logger = logger;
        logger.debug("BackupProvider ready");
    }

    @Override
    public void backup(OutputStream arg0) throws Exception {
        logger.debug("backup called");
    }

    @Override
    public boolean restore(InputStream arg0, String arg1) throws Exception {
        logger.debug("restore called");
        return true;
    }

    @Override
    public String getDataVersion() {
        return "1.0.0";
    }

}
