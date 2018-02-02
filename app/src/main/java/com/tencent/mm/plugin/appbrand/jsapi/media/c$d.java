package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Rect;
import com.tencent.mm.plugin.appbrand.appcache.ah;
import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.jsapi.media.c.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.vending.j.a;
import java.io.Closeable;
import java.io.IOException;

final class c$d implements c$b {
    private c$d() {
    }

    public final a i(e eVar, String str) {
        Closeable d = ah.d(eVar, str);
        if (d == null) {
            return a.cr(c.e.jnB);
        }
        d.mark(0);
        Options options = new Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(d, new Rect(), options);
        c cVar = new c((byte) 0);
        cVar.width = options.outWidth;
        cVar.height = options.outHeight;
        cVar.type = com.tencent.mm.plugin.appbrand.q.a.b(options);
        boolean a = com.tencent.mm.plugin.appbrand.q.a.a(options);
        try {
            d.reset();
        } catch (IOException e) {
        }
        cVar.iNT = a ? com.tencent.mm.plugin.appbrand.q.a.lJ(com.tencent.mm.plugin.appbrand.q.a.l(d)) : "up";
        bh.d(d);
        return a.v(c.e.jnD, cVar);
    }
}
