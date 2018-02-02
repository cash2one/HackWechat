package com.tencent.mm.plugin.appbrand.jsapi.media;

import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.media.c.2;
import com.tencent.mm.plugin.appbrand.jsapi.media.c.b;
import com.tencent.mm.plugin.appbrand.jsapi.media.c.c;
import com.tencent.mm.plugin.appbrand.jsapi.media.c.e;
import com.tencent.mm.vending.j.a;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

class c$1 implements Runnable {
    final /* synthetic */ int gOK;
    final /* synthetic */ j iZy;
    final /* synthetic */ WeakReference jny;
    final /* synthetic */ c jnz;
    final /* synthetic */ String val$url;

    c$1(c cVar, j jVar, String str, WeakReference weakReference, int i) {
        this.jnz = cVar;
        this.iZy = jVar;
        this.val$url = str;
        this.jny = weakReference;
        this.gOK = i;
    }

    public final void run() {
        a aVar = null;
        for (b i : c.agA()) {
            aVar = i.i(this.iZy.irP, this.val$url);
            if (aVar != null) {
                break;
            }
        }
        a aVar2 = aVar;
        if (this.jny.get() != null && ((j) this.jny.get()).Vx) {
            if (aVar2 != null) {
                String e;
                switch (2.jnA[((e) aVar2.get(0)).ordinal()]) {
                    case 1:
                        e = this.jnz.e("fail:file not found", null);
                        break;
                    case 2:
                        Map hashMap = new HashMap(2);
                        hashMap.put("width", Integer.valueOf(((c) aVar2.get(1)).width));
                        hashMap.put("height", Integer.valueOf(((c) aVar2.get(1)).height));
                        hashMap.put("orientation", ((c) aVar2.get(1)).iNT);
                        hashMap.put(DownloadSettingTable$Columns.TYPE, ((c) aVar2.get(1)).type);
                        e = this.jnz.e("ok", hashMap);
                        break;
                    default:
                        e = this.jnz.e("fail", null);
                        break;
                }
                ((j) this.jny.get()).E(this.gOK, e);
                return;
            }
            ((j) this.jny.get()).E(this.gOK, this.jnz.e("fail:src not support", null));
        }
    }
}
