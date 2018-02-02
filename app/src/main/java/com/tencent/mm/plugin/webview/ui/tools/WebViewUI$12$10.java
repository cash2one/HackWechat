package com.tencent.mm.plugin.webview.ui.tools;

import android.os.Bundle;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI.12;
import com.tencent.mm.sdk.platformtools.x;

class WebViewUI$12$10 implements Runnable {
    final /* synthetic */ Bundle fhp;
    final /* synthetic */ 12 tAx;

    WebViewUI$12$10(12 12, Bundle bundle) {
        this.tAx = 12;
        this.fhp = bundle;
    }

    public final void run() {
        boolean z = false;
        byte[] byteArray = this.fhp.getByteArray("jsapi_control_bytes");
        if (byteArray == null || this.tAx.tAv.juR == null || this.tAx.tAv.juR.bSs() == null) {
            String str = "MicroMsg.WebViewUI";
            String str2 = "has JSAPI_CONTROL_BYTES %b, has wvPerm %b";
            Object[] objArr = new Object[2];
            objArr[0] = Boolean.valueOf(byteArray != null);
            if (this.tAx.tAv.juR != null) {
                z = true;
            }
            objArr[1] = Boolean.valueOf(z);
            x.e(str, str2, objArr);
        } else {
            x.i("MicroMsg.WebViewUI", "update control bytes, %d", new Object[]{Integer.valueOf(byteArray.length)});
            this.tAx.tAv.juR.bSs().vAQ = byteArray;
        }
        if (this.tAx.tAv.tlx != null) {
            this.tAx.tAv.tlx.bUo();
        }
    }
}
