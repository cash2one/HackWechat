package com.tencent.mm.plugin.webview.ui.tools;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.mm.plugin.webview.modelcache.o;
import com.tencent.mm.plugin.webview.modeltools.b;
import com.tencent.mm.plugin.webview.stub.d.a;
import com.tencent.mm.sdk.platformtools.x;

class WebViewUI$34 implements ServiceConnection {
    final /* synthetic */ WebViewUI tAv;

    WebViewUI$34(WebViewUI webViewUI) {
        this.tAv = webViewUI;
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        boolean z = true;
        x.i("MicroMsg.WebViewUI", "edw onServiceConnected");
        if (this.tAv.ptK == null) {
            x.e("MicroMsg.WebViewUI", "onServiceConnected, activity destroyed");
            return;
        }
        this.tAv.juQ = a.X(iBinder);
        try {
            this.tAv.juQ.a(this.tAv.fBH, this.tAv.hashCode());
        } catch (Exception e) {
            x.e("MicroMsg.WebViewUI", "addCallback fail, ex = %s", new Object[]{e.getMessage()});
        }
        String str = "MicroMsg.WebViewUI";
        String str2 = "onServiceConnected, invoker == null ? %b";
        Object[] objArr = new Object[1];
        if (this.tAv.juQ != null) {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        x.i(str, str2, objArr);
        if (this.tAv.juQ == null) {
            x.f("MicroMsg.WebViewUI", "service connect success, while invoker is null");
            this.tAv.finish();
            return;
        }
        this.tAv.akN();
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        x.i("MicroMsg.WebViewUI", "edw onServiceDisconnected");
        if ((this.tAv.tzO && WebViewUI.bTf() <= 0) || (!this.tAv.tzO && WebViewUI.bTf() <= 1)) {
            b.d(this.tAv.juQ);
            o bRo = o.a.bRo();
            for (int i = 0; i < bRo.ttM.size(); i++) {
                bRo.ttM.valueAt(i);
            }
            bRo.ttM.clear();
            bRo.ttN.clear();
        }
        if (this.tAv.tzO || WebViewUI.B(this.tAv) || this.tAv.isFinishing()) {
            this.tAv.juQ = null;
            return;
        }
        x.i("MicroMsg.WebViewUI", "maybe mm process crash, try rebind service");
        WebViewUI.C(this.tAv);
    }
}
