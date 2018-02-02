package com.tencent.mm.plugin.downloader.model;

import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ak.a;
import com.tencent.mm.sdk.platformtools.x;

class i$2 implements a {
    final /* synthetic */ i lsO;

    i$2(i iVar) {
        this.lsO = iVar;
    }

    public final boolean uF() {
        g.Dm().F(new i$3(this.lsO));
        i iVar = this.lsO;
        boolean z = iVar.lsM == null || iVar.lsM.size() == 0;
        if (z) {
            x.d("MicroMsg.FileDownloaderImpl23", "timer stop");
        } else {
            this.lsO.ikI.J(1000, 1000);
        }
        return false;
    }
}
