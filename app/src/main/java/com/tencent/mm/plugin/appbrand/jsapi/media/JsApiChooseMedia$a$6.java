package com.tencent.mm.plugin.appbrand.jsapi.media;

import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseMedia.a;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;

class JsApiChooseMedia$a$6 implements Runnable {
    final /* synthetic */ String icE;
    final /* synthetic */ boolean jmT;
    final /* synthetic */ a jnj;

    JsApiChooseMedia$a$6(a aVar, boolean z, String str) {
        this.jnj = aVar;
        this.jmT = z;
        this.icE = str;
    }

    public final void run() {
        String access$1500 = this.jmT ? a.access$1500(this.icE) : this.icE;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        AppBrandLocalMediaObject attach = AppBrandLocalMediaObjectManager.attach(a.h(this.jnj).appId, access$1500, this.jmT | 1);
        if (attach != null) {
            arrayList.add(Long.valueOf(attach.ieE));
            arrayList2.add(attach.fus);
            ag.y(new 1(this, arrayList2, arrayList));
            return;
        }
        x.e("MicroMsg.JsApiChooseMedia", "handle image from mm-sight camera, get null obj from path: %s", new Object[]{this.icE});
        a.e(this.jnj).bjW = -2;
        a.h(this.jnj, a.e(this.jnj));
    }
}
