package com.tencent.mm.plugin.appbrand.jsapi.live;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.rtmp.ITXLiveBaseListener;

class k$1 implements ITXLiveBaseListener {
    k$1() {
    }

    public final void OnLog(int i, String str, String str2) {
        switch (i) {
            case 0:
                x.v(str, str2);
                return;
            case 1:
                x.d(str, str2);
                return;
            case 2:
                x.i(str, str2);
                return;
            case 3:
                x.w(str, str2);
                return;
            case 4:
                x.e(str, str2);
                return;
            case 5:
                x.f(str, str2);
                return;
            default:
                x.d(str, str2);
                return;
        }
    }
}
