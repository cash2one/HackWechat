package com.tencent.mm.plugin.appbrand.jsapi.media;

import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseMedia.a.6;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;

class JsApiChooseMedia$a$6$1 implements Runnable {
    final /* synthetic */ ArrayList jnk;
    final /* synthetic */ ArrayList jnn;
    final /* synthetic */ 6 jno;

    JsApiChooseMedia$a$6$1(6 6, ArrayList arrayList, ArrayList arrayList2) {
        this.jno = 6;
        this.jnk = arrayList;
        this.jnn = arrayList2;
    }

    public final void run() {
        x.i("MicroMsg.JsApiChooseMedia", "handle image from album is ok");
        this.jno.jnj.jne.bjW = -1;
        this.jno.jnj.jne.type = SlookAirButtonRecentMediaAdapter.IMAGE_TYPE;
        this.jno.jnj.jne.jnd = JsApiChooseMedia$a.a(this.jnk, this.jnn);
        this.jno.jnj.a(this.jno.jnj.jne);
    }
}
