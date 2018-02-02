package com.tencent.mm.plugin.appbrand.jsapi.media;

import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseMedia.a;
import com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseMedia.a.5;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;

class JsApiChooseMedia$a$5$1 implements Runnable {
    final /* synthetic */ ArrayList jnk;
    final /* synthetic */ ArrayList jnl;
    final /* synthetic */ 5 jnm;

    JsApiChooseMedia$a$5$1(5 5, ArrayList arrayList, ArrayList arrayList2) {
        this.jnm = 5;
        this.jnk = arrayList;
        this.jnl = arrayList2;
    }

    public final void run() {
        x.i("MicroMsg.JsApiChooseMedia", "handle image from album is ok");
        a.e(this.jnm.jnj).bjW = -1;
        a.e(this.jnm.jnj).type = SlookAirButtonRecentMediaAdapter.IMAGE_TYPE;
        a.e(this.jnm.jnj).jnd = a.b(this.jnk, this.jnl);
        a.f(this.jnm.jnj, a.e(this.jnm.jnj));
    }
}
