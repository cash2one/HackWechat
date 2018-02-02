package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.mm.loader.stub.b;
import com.tencent.mm.sdk.platformtools.bh;
import java.io.File;

class d$1 implements Runnable {
    d$1() {
    }

    public final void run() {
        File file = new File(AppBrandLocalMediaObjectManager.OBJECT_ROOT_DIR_PATH);
        if (file.exists() && file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null && listFiles.length > 0) {
                for (File q : listFiles) {
                    q(q);
                }
            }
        }
    }

    private void q(File file) {
        if (file.exists() && file.isDirectory()) {
            File[] listFiles = file.listFiles(new 1(this));
            if (listFiles != null && listFiles.length > 0) {
                long Wp = bh.Wp();
                for (File file2 : listFiles) {
                    if (Wp - file2.lastModified() >= d.aaz()) {
                        b.deleteFile(file2.getAbsolutePath());
                    }
                }
            }
        }
    }
}
