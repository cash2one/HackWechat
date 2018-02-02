package com.tencent.mm.plugin.ac.a;

import com.tencent.mm.plugin.ac.a.b.a;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;

class b$2 implements Runnable {
    final /* synthetic */ String puY;
    final /* synthetic */ a puZ;
    final /* synthetic */ b pvb;

    public b$2(b bVar, String str, a aVar) {
        this.pvb = bVar;
        this.puY = str;
        this.puZ = aVar;
    }

    public final void run() {
        b bVar = this.pvb;
        String str = this.puY;
        a aVar = this.puZ;
        List<a> list = (List) bVar.puU.get(str);
        if (list != null) {
            for (a aVar2 : list) {
                if (aVar2 != null && aVar2 == aVar) {
                    list.remove(aVar2);
                    break;
                }
            }
        } else {
            x.e("MicroMsg.FileScanQueueService", "removeFormCallbackList, list is null");
        }
        if (list != null && list.isEmpty()) {
            bVar.puU.remove(str);
            bVar.hCK.remove(str);
            bVar.puV.remove(str);
            if (bVar.puW != null && bVar.puW.equals(str)) {
                a aVar3 = bVar.puX;
                x.i("MicroMsg.scanner.DecodeFile", "cancelled");
                aVar3.iu = true;
                bVar.puX = null;
            }
            bVar.blq();
        }
    }
}
