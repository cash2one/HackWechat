package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKImageItem;
import com.tencent.mm.plugin.webview.model.c$b;
import com.tencent.mm.plugin.webview.modeltools.f;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;

class g$53 implements c$b {
    final /* synthetic */ String tIR;
    final /* synthetic */ i tIg;
    final /* synthetic */ g tIj;

    g$53(g gVar, String str, i iVar) {
        this.tIj = gVar;
        this.tIR = str;
        this.tIg = iVar;
    }

    public final void a(boolean z, String str, String str2, String str3) {
        x.i("MicroMsg.MsgHandler", "doDownLoadImage, on cdn finish, is success : %b, local id : %s, media id is : %s", new Object[]{Boolean.valueOf(z), str, str2});
        if (!bh.ov(str2) && str2.equals(this.tIR)) {
            f.bRA().a(this);
            if (g.k(this.tIj) != null) {
                g.k(this.tIj).dismiss();
                g.a(this.tIj, null);
            }
            if (z) {
                WebViewJSSDKFileItem Oo = f.bRB().Oo(str);
                if ((Oo instanceof WebViewJSSDKImageItem) && bh.ov(Oo.jip)) {
                    ((WebViewJSSDKImageItem) Oo).bQQ();
                }
                Map hashMap = new HashMap();
                hashMap.put("localId", str);
                g.a(this.tIj, this.tIg, "downloadImage:ok", hashMap);
                return;
            }
            g.a(this.tIj, this.tIg, "downloadImage:fail", null);
        }
    }
}
