package com.tencent.mm.plugin.webview.modelcache;

import com.tencent.mm.ae.d;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.protocal.c.bw;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.bs.a;

class n$1 implements a {
    final /* synthetic */ n ttK;

    n$1(n nVar) {
        this.ttK = nVar;
    }

    public final void a(d.a aVar) {
        bw bwVar = aVar.hmq;
        if (bwVar.vGZ != null && !bh.ov(n.a(bwVar.vGZ))) {
            x.d("MicroMsg.WebViewCacheSubCoreToolsExtension", "can not do brand pre-push");
        }
    }
}
