package com.tencent.mm.pluginsdk.i.a.d;

import android.database.Cursor;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;
import java.util.List;

class n$1 implements Runnable {
    n$1() {
    }

    public final void run() {
        List list = null;
        o bZC = a.vhX;
        int networkType = n.getNetworkType();
        x.i("MicroMsg.ResDownloaderCore", "resumeAllAndEvictExpired, networkType = %d", new Object[]{Integer.valueOf(networkType)});
        if (networkType == 0) {
            x.i("MicroMsg.ResDownloaderCore", "resumeAllAndEvictExpired, networkType is unavailable");
        } else if (bZC.iYd) {
            if (bZC.iYd) {
                long Wp = bh.Wp();
                Cursor Tj = bZC.vhU.Tj();
                if (Tj != null) {
                    if (Tj.getCount() <= 0) {
                        Tj.close();
                    } else {
                        list = new LinkedList();
                        Tj.moveToFirst();
                        do {
                            q qVar = new q();
                            qVar.b(Tj);
                            list.add(qVar);
                        } while (Tj.moveToNext());
                        Tj.close();
                    }
                }
                x.i("MicroMsg.ResDownloaderCore", "queryAll: cost = %d", new Object[]{Long.valueOf(bh.bz(Wp))});
            }
            if (bh.cA(r0)) {
                x.i("MicroMsg.ResDownloaderCore", "resumeAllAndEvictExpired, no record stored, skip this resumeAll-op");
                return;
            }
            for (q qVar2 : r0) {
                if (!bh.ov(qVar2.field_groupId1)) {
                    int hashCode = qVar2.field_groupId1.hashCode();
                    for (g gVar : p.bZD()) {
                        if (hashCode == bh.ou(gVar.aab()).hashCode()) {
                            gVar.bRt().a(qVar2, networkType);
                        }
                    }
                }
            }
        } else {
            x.e("MicroMsg.ResDownloaderCore", "resumeAllAndEvictExpired, core can not work");
        }
    }
}
