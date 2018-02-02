package com.tencent.mm.plugin.webview.fts;

import android.os.Bundle;
import android.os.RemoteException;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.g;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.h;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;

class e$2 implements Runnable {
    final /* synthetic */ e tms;
    final /* synthetic */ String tmw;
    final /* synthetic */ ArrayList tmx;

    e$2(e eVar, String str, ArrayList arrayList) {
        this.tms = eVar;
        this.tmw = str;
        this.tmx = arrayList;
    }

    public final void run() {
        g Be = h.Be(this.tms.tml.hjF.fDl);
        String str = this.tms.tml.hjF.fod;
        String str2 = this.tmw;
        x.i("MicroMsg.MsgHandler", "onSearchSuggestCallback: %s", new Object[]{this.tmx.toString()});
        Bundle bundle = new Bundle();
        bundle.putString("query", str);
        bundle.putString("suggestionId", str2);
        bundle.putStringArrayList("result", r3);
        try {
            if (Be.fBH != null) {
                Be.fBH.n(127, bundle);
            }
        } catch (RemoteException e) {
            x.w("MicroMsg.MsgHandler", "onSearchSuggestCallback exception" + e.getMessage());
        }
    }
}
