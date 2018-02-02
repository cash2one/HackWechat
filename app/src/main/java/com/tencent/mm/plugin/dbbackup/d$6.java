package com.tencent.mm.plugin.dbbackup;

import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;

class d$6 implements Runnable {
    final /* synthetic */ d lqk;
    final /* synthetic */ String lqv;

    d$6(d dVar, String str) {
        this.lqk = dVar;
        this.lqv = str;
    }

    public final void run() {
        if (!FileOp.bO((this.lqv + "corrupted/EnMicroMsg.db") + ".corrupt")) {
            long currentTimeMillis = System.currentTimeMillis();
            File file = new File(this.lqv + "corrupted");
            if (file.isDirectory()) {
                File[] listFiles = file.listFiles();
                int length = listFiles.length;
                int i = 0;
                while (i < length) {
                    if (currentTimeMillis - listFiles[i].lastModified() >= 7776000000L) {
                        i++;
                    } else {
                        return;
                    }
                }
                if (FileOp.G(file.getPath(), false)) {
                    x.i("MicroMsg.SubCoreDBBackup", "Corrupted databases removed.");
                }
            }
        }
    }
}
