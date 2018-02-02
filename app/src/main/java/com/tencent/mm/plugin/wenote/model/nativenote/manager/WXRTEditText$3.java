package com.tencent.mm.plugin.wenote.model.nativenote.manager;

import com.tencent.mm.sdk.platformtools.ak.a;

class WXRTEditText$3 implements a {
    final /* synthetic */ WXRTEditText tTU;

    WXRTEditText$3(WXRTEditText wXRTEditText) {
        this.tTU = wXRTEditText;
    }

    public final boolean uF() {
        if (WXRTEditText.m(this.tTU) != null && WXRTEditText.m(this.tTU).getType() == 1) {
            int i = WXRTEditText.m(this.tTU).tUE;
            WXRTEditText.n(this.tTU);
            this.tTU.Y(i, false);
        }
        return true;
    }
}
