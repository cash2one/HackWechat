package com.tencent.mm.plugin.webview.fts.topstory.a;

import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;

class c$2 implements Runnable {
    final /* synthetic */ ArrayList lft;
    final /* synthetic */ c tnH;

    c$2(c cVar, ArrayList arrayList) {
        this.tnH = cVar;
        this.lft = arrayList;
    }

    public final void run() {
        if (this.lft != null) {
            x.i("MicroMsg.WebSearch.TopStoryVideoListFetcher", "callbackToSucc, result lisze size: %s", new Object[]{Integer.valueOf(this.lft.size())});
            if (this.lft.size() <= 0) {
                this.tnH.Oa(null);
            } else if (this.tnH.tnF != null) {
                this.tnH.tnF.cl(this.lft);
            }
        }
    }
}
