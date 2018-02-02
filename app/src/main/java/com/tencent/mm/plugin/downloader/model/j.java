package com.tencent.mm.plugin.downloader.model;

import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;

public abstract class j implements p {
    protected c lsp;

    public j(c cVar) {
        this.lsp = cVar;
    }

    public static void xQ(String str) {
        if (!bh.ov(str)) {
            if (new File(str).exists()) {
                x.i("MicroMsg.FileDownloaderImplBase", "Delete previous file result: %b", new Object[]{Boolean.valueOf(new File(str).delete())});
            }
        }
    }
}
