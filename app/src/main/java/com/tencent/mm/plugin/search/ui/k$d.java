package com.tencent.mm.plugin.search.ui;

import android.graphics.Bitmap.CompressFormat;
import com.tencent.mm.plugin.search.ui.k.a;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;

class k$d implements Runnable {
    private a qdD;
    final /* synthetic */ k qdz;

    public k$d(k kVar, a aVar) {
        this.qdz = kVar;
        this.qdD = aVar;
    }

    public final void run() {
        x.d("MicroMsg.FTS.SearchImageLoader", "Start to run save bitmap job");
        try {
            if (!new File(this.qdD.fCa).exists()) {
                if (this.qdD.bitmap == null || this.qdD.bitmap.isRecycled()) {
                    x.d("MicroMsg.FTS.SearchImageLoader", "Save Bitmap is Recycled");
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                d.a(this.qdD.bitmap, 100, CompressFormat.PNG, this.qdD.fCa, false);
                x.d("MicroMsg.FTS.SearchImageLoader", "Save bitmap use time: %d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.FTS.SearchImageLoader", e, "", new Object[0]);
        }
    }
}
