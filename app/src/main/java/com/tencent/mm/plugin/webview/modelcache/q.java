package com.tencent.mm.plugin.webview.modelcache;

import android.util.SparseArray;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import java.util.Iterator;
import java.util.Set;

public final class q {
    private volatile ag hmW;
    private final Object jRO;
    public final c ttP;
    public final c ttQ;
    private volatile i ttR;
    final SparseArray<l> ttS;
    public final c ttT;
    final e ttU;
    public final byte[] ttV;
    public final SparseArray<Set<Object>> ttW;

    private q() {
        this.ttP = new 1(this);
        this.ttQ = new 2(this);
        this.ttS = new SparseArray();
        this.ttT = new c();
        this.ttU = new e();
        this.jRO = new Object();
        this.ttV = new byte[0];
        this.ttW = new SparseArray();
    }

    public final void release(boolean z) {
        for (int i = 0; i < this.ttS.size(); i++) {
            this.ttS.valueAt(i);
        }
        this.ttS.clear();
        a.clearCache();
        if (this.hmW != null) {
            synchronized (this.jRO) {
                if (this.hmW == null) {
                } else if (z) {
                    this.hmW.oAt.quit();
                } else {
                    this.hmW.F(new 4(this, this.hmW));
                    this.hmW = null;
                }
            }
        }
    }

    public final ag Dm() {
        if (this.hmW == null) {
            synchronized (this.jRO) {
                if (this.hmW == null) {
                    this.hmW = new 3(this, "WebViewCacheWorkerManager#WorkerThread");
                }
            }
        }
        return this.hmW;
    }

    public final void Aq(int i) {
        if (ar.Hj()) {
            try {
                Set set;
                a.bRp().ttU.An(i);
                synchronized (this.ttV) {
                    set = (Set) this.ttW.get(i);
                }
                if (set == null) {
                    return;
                }
                if (set.size() > 0) {
                    Iterator it = set.iterator();
                    while (it.hasNext()) {
                        it.next();
                        if (this.ttR == null) {
                            this.ttR = new i();
                        }
                        i iVar = this.ttR;
                    }
                }
            } catch (Exception e) {
                x.e("MicroMsg.WebViewCacheWorkerManager", "onWebViewUIDestroy, accHasReady, but occurred exception = %s", new Object[]{e});
            }
        }
    }
}
