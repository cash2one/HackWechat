package com.tencent.mm.plugin.game.gamewebview.ui;

import android.os.Bundle;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.xweb.x5.a.a.a.a.b;

class d$3 extends b {
    final /* synthetic */ d mZC;

    d$3(d dVar) {
        this.mZC = dVar;
    }

    public final Object onMiscCallBack(String str, Bundle bundle) {
        boolean z = false;
        String str2 = "MicroMsg.GameWebPageView";
        String str3 = "method = %s, bundler == null ? %b";
        Object[] objArr = new Object[2];
        objArr[0] = str;
        if (bundle == null) {
            z = true;
        }
        objArr[1] = Boolean.valueOf(z);
        x.i(str2, str3, objArr);
        if (bh.ov(str) || bundle == null) {
            return super.onMiscCallBack(str, bundle);
        }
        if (!(d.i(this.mZC) == null || d.i(this.mZC).tLw == null)) {
            Object onMiscCallBack = d.i(this.mZC).tLw.onMiscCallBack(str, bundle);
            if (onMiscCallBack != null) {
                return onMiscCallBack;
            }
        }
        return super.onMiscCallBack(str, bundle);
    }
}
