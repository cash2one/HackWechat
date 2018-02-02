package com.tencent.mm.plugin.gallery.ui;

import android.os.SystemClock;
import com.tencent.mm.plugin.gallery.model.a;
import com.tencent.mm.plugin.gallery.model.c;
import com.tencent.mm.sdk.platformtools.x;

class h$1 implements Runnable {
    final /* synthetic */ h mVa;

    h$1(h hVar) {
        this.mVa = hVar;
    }

    public final void run() {
        x.v("MicroMsg.ThumbDrawable", "invalidateSelf");
        h hVar = this.mVa;
        a aND = c.aND();
        String str = this.mVa.mFilePath;
        String str2 = this.mVa.mQx;
        long j = this.mVa.mQy;
        h.a(hVar, aND.Br(str));
        if (!(this.mVa.mUV == null || h.a(this.mVa) == null || h.a(this.mVa).isRecycled())) {
            this.mVa.mUV.aOn();
        }
        this.mVa.mUW = SystemClock.uptimeMillis();
        this.mVa.invalidateSelf();
    }
}
