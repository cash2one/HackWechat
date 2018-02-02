package com.tencent.mm.plugin.downloader.d;

import android.os.RemoteException;
import com.tencent.mm.network.n.a;
import com.tencent.mm.sdk.platformtools.x;

class a$5 extends a {
    final /* synthetic */ a lrq;

    a$5(a aVar) {
        this.lrq = aVar;
    }

    public final void eq(int i) {
        a aVar = this.lrq;
        x.i("MicroMsg.CDNDownloadClient", "notifyNetworkChange: " + i);
        if (aVar.lrj != null) {
            try {
                aVar.lrj.ow(i);
            } catch (RemoteException e) {
            }
        }
    }
}
