package com.tencent.mm.plugin.downloader;

import com.tencent.mm.by.h;
import com.tencent.mm.kernel.api.bucket.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.downloader.e.b;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;

public final class a implements com.tencent.mm.kernel.api.bucket.a, d, com.tencent.mm.plugin.downloader.b.a {
    private b lqX;

    public final void onDataBaseOpened(h hVar, h hVar2) {
        this.lqX = new b(hVar);
    }

    public final void onDataBaseClosed(h hVar, h hVar2) {
    }

    public final b Fe() {
        g.Dk();
        g.Dh().Ct();
        return this.lqX;
    }

    public final HashMap<Integer, h.d> collectDatabaseFactory() {
        x.d("MicroMsg.FileDownloaderService", "collectDatabaseFactory");
        HashMap<Integer, h.d> hashMap = new HashMap();
        hashMap.put(Integer.valueOf("FILEDOWNLOAD_TABLE".hashCode()), new 1(this));
        return hashMap;
    }
}
