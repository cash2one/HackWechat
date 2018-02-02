package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.os.Bundle;
import com.tencent.mm.plugin.webview.ui.tools.widget.e.4;
import com.tencent.mm.sdk.platformtools.x;

class e$4$4 implements Runnable {
    final /* synthetic */ Bundle fhp;
    final /* synthetic */ 4 tKr;

    e$4$4(4 4, Bundle bundle) {
        this.tKr = 4;
        this.fhp = bundle;
    }

    public final void run() {
        boolean z = false;
        byte[] byteArray = this.fhp.getByteArray("jsapi_control_bytes");
        if (byteArray == null || this.tKr.tKp.tGR == null || this.tKr.tKp.tGR.bSs() == null) {
            String str = "MicroMsg.MMWebViewClient";
            String str2 = "has JSAPI_CONTROL_BYTES %b, has wvPerm %b";
            Object[] objArr = new Object[2];
            objArr[0] = Boolean.valueOf(byteArray != null);
            if (this.tKr.tKp.tGR != null) {
                z = true;
            }
            objArr[1] = Boolean.valueOf(z);
            x.e(str, str2, objArr);
        } else {
            x.i("MicroMsg.MMWebViewClient", "update control bytes, %d", new Object[]{Integer.valueOf(byteArray.length)});
            this.tKr.tKp.tGR.bSs().vAQ = byteArray;
        }
        if (this.tKr.tKp.tFj != null) {
            this.tKr.tKp.tFj.bUo();
        }
    }
}
