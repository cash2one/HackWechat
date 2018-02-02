package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.mm.a.g;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.j;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

class m$1 implements Runnable {
    final /* synthetic */ String fgU;
    final /* synthetic */ int gOK;
    final /* synthetic */ j iZy;
    final /* synthetic */ String jjA;
    final /* synthetic */ m jjB;
    final /* synthetic */ String jjz;

    m$1(m mVar, String str, String str2, j jVar, int i, String str3) {
        this.jjB = mVar;
        this.fgU = str;
        this.jjz = str2;
        this.iZy = jVar;
        this.gOK = i;
        this.jjA = str3;
    }

    public final void run() {
        AppBrandLocalMediaObject itemByLocalId = AppBrandLocalMediaObjectManager.getItemByLocalId(this.fgU, this.jjz);
        if (itemByLocalId == null) {
            this.iZy.E(this.gOK, this.jjB.e("fail:file doesn't exist", null));
            return;
        }
        File file = new File(itemByLocalId.hhZ);
        String str = this.jjA;
        Object obj = -1;
        switch (str.hashCode()) {
            case 107902:
                if (str.equals("md5")) {
                    obj = null;
                    break;
                }
                break;
            case 3528965:
                if (str.equals("sha1")) {
                    obj = 1;
                    break;
                }
                break;
        }
        switch (obj) {
            case null:
                obj = g.i(file);
                break;
            case 1:
                obj = m.v(file);
                break;
            default:
                obj = "";
                break;
        }
        Map hashMap = new HashMap(2);
        hashMap.put("size", Long.valueOf(file.length()));
        hashMap.put("digest", obj);
        this.iZy.E(this.gOK, this.jjB.e("ok", hashMap));
    }
}
