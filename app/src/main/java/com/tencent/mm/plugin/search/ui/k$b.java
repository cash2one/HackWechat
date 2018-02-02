package com.tencent.mm.plugin.search.ui;

import android.graphics.Bitmap;
import com.tencent.mm.plugin.search.ui.k.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class k$b implements Runnable {
    private String fCa;
    private int height;
    private String iUc;
    private boolean qdB;
    private c qdC;
    final /* synthetic */ k qdz;
    private String url;
    private int width;

    public k$b(k kVar, String str, String str2, String str3, boolean z, int i, int i2, c cVar) {
        this.qdz = kVar;
        this.iUc = str;
        this.url = str2;
        this.fCa = str3;
        this.qdC = cVar;
        this.qdB = z;
        this.width = i;
        this.height = i2;
    }

    public final void run() {
        x.d("MicroMsg.FTS.SearchImageLoader", "Start to run load bitmap job %s", new Object[]{this.iUc});
        if (bh.ov(this.fCa)) {
            this.fCa = k.IW(this.iUc);
        }
        long currentTimeMillis = System.currentTimeMillis();
        Bitmap Q = k.Q(this.fCa, this.width, this.height);
        long currentTimeMillis2 = System.currentTimeMillis();
        if (Q != null) {
            x.d("MicroMsg.FTS.SearchImageLoader", "Found image in local %s | localPath %s | use time %d", new Object[]{this.url, this.fCa, Long.valueOf(currentTimeMillis2 - currentTimeMillis)});
            k.a(this.qdz, this.iUc, this.fCa, Q);
            this.qdC.ay(this.iUc, true);
            return;
        }
        Bitmap a = k.a(this.qdz, this.url, this.qdB, this.width, this.height);
        long currentTimeMillis3 = System.currentTimeMillis();
        x.d("MicroMsg.FTS.SearchImageLoader", "Get image from net %s | localPath %s | use time %d", new Object[]{this.url, this.fCa, Long.valueOf(currentTimeMillis3 - currentTimeMillis2)});
        if (a != null) {
            k.a(this.qdz, this.iUc, this.fCa, a);
            this.qdC.ay(this.iUc, true);
            return;
        }
        this.qdC.ay(this.iUc, false);
    }
}
