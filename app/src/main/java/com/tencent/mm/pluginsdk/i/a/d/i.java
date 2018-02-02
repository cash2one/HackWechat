package com.tencent.mm.pluginsdk.i.a.d;

import android.util.SparseArray;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;

public final class i implements c {
    private final af vhD;
    public final SparseArray<List<d>> vhE = new SparseArray();
    public final Object vhF = new Object();

    i(af afVar) {
        this.vhD = afVar;
    }

    public final void a(e eVar, l lVar) {
        x.i("MicroMsg.ResDownloader.NetworkEventDispatcher", "dispatchResponse, response = " + lVar);
        q RW;
        List RV;
        switch (lVar.status) {
            case 2:
                RW = a.vhX.RW(lVar.vgd);
                if (RW != null) {
                    RW.field_status = 2;
                    a.vhX.e(RW);
                }
                x.d("MicroMsg.ResDownloader.NetworkEventDispatcher", "dispatchComplete, groupId = " + eVar.aab());
                RV = RV(eVar.aab());
                if (bh.cA(RV)) {
                    x.d("MicroMsg.ResDownloader.NetworkEventDispatcher", "dispatchComplete, listeners.size = null");
                    return;
                }
                x.d("MicroMsg.ResDownloader.NetworkEventDispatcher", "dispatchComplete, listeners.size = " + RV.size());
                this.vhD.post(new 2(this, RV, lVar, eVar.bZj()));
                return;
            case 3:
                RW = a.vhX.RW(lVar.vgd);
                if (RW != null) {
                    RW.field_status = 3;
                    a.vhX.e(RW);
                }
                RV = RV(eVar.aab());
                if (!bh.cA(RV)) {
                    this.vhD.post(new 1(this, RV, lVar, eVar.bZj()));
                    return;
                }
                return;
            case 4:
                RW = a.vhX.RW(lVar.vgd);
                if (RW != null) {
                    RW.field_status = 4;
                    a.vhX.e(RW);
                }
                RV = RV(eVar.aab());
                if (!bh.cA(RV)) {
                    this.vhD.post(new 3(this, RV, lVar, eVar.bZj()));
                    return;
                }
                return;
            default:
                return;
        }
    }

    public final void o(String str, int i, int i2) {
        x.i("MicroMsg.ResDownloader.NetworkEventDispatcher", "dispatchRetry, urlKey = %s, max = %d, count = %d", new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2)});
        q RW = a.vhX.RW(str);
        if (RW != null) {
            RW.field_maxRetryTimes = i;
            RW.field_retryTimes = i2;
            a.vhX.e(RW);
        }
    }

    public final void s(String str, long j) {
        q RW = a.vhX.RW(str);
        if (RW != null) {
            RW.field_contentLength = j;
            a.vhX.e(RW);
        }
    }

    private List<d> RV(String str) {
        List<d> list;
        int hashCode = str.hashCode();
        synchronized (this.vhF) {
            list = (List) this.vhE.get(hashCode);
        }
        return list;
    }
}
