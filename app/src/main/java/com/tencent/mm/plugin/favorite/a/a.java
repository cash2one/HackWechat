package com.tencent.mm.plugin.favorite.a;

import android.os.Looper;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import java.util.ArrayList;

public final class a {
    private static a mpu = null;
    private long endTime = -1;
    private boolean lAx = false;
    af mHandler = new 2(this, Looper.getMainLooper());
    public ArrayList<a> mpt = new ArrayList();
    private Object mpv = new Object();
    private Runnable mpw = new 1(this);
    private long startTime = -1;

    private a() {
    }

    public static synchronized a aIw() {
        a aVar;
        synchronized (a.class) {
            if (mpu == null) {
                mpu = new a();
            }
            aVar = mpu;
        }
        return aVar;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(a aVar) {
        synchronized (this.mpv) {
            ar.Hg();
            if (!((Boolean) c.CU().get(com.tencent.mm.storage.w.a.xpB, Boolean.valueOf(false))).booleanValue()) {
                if (aVar != null) {
                    this.mpt.add(aVar);
                }
                if (this.lAx) {
                    x.i("MicroMsg.FavCleanFirstLoader", "isLoading is true, ignore");
                    return;
                }
                this.lAx = true;
                this.startTime = System.currentTimeMillis();
                e.post(this.mpw, "FavCleanFirstLoader_CalFavDataLength");
            } else if (aVar != null) {
                aVar.onFinish();
            }
        }
    }
}
