package com.tencent.mm.plugin.appbrand.dynamic.b;

import android.graphics.Bitmap;
import android.os.Bundle;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.modelappbrand.a.b.h;
import com.tencent.mm.plugin.appbrand.canvas.g.a;
import com.tencent.mm.plugin.appbrand.dynamic.f$a;
import com.tencent.rtmp.TXLiveConstants;

class c$1 implements h {
    final /* synthetic */ a iKX;
    final /* synthetic */ c iSI;
    final /* synthetic */ String uR;
    final /* synthetic */ String val$url;

    c$1(c cVar, a aVar, String str, String str2) {
        this.iSI = cVar;
        this.iKX = aVar;
        this.uR = str;
        this.val$url = str2;
    }

    public final void Jm() {
    }

    public final void j(Bitmap bitmap) {
        if (this.iKX != null && bitmap != null && !bitmap.isRecycled()) {
            this.iKX.abm();
        }
    }

    public final void Jn() {
        Bundle bundle = new Bundle();
        bundle.putString(SlookAirButtonFrequentContactAdapter.ID, this.uR);
        bundle.putInt("widgetState", TXLiveConstants.PLAY_WARNING_RECONNECT);
        f.a("com.tencent.mm:support", bundle, f$a.class, null);
    }

    public final String Jo() {
        return "WxaWidgetIcon";
    }
}
