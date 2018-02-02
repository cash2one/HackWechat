package com.tencent.mm.plugin.emoji.sync;

import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.plugin.emoji.sync.b.b;
import com.tencent.mm.plugin.emoji.sync.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Vector;
import java.util.concurrent.TimeUnit;

public final class a<T extends d> {
    public BKGLoaderManager lzq;

    public enum a {
        Default,
        Syncing,
        PauseSync,
        PauseSyncOffline,
        PauseSyncSDCardFull,
        FinishSync
    }

    public a() {
        com.tencent.mm.plugin.emoji.sync.b.a aVar = new com.tencent.mm.plugin.emoji.sync.b.a();
        aVar.lzy = 1;
        aVar.hDf = 10;
        aVar.lzA = new b(aVar.lzy, aVar.lzy, TimeUnit.MILLISECONDS, new com.tencent.mm.aq.a.e.a(), new c(aVar.hDf, "bkg_loader_"));
        a(new b(aVar));
    }

    private synchronized void a(b bVar) {
        if (this.lzq == null) {
            this.lzq = new BKGLoaderManager(bVar);
        } else {
            x.i("MicroMsg.BKGLoader.BKGLoader", "[cpan] BKGLoader had init.");
        }
    }

    public final void s(ArrayList<d> arrayList) {
        BKGLoaderManager bKGLoaderManager = this.lzq;
        bKGLoaderManager.lzD = false;
        if (bKGLoaderManager.lzN == null) {
            bKGLoaderManager.lzN = new Vector();
        }
        if (arrayList.size() > 0) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                d dVar = (d) arrayList.get(i);
                if (dVar == null || bKGLoaderManager.lzN.contains(dVar)) {
                    x.i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] task is has exist.:%s", new Object[]{dVar.getKey()});
                } else {
                    bKGLoaderManager.lzN.add(dVar);
                }
            }
        }
    }

    public final void t(ArrayList<d> arrayList) {
        BKGLoaderManager bKGLoaderManager = this.lzq;
        if (bKGLoaderManager.lzP == null) {
            bKGLoaderManager.lzP = new Vector();
        }
        if (arrayList.size() > 0) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                d dVar = (d) arrayList.get(i);
                String str;
                String str2;
                Object[] objArr;
                if (bKGLoaderManager.lzL != null && bKGLoaderManager.lzL.equals(dVar)) {
                    str = "MicroMsg.BKGLoader.BKGLoaderManager";
                    str2 = "[cpan] currentTask equals task is has exist:%s";
                    objArr = new Object[1];
                    objArr[0] = dVar == null ? "task is null" : dVar.getKey();
                    x.i(str, str2, objArr);
                } else if (dVar == null || bKGLoaderManager.lzP.contains(dVar)) {
                    str = "MicroMsg.BKGLoader.BKGLoaderManager";
                    str2 = "[cpan] task is has exist:%s";
                    objArr = new Object[1];
                    objArr[0] = dVar == null ? "task is null" : dVar.getKey();
                    x.i(str, str2, objArr);
                } else {
                    bKGLoaderManager.lzP.add(dVar);
                }
            }
        }
    }

    public final a aBY() {
        BKGLoaderManager bKGLoaderManager = this.lzq;
        if (bKGLoaderManager.lzE && bKGLoaderManager.lzJ) {
            return a.PauseSyncSDCardFull;
        }
        if (BKGLoaderManager.aAP() && !bKGLoaderManager.lzE && i.aBE().lwL.ckG() > 0) {
            return a.PauseSync;
        }
        if (!an.isConnected(ac.getContext()) && !bKGLoaderManager.lzE && i.aBE().lwL.ckG() > 0) {
            return a.PauseSyncOffline;
        }
        if (an.isConnected(ac.getContext())) {
            if (bKGLoaderManager.lzE && bKGLoaderManager.lzK) {
                return a.Syncing;
            }
            if (bKGLoaderManager.lzH) {
                return a.FinishSync;
            }
        }
        return a.Default;
    }

    public final void eu(boolean z) {
        this.lzq.lzK = z;
    }
}
