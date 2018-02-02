package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.os.Bundle;
import com.tencent.mm.ae.g.a;
import com.tencent.mm.g.a.ez;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.x;

class g$70 implements Runnable {
    final /* synthetic */ String jjz;
    final /* synthetic */ WebViewJSSDKFileItem tIY;
    final /* synthetic */ g tIj;

    g$70(g gVar, WebViewJSSDKFileItem webViewJSSDKFileItem, String str) {
        this.tIj = gVar;
        this.tIY = webViewJSSDKFileItem;
        this.jjz = str;
    }

    public final void run() {
        b ezVar = new ez();
        ezVar.ftT.op = 1;
        ezVar.ftT.fileName = this.tIY.fileName;
        ezVar.ftT.fjt = true;
        ezVar.ftT.ftW = new a(this) {
            final /* synthetic */ g$70 tJb;

            {
                this.tJb = r1;
            }

            public final void vh() {
                try {
                    Bundle bundle = new Bundle();
                    bundle.putString("playResult", "onVoicePlayEnd:ok");
                    bundle.putString("localId", this.tJb.jjz);
                    g.z(this.tJb.tIj).n(2002, bundle);
                } catch (Exception e) {
                    x.e("MicroMsg.MsgHandler", "notify voice play end failed : %s", new Object[]{e.getMessage()});
                }
            }
        };
        ezVar.ftT.ftX = new 2(this);
        com.tencent.mm.sdk.b.a.xef.m(ezVar);
    }
}
