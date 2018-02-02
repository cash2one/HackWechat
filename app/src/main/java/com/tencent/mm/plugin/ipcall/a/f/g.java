package com.tencent.mm.plugin.ipcall.a.f;

import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.GameJsApiGetOpenDeviceId;
import com.tencent.mm.plugin.ipcall.a.a.a;
import com.tencent.mm.plugin.ipcall.a.a.c;
import com.tencent.mm.plugin.ipcall.a.d.l;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;

public final class g extends a {
    public final int[] aTJ() {
        return new int[]{GameJsApiGetOpenDeviceId.CTRL_BYTE};
    }

    public final int LC() {
        return 7;
    }

    public final void aTK() {
    }

    public final void onDestroy() {
    }

    public final void b(c cVar) {
        if (cVar != null) {
            ar.CG().a(new l(cVar.nDx, cVar.nDz, cVar.nEc), 0);
            x.i("MicroMsg.IPCallReportService", "start report, roomid: %d, callseq: %d, isAccept: %b", new Object[]{Integer.valueOf(cVar.nDx), Long.valueOf(cVar.nDz), Boolean.valueOf(cVar.nEc)});
        }
    }
}
