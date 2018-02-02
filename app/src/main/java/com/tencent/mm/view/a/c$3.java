package com.tencent.mm.view.a;

import android.graphics.Bitmap;
import com.tencent.mm.a.e;
import com.tencent.mm.aq.a.c.l;
import com.tencent.mm.plugin.gif.g;

class c$3 implements l {
    final /* synthetic */ c zEr;

    c$3(c cVar) {
        this.zEr = cVar;
    }

    public final Bitmap I(byte[] bArr) {
        return g.ay(bArr);
    }

    public final Bitmap lD(String str) {
        return g.ay(e.d(str, 0, e.bN(str)));
    }
}
