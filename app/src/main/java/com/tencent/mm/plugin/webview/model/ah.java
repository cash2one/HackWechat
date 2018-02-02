package com.tencent.mm.plugin.webview.model;

import android.os.Bundle;
import com.tencent.mm.plugin.webview.stub.e;
import com.tencent.mm.sdk.platformtools.x;

public final class ah {
    public static ah tsE = new ah();
    public e fBH = null;
    public boolean hasInit;

    private ah() {
    }

    public static ah bQR() {
        return tsE;
    }

    public final void setNetWorkState(int i) {
        String str = "MicroMsg.WebViewVideoProxy";
        String str2 = "set networkd state = %d, callbacker == null ? %b";
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Boolean.valueOf(this.fBH == null);
        x.i(str, str2, objArr);
        if (this.fBH != null) {
            Bundle bundle = new Bundle();
            bundle.putInt("webview_video_proxy_net_state", i);
            try {
                this.fBH.e(5005, bundle);
            } catch (Exception e) {
                x.e("MicroMsg.WebViewVideoProxy", "set network state failed : %s", new Object[]{e.getMessage()});
            }
        }
    }
}
