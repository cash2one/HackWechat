package com.tencent.mm.plugin.facedetect.model;

import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class d {
    public static final Object mLock = new Object();
    private static volatile d mfV = null;
    public List<a> mfW = null;

    private class a {
        public byte[] data;
        public b mfX;
        final /* synthetic */ d mfY;

        a(d dVar, b bVar) {
            this.mfY = dVar;
            this.mfX = bVar;
        }
    }

    public static final d aGr() {
        if (mfV != null) {
            return mfV;
        }
        d dVar;
        synchronized (mLock) {
            if (mfV == null) {
                mfV = new d();
            }
            dVar = mfV;
        }
        return dVar;
    }

    public final synchronized void a(b bVar) {
        if (bVar == null) {
            x.w("MicroMsg.FaceCameraDataCallbackHolder", "hy: invalid callbacker");
        } else {
            synchronized (mLock) {
                if (this.mfW == null) {
                    this.mfW = Collections.synchronizedList(new ArrayList(5));
                }
                this.mfW.add(new a(this, bVar));
            }
        }
    }

    public final void b(b bVar) {
        synchronized (mLock) {
            if (this.mfW != null) {
                this.mfW.remove(bVar);
            }
        }
    }
}
