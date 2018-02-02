package com.tencent.mm.plugin.gallery.model;

import android.os.HandlerThread;
import android.os.Looper;
import android.os.Process;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;

public final class e {
    private af hae;
    HandlerThread mQV = new HandlerThread("galleryDecodeHanlderThread", 10);
    HandlerThread mQW;
    HandlerThread mQX;
    af mQY = null;
    af mQZ;
    af mRa;

    public e() {
        x.d("MicroMsg.GalleryHandlerThread", "galleryhandlerthread init");
        this.mQV.start();
        this.mQW = new HandlerThread("galleryQueryHandlerThread", 1);
        this.mQZ = null;
        this.mQW.start();
        this.mQX = new HandlerThread("galleryAfterTakePicThreadThread", 0);
        this.mRa = null;
        this.mQX.start();
    }

    public final af aNR() {
        if (this.mQY == null && this.mQV != null) {
            this.mQY = new af(this.mQV.getLooper());
        }
        return this.mQY;
    }

    public final void qn(int i) {
        try {
            Process.setThreadPriority(this.mQX.getThreadId(), i);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.GalleryHandlerThread", e, "", new Object[0]);
        }
    }

    public final af aNS() {
        if (this.mQZ == null) {
            this.mQZ = new af(this.mQW.getLooper());
        }
        return this.mQZ;
    }

    public final af aNT() {
        if (this.hae == null) {
            this.hae = new af(Looper.getMainLooper());
        }
        return this.hae;
    }

    public final void x(Runnable runnable) {
        af aNR = aNR();
        if (aNR == null) {
            x.e("MicroMsg.GalleryHandlerThread", "post to decode worker, but decode handler is null");
        } else {
            aNR.post(runnable);
        }
    }

    public final void aNU() {
        af aNR = aNR();
        if (aNR == null) {
            x.e("MicroMsg.GalleryHandlerThread", "remove all work handler callbacks, but decode handler is null");
        } else {
            aNR.removeCallbacksAndMessages(null);
        }
    }

    public final void y(Runnable runnable) {
        aNT().post(runnable);
    }
}
