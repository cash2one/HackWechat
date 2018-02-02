package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.aa.1;
import com.tencent.mm.plugin.webview.ui.tools.widget.h;
import com.tencent.mm.plugin.webview.ui.tools.widget.h.a;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

class aa$1$1 implements Runnable {
    final /* synthetic */ LinkedList iVD;
    final /* synthetic */ String mWU;
    final /* synthetic */ 1 mWV;
    final /* synthetic */ String mWy;
    final /* synthetic */ String mWz;

    aa$1$1(1 1, String str, LinkedList linkedList, String str2, String str3) {
        this.mWV = 1;
        this.mWU = str;
        this.iVD = linkedList;
        this.mWy = str2;
        this.mWz = str3;
    }

    public final void run() {
        h hVar = new h(this.mWV.val$context);
        a 1 = new 1(this);
        com.tencent.mm.plugin.game.gamewebview.jsapi.a.a aVar;
        aa aaVar;
        if (this.iVD == null || this.iVD.size() <= 0) {
            x.e("MicroMsg.GameJsApiLogin", "scopeInfoList is empty!");
            aVar = this.mWV.mWw;
            aaVar = this.mWV.mWT;
            aVar.sj(com.tencent.mm.plugin.game.gamewebview.jsapi.a.e("loginfail", null));
        } else if (!hVar.a(this.iVD, this.mWy, this.mWz, 1)) {
            aVar = this.mWV.mWw;
            aaVar = this.mWV.mWT;
            aVar.sj(com.tencent.mm.plugin.game.gamewebview.jsapi.a.e("loginfail", null));
        }
    }
}
