package com.tencent.mm.plugin.downloader.model;

import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;

class i$3 implements Runnable {
    final /* synthetic */ i lsO;

    i$3(i iVar) {
        this.lsO = iVar;
    }

    public final void run() {
        try {
            Iterator it = this.lsO.lsM.iterator();
            while (it.hasNext()) {
                i.a(this.lsO, Long.valueOf(((Long) it.next()).longValue()));
            }
        } catch (Exception e) {
            x.e("MicroMsg.FileDownloaderImpl23", e.getMessage());
        }
    }
}
