package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.content.Context;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.sdk.platformtools.bh;

class a$1 implements Runnable {
    final /* synthetic */ int gOK;
    final /* synthetic */ j iZy;
    final /* synthetic */ String jmB;
    final /* synthetic */ a jmC;

    a$1(a aVar, j jVar, String str, int i) {
        this.jmC = aVar;
        this.iZy = jVar;
        this.jmB = str;
        this.gOK = i;
    }

    public final void run() {
        j jVar;
        int i;
        e eVar;
        String str;
        AppBrandLocalMediaObject itemByLocalId = AppBrandLocalMediaObjectManager.getItemByLocalId(this.iZy.mAppId, this.jmB);
        if (itemByLocalId == null || bh.ov(itemByLocalId.hhZ)) {
            jVar = this.iZy;
            i = this.gOK;
            eVar = this.jmC;
            str = "fail file not exists";
        } else if (this.jmC.su(itemByLocalId.mimeType)) {
            boolean z = false;
            if (this.iZy.Vx) {
                Context a = this.jmC.a(this.iZy);
                if (a != null) {
                    z = this.jmC.l(a, itemByLocalId.hhZ, itemByLocalId.mimeType);
                }
            }
            jVar = this.iZy;
            i = this.gOK;
            eVar = this.jmC;
            str = z ? "ok" : "fail";
        } else {
            this.iZy.E(this.gOK, this.jmC.e("fail invalid file type", null));
            return;
        }
        jVar.E(i, eVar.e(str, null));
    }
}
