package com.tencent.mm.plugin.ac.a;

import com.tencent.mm.plugin.ac.a.b.a;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;

class b$3 implements Runnable {
    final /* synthetic */ b pvb;
    final /* synthetic */ d pvc;

    b$3(b bVar, d dVar) {
        this.pvb = bVar;
        this.pvc = dVar;
    }

    public final void run() {
        b bVar = this.pvb;
        d dVar = this.pvc;
        x.i("MicroMsg.FileScanQueueService", "onFinishScan fileUri: %s, result: %s", new Object[]{bVar.puW, dVar});
        List<a> list = (List) bVar.puU.get(bVar.puW);
        if (list != null && dVar != null) {
            x.d("MicroMsg.FileScanQueueService", "onFinishScan, callback size: %d", new Object[]{Integer.valueOf(list.size())});
            for (a j : list) {
                j.j(bVar.puW, dVar.result, dVar.fqb, dVar.fqc);
            }
        } else if (list != null) {
            for (a j2 : list) {
                j2.HX(bVar.puW);
            }
        }
        bVar.puU.remove(bVar.puW);
        bVar.puV.remove(bVar.puW);
        bVar.puW = null;
        bVar.puX = null;
        bVar.blq();
    }
}
