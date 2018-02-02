package com.tencent.mm.plugin.webview.fts;

import android.os.Bundle;
import android.os.RemoteException;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.webview.fts.e.4;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.g;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;

class e$4$1 implements Runnable {
    final /* synthetic */ h mJd;
    final /* synthetic */ ArrayList tmu;
    final /* synthetic */ 4 tmy;

    e$4$1(4 4, h hVar, ArrayList arrayList) {
        this.tmy = 4;
        this.mJd = hVar;
        this.tmu = arrayList;
    }

    public final void run() {
        if (this.tmy.tms.mMa != null && this.tmy.tms.mMa.mLn != null) {
            g Be = com.tencent.mm.plugin.webview.ui.tools.jsapi.h.Be(((Integer) this.tmy.tms.mMa.mLn).intValue());
            String str = this.mJd.mJc.fDj;
            x.i("MicroMsg.MsgHandler", "onSearchHistoryCallback: %s", this.tmu.toString());
            Bundle bundle = new Bundle();
            bundle.putString("query", str);
            bundle.putStringArrayList("result", r2);
            try {
                if (Be.fBH != null) {
                    Be.fBH.n(126, bundle);
                }
            } catch (RemoteException e) {
                x.w("MicroMsg.MsgHandler", "onSearchHistoryCallback exception" + e.getMessage());
            }
        }
    }
}
